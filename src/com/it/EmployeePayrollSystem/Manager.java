package com.it.EmployeePayrollSystem;

public class Manager extends Employee{
	private double basicSalary;
    private double bonus;

    public Manager(int id, String name, String department,
                   double basicSalary, double bonus) {

        super(id, name, department);
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }
    public double getBasicSalary() {
        return basicSalary;
    }

    public double getBonus() {
        return bonus;
    }
    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

}
