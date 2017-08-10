package com.quiz.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String un=request.getParameter("usr");
		String pw=request.getParameter("pwd");
		String usr=request.getParameter("optradio");
		if(usr.contentEquals("student"))
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
			PreparedStatement pst=con.prepareStatement("select * from student");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				if(un.equals(rs.getString(1)) && pw.equals(rs.getString(2)))
				{
					RequestDispatcher rd=request.getRequestDispatcher("QUIZ.jsp");
					rd.forward(request, response);
				}
				
			}
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			rd.include(request, response);
				}
			catch(Exception we)
			{
				we.printStackTrace();
			}
		}
		
		if(usr.contentEquals("teacher"))
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
			PreparedStatement pst=con.prepareStatement("select * from teacher");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				if(un.equals(rs.getString(1)) && pw.equals(rs.getString(2)))
				{
					RequestDispatcher rd=request.getRequestDispatcher("t1.jsp");
					rd.forward(request, response);
				}
			}
		}
			
	catch(Exception e)
	{e.printStackTrace();
	}
	}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
