package com.java.inheritance;

public class PermanentEmployee extends Employee {

    public PermanentEmployee(String name, String accountNumber, double earnings) {
        super(name, accountNumber, earnings);
    }

    /*
     * Returns 40% of employee earnings as salary.
     * 
     * @see com.java.inheritance.Employee#getSalary()
     */
    @Override
    public double getSalary() {
        return (earnings * 80) / 100;
    }

}
