package com.doctorappointment;

public class Payment {
    private String doctor;
    private String department;
    private Float price;
    public Payment(String doctor, String department, Float price) {
        this.doctor = doctor;
        this.department = department;
        this.price = price;
    }

    public float calculateTotal() {
        return this.price;
    }

    public String getDoctor(){return doctor;}
    public String getDepartment(){return department;}
    public Float getPrice() {return price;}

    public String setDoctor(String doctor){this.doctor = doctor;}
    public String setDepartment(String department){this.department = department;}
    public Float setPrice(Float price){this.price = price;}

    public boolean processedPayment(Float amount) {
        if (amount < this.price) {
            console.log("Error: com.doctorappointment.Payment amount is less than the total cost");
            return false;
        }
        else {
            console.log("com.doctorappointment.Payment accepted. Thank you for your visit!");
            return true;
        }
    }
}