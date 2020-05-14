package blogController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
	BlogDao dao;
	
	public BlogController(BlogDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/blogMain.bg", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView blogMain(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String kind = req.getParameter("kind");
		/*List<BlogBoardVo> boardList = dao.select(kind);*/
		
		/*BlogVo blogVo = new BlogVo();*/
		
		mv.setViewName("blog_main");
		return mv;
	}
	
	@RequestMapping(value = "/myblogMain.bg", method = {RequestMethod.POST})
	public ModelAndView myblogMain(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String cName = req.getParameter("cName");
		
		mv.addObject("cName", cName);
		mv.setViewName("myblog_main");
		return mv;
	}
	
	@RequestMapping(value = "/blogBrd.bg", method = {RequestMethod.POST})
	public ModelAndView blogBrdView() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("myblog_brd");
		return mv;
	}
	
	@RequestMapping(value = "/brdInsert.bg", method = {RequestMethod.POST})
	public ModelAndView brdInsert() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("blog_brdInsert");
		return mv;
	}
	
	@RequestMapping(value = "/brdModify.bg", method = {RequestMethod.POST})
	public ModelAndView brdModify() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("blog_brdModify");
		return mv;
	}
	
	@RequestMapping(value = "/blogManage.bg", method = {RequestMethod.POST})
	public ModelAndView blogManage() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("blog_manage");
		return mv;
	}
	
	@RequestMapping(value = "/blogSetManage.bg", method = {RequestMethod.POST})
	public ModelAndView blogSetManage() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("myblog_manageSet");
		return mv;
	}
	
	@RequestMapping(value = "/brdManage.bg", method = {RequestMethod.POST})
	public ModelAndView brdManage() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("myblog_manageBrd");
		return mv;
	}
	
	@RequestMapping(value = "/cmtManage.bg", method = {RequestMethod.POST})
	public ModelAndView cmtManage() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("myblog_manageCmt");
		return mv;
	}
	
	@RequestMapping(value = "/statManage.bg", method = {RequestMethod.POST})
	public ModelAndView statManage() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("myblog_manageStat");
		return mv;
	}
}

