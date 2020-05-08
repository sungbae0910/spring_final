package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.MusicDao;
import mybatis.MusicVo;

@Controller
public class MusicController {
	
	MusicDao dao;
	
	public MusicController(MusicDao dao) {
		this.dao = dao;
	}
	
	String url = "./sb_music/";
	
	@RequestMapping(value="/sb_home.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView top10(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		System.out.println("mc1");
		List<MusicVo> list = dao.top10();
		for(MusicVo asd : list) {
			System.out.println(asd.getAlbum_serial());
			System.out.println("ss");
		}
		
		mv.addObject("top10", list);
		mv.setViewName("sb_home");
		System.out.println("mc2");
		return mv;
	}
	
}
