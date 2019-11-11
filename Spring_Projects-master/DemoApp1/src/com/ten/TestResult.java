package com.ten;

import java.sql.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestResult extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		int i = Integer.parseInt(req.getParameter("q1"));
		int j = Integer.parseInt(req.getParameter("q2"));
		String s = req.getParameter("q3");
		String name = req.getParameter("q4");
		String s2="ram";
		System.out.println(s);
		int total = 0;
		int marks;
		boolean a = (s==s2);
		System.out.println(a);
		if(i==99)
		{
			total = total+5;
			
		}
		if(j==7956)
		{
			total = total+5;
		}
		if((s==s2))
		{
			total = total+5;
		}
		try {
		PrintWriter out = res.getWriter();
		out.println("HERE IS YOUR RESULT  "+total);
	    }
		catch(Exception e)
		{
			System.out.println("exception");
			
		}
		try {
			marks = total;
			System.out.println(marks);
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("class is ok");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","password");
			System.out.println("connected");
			Statement st = con.createStatement();
			PreparedStatement pr = con.prepareStatement("INSERT INTO results (name,marks) VALUES (' "+name+" ',' "+marks+" ')");
			pr.executeUpdate();
			System.out.println("succcess");
			
		}
			catch(Exception ex)
		{
			System.out.println("error:"+ex);
			
		}


}
}