package com.it.EmployeePayrollSystem;

public class FullTimeEmployee extends Employee{
	private double monthlySalary;

    public FullTimeEmployee(int id, String name, String department,
                            double monthlySalary) {

        super(id, name, department);
        this.monthlySalary = monthlySalary;
    }
    public double getMonthlySalary() {
        return monthlySalary;
    }
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

}
