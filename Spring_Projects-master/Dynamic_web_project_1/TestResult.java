import apt.Record1;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestResult extends HttpServlet 
{
	Record a = new Record();
	String name1 = a.name;
	

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		int i = Integer.parseInt(req.getParameter("q1"));
		int j = Integer.parseInt(req.getParameter("q2"));
		String s = req.getParameter("q3");
		String name = req.getParameter("q4");
		int k = Integer.parseInt(req.getParameter("q5"));
		int l = Integer.parseInt(req.getParameter("q6"));
		int m = Integer.parseInt(req.getParameter("q7"));
		System.out.println(" this name i got from there  "+name1);

		String s2="ram";
		String s1 = s.toLowerCase();
		int total = 0;
		int marks;
		if(i==99)
		{
			total = total+5;
			
		}
		if(j==7956)
		{
			total = total+5;
		}
		if(k==37)
		{
			total = total+5;	
		}
		if(l==1944)
		{
			total = total+5;
		}
		if(m==29)
		{
			total = total+5;
		}
		if((s1.compareTo(s2)== 0))
		{
			total = total+5;
		}
		try {
		PrintWriter out = res.getWriter();
		if(total>15)
		{
			out.println("<centre>Congratulations! You are shortlisted for the next round.</centre>\n");
		}
		else
		{
			out.println("<centre>Better luck next time</centre>");
		}
		out.println("\n HERE IS YOUR RESULT :  "+total);
		//out.println("<a href = 'Record.java' > view all records</a>");
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

