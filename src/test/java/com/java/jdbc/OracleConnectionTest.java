package com.java.jdbc;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class OracleConnectionTest {

    @Test
    public void getConnection() {
        Connection con1 = DBConnection.getConnection();
        Connection con2 = DBConnection.getConnection();

        Assert.assertSame(con1, con2);
    }

}
