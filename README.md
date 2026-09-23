# Employee Payroll Management System

## Overview

The **Employee Payroll Management System** is a Java-based console application developed using **Core Java, JDBC, and MySQL**.

The application allows users to manage employee records, perform CRUD operations, and calculate salaries based on different employee types.

## Technologies Used

* Java
* JDBC
* MySQL
* Eclipse IDE

## Employee Types

The system supports three types of employees:

* Full-Time Employee
* Part-Time Employee
* Manager

## Features

* Add Full-Time Employee
* Add Part-Time Employee
* Add Manager
* View All Employees
* Search Employee by ID
* Update Employee Department
* Delete Employee
* Calculate salary based on employee type
* Store employee information in MySQL database

## CRUD Operations

The application performs the following database operations using JDBC:

| Operation | Function                             |
| --------- | ------------------------------------ |
| Create    | Add new employee                     |
| Read      | View all employees / Search employee |
| Update    | Update employee department           |
| Delete    | Delete employee                      |

## Salary Calculation

The salary is calculated according to the employee type:

### Full-Time Employee

Salary = Monthly Salary

### Part-Time Employee

Salary = Hourly Rate × Hours Worked

### Manager

Salary = Basic Salary + Bonus

## Project Structure

```text
EmployeePayrollSystem
│
├── src
│   └── com
│       └── it
│           └── EmployeePayrollSystem
│               ├── DBConnection.java
│               ├── Employee.java
│               ├── EmployeeNotFoundException.java
│               ├── EmployeeService.java
│               ├── FullTimeEmployee.java
│               ├── Main.java
│               ├── Manager.java
│               └── PartTimeEmployee.java
│
├── .gitignore
└── README.md
```

## Database

The project uses **MySQL** as the database.

### Database Name

```text
employee_payroll
```

### Table Name

```text
employees
```

### Table Structure

The `employees` table contains:

* `id`
* `name`
* `department`
* `employee_type`
* `monthly_salary`
* `hourly_rate`
* `hours_worked`
* `basic_salary`
* `bonus`

## Database Setup

Create the database:

```sql
CREATE DATABASE employee_payroll;

USE employee_payroll;
```

Create the employees table:

```sql
CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    employee_type VARCHAR(30) NOT NULL,
    monthly_salary DOUBLE,
    hourly_rate DOUBLE,
    hours_worked INT,
    basic_salary DOUBLE,
    bonus DOUBLE
);
```

## JDBC Configuration

The database connection is handled using the `DBConnection.java` class.

Update the following values according to your MySQL configuration:

```java
private static final String URL =
        "jdbc:mysql://localhost:3306/employee_payroll";

private static final String USER = "root";

private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";
```

> Do not upload your actual MySQL password to GitHub. Use a placeholder such as `YOUR_MYSQL_PASSWORD`.

## Requirements

Before running the project, make sure you have:

* Java JDK installed
* MySQL Server installed
* Eclipse IDE
* MySQL Connector/J JDBC driver

## How to Run

1. Clone or download the repository.
2. Open the project in Eclipse.
3. Create the `employee_payroll` database in MySQL.
4. Create the `employees` table using the SQL query provided above.
5. Add the **MySQL Connector/J** JAR file to the Eclipse project's Build Path.
6. Update the database username and password in `DBConnection.java`.
7. Run `Main.java`.
8. Select an option from the console menu.

## Application Menu

```text
===== EMPLOYEE PAYROLL MANAGEMENT SYSTEM =====

1. Add Full-Time Employee
2. Add Part-Time Employee
3. Add Manager
4. View All Employees
5. Search Employee
6. Update Employee Department
7. Delete Employee
8. Exit
```

## Concepts Used

This project demonstrates:

* Object-Oriented Programming
* Abstraction
* Inheritance
* Polymorphism
* Encapsulation
* Exception Handling
* JDBC
* MySQL Database Connectivity
* CRUD Operations
* SQL Queries
* Console-Based Menu System

## Author

Shruti Sree K P

B.Tech Information Technology
St. Joseph's College of Engineering
