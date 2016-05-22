package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnection {

    private DBConnection() {

    }

    public static Connection con;

    private static final Logger LOGGER = LoggerFactory.getLogger(DBConnection.class);

    /**
     * Creates a singleton connection with Oracle DB
     * 
     * @return {@link Connection}
     */
    public static synchronized Connection getConnection() {
        final String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            if (con == null) {
                LOGGER.info("Connection is not created earlier, hence creating newly...");
                con = DriverManager.getConnection(url, "SYSTEM", "password");
            }
        } catch (SQLException e) {
            LOGGER.error("Not able to create Oracle connection - ", e);
        }
        return con;
    }

    public static synchronized Long getNextEmpId() {
        Long nextId = 0L;
        try {
            LOGGER.info("Trying to fetch next id for employee");
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select EMPLOYEE_SEQ.nextval from dual");
            if (rs != null && rs.next()) {
                nextId = rs.getLong(1);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception while fetching next employee id - ", e);
        }
        return nextId;
    }

}
