package newsController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {
	
	String url = "./news/";
	public NewsController(){
	}
	
	@RequestMapping(value="newsDetailT.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView view(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		System.out.println("ㅇ해?????");
		
		mv.setViewName("newsDetailT");
		
		return mv;
	}
	
	@RequestMapping(value="/test.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView test(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		System.out.println("뭐가 문제죠");
		
		mv.setViewName("newsDetailT");
		
		return mv;
	}
	
	@RequestMapping(value="/crawling.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView crawling(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		
		
		
		return mv;
	}
	
	
}
