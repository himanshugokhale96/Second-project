package springMVC;

import javax.servlet.http.HttpServletRequest;



import javax.servlet.http.HttpServletResponse;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	

	
	String nam;
	@RequestMapping("/test")
	public ModelAndView test(HttpServletRequest request,HttpServletResponse response)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

	      StudentJDBCTemplate studentJDBCTemplate = 
	         (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
		int ans1 = Integer.parseInt(request.getParameter("q1"));
		int ans2 = Integer.parseInt(request.getParameter("q2"));
		String ans6 = request.getParameter("q6");
		int ans3 = Integer.parseInt(request.getParameter("q3"));
		int ans4 = Integer.parseInt(request.getParameter("q4"));
		int ans5 = Integer.parseInt(request.getParameter("q5"));
		String name = nam;
		
		String s2="ram";
		String s1 = ans6.toLowerCase();
		int total = 0;
		if(ans1==99)
		{
			total = total+5;
			
		}
		if(ans2==7956)
		{
			total = total+5;
		}
		if(ans3==37)
		{
			total = total+5;	
		}
		if(ans4==1944)
		{
			total = total+5;
		}
		if(ans5==29)
		{
			total = total+5;
		}
		if((s1.compareTo(s2)== 0))
		{
			total = total+5;
		}
		studentJDBCTemplate.create(name, total);
		System.out.println("success");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",total);
		return mv;

	}
	@RequestMapping("/result")
	public ModelAndView result(HttpServletRequest request,HttpServletResponse response)
	{
		int id;
		int mark;
		String nam;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

	      StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
	      String name = request.getParameter("name");
	      System.out.println(name);
	      Student student = studentJDBCTemplate.getStudent(name);
	      id = student.getId();
	      nam=student.getName();
	      mark=student.getMarks();
	      System.out.print("ID : " + student.getId() );
	      System.out.print(", Name : " + student.getName() );
	      System.out.println(", Marks : " + student.getMarks());
	      System.out.println("you know what session is working  "+name);

	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("result.jsp");
	      mv.addObject("id",id);
	      mv.addObject("name",nam);
	      mv.addObject("marks",mark);
	      return mv;

	}
	
	@RequestMapping("/addStudent")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response)
	{
		String name = request.getParameter("name");
		nam = name;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("instruction.jsp");
		return mv;
	}

	

}
