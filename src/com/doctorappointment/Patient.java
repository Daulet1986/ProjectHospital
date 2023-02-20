package com.doctorappointment;

import java.sql.Connection;
import java.sql.Statement;

public class Patient extends Person  implements createTable{
    public Patient(){
        super();
    }
    ///Getters
    ///Setters

    @Override
    public void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name + "(id serial primary key, IIN varchar," +
                    " name varchar(20), surname varchar(20), gender varchar(20), age int," +
                    " insurance boolean, payment varchar(20));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}