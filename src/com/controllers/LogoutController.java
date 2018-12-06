package com.controllers;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Logout", urlPatterns = { "/Logout" })//set in web.xml
public class LogoutController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String LOGINVIEW= "/view/index.jsp";

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		session.invalidate();

        //response.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html; charset=UTF-8");
        //PrintWriter pwOut = response.getWriter();
        //pwOut.print("You have successfully logged out");
        //pwOut.print("<p style=\"color:red\">Incorrect Username or Password!</p>");
        //pwOut.close();
		System.out.println(":::: Page_Logout ::::");

		RequestDispatcher view = request.getRequestDispatcher(LOGINVIEW);
		view.forward(request, response);
	}
}
