package com.java.inheritance;

/**
 * Contract Employee
 * 
 * @author Paramesh
 *
 */
public class ContractEmployee extends Employee {

    public ContractEmployee(String name, String accountNumber, double earnings) {
        super(name, accountNumber, earnings);
    }

    /*
     * Returns 40% of employee earnings as salary.
     * 
     * @see com.java.inheritance.Employee#getSalary()
     */
    @Override
    public double getSalary() {
        return (earnings * 40) / 100;
    }

}
