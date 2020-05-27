package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

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
		String mId = req.getParameter("mId");
		
		int s = Integer.parseInt(serial);
		 
		MusicVo vo = dao.play(s); // 
		
		
	
		MusicListVo mlv = dao.playList(mId);
		mlv.setMusic_serial(Integer.toString(vo.getMusic_serial())+"," );

		mlv.setmId(mId);
		dao.addList(mlv);
		
		
		
		
		
		mv.addObject("play", vo);
		List<MusicVo> list = dao.top10();
		mv.addObject("top10", list);
		mv.setViewName("sb_main");
		top10(req);
		return mv;
	}
	@RequestMapping(value="/sb_music/sb_play2.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody ModelAndView play2(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String serial = (req.getParameter("m_serial"));
		String mId = req.getParameter("mId");
		
		int s = Integer.parseInt(serial);
		 
		MusicVo vo = dao.play(s); 
		
		

		MusicListVo mlv = dao.playList(mId);
		mlv.setMusic_serial(Integer.toString(vo.getMusic_serial())+"," );

		mlv.setmId(mId);
		
		
		
		
		
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
		
		Gson gson = new GsonBuilder().create();
		
		
		String mId = req.getParameter("mId");

		
		MusicListVo vo = dao.playList(mId); 

		
		String ml = vo.getMusic_list();

		
		String[] num = ml.split(","); 
		
		
		int[] nums = new int[num.length];
		
		for(int i=0; i<num.length; i++) {
			nums[i] = Integer.parseInt(num[i].trim());
		}
			
		
		List<MusicVo> list = new ArrayList<MusicVo>();
		for(int i = 0; i < nums.length; i++) {
			int a = nums[i];
			MusicVo mv = dao.pL_music(a);
			list.add(mv);
		}
		
		String list2 =  gson.toJson(list);

		


		
		return list2;	
	}
	
	@RequestMapping(value="/sb_music/sb_kimchi.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public String kimchi(HttpServletRequest req) {
		String str = null;
		
		
		String mId = req.getParameter("mId");
		String ms = req.getParameter("m_serial");
		
		MusicListVo vo = dao.playList(mId);
		vo.setMusic_serial(ms+",");
		
		
		dao.addList(vo);
		
		
		return str;
		
	}
	@RequestMapping(value="/sb_music/sb_removeAll.mu", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String removeAll(HttpServletRequest req) {
		String str="";
		String mId = req.getParameter("mId");
		
		dao.removeAll(mId);
		
		
		
		
		
		return str;
	}
	
	
	@RequestMapping(value="/sb_music/sb_delList.mu", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String delList(HttpServletRequest req) {
		
	Gson gson = new GsonBuilder().create();
		

		String mId = req.getParameter("mId");
		String ms = req.getParameter("m_serial"); 

		MusicListVo vo = dao.playList(mId);
		vo.setmId(mId); 
		vo.setMusic_serial(ms); 
		
		
		dao.delList(vo); 
		
		MusicListVo vo2 = dao.playList(mId);
		
		String ml = vo2.getMusic_list();
		
		
		String[] num = ml.split(",");
		
		
		int[] nums = new int[num.length];
		
		for(int i=0; i<num.length; i++) {
			nums[i] = Integer.parseInt(num[i].trim());
		}
		
		List<MusicVo> list = new ArrayList<MusicVo>();
		for(int i = 0; i < nums.length; i++) {
			int a = nums[i];
			MusicVo mv = dao.pL_music(a);
			list.add(mv);
		}
		
		
		
		String list2 =  gson.toJson(list);
		
		
		
		return list2;	
	}
	@RequestMapping(value="/sb_music/sb_prevMusic.mu", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String prevMusic(HttpServletRequest req) {
		Gson gson = new GsonBuilder().create();
		String serial = req.getParameter("m_serial");
		String mId = req.getParameter("mId");
		
		MusicListVo mlv = dao.playList(mId);
		String playlist = mlv.getMusic_list();
		String s[] = playlist.split(",");
		int n[] = new int[s.length];
		for(int i=0; i<s.length; i++) {
			n[i] = Integer.parseInt(s[i].trim());
		}
		
		int serial2 = Integer.parseInt(serial);
		int cnt = 0;
		int result = 0;
		for(int i=0; i<n.length; i++) {
			if(serial2 == n[i]) {
				cnt = i-1;
				result = n[cnt];
			}else {
				result = serial2;
			}
		}
		
		String str = gson.toJson(result);
		
		return str;
	}
	
	@RequestMapping(value="/sb_music/sb_nextMusic.mu", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String nextMusic(HttpServletRequest req) {
		Gson gson = new GsonBuilder().create();
		String serial = req.getParameter("m_serial");
		String mId = req.getParameter("mId");
		
		MusicListVo mlv = dao.playList(mId);
		String playlist = mlv.getMusic_list();
		String s[] = playlist.split(",");
		int n[] = new int[s.length];
		for(int i=0; i<s.length; i++) {
			n[i] = Integer.parseInt(s[i].trim());
		}
		
		int serial2 = Integer.parseInt(serial);
		int cnt = 0;
		for(int i=0; i<n.length; i++) {
			if(serial2 == n[i]) {
				cnt = i+1;
			}
		}
		
		System.out.println(n[cnt]);
		
		int result = n[cnt];
		
		String str = gson.toJson(result);
		
		return str;
	}
	
	
	@RequestMapping(value="/sb_music/sb_ChDrag.mu", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String ChDrag(HttpServletRequest req) {
		String str = null;
		
		String listV= req.getParameter("listV");
		String mId = req.getParameter("mId");
		
		MusicListVo vo = dao.playList(mId);
		String ml = vo.getMusic_list(); 
		String[] num = ml.split(",");
		int[] nums = new int[num.length]; 
		for(int i=0; i<num.length; i++) {
			nums[i] = Integer.parseInt(num[i].trim()); 
		}
		String[] listnum = listV.split(",");
		double[] listnums = new double[listnum.length];
		for(int i=0; i<listnum.length; i++) {
			listnums[i] = Double.parseDouble(listnum[i].trim());
		}
		
		
		bubbleSort(listnums, nums);
		
		
		String music_list = "";
		for(int i : nums) {
			music_list += Integer.toString(i) + ",";
		}
	
		MusicListVo mlv = new MusicListVo();
		mlv.setmId(mId);
		mlv.setMusic_list(music_list);
		
		
		dao.ChDrag(mlv);
		
		
		
		return str;
	}
	
	public int[] bubbleSort(double[] arr, int[] arr2) {
	    for(int i = 0; i < arr.length; i++) {
	        for(int j = 0 ; j < arr.length - i - 1 ; j++) {
	            if(arr[j] > arr[j+1]) {
	                double temp = arr[j+1];
	                arr[j+1] = arr[j];
	                arr[j] = temp;
	                
	                int temp2 = arr2[j+1];
	                arr2[j+1] = arr2[j];
	                arr2[j] = temp2;
	            }
	        }
	    }
	    
	    return arr2;
	}





 
}
