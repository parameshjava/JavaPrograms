package com.java.inheritance;

import java.util.ArrayList;
import java.util.List;

public class SalaryProcessSystem {

    private List<Payee> payees;

    public SalaryProcessSystem() {
        payees = new ArrayList<>();
    }

    public void addPayee(Payee payee) {
        if (!payees.contains(payee)) {
            payees.add(payee);
        }
    }

    public void processPayments() {
        for (Payee payee : payees) {
            System.out.println("Depositing salry to Employee");

            System.out.println("\tName \t:  " + payee.getName());
            System.out.println("\tAccount \t:" + payee.getAccountNumber());
            System.out.println("\tSalary \t:" + payee.getSalary());
        }
    }
}