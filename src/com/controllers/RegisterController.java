package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.LoginModel;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String USER_ADMIN_VIEW = "/view/userAdmin.jsp";
    private static String INDEX_VIEW = "/view/main.jsp";
    private UserDao dao;

    public RegisterController() {
        super();
        dao = new UserDao();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginModel user = new LoginModel();
        String un = request.getParameter("username");
        String pw = request.getParameter("password");
        String email = request.getParameter("email");
        String userID = request.getParameter("userid");
        user.setUsername(un);
        user.setPassword(pw);
        user.setEmail(email);

        if (userID == null || userID.isEmpty()) {
            dao.createUser(user);
            RequestDispatcher view = request.getRequestDispatcher(INDEX_VIEW);
            view.forward(request, response);
        } else {
            user.setUserid(Integer.parseInt(userID));
            dao.editAccount(user);
            request.setAttribute("users", dao.listUsers());
            RequestDispatcher view = request.getRequestDispatcher(USER_ADMIN_VIEW);
            view.forward(request, response);
        }
    }
}
