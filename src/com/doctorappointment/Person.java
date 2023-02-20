package com.doctorappointment;

import java.sql.Connection;

public abstract class Person{

    private int id;
    private static int id_gen = 1;
    protected String name;
    private String surname;
    private int age;

    public Person(){
        id = id_gen++;
    }

    public Person(int id, String name, String surname,int age, String phone_num){
        this.name=name;
        this.surname = surname;
        this.age = age;
    }

    ///Getters
    public int getID(){
        return id;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }

    ///Setters
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public abstract void createTable(Connection conn, String table_name);
}