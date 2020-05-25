package newsController;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		Page p = new Page();
		NewsVo vo = null;
		String cnt = "";
		List<NewsVo> list = null;
		//댓글
		List<CommentVo> comment = null;
		//대댓글
		List<CommentVo> reComment = null;
		NewsService ns = new NewsService();
		String nSerial = req.getParameter("nSerial");
		String mName = req.getParameter("mName");
		System.out.println("상세보기");
		
		p.setnSerial(nSerial);
		if(req.getParameter("nowPage") == null || req.getParameter("nowPage") == "") {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
		vo = ns.newsDetail(nSerial);
		list = ns.newsDetailSide("경제");
		/*comment = ns.commentView(nSerial);*/
		comment = ns.commentView(p);
		reComment = ns.reComment(nSerial);
		cnt = ns.commentCnt(nSerial);
		
		
		mv.addObject("p", p);
		mv.addObject("list", list);
		mv.addObject("vo", vo);
		mv.addObject("comment", comment);
		mv.addObject("reComment", reComment);
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
	
	// 페이징
	@RequestMapping(value="/news/commentPage.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView commentPage(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		CommentVo vo = new CommentVo();
		Page p = new Page();
		String cnt = "";
		List<CommentVo> comment = null;
		List<CommentVo> reComment = null;
		NewsService ns = new NewsService();
		int nSerial = Integer.parseInt(req.getParameter("nSerial"));
		String nSerial2 = req.getParameter("nSerial");
		String mName = req.getParameter("mName");
		String cContent = req.getParameter("content");
		
		p.setnSerial(nSerial2);
		if(req.getParameter("nowPage") == null || req.getParameter("nowPage") == "") {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
		vo.setnSerial(nSerial);
		vo.setmName(mName);
		vo.setcContent(cContent);
		
		comment = ns.commentView(p);
		reComment = ns.reComment(nSerial2);
		cnt = ns.commentCnt(nSerial2);
		
		mv.addObject("p", p);
		mv.addObject("comment", comment);
		mv.addObject("reComment", reComment);
		mv.addObject("cnt", cnt);		
		mv.setViewName("newsComment");
		
		return mv;
	}
	
	
	// 댓글 입력
	@RequestMapping(value="/news/comment.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView commentInsert(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		CommentVo vo = new CommentVo();
		Page p = new Page();
		String cnt = "";
		List<CommentVo> comment = null;
		List<CommentVo> reComment = null;
		NewsService ns = new NewsService();
		int nSerial = Integer.parseInt(req.getParameter("nSerial"));
		String nSerial2 = req.getParameter("nSerial");
		String mName = req.getParameter("mName");
		String cContent = req.getParameter("content");
		
		p.setnSerial(nSerial2);
		if(req.getParameter("nowPage") == null || req.getParameter("nowPage") == "") {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
		vo.setnSerial(nSerial);
		vo.setmName(mName);
		vo.setcContent(cContent);
		
		ns.commentInsert(vo);
		
		comment = ns.commentView(p);
		reComment = ns.reComment(nSerial2);
		cnt = ns.commentCnt(nSerial2);
		
		mv.addObject("comment", comment);
		mv.addObject("reComment", reComment);
		mv.addObject("cnt", cnt);		
		mv.setViewName("newsComment");
		
		return mv;
	}
	
	//대댓글입력
	@RequestMapping(value="/news/reComment.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView reCommentInsert(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		NewsService ns = new NewsService();
		List<CommentVo> comment = null;
		List<CommentVo> reComment = null;
		CommentVo vo = new CommentVo();
		int nSerial = Integer.parseInt(req.getParameter("nSerial"));
		String nSerial2 = req.getParameter("nSerial");
		int cGroup = Integer.parseInt(req.getParameter("cGroup"));
		String mName = req.getParameter("mName");
		String cContent = req.getParameter("reContent");
		
		System.out.println("컨텐츠내용 : "+ cContent);
		
		vo.setnSerial(nSerial);
		vo.setcGroup(cGroup);
		vo.setmName(mName);
		vo.setcContent(cContent);
		
		ns.reCommentInsert(vo);
		
/*		comment = ns.commentView(nSerial2);*/
		reComment = ns.reComment(nSerial2);
		
		mv.addObject("comment", comment);
		mv.addObject("reComment", reComment);
		
		mv.setViewName("newsComment");
		
		return mv;
	}
	
	@RequestMapping(value="/news/commentDelete.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView commentDelete(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Page p = new Page();
		List<CommentVo> comment = null;
		List<CommentVo> reComment = null;
		NewsService ns = new NewsService();
		
		String nSerial = req.getParameter("nSerial");
		String cIndent = req.getParameter("indent");
		String cSerial = req.getParameter("cSerial");
		String cGroup = req.getParameter("cGroup");
		p.setnSerial(nSerial);
		if(req.getParameter("nowPage") == null || req.getParameter("nowPage") == "") {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
		if(cIndent.equals("0")) {
			ns.commentDelete(cGroup);
		}else {
			ns.commentDeletes(cSerial);
		}
		
		comment = ns.commentView(p);
		reComment = ns.reComment(nSerial);
		
		mv.addObject("comment", comment);
		mv.addObject("reComment", reComment);
		
		mv.setViewName("newsComment");
		
		return mv;
	}
	
	
	// 좋아요 확인 및 입력, 취소 
	@RequestMapping(value="/news/likeA.news", method= {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String likeA(HttpServletRequest req) {
		NewsService ns = new NewsService();
		LikeVo like = new LikeVo();
		String likeA = "";
		int likeCheck = 0;
		JSONObject obj = new JSONObject();
		
		int nSerial = Integer.parseInt(req.getParameter("nSerial"));
		int cSerial = Integer.parseInt(req.getParameter("cSerial"));
		String mName = req.getParameter("mName");
		
		like.setnSerial(nSerial);
		like.setcSerial(cSerial);
		like.setmName(mName);
		
		likeCheck = ns.likeCheck(like);
		
		if(likeCheck == 0) {
			likeA = ns.likeIn(like);
		}else if(likeCheck == 1){
			likeA = ns.likeOut(like);
		}else {
			likeA = "싫어요를 취소해주세요!!";
		}
		
		obj.put("like_check", likeCheck);
		obj.put("likeA", likeA);
		
		return obj.toJSONString();
	}
	
	//싫어요 확인 및 클릭,취소
	@RequestMapping(value="/news/unLikeA.news", method= {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String unLikeA(HttpServletRequest req) {
		NewsService ns = new NewsService();
		LikeVo like = new LikeVo();
		String unLikeA = "";
		int likeCheck = 0;
		JSONObject obj = new JSONObject();
		
		int nSerial = Integer.parseInt(req.getParameter("nSerial"));
		int cSerial = Integer.parseInt(req.getParameter("cSerial"));
		String mName = req.getParameter("mName");
		
		like.setnSerial(nSerial);
		like.setcSerial(cSerial);
		like.setmName(mName);
		
		likeCheck = ns.unLikeCheck(like);
		
		if(likeCheck==0) {
			unLikeA = ns.unLikeIn(like);
		}else if(likeCheck==1){
			unLikeA = ns.unLikeOut(like);
		}else {
			unLikeA = "좋아요를 취소해주세요!!";
		}
		
		obj.put("unlike_check", likeCheck);
		obj.put("unLikeA", unLikeA);
		
		return obj.toJSONString();
	}
	
	@RequestMapping(value="/news/newsSearch.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView newsSearch(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		NewsService ns = new NewsService();
		List<NewsVo> vo = null;
		List<NewsPhotoVo> vo2 = new ArrayList<NewsPhotoVo>();
		String searchText = req.getParameter("searchText");
		Page page = new Page();
		
		if(req.getParameter("nowPage") == null || req.getParameter("nowPage") == "") {
			page.setNowPage(1);
		}else {
			page.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
		System.out.println(page.getNowPage());
		
		page.setFindStr(searchText);
		vo = ns.neswSearch(page);
		
		for(NewsVo list : vo) {
			int nSerial = list.getnSerial();
			NewsPhotoVo pho = ns.newsSearchPho(nSerial);
			vo2.add(pho);
		}
		
		mv.addObject("p", page);
		mv.addObject("vo", vo);
		mv.addObject("vo2", vo2);
		mv.setViewName("newsSearch");
		
		return mv;
	}
}
