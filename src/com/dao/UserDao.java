package com.dao;

import com.model.LoginModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection conn;

    public UserDao() {

        conn = DBUtil.getConnection();
    }

    public boolean validateLogin(String em, String pw) {
        boolean canLogin = false;

        try {
            PreparedStatement ps = conn
                    .prepareStatement("select * from user where email=? and password=?");
            ps.setString(1, em);
            ps.setString(2, pw);

            ResultSet rs = ps.executeQuery();
            canLogin = rs.next(); //true if found else false
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return canLogin;
    }

    public LoginModel userSession(String em) {
        LoginModel user = new LoginModel();
        try {
            PreparedStatement ps = conn
                    .prepareStatement("select * from user where email=?");
            ps.setString(1, em);

            ResultSet rs = ps.executeQuery();

            loginResultSet(user, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private void loginResultSet(LoginModel user, ResultSet rs) throws SQLException {
        if (rs.next()) {
            user.setUserid(rs.getInt("userid"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
        }
    }

    public void createUser(LoginModel user) {
        try {
            PreparedStatement ps = conn
                    .prepareStatement("insert into user(username,password,email) values (?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editAccount(LoginModel user) {
        try {
            PreparedStatement ps = conn
                    .prepareStatement("update user set username=?, email=?, password=?" + " where userid=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getUserid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int userid) {
        try {
            PreparedStatement ps = conn
                    .prepareStatement("delete from user where userid=?");
            ps.setInt(1, userid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LoginModel> listUsers() {
        List<LoginModel> userList = new ArrayList<LoginModel>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while (rs.next()) {
                LoginModel user = new LoginModel();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public LoginModel getUserByID(int userid) {
        LoginModel user = new LoginModel();
        try {
            PreparedStatement ps = conn
                    .prepareStatement("select * from user where userid= ?");
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();

            loginResultSet(user, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
