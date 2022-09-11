package com.session;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		switch (action) {
		case "login": {
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String action = request.getParameter("action");
		switch (action) {
		case "loginSubmit": {
			auth(request,response);
			break;
			
		}
		
		case "login":
			request.getRequestDispatcher("login.jsp");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		
	}
	
	protected void auth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String pass = request.getParameter("password");
		String sec = response.encodeUrl(request.getContextPath());
		if(username.equals("Kadyan") && pass.equals("Ab@12345"))
		{
			request.getSession().invalidate();
			
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(500);
//			Cookie ck = new Cookie("UserName", username);
//			response.addCookie(ck);			
			newSession.setAttribute("username", username);
			//response.sendRedirect("Homepage.jsp");
			response.sendRedirect(sec+"/Logout?action=member");
			
		}
		else
		{
			response.sendRedirect(sec+"/Login?action=login");
		}
		
	}

}
