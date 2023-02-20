package com.doctorappointment;
import java.util.Scanner;
import java.sql.SQLException;

public class Payment extends Dbfunctions  {
    private boolean appoint;
    public boolean getAppoint(){
        return appoint;
    }
    Dbfunctions db = new Dbfunctions();
    Scanner scanner=new Scanner(System.in);
    Employee employee=new Employee();
    float amount;
    public String iin;
    public String pos;
    public boolean processPayment() throws SQLException {
        try {
            System.out.println("Confirm IIN of patient:");
            String IIN=scanner.nextLine();
            iin=IIN;
            System.out.println("Confirm position of doctor:");
            String position=scanner.nextLine();
            db.readTable(connect_to_db("postgres","postgres","autochthonous"),"patients",IIN);
            employee.readTable(connect_to_db("postgres","postgres","autochthonous"),"employee",position);
            if (db.getInsurance() == true) {
                System.out.println("Insurance is found. Your appointment will now be set.");
                if (db.getPayment() < employee.getPrice()) {
                    System.out.println("Payment denied. Try again later.");
                    appoint=false;
                } else {
                    System.out.println("Payment accepted. Your appointment will now be set.");
                    appoint=true;
                }
            }
            else {
                System.out.println("Insurance was not found.");
                appoint=false;
            }
        } catch (Exception e) {
            System.out.println("Error occurred while processing the payment. Try again later!");
        }
        return appoint;
    }

}