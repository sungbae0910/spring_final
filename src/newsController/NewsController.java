package newsController;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public ModelAndView topNews(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		// 메인상단 뉴스
		List<NewsVo> list = null;
		// 메인상단 사진 
		List<NewsPhotoVo> list2 = null;
		NewsService ns = new NewsService();
		HttpSession httpSession = req.getSession(true);
		System.out.println("뭐가 문제죠");
		
		list = ns.selectI();
		list2 = ns.selectP();
		httpSession.setAttribute("mName", "lee");
		
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
	
	// 뉴스 카테고리별 조회
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
	
	// 많이 본 뉴스 조회
	@RequestMapping(value="/news/weekly.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView weekly() {
		ModelAndView mv = new ModelAndView();
		List<NewsVo> vo = null;
		NewsService ns = new NewsService();
		
		vo = ns.weekly();
		
		mv.addObject("vo3", vo);
		mv.setViewName("weeklyNews");
		
		return mv;
	}
	
	// 뉴스 상세보기
	@RequestMapping(value="/news/newsDetail.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView newsDetail(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		NewsVo vo = null;
		List<NewsVo> list = null;
		List<CommentVo> comment = null;
		List<String> cnt = null;
		NewsService ns = new NewsService();
		String nSerial = req.getParameter("nSerial"); 
		System.out.println("상세보기");
		
		vo = ns.newsDetail(nSerial);
		list = ns.newsDetailSide("경제");
		comment = ns.commentView(nSerial);
		cnt = ns.commentCnt(nSerial);
		
		mv.addObject("list", list);
		mv.addObject("vo", vo);
		mv.addObject("comment", comment);
		mv.addObject("cnt", cnt);
		
		mv.setViewName("newsDetailT");
		
		return mv;
	}
	
	// 뉴스 상세보기 사이드
	@RequestMapping(value="/news/newsDetailSide.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView newDetailSide(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		List<NewsVo> list = null;
		NewsService ns = new NewsService();
		String nCategory = req.getParameter("nCategory");
		System.out.println("사이드");
		System.out.println(nCategory);
		
		list = ns.newsDetailSide(nCategory);
		
		mv.addObject("list2", list);
		mv.setViewName("detailSide");
		
		return mv;
	}
	
	@RequestMapping(value="/news/comment.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView comment(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		CommentVo vo = new CommentVo();
		NewsService ns = new NewsService();
		int nSerial = Integer.parseInt(req.getParameter("nSerial"));
		String mName = req.getParameter("mName");
		String cContent = req.getParameter("content");
		
		System.out.println(nSerial);
		System.out.println(mName);
		System.out.println(cContent);
		
		vo.setnSerial(nSerial);
		vo.setmName(mName);
		vo.setcContent(cContent);
		
		ns.commentInsert(vo);
		
		return mv;
	}
}
