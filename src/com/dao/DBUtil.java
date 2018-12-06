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
                String url = "jdbc:mysql://shimdbinstance.cmpytcfduasf.ap-northeast-2.rds.amazonaws.com:3306/portfoliodb";
                String driver = "com.mysql.jdbc.Driver";
                String username = "shimdbmaster";
                String password = "!tla2995";

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