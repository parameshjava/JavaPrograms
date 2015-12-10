package com.java.inheritance;

/**
 * An Employee with default implementation.
 * 
 * @author Paramesh
 *
 */
public abstract class Employee implements Payee {

    protected String name;

    protected String accountNumber;

    protected double earnings;

    public Employee(String name, String accountNumber, double earnings) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.earnings = earnings;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public abstract double getSalary();

}
