package newsController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import newsCommand.NewsService;

@Controller
public class NewsController {
	
	public NewsController(){
	}
	
	@RequestMapping(value="/newsDetailT.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView view(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		System.out.println("ㅇ해?????");
		
		mv.setViewName("newsDetailT");
		
		return mv;
	}
	
	@RequestMapping(value="/news/newsMain.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView test(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		List<NewsVo> list = null;
		List<NewsPhotoVo> list2 = null;
		NewsService ns = new NewsService();
		System.out.println("뭐가 문제죠");
		
		list = ns.selectI();
		list2 = ns.selectP();
		
		mv.addObject("list", list);
		mv.addObject("photo", list2);
		
		mv.setViewName("newsMainT");
		
		return mv;
	}
	
	@RequestMapping(value="/crawling.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView crawling(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		
		
		
		return mv;
	}
	
	
}
