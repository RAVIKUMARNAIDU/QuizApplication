package com.quiz.servlets;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet1
 */
@WebServlet("/RegServlet1")
public class RegServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		String un=request.getParameter("usr");
		String pw=request.getParameter("pwd");
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		PreparedStatement pst=con.prepareStatement("insert into student values(?,?)");
		pst.setString(1,un);
		pst.setString(2,pw);
		int c=pst.executeUpdate();
		if(c>0)
		{
			out.println("RECORD INSERTED");
					
		RequestDispatcher rd=request.getRequestDispatcher("Signinpage.html");
		rd.include(request, response);
			}
		else
		{
			out.println("NOT INSERTED TRY AGAIN");
			RequestDispatcher rd=request.getRequestDispatcher("Signinpage.html");
			rd.include(request, response);
		
		}
		}
		catch(Exception we)
		{
			we.printStackTrace();
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
