package com.java.jdbc;

import java.util.Date;
import java.util.UUID;

public class EmployeeSalary {

    private String transactionId;

    private Long empId;

    private Double salary;

    private Date issuedDate;

    public EmployeeSalary(Long empId, Double salary, Date issuedDate) {
        this.transactionId = UUID.randomUUID().toString();
        this.empId = empId;
        this.salary = salary;
        this.issuedDate = issuedDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

}
