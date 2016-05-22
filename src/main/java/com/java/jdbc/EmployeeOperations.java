package com.java.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeOperations {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeOperations.class);

    public static int insertByStatement(String firstName, String lastName, String emailId, String mobileNumber) {
        // Fetch the next id from Employee sequence
        Long nextId = DBConnection.getNextEmpId();

        // Create and populate employee record to insert to DB
        String recordInsert = String.format(
                "insert into EMPLOYEE (ID, FIRSTNAME, LASTNAME, EMAILID, MOBILENUMBER) VALUES (%s, '%s', '%s', '%s', '%s')",
                nextId, firstName, lastName, emailId, mobileNumber);

        try {
            // Creating a statement object to pass the sql query string to DB
            Statement stmt = DBConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(recordInsert);
            if (rs.next()) {
                // Record inserted successfully
                return 1;
            }
        } catch (SQLException e) {
            // Record insertion failed
            LOGGER.error("Insertion failed for Query String : {}", recordInsert, e);
        }

        return 0;
    }

    public static int insertByPrearedStatement(List<Employee> employees) {
        int insertionCount = 0;
        try {

            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(
                    "insert into EMPLOYEE (ID, FIRSTNAME, LASTNAME, EMAILID, MOBILENUMBER) VALUES (?, ?, ?, ?, ?)");
            for (Employee emp : employees) {
                LOGGER.info("Trying to insert employee : {} " + emp.toString());
                // Fetch the next id from Employee sequence
                Long nextId = DBConnection.getNextEmpId();
                stmt.setLong(1, nextId);
                stmt.setString(2, emp.getFirstname());
                stmt.setString(3, emp.getLastName());
                stmt.setString(4, emp.getEmailId());
                stmt.setString(5, emp.getMobileNumber());
                ResultSet rs = null;
                try {
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        // Record inserted successfully, hence incrementing the insertion count by 1
                        insertionCount = insertionCount + 1;
                        LOGGER.info("Insertion successfull..");
                    }
                } catch (SQLException e) {
                    LOGGER.warn("Exception while inserting record : {}", rs.getStatement().toString(), e);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Exception while creating prepared statement : ", e);
        }
        return insertionCount;
    }

    public static void insertEmployeeSalary(EmployeeSalary... empSalaries) {
        try {

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(
                    "insert into EMPLOYEE_SALARY (TRANSACTION_ID, EMPLOYEE_ID, SALARY, ISSUED_DATE) VALUES (?, ?, ?, ?)");
            for (EmployeeSalary empSalary : empSalaries) {
                stmt.setString(1, empSalary.getTransactionId());
                stmt.setLong(2, empSalary.getEmpId());
                stmt.setDouble(3, empSalary.getSalary());
                stmt.setDate(4, sqlDate);
                stmt.executeQuery();
            }
        } catch (SQLException e) {
            LOGGER.error("Exception while inserting employee record : ", e);
        }
    }

    public List<Employee> getEmployees() {
        final String queryString = "select * from employee";
        List<Employee> employees = new ArrayList<>();
        Statement stmt;
        try {
            stmt = DBConnection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(queryString);
            if (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getLong("ID"));
                emp.setFirstname("FIRSTNAME");
                emp.setLastName("LASTNAME");
                emp.setEmailId(rs.getString("EMAILID"));
                emp.setMobileNumber(rs.getString("MOBILENUMBER"));
                emp.setCreationDate(new Date(rs.getDate("CREATIONTIME").getTime()));
                employees.add(emp);
            }
        } catch (SQLException e) {
            LOGGER.error("Not able to fetch employee record....");
        }

        return employees;
    }
}
