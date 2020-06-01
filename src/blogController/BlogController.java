package blogController;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import blogCommand.BlogService;
import blogCommand.FileUpload;

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
		System.out.println("들어왔당");
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
	
	@RequestMapping(value = "/uploadSummernoteImg.bg",  produces = "application/json", method = {RequestMethod.POST})
	@ResponseBody
	public String uploadSummernoteImg(MultipartHttpServletRequest req) {
		FileUpload upload = new FileUpload();
		String json = upload.brdSummernoteImgUploading(req);
		
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value = "/brdInsert.bg", method = {RequestMethod.POST})
	public ModelAndView brdInsert(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		int bNo = Integer.parseInt(req.getParameter("c_bNo"));
		System.out.println(req.getParameter("c_bNo"));
		
		List<BlogVo> category = blogDao.category(bNo);
		System.out.println(category.get(0).getbNo());
		mv.addObject("category", category);
		mv.setViewName("blog_brdInsert");
		return mv;
	}
	
	@RequestMapping(value = "/brdInsertR.bg", method = {RequestMethod.POST})
	public ModelAndView brdInsertR(MultipartHttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		BlogBoardVo brdVo = null;
		/*if (req.getFile("c_brdHeaderImg") != null) { //게시물 헤더 사진이 있을 때만
		}*/
		FileUpload upload = new FileUpload();
		brdVo = upload.brdFileUploading(req);
		
		blogDao.brdInsertR(brdVo, req);
		mv.setViewName("blog_manage");
		return mv;
	}
	
	@RequestMapping(value = "/brdModify.bg", method = {RequestMethod.POST})
	public ModelAndView brdModify(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		int brdNo = Integer.parseInt(req.getParameter("c_brdNo"));
		int bNo = Integer.parseInt(req.getParameter("c_bNo"));
		
		List<BlogVo> category = blogDao.category(bNo);
		BlogBoardVo board = blogDao.brdView(brdNo);
		
		//태그 리스트형태로 만들기
		BlogService service = new BlogService();
		/*List<String> tagList = service.tagSplit(board.getTContent());*/
		List<String> tagList = service.tagSplit(board.getTContent());
		mv.addObject("category", category);
		mv.addObject("board", board);
		mv.addObject("tagList", tagList);			
		mv.setViewName("blog_brdModify");
		return mv;
	}
	
	
	@RequestMapping(value = "/brdModifyR.bg", method = {RequestMethod.POST})
	public ModelAndView brdModifyR(MultipartHttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		BlogBoardVo brdVo = null;
		if (req.getFile("c_brdHeaderImg") != null) { //게시물 헤더 사진이 있을 때만
			FileUpload upload = new FileUpload();
			brdVo = upload.brdFileUploading(req);
		}
		System.out.println(brdVo.getmId());
		System.out.println(brdVo.getbNo());
		System.out.println(brdVo.getBrdNo());
		System.out.println(brdVo.getcName());
		System.out.println(brdVo.getSubject());
		System.out.println(brdVo.getContent());
		System.out.println(brdVo.getTContent());
		System.out.println(brdVo.getBasicSet());
		System.out.println(brdVo.getOriBrdHeader());
		System.out.println(brdVo.getBrdHeader());
		
		blogDao.brdModifyR(brdVo, req);
		
		mv.setViewName("blog_manage");
		return mv;
	}
	
	@RequestMapping(value = "/brdDelete.bg", method = {RequestMethod.POST})
	public ModelAndView brdDelete(HttpServletRequest req) {
		System.out.println("삭제");
		ModelAndView mv = new ModelAndView();
		
		int brdNo = Integer.parseInt(req.getParameter("c_brdNo"));
		blogDao.brdDelete(brdNo);
		
		return mv;
	}
	
	/*@RequestMapping(value = "/brdModifyR.bg", method = {RequestMethod.POST})
	public ModelAndView brdModifyR(HttpServletRequest req, @RequestParam("c_brdHeaderImg") MultipartFile file) {
		ModelAndView mv = new ModelAndView();
		
		BlogBoardVo brdVo = new BlogBoardVo();
		brdVo.setbNo(Integer.parseInt(req.getParameter("c_bNo")));
		brdVo.setBrdNo(Integer.parseInt(req.getParameter("c_brdNo")));
		brdVo.setcName(req.getParameter("c_cName"));
		brdVo.setSubject(req.getParameter("c_subject"));
		brdVo.setContent(req.getParameter("c_content"));
		brdVo.setTagContent(req.getParameter("c_tagContent"));
		brdVo.setBasicSet(Integer.parseInt(req.getParameter("c_basicSet")));
		System.out.println(brdVo.getbNo());
		System.out.println(brdVo.getcName());
		System.out.println(brdVo.getSubject());
		System.out.println(brdVo.getContent());
		System.out.println(brdVo.getTagContent());
		System.out.println(file.getOriginalFilename());
		System.out.println(brdVo.getBasicSet());
		
		mv.setViewName("blog_manage");
		return mv;
	}*/
	
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

