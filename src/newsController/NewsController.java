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
	
	// 뉴스 최상단 조회
	@RequestMapping(value="/news/newsMain.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView test(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		// 메인상단 뉴스
		List<NewsVo> list = null;
		//카테고리 
		List<NewsPhotoVo> list2 = null;
		NewsService ns = new NewsService();
		System.out.println("뭐가 문제죠");
		
		list = ns.selectI();
		list2 = ns.selectP();
		
		mv.addObject("list", list);
		mv.addObject("photo", list2);
		
		mv.setViewName("newsTrending");
		
		return mv;
	}
	
	// 뉴스 카테고리 랜덤 조회
	@RequestMapping(value="/news/cateAll.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView cateAll(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		List<NewsVo> vo = null;
		NewsService ns = new NewsService();
		System.out.println("aasdasd");
		vo = ns.selectCateAi();
		
		mv.addObject("vo", vo);
		
		mv.setViewName("whatsNews");
		
		return mv;
	}
	
	@RequestMapping(value="/news/cateDe.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView cateDe(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		List<NewsVo> vo = null;
		NewsService ns = new NewsService();
		String cateName = req.getParameter("cate_name");
		System.out.println("카테고리 상세");
		
		vo = ns.selectCateDe(cateName);
		
		mv.addObject("vo2", vo);
		mv.setViewName("whatsNews");
		
		return mv;
	}
	
}
