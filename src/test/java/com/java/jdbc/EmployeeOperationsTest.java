package com.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.java.jdbc.Employee;
import com.java.jdbc.EmployeeOperations;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DBConnection.class)
public class EmployeeOperationsTest {

    private Connection con = Mockito.mock(Connection.class);

    private Statement stmt = Mockito.mock(Statement.class);

    private PreparedStatement pstmt = Mockito.mock(PreparedStatement.class);

    private ResultSet rs = Mockito.mock(ResultSet.class);

    @Test
    public void insertByStatement() throws SQLException {
        final String sql = String.format(
                "insert into EMPLOYEE (ID, FIRSTNAME, LASTNAME, EMAILID, MOBILENUMBER) VALUES (%s, '%s', '%s', '%s', '%s')",
                10, "Sashwin", "K", "sashiwin.k@gmail.com", "+91999999999");
        PowerMockito.mockStatic(DBConnection.class);
        PowerMockito.when(DBConnection.getNextEmpId()).thenReturn(10L);
        PowerMockito.when(DBConnection.getConnection()).thenReturn(con);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(sql)).thenReturn(rs);
        Mockito.when(rs.next()).thenReturn(true);

        int count = EmployeeOperations.insertByStatement("Sashwin", "K", "sashiwin.k@gmail.com", "+91999999999");
        Assert.assertEquals(1, count);
    }

    @Test
    public void insertByStatementException() throws SQLException {
        final String sql = String.format(
                "insert into EMPLOYEE (ID, FIRSTNAME, LASTNAME, EMAILID, MOBILENUMBER) VALUES (%s, '%s', '%s', '%s', '%s')",
                10, "Sashwin", "K", "sashiwin.k@gmail.com", "+91999999999");
        PowerMockito.mockStatic(DBConnection.class);
        PowerMockito.when(DBConnection.getNextEmpId()).thenReturn(10L);
        PowerMockito.when(DBConnection.getConnection()).thenReturn(con);
        Mockito.when(con.createStatement()).thenReturn(stmt);
        Mockito.when(stmt.executeQuery(sql)).thenThrow(new SQLException());

        try {
            EmployeeOperations.insertByStatement("Sashwin", "K", "sashiwin.k@gmail.com", "+91999999999");
        } catch (Exception exp) {
            Assert.assertTrue(exp instanceof SQLException);
        }
    }

    @Test
    public void insertByPreparedStatement() throws SQLException {
        Employee emp1 = new Employee("Nagaraj", "K", "nagaraj.k@gmail.com", "+91999999991");
        Employee emp2 = new Employee("Paramesh", "K", "paramesh.k@gmail.com", "+91999999992");

        List<Employee> employees = Arrays.asList(emp1, emp2);

        PowerMockito.mockStatic(DBConnection.class);
        PowerMockito.when(DBConnection.getConnection()).thenReturn(con);
        Mockito.when(con.prepareStatement(
                "insert into EMPLOYEE (ID, FIRSTNAME, LASTNAME, EMAILID, MOBILENUMBER) VALUES (?, ?, ?, ?, ?)"))
                .thenReturn(pstmt);
        // When first time call employee sequence number, return 1, for second call return 11.
        PowerMockito.when(DBConnection.getNextEmpId()).thenReturn(10L).thenReturn(11L);
        Mockito.doNothing().when(pstmt).setLong(1, 10L);
        Mockito.doNothing().when(pstmt).setString(Mockito.anyInt(), Mockito.anyString());

        Mockito.when(pstmt.executeQuery()).thenReturn(rs);
        Mockito.when(rs.next()).thenReturn(true).thenReturn(true);

        int count = EmployeeOperations.insertByPrearedStatement(employees);
        Assert.assertEquals(2, count);
    }

    @Test
    public void insertByPreparedStatementInsertionFail() throws SQLException {
        Employee emp1 = new Employee("Nagaraj", "K", "nagaraj.k@gmail.com", "+91999999991");
        Employee emp2 = new Employee("Paramesh", "K", "paramesh.k@gmail.com", "+91999999992");

        List<Employee> employees = Arrays.asList(emp1, emp2);

        PowerMockito.mockStatic(DBConnection.class);
        PowerMockito.when(DBConnection.getConnection()).thenReturn(con);
        Mockito.when(con.prepareStatement(
                "insert into EMPLOYEE (ID, FIRSTNAME, LASTNAME, EMAILID, MOBILENUMBER) VALUES (?, ?, ?, ?, ?)"))
                .thenReturn(pstmt);
        // When first time call employee sequence number, return 1, for second call return 11.
        PowerMockito.when(DBConnection.getNextEmpId()).thenReturn(10L).thenReturn(11L);
        Mockito.doNothing().when(pstmt).setLong(1, 10L);
        Mockito.doNothing().when(pstmt).setString(Mockito.anyInt(), Mockito.anyString());

        Mockito.when(pstmt.executeQuery()).thenReturn(rs);
        Mockito.when(rs.next()).thenThrow(new SQLException());
        Mockito.when(rs.getStatement()).thenReturn(stmt).thenReturn(stmt);

        int insertionCount = EmployeeOperations.insertByPrearedStatement(employees);
        Assert.assertEquals(0, insertionCount);
    }

    @Test
    public void insertByPreparedStatementException() throws SQLException {
        Employee emp1 = new Employee("Nagaraj", "K", "nagaraj.k@gmail.com", "+91999999991");
        Employee emp2 = new Employee("Paramesh", "K", "paramesh.k@gmail.com", "+91999999992");

        List<Employee> employees = Arrays.asList(emp1, emp2);

        PowerMockito.mockStatic(DBConnection.class);
        PowerMockito.when(DBConnection.getConnection()).thenReturn(con);
        Mockito.when(con.prepareStatement(
                "insert into EMPLOYEE (ID, FIRSTNAME, LASTNAME, EMAILID, MOBILENUMBER) VALUES (?, ?, ?, ?, ?)"))
                .thenThrow(new SQLException());

        try {
            EmployeeOperations.insertByPrearedStatement(employees);
        } catch (Exception exp) {
            Assert.assertTrue(exp instanceof SQLException);
        }
    }

}
