package com.ten;
import java.io.*;
import javax.servlet.http.*;

public class AddServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num"));
		int k = i+j;
		try {
			PrintWriter out = res.getWriter();
			out.println("result"+k);

		   }
		catch (Exception e)
		{
			System.out.println("exception"+e);
		}
			}

}
