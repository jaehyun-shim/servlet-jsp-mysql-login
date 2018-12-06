package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.LoginModel;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String EDIT_VIEW = "/view/inc/edit.jsp";
    private static String USER_ADMIN_VIEW = "/view/userAdmin.jsp";
    private static String MAIN_VIEW = "/view/main.jsp";
    private static String LOGIN_VIEW = "/view/index.jsp";
    private static String ERROR_404_VIEW = "/view/error/404.jsp";
    private static String ERROR_500_VIEW = "/view/error/500.jsp";

    private UserDao dao;

    public LoginController() {
        super();
        dao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectPage = "/view/index.jsp";
        String action = request.getParameter("action");
        String stringUrl = request.getContextPath();
        HttpSession session = request.getSession();
        System.out.println("# GetContextPath_URL_Login : " + stringUrl);

        if (session != null) {
            if (!session.getAttribute("username").equals("")) {
                redirectPage = MAIN_VIEW;
            }
        }

        if (action != null) {
            if (action.equalsIgnoreCase("remove")) {
                int userid = Integer.parseInt(request.getParameter("userid"));
                dao.deleteAccount(userid);
                redirectPage = USER_ADMIN_VIEW;
                request.setAttribute("users", dao.listUsers());
            } else if (action.equalsIgnoreCase("listUsers")) {
                redirectPage = USER_ADMIN_VIEW;
                request.setAttribute("users", dao.listUsers());
            } else if (action.equalsIgnoreCase("edit")) {
                redirectPage = EDIT_VIEW;
                int userId = Integer.parseInt(request.getParameter("userid"));
                LoginModel user = dao.getUserByID(userId);
                request.setAttribute("user", user);
            } else if (action.equalsIgnoreCase("404")) {
                redirectPage = ERROR_404_VIEW;
            } else if (action.equalsIgnoreCase("500")) {
                redirectPage = ERROR_500_VIEW;
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(redirectPage);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pwOut = response.getWriter();
        String em = request.getParameter("email");
        String pw = request.getParameter("password");

        if (dao.validateLogin(em, pw)) {
            LoginModel user = dao.userSession(em);
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            session.setAttribute("email", em);
            RequestDispatcher view = request.getRequestDispatcher(MAIN_VIEW);
            view.forward(request, response);

        } else {
            RequestDispatcher view = request.getRequestDispatcher(LOGIN_VIEW);
            view.forward(request, response);

        }

        pwOut.close();
    }
}
