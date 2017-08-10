package com.quiz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addsubject
 */
@WebServlet("/Addsubject")
public class Addsubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addsubject() {
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
		String sn=request.getParameter("sn1");
		String sd=request.getParameter("sd1");
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
		PreparedStatement pst=con.prepareStatement("insert into subject values(?,?)");
		pst.setString(1,sn);
		pst.setString(2,sd);
		int c=pst.executeUpdate();
		if(c>0)
		{
			out.println("SUBJECT INSERTED");
					
		RequestDispatcher rd=request.getRequestDispatcher("question.html");
		rd.include(request, response);
			}
		else
		{
			out.println("NOT INSERTED TRY AGAIN");
			RequestDispatcher rd=request.getRequestDispatcher("error.html");
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
