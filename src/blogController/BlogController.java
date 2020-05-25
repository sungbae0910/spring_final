package blogController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
	BlogDao blogDao;
	
	@Autowired
	public BlogController(BlogDao blogDao) {
		this.blogDao = blogDao;
	}
	
	@RequestMapping(value = "/blogMain.bg", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView blogMain(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String[] tag = req.getParameterValues("tag");

		if (tag == null) {
			tag = new String[]{"일상", "데일리"};
		} 
		
		List<BlogBoardVo> bestBrdList = blogDao.bestBrdSelect(tag);
		List<BlogBoardVo> brdList =  blogDao.brdListSelect(tag);
		
		mv.addObject("bestBrdList", bestBrdList);
		mv.addObject("brdList", brdList);
		mv.setViewName("blog_content");
		return mv;
	}

	@RequestMapping(value = "/myblogMain.bg", method = {RequestMethod.POST})
	public ModelAndView myblogMain(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> category = new HashMap<String, String>();
		BlogBoardVo boardVo = new BlogBoardVo();
		String mId = req.getParameter("c_mId");
		boardVo.setmId(mId);
		
		if (req.getParameter("c_cName") =="" || req.getParameter("c_cName") == null) { //전체 글
			category.put("cName", "전체 글");
		} else { //카테고리 글
			String cName = req.getParameter("c_cName");
			boardVo.setcName(cName);
			category.put("cName", cName);
		}
		
		BlogVo myblogHeader = blogDao.myblogHeaderSelect(mId);
		List<BlogBoardVo> myblogBrdList = blogDao.myblogBrdSelect(boardVo);
		
		String cnt = String.valueOf(myblogBrdList.size());
		category.put("cnt", cnt);
			
		mv.addObject("category", category);
		mv.addObject("myblogHeader", myblogHeader);
		mv.addObject("myblogBrdList", myblogBrdList);
		mv.setViewName("myblog_main");
		return mv;
	}
	
	@RequestMapping(value = "/blogBrd.bg", method = {RequestMethod.POST})
	public ModelAndView blogBrdView(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		int brdLike = -1;
		String mId = req.getParameter("c_mId");
		int brdNo = Integer.parseInt(req.getParameter("c_brdNo"));
		/*if (req.getParameter("c_mId") != null) { //공감버튼 눌렀을 때
			brdLike = Integer.parseInt(req.getParameter("c_brdLike"));
		}*/
		BlogVo myblogHeader = blogDao.myblogHeaderSelect(mId);
		BlogBoardVo board = blogDao.brdView(brdNo);
		mv.addObject("board", board);
		mv.addObject("myblogHeader", myblogHeader);
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
	public ModelAndView brdModify(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		int brdNo = Integer.parseInt(req.getParameter("c_brdNo"));
		int bNo = Integer.parseInt(req.getParameter("c_bNo"));
		
		List<BlogVo> category = blogDao.category(bNo);
		BlogBoardVo board = blogDao.brdModify(brdNo);
		
		mv.addObject("category", category);
		mv.addObject("board", board);
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

