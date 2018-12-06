package com.controllers;

import com.dao.UserDao;
import com.model.LoginModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Index", urlPatterns = { "/"})
public class IndexController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String MAIN_VIEW= "/view/main.jsp";
    private static String LOGIN_VIEW= "/view/index.jsp";
	private UserDao dao;

	public IndexController()
	{
		super();
		dao = new UserDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		String redirectPage= LOGIN_VIEW;
        HttpSession session = request.getSession();

		if (session.getAttribute("username") != null){
			redirectPage= MAIN_VIEW;
			System.out.println("IndexPage_HttpSession_OK");
		}

		RequestDispatcher view = request.getRequestDispatcher(redirectPage);
		view.forward(request, response);

	}
}
