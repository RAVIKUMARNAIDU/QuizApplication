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
 * Servlet implementation class RegServlet2
 */
@WebServlet("/RegServlet2")
public class RegServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet2() {
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
		PreparedStatement pst=con.prepareStatement("insert into teacher values(?,?)");
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
