package springMVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerDemo {
	String nam;
	@RequestMapping("/noadd")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response)
	{
		String name = request.getParameter("name");
		nam = name;
		HttpSession hs = request.getSession();
		hs.setAttribute("name", name);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("just.jsp");
		System.out.println("i'm here");
		return mv;
	}
	@RequestMapping("/try")
	public void trial()
	{
		System.out.println("name...."+nam);
	}

}
