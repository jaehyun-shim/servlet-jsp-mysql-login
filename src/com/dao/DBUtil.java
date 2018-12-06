package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn != null)
            return conn;
        else {
            try {
                String url = "your-url";
                String driver = "com.mysql.jdbc.Driver";
                String username = "your-name";
                String password = "your-password";

                Class.forName(driver);
                DriverManager.setLoginTimeout(3600);
                conn = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();

            }
            return conn;
        }
    }
}
