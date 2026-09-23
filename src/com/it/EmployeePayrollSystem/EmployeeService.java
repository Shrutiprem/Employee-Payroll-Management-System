package com.it.EmployeePayrollSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeService {

    // ADD FULL-TIME EMPLOYEE
    public void addFullTimeEmployee(Connection con, Scanner sc) {

        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Employee Name:");
        String name = sc.nextLine();

        System.out.println("Enter Department:");
        String department = sc.nextLine();

        System.out.println("Enter Monthly Salary:");
        double monthlySalary = sc.nextDouble();

        String query = "INSERT INTO employees "
                + "(id, name, department, employee_type, monthly_salary) "
                + "VALUES (" + id + ", '" + name + "', '" + department
                + "', 'FULL_TIME', " + monthlySalary + ")";

        try {

            Statement stmt = con.createStatement();

            int count = stmt.executeUpdate(query);

            if (count > 0) {
                System.out.println("Full-Time Employee added successfully.");
            } else {
                System.out.println("Try again.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ADD PART-TIME EMPLOYEE
    public void addPartTimeEmployee(Connection con, Scanner sc) {

        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Employee Name:");
        String name = sc.nextLine();

        System.out.println("Enter Department:");
        String department = sc.nextLine();

        System.out.println("Enter Hourly Rate:");
        double hourlyRate = sc.nextDouble();

        System.out.println("Enter Hours Worked:");
        int hoursWorked = sc.nextInt();

        String query = "INSERT INTO employees "
                + "(id, name, department, employee_type, hourly_rate, hours_worked) "
                + "VALUES (" + id + ", '" + name + "', '" + department
                + "', 'PART_TIME', " + hourlyRate + ", " + hoursWorked + ")";

        try {

            Statement stmt = con.createStatement();

            int count = stmt.executeUpdate(query);

            if (count > 0) {
                System.out.println("Part-Time Employee added successfully.");
            } else {
                System.out.println("Try again.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ADD MANAGER
    public void addManager(Connection con, Scanner sc) {

        System.out.println("Enter Manager ID:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Manager Name:");
        String name = sc.nextLine();

        System.out.println("Enter Department:");
        String department = sc.nextLine();

        System.out.println("Enter Basic Salary:");
        double basicSalary = sc.nextDouble();

        System.out.println("Enter Bonus:");
        double bonus = sc.nextDouble();

        String query = "INSERT INTO employees "
                + "(id, name, department, employee_type, basic_salary, bonus) "
                + "VALUES (" + id + ", '" + name + "', '" + department
                + "', 'MANAGER', " + basicSalary + ", " + bonus + ")";

        try {

            Statement stmt = con.createStatement();

            int count = stmt.executeUpdate(query);

            if (count > 0) {
                System.out.println("Manager added successfully.");
            } else {
                System.out.println("Try again.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // VIEW ALL EMPLOYEES
    public void viewAllEmployees(Connection con) {

        String query = "SELECT * FROM employees";

        try {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println(
                    "+--------------------------------------------------------------------------------------+"
            );

            System.out.println(
                    "ID\tNAME\t\tDEPARTMENT\tTYPE\t\tSALARY"
            );

            System.out.println(
                    "+--------------------------------------------------------------------------------------+"
            );

            while (rs.next()) {

                int id = rs.getInt("id");

                String name = rs.getString("name");

                String department = rs.getString("department");

                String type = rs.getString("employee_type");

                double salary = 0;

                if (type.equals("FULL_TIME")) {

                    salary = rs.getDouble("monthly_salary");

                } else if (type.equals("PART_TIME")) {

                    double hourlyRate =
                            rs.getDouble("hourly_rate");

                    int hoursWorked =
                            rs.getInt("hours_worked");

                    salary = hourlyRate * hoursWorked;

                } else if (type.equals("MANAGER")) {

                    double basicSalary =
                            rs.getDouble("basic_salary");

                    double bonus =
                            rs.getDouble("bonus");

                    salary = basicSalary + bonus;
                }

                System.out.println(
                        id + "\t"
                        + name + "\t\t"
                        + department + "\t\t"
                        + type + "\t"
                        + salary
                );
            }

            System.out.println(
                    "+--------------------------------------------------------------------------------------+"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // SEARCH EMPLOYEE
    public void searchEmployee(Connection con, Scanner sc) {

        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();

        String query =
                "SELECT * FROM employees WHERE id = " + id;

        try {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            boolean found = false;

            System.out.println(
                    "+--------------------------------------------------------------------------------------+"
            );

            System.out.println(
                    "ID\tNAME\t\tDEPARTMENT\tTYPE\t\tSALARY"
            );

            System.out.println(
                    "+--------------------------------------------------------------------------------------+"
            );

            while (rs.next()) {

                found = true;

                int employeeId =
                        rs.getInt("id");

                String name =
                        rs.getString("name");

                String department =
                        rs.getString("department");

                String type =
                        rs.getString("employee_type");

                double salary = 0;

                if (type.equals("FULL_TIME")) {

                    salary =
                            rs.getDouble("monthly_salary");

                } else if (type.equals("PART_TIME")) {

                    double hourlyRate =
                            rs.getDouble("hourly_rate");

                    int hoursWorked =
                            rs.getInt("hours_worked");

                    salary =
                            hourlyRate * hoursWorked;

                } else if (type.equals("MANAGER")) {

                    double basicSalary =
                            rs.getDouble("basic_salary");

                    double bonus =
                            rs.getDouble("bonus");

                    salary =
                            basicSalary + bonus;
                }

                System.out.println(
                        employeeId + "\t"
                        + name + "\t\t"
                        + department + "\t\t"
                        + type + "\t"
                        + salary
                );
            }

            System.out.println(
                    "+--------------------------------------------------------------------------------------+"
            );

            if (!found) {
                System.out.println(
                        "Employee with ID " + id + " not found."
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // UPDATE EMPLOYEE DEPARTMENT
    public void updateEmployeeDepartment(Connection con, Scanner sc) {

        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter New Department:");
        String department = sc.nextLine();

        String query =
                "UPDATE employees SET department = '"
                + department + "' WHERE id = " + id;

        try {

            Statement stmt = con.createStatement();

            int count = stmt.executeUpdate(query);

            if (count > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee not found. Try again.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // DELETE EMPLOYEE
    public void deleteEmployee(Connection con, Scanner sc) {

        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();

        String query =
                "DELETE FROM employees WHERE id = " + id;

        try {

            Statement stmt = con.createStatement();

            int count = stmt.executeUpdate(query);

            if (count > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found. Try again.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}