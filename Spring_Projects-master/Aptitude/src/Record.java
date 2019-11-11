//import java.sql.Connection;

//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;

import javax.servlet.http.*;

public class Record extends HttpServlet {
	public String clg;
	public String name;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

			// TODO Auto-generated method stub
		public void service(HttpServletRequest req, HttpServletResponse res)
		{
			 name = req.getParameter("name");
			 clg = req.getParameter("clg");
		}
		
	/*		try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("class is ok");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","password");
				System.out.println("connected");
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select * from results ");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t "+rs.getInt(2));
			     }
			}
				catch(Exception ex)
			{
				System.out.println("error:"+ex);
				
			}
		
			
	*/
	
}

