package com.doctorappointment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Dbfunctions extends ConnectiontoDb implements readTab {
    private String name = "";
    private String surname = "";
    private boolean insurance;
    private float payment;

    public float getPayment() {
        return payment;
    }
    public boolean getInsurance(){
        return insurance;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    @Override
    public void readTable(Connection conn, String table_name, String IIN) {
        Statement statement;
        ResultSet resultSet = null;
        try {// Step 5: Extract data from the result set
            String query = String.format("select * from %s where IIN = '%s'", table_name, IIN);
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                this.name = resultSet.getString("name");
                this.surname = resultSet.getString("surname");
                this.insurance = resultSet.getBoolean("insurance");
                this.payment = resultSet.getFloat("payment");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void  delete_table(Connection conn,String table_name){
        Statement statement;
        try {
            String query=String.format("drop table %s",table_name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }


}