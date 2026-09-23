package com.it.EmployeePayrollSystem;
public class PartTimeEmployee extends Employee {
	private double hourlyRate;
    private int hoursWorked;
    public PartTimeEmployee(int id, String name, String department,
                            double hourlyRate, int hoursWorked) {
        super(id, name, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
