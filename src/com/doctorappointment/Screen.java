package com.doctorappointment;

import java.sql.*;
import java.util.Scanner;
public class Screen {
    Scanner scanner = new Scanner(System.in);
    Dbfunctions db = new Dbfunctions();
<<<<<<< HEAD
    Patient patient=new Patient();
    Employee employee=new Employee();
    Appointment appointment=new Appointment();
    Payment payment=new Payment();
    public void employeeTab(){
=======
    Patient patient = new Patient();
    Employee employee = new Employee();
    Appointment appointment = new Appointment();
    Payment payment = new Payment();

    public void employeeTab() {
>>>>>>> origin/master
        //employee.createTable(db.connect_to_db("postgres","postgres","DDAA2005"),"employee");
        //employee.addDoc(db.connect_to_db("postgres","postgres","DDAA2005"),"employee","Muhtar","Aliev","Therapist","13:00-16:00","7000" );
        //employee.addDoc(db.connect_to_db("postgres","postgres","DDAA2005"),"employee","Alisher","Maratov","Dermatologist","9:00-12:00","8000" );
        //employee.addDoc(db.connect_to_db("postgres","postgres","DDAA2005"),"employee","Maksat","Utepov","Surgeon","12:00-15:00","10000" );
        //employee.addDoc(db.connect_to_db("postgres","postgres","DDAA2005"),"employee","Kairat","Nurtas","Psychiatrist","18:00-19:00","5000" );
        //employee.addDoc(db.connect_to_db("postgres","postgres","DDAA2005"),"employee","Dimash","Bolatov","Neuropathologist","14:00-16:00","7500" );
    }

<<<<<<< HEAD
    public void screenFunctions(){
        Connection conn=db.connect_to_db("postgres","postgres","DDAA2005");
        while(true) {
=======
    public void screenFunctions() {
        Connection conn = db.connect_to_db("postgres", "postgres", "DDAA2005");
        while (true) {
>>>>>>> origin/master
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
<<<<<<< HEAD
            }

        }}}
=======
            } else if (command == 2) {
                System.out.println("Do you want to continue?(Yes(Y)/No(N))");
                String input = scanner.next();
                try {
                    if (input.equalsIgnoreCase("N")) {
                        System.out.println("Exiting...");
                        continue;
                    } else if (input.equalsIgnoreCase("Y")) {
                        int fee2 = scanner.nextInt();
                        String sql = "update patients set payment =? where id = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        System.out.println("Input patient id:");
                        int patientId = scanner.nextInt();
                        preparedStatement.setInt(1, fee2);
                        preparedStatement.setInt(2, patientId);
                        preparedStatement.executeUpdate();
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please enter 'exit' or 'continue'.");
                    }
                } catch (IllegalArgumentException | SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (command == 3) {
                System.out.println("Do you want to continue?(Yes(Y)/No(N))");
                String input = scanner.next();
                try {
                    if (input.equalsIgnoreCase("N")) {
                        System.out.println("Exiting...");
                        continue;
                    } else if (input.equalsIgnoreCase("Y")) {
                        String sql = "insert into patients(IIN, name, surname, gender, age, insurance, payment) values(?, ?, ?, ?, ?, ?, ?);";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        System.out.println("Add a patient: ");
                        scanner.nextLine();
                        System.out.println("Input patient IIN:");
                        String IIN = scanner.nextLine();
                        System.out.println("Input patient name:");
                        String name = scanner.nextLine();
                        System.out.println("Input patient surname:");
                        String surname = scanner.nextLine();
                        System.out.println("Input patient gender(Male/Female):");
                        String gender = scanner.nextLine();
                        if (gender.equals("male") || gender.equals("female")) {
                        } else {
                            throw new IllegalArgumentException("Error: Incorrect data entered for gender. Please enter either 'male' or 'female'.");
                        }
                        System.out.println("Input patient age:");
                        int age = Integer.parseInt(scanner.nextLine());
                        //System.out.println("Input patient address:");
                        // int address =Integer.parseInt(scanner.nextLine());
                        System.out.println("Input patient insurance:");
                        boolean insurance = Boolean.parseBoolean(scanner.nextLine());
                        System.out.println("Input service fee:");
                        String payment = scanner.nextLine();
                        preparedStatement.setString(1, IIN);
                        preparedStatement.setString(2, name);
                        preparedStatement.setString(3, surname);
                        preparedStatement.setString(4, gender);
                        preparedStatement.setInt(5, age);
                        // preparedStatement.setInt(6, address);
                        preparedStatement.setBoolean(6, insurance);
                        preparedStatement.setString(7, payment);
                        preparedStatement.executeUpdate();
                    } else {
                        throw new IllegalArgumentException("Invalid input. Please enter 'exit' or 'continue'.");
                    }
                } catch (IllegalArgumentException | SQLException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
>>>>>>> origin/master
