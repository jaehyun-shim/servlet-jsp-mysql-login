package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        Connection conn = DBUtil.getConnection();
        if (conn != null) {
            System.out.println("Connection");

            //Statement st;
            try {
                //st = conn.createStatement();
                //ResultSet rs = st.executeQuery("SELECT * FROM TheUser");
                PreparedStatement ps = conn
                        .prepareStatement("select * from user where username=? and password=?");
                ps.setString(1, "shim");
                ps.setString(2, "cho");

                ResultSet rs = ps.executeQuery();
                while (rs.next())
                    System.out.print(rs.getString("username") + rs.getString("password"));

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else
            System.out.println(" No Connection");
    }
}
