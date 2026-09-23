package com.it.EmployeePayrollSystem;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EmployeeService service = new EmployeeService();

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            int choice;

            do {

                System.out.println();
                System.out.println("===== EMPLOYEE PAYROLL MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Full-Time Employee");
                System.out.println("2. Add Part-Time Employee");
                System.out.println("3. Add Manager");
                System.out.println("4. View All Employees");
                System.out.println("5. Search Employee");
                System.out.println("6. Update Employee Department");
                System.out.println("7. Delete Employee");
                System.out.println("8. Exit");

                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        service.addFullTimeEmployee(con, scanner);
                        break;

                    case 2:
                        service.addPartTimeEmployee(con, scanner);
                        break;

                    case 3:
                        service.addManager(con, scanner);
                        break;

                    case 4:
                        service.viewAllEmployees(con);
                        break;

                    case 5:
                        service.searchEmployee(con, scanner);
                        break;

                    case 6:
                        service.updateEmployeeDepartment(con, scanner);
                        break;

                    case 7:
                        service.deleteEmployee(con, scanner);
                        break;

                    case 8:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 8);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (con != null) {
                    con.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }

            scanner.close();
        }
    }
}