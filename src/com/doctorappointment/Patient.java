package com.doctorappointment;

import java.sql.Connection;
import java.sql.Statement;

public class Patient extends Person  implements createTable{
    private String UIN;
    private int insurance_amount;
    public Patient(){
        super();
    }

    public Patient(String name, String surname, int age, String UIN, String phone_num, int insurance_amount){
        setName(name);
        setSurname(surname);
        setAge(age);
        setUIN(UIN);
        setInsurance(insurance_amount);
    }

    ///Getters
    public String getUIN(){
        return UIN;
    }
    public int getInsurance(){
        return insurance_amount;
    }
    ///Setters
    public void setUIN(String UIN){
        this.UIN = UIN;
    }
    public void setInsurance(int insurance_amount){
        this.insurance_amount = insurance_amount;
    }
    @Override
    public void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name + "(id serial primary key, IIN varchar," +
                    " name varchar(20), surname varchar(20), gender varchar(20), age int, address varchar(20)," +
                    " insurance boolean, payment varchar(20));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}