# Hospital Management System
📌 Project Overview

The Hospital Management System is a Java-based console application developed using JDBC and MySQL.
It helps manage patients, doctors, and appointments efficiently while demonstrating real-world Java–database integration.

# Technologies Used
Java (Core Java)
JDBC
MySQL
SQL
OOP Concepts

## Features
Patient registration and search
Doctor management with specialization
Appointment booking system
Duplicate appointment prevention
Secure database operations using PreparedStatement
Exception handling for stability
Menu-driven console interface

## Database Tables
patients
doctors
appointments

## Database Setup:
## 1.Create a Database:
```sql
CREATE DATABASE hospital_db;
```

## 2.Use a Database:
```sql
USE hospital_db;
```
## Create Tables:
### 1.Patients Table:
```sql
CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT CHECK (age > 0),
    gender VARCHAR(10),
    phone VARCHAR(15) UNIQUE
);
```
### 2.Doctors Table:
```sql
CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    specialization VARCHAR(50),
    available BOOLEAN DEFAULT true
);
```

### 3.Appointments Table:
```sql
CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    date DATE,
    UNIQUE(patient_id, doctor_id, date),
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);
```
### 4.Main:
```sql

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Add Doctor");
            System.out.println("4. Book Appointment");
            System.out.println("5. Exit");

            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> PatientService.addPatient();
                case 2 -> PatientService.searchPatientById();
                case 3 -> DoctorService.addDoctor();
                case 4 -> AppointmentService.bookAppointment();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
```
### 5.DBConnection:
```sql
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "root";
    private static final String PASS = "Password@123";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            return null;
        }
    }
}
```
