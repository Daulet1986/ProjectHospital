package com.doctorappointment;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Appointment {
    Payment payment = new Payment();
    Employee employee=new Employee();
    Dbfunctions db=new Dbfunctions();
    Statement statement;
    private boolean appoint;

    public Appointment() {
        setAppoint();
        getAppoint();
    }
    public void setAppoint(){
        this.appoint=appoint;
    }
    public boolean getAppoint(){
        return appoint;
    }
    public void creatTabApp(Connection conn, String table_name) throws SQLException {
        try {
            String query = "create table " + table_name + "(id serial primary key, name varchar(20), " +
                    "surname varchar(20) , time varchar(50),position varchar(20));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void addAppoint(Connection conn, String table_name, String name, String surname, String time, String position) throws SQLException {
        appoint = payment.processPayment();
        if (appoint==true) {
            try {
                String query = String.format("INSERT INTO %s(name, surname, time, position) VALUES('%s', '%s', '%s', '%s');", table_name, name, surname, time, position );
                Statement statement = conn.createStatement();
                statement.executeUpdate(query);
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error executing SQL query: " + e.getMessage());
            }
        } else {
            System.out.println("Payment failed. Appointment not added.");
        }
    }

}