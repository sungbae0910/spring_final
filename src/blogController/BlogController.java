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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
	
	@RequestMapping(value = "/brdModifyR.bg", method = {RequestMethod.POST})
	public ModelAndView brdModifyR(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		BlogBoardVo brdVo = new BlogBoardVo();
		brdVo.setbNo(Integer.parseInt(req.getParameter("c_bNo")));
		brdVo.setcName(req.getParameter("c_cName"));
		brdVo.setBrdHeader(req.getParameter("c_brdHeaderImg"));
		brdVo.setSubject(req.getParameter("c_subject"));
		brdVo.setContent(req.getParameter("c_content"));
		brdVo.setTagContent(req.getParameter("c_tagContent"));
		System.out.println(req.getParameter("c_content"));
		
		
		/*mv.setViewName("blog_brdModify");*/
		return mv;
	}
	
	@RequestMapping(value = "/uploadSummernoteImg.bg",  produces = "application/json", method = {RequestMethod.POST})
	@ResponseBody
	public String brdImg(MultipartFile file) {
		JSONObject json = new JSONObject();
		String fileRoot = "C:\\Users\\JHTA\\eclipse-workspace\\spring_final\\WebContent\\blog\\summernoteImage\\"; //저장될 외부 파일 경로
		String originalFileName = file.getOriginalFilename(); //오리지널 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); //파일 확장자	
		String sysFileName = UUID.randomUUID() + extension; //저장될 파일 명
		
		File targetFile = new File(fileRoot + sysFileName);	
		
		try {
			InputStream fileStream = file.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile); //파일 저장
			
			json.put("url", "/summernoteImage/" + sysFileName);
			json.put("responseCode", "success");
				
		} catch (Exception e) {
			FileUtils.deleteQuietly(targetFile); //저장된 파일 삭제
			json.put("responseCode", "error");
			e.printStackTrace();
		}
		
		return json.toJSONString();
	}
	
	@Configuration
	public class WebMvcConfig implements WebMvcConfigurer {
		//web root가 아닌 외부 경로에 있는 리소스를 url로 불러올 수 있도록 설정
	    //현재 localhost:8888/summernoteImage/1234.jpg
	    //로 접속하면 C:/summernote_image/1234.jpg 파일을 불러온다.
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    	System.out.println(1);
	        registry.addResourceHandler("/summernoteImage/**")
	                .addResourceLocations("file:///C:/Users/JHTA/eclipse-workspace/spring_final/WebContent/blog/summernoteImage/");
	        System.out.println(2);
	    }
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

