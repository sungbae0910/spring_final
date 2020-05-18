package controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.MusicDao;
import mybatis.MusicListVo;
import mybatis.MusicVo;

@Controller
public class MusicController {
	
	MusicDao dao;
	
	public MusicController(MusicDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/sb_music/sb_home.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView top10(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		List<MusicVo> list = dao.top10();
		
		mv.addObject("top10", list);
		mv.setViewName("sb_home");
		return mv;
	}
	
	@RequestMapping(value="/sb_music/sb_top.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView top100(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		List<MusicVo> list = dao.top100();
		
		mv.addObject("top100", list);
		mv.setViewName("sb_top");
		
		return mv;
	}
	
	@RequestMapping(value="/sb_music/sb_info.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView info(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		String serial = req.getParameter("m_serial");
		int s = Integer.parseInt(serial);
		MusicVo vo = dao.info(s);
		
		String lylics = vo.getLylics();
		String temp = lylics.replaceAll("\r\n", "<br>");
		
		vo.setLylics(temp);
		
		
		mv.addObject("info", vo);
		mv.setViewName("sb_info");
		
		return mv;
	}
	
	
	@RequestMapping(value="/sb_music/sb_movie.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView movie(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String serial = (req.getParameter("m_serial"));
		int s = Integer.parseInt(serial);
		MusicVo vo = dao.movie(s);
		
		mv.addObject("movie", vo);
		mv.setViewName("sb_movie");
		return mv;
	}
	
	@RequestMapping(value="/sb_music/sb_play.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody ModelAndView play(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String serial = (req.getParameter("m_serial"));
		int s = Integer.parseInt(serial);
		MusicVo vo = dao.play(s);
		
		mv.addObject("play", vo);
		
		List<MusicVo> list = dao.top10();
		
		mv.addObject("top10", list);
		
		mv.setViewName("sb_main");
		
		
		top10(req);
		return mv;
	}
	
	@RequestMapping(value="/sb_music/sb_playList.mu", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String playList(HttpServletRequest req) {
		
		System.out.println("¿È");
		
		Gson gson = new GsonBuilder().create();
		
		
		String mId = req.getParameter("mId");
		System.out.println(mId);
		
		MusicListVo vo = dao.playList(mId);
		System.out.println(vo.getMusic_list());
		
		
		String ml = vo.getMusic_list();
		System.out.println("ml: " + ml);
		
		String[] num = ml.split(",");
		
		
		int[] nums = new int[num.length];
		
		for(int i=0; i<num.length; i++) {
			nums[i] = Integer.parseInt(num[i].trim());
		}
		
	
		
		List<MusicVo> list = dao.pL_music(nums);
		
		String list2 =  gson.toJson(list);
		
		
		System.out.println(list2);
		
		return list2;
		
	}
}
