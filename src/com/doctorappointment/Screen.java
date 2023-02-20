package com.doctorappointment;

import java.sql.*;
import java.util.Scanner;
public class Screen {
    Scanner scanner = new Scanner(System.in);
    Dbfunctions db = new Dbfunctions();
    Patient patient=new Patient();
    Employee employee=new Employee();
    Appointment appointment=new Appointment();
    Payment payment=new Payment();
    public void employeeTab(){
        //employee.createTable(db.connect_to_db("postgres","postgres","DDAA2005"),"employee");
        //employee.addDoc(db.connect_to_db("postgres","postgres","DDAA2005"),"employee","Muhtar","Aliev","Therapist","13:00-16:00","7000" );
        //employee.addDoc(db.connect_to_db("postgres","postgres","DDAA2005"),"employee","Alisher","Maratov","Dermatologist","9:00-12:00","8000" );
        //employee.addDoc(db.connect_to_db("postgres","postgres","DDAA2005"),"employee","Maksat","Utepov","Surgeon","12:00-15:00","10000" );
        //employee.addDoc(db.connect_to_db("postgres","postgres","DDAA2005"),"employee","Kairat","Nurtas","Psychiatrist","18:00-19:00","5000" );
        //employee.addDoc(db.connect_to_db("postgres","postgres","DDAA2005"),"employee","Dimash","Bolatov","Neuropathologist","14:00-16:00","7500" );
    }

    public void screenFunctions(){
        Connection conn=db.connect_to_db("postgres","postgres","DDAA2005");
        while(true) {
            System.out.println("0. Create database of patients");
            System.out.println("1. List all patients");
            System.out.println("2. Update information");
            System.out.println("3. Add a patient");
            System.out.println("4. Delete a patient");
            System.out.println("5. Search");
            System.out.println("6. Quit");
            System.out.println("7. Delete Database");
            System.out.println("8. Book an appointment");
            System.out.println("9. Clean all timetable of appointments");
            System.out.println("10. Clean row of appointments");
            System.out.println("11. List all appointments");

            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Do you want to continue(Yes(Y)/No(N))?");
                String input = scanner.next();
                try {
                    if (input.equalsIgnoreCase("N")) {
                        System.out.println("Exiting...");
                        continue;
                    } else if (input.equalsIgnoreCase("Y")) {
                        Statement statement = conn.createStatement();
                        String SQL_SELECT_TASKS = "select * from patients";
                        ResultSet result = statement.executeQuery(SQL_SELECT_TASKS);
                        while (result.next()) {
                            System.out.println(result.getInt("id") + ". " +
                                    result.getString("IIN") + ", " +
                                    result.getString("name") + " " +
                                    result.getString("surname") + ", " +
                                    result.getString("gender") + ", " +
                                    result.getInt("age") + ", " +
                                    result.getBoolean("insurance") + ", " +
                                    result.getString("payment"));
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please enter 'exit' or 'continue'.");
                    }
                } catch (IllegalArgumentException | SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (command == 0) {
                System.out.println("Do you want to continue?(Yes(Y)/No(N))");
                String input = scanner.next();
                try {
                    if (input.equalsIgnoreCase("N")) {
                        System.out.println("Exiting...");
                        continue;
                    } else if (input.equalsIgnoreCase("Y")) {
                        patient.createTable(conn, "patients");
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please enter 'exit' or 'continue'.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

        }}}
