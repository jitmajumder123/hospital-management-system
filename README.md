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

✨ Features
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
1.Create a Database:
```sql
CREATE DATABASE hospital_db;
```

## 2.Use a Database:
```sql
USE hospital_db;
```

### 3.Patients Table:
```sql
CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT CHECK (age > 0),
    gender VARCHAR(10),
    phone VARCHAR(15) UNIQUE
);
```
### 4.Doctors Table:
```sql
CREATE TABLE doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    specialization VARCHAR(50),
    available BOOLEAN DEFAULT true
);
```

### 5.Appointments Table:
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
