package apt;

import java.io.PrintWriter;

import javax.servlet.http.*;

public class Record1 extends HttpServlet {
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
			 try {
			 PrintWriter out = res.getWriter();
			 out.println("name: "+name);
			 out.println("college name: "+clg);
			 out.println("<br></br>");
			 //out.println("<form action=\"trial\">\r\n" + 
			 	//	"<input type = \"submit\" value = \"next\">\r\n" + 
			 		//"</form>\r\n" + 
			 		//"");
			 out.println("<a href = \"Test.html\" > click here</a>");

			 }
			 catch(Exception e) {
			 System.out.println("error: "+e);
		}


}
}
