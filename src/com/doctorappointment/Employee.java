package com.doctorappointment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee extends Person implements createTable, readTab {
    private String position;
    private int price;
    private String time;
    //Constructors
    public Employee(){
        super();
    }
    //Getters
    public String getPosition(){
        return position;
    }

    public String getTime() {
        return time;
    }

    public int getPrice(){return price;}

    //Setters
    public void setPosition(String position){
        this.position = position;
    }
    public void setPrice(int price){this.price = price;}
    @Override
    public void createTable (Connection conn, String table) {
        Statement statement;
        try {
            String query = "create table " + table+ "(id serial primary key, name varchar(20), " +
                    "surname varchar(20),position varchar(20), time varchar(50),price varchar(20));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void addDoc(Connection conn,String table_name,String name,String surname,String position,String time,String price){
        Statement statement;
        try{
            String query=String.format("insert into %s(name,surname,position,time,price) values ('%s','%s','%s','%s','%s');",table_name,name,surname,position,time,price);
            statement=conn.createStatement();
            statement.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void readTable(Connection conn, String table_name, String position)  {
        Statement statement;
        ResultSet resultSet = null;
        try {
            String query = String.format("select * from %s where position = '%s'", table_name,position );
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                time= resultSet.getString("time");
                price= resultSet.getInt("price");
                name= resultSet.getString("name");
                this.position=resultSet.getString("position");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}