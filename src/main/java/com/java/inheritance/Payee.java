package com.java.inheritance;

/**
 * An interface, which helps to configure rules for Salary deposit
 * 
 * @author Paramesh
 *
 */
public interface Payee {
    
    /**
     * Returns name of an employee
     * 
     * @return name
     */
    public abstract String getName();
    
    /**
     * Returns Account Number of the Employee
     * 
     * @return account number
     */
    public abstract String getAccountNumber();
    
    /**
     * Calculates salary of an employee based on the employee category.
     * 
     * @return salary
     */
    public abstract double getSalary();

}
