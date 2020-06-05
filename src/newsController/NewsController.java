package newsController;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	NewsService ns;
	
	@Autowired
	public NewsController(NewsService newsService){
		this.ns = newsService;
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
		
		vo = ns.weekly();
		
		mv.addObject("vo3", vo);
		mv.setViewName("weeklyNews");
		
		return mv;
	}
	
	// 뉴스 상세보기
	@RequestMapping(value="/news/newsDetail.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView newsDetail(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		Page p = new Page();
		NewsVo vo = null;
		String cnt = "";
		//세션 비교
		int result = 0;
		Cookie[] cookies = req.getCookies();
		List<NewsVo> list = null;
		//댓글
		List<CommentVo> comment = null;
		//대댓글
		List<CommentVo> reComment = null;
		List<LikeVo> likeCk = null;
		List<LikeVo> likeCd = null;
		String nSerial = req.getParameter("nSerial");
		String mId = req.getParameter("mId");
		
		// 쿠키를 확인하여 조회수 중복 증가 방지
		if(cookies != null && cookies.length >0) {
			for(int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("cookie"+nSerial)) {
					result=0;
					break;
				}else {
					Cookie newCookie = new Cookie("cookie"+nSerial, nSerial);
					res.addCookie(newCookie);
					result=1;
				}
			}
		}
		if(result==1) {
			ns.upHit(nSerial);
		}
		
		p.setnSerial(nSerial);
		if(req.getParameter("nowPage") == null || req.getParameter("nowPage") == "") {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
		vo = ns.newsDetail(nSerial);
		list = ns.newsDetailSide("경제");
		comment = ns.commentView(p);
		reComment = ns.reComment(nSerial);
		cnt = ns.commentCnt(nSerial);
		likeCk = ns.likeCk(mId);
		likeCd = ns.likeCd(mId);
		
		mv.addObject("p", p);
		mv.addObject("list", list);
		mv.addObject("vo", vo);
		mv.addObject("comment", comment);
		mv.addObject("reComment", reComment);
		mv.addObject("cnt", cnt);
		mv.addObject("likeCk", likeCk);
		mv.addObject("likeCd", likeCd);
		
		mv.setViewName("newsDetailT");
		
		return mv;
	}
	
	// 뉴스 상세보기 사이드
	@RequestMapping(value="/news/newsDetailSide.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView newDetailSide(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		List<NewsVo> list = null;
		String nCategory = req.getParameter("nCategory");
		
		list = ns.newsDetailSide(nCategory);
		
		mv.addObject("list2", list);
		mv.setViewName("detailSide");
		
		return mv;
	}
	
	// 페이징
	@RequestMapping(value="/news/commentPage.news", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView commentPage(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Page p = new Page();
		String cnt = "";
		List<CommentVo> comment = null;
		List<CommentVo> reComment = null;
		String nSerial2 = req.getParameter("nSerial");
		
		p.setnSerial(nSerial2);
		if(req.getParameter("nowPage") == null || req.getParameter("nowPage") == "") {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
		comment = ns.commentView(p);
		reComment = ns.reComment(req);
		cnt = ns.commentCnt(req);
		
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
		Page p = new Page();
		String cnt = "";
		List<CommentVo> comment = null;
		List<CommentVo> reComment = null;

		ns.commentInsert(req);
		comment = ns.commentView(req);
		reComment = ns.reComment(req);
		cnt = ns.commentCnt(req);
		
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
		List<CommentVo> comment = null;
		List<CommentVo> reComment = null;
		CommentVo vo = new CommentVo();
		
		ns.reCommentInsert(req);
		
		reComment = ns.reComment(req);
		comment = ns.commentView(req);
		
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
		List<NewsVo> vo = null;
		List<NewsPhotoVo> vo2 = new ArrayList<NewsPhotoVo>();
		String searchText = req.getParameter("searchText");
		Page page = new Page();
		
		if(req.getParameter("nowPage") == null || req.getParameter("nowPage") == "") {
			page.setNowPage(1);
		}else {
			page.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
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
