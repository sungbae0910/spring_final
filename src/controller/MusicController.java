package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.MusicDao;
import mybatis.MusicVo;

@Controller
public class MusicController {
	
	MusicDao dao;
	
	public MusicController(MusicDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/sb_home.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView top10(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("home");
		
		List<MusicVo> list = dao.top10();
		
		mv.addObject("top10", list);
		mv.setViewName("sb_home");
		return mv;
	}
	
	@RequestMapping(value="/sb_movie.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView movie(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String serial = (req.getParameter("m_serial"));
		int s = Integer.parseInt(serial);
		MusicVo vo = dao.movie(s);
		
		mv.addObject("movie", vo);
		mv.setViewName("sb_movie");
		return mv;
	}
	
	@RequestMapping(value="/sb_play.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView play(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String serial = (req.getParameter("m_serial"));
		int s = Integer.parseInt(serial);
		MusicVo vo = dao.play(s);
		mv.addObject("play", vo);
		mv.setViewName("sb_nav");
		return mv;
	}
	
	
	
}
