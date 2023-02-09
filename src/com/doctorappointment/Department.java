package com.doctorappointment;

import java.lang.reflect.Array;

public class Department {
    private String name;
    private String head;
    private Array doctors;
    public Department(String name, String head, Array doctors) {
        this.name = name;
        this.head = head;
        this.doctors = doctors;
    }

    public String getDoctorName(){
        return name;
    }
    public String getHeadName(){
        return head;
    }
    public Array getDoctorList(){
        return doctors;
    }

    public void setDoctorName(String name){
        this.name = name;
    }
    public void setHeadName(String head){
        this.head = head;
    }
    public void setDoctorList(Array doctors){
        this.doctors = doctors;
    }
}