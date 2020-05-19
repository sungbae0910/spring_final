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
		String mId = req.getParameter("mId");
		
		int s = Integer.parseInt(serial);
		 
		MusicVo vo = dao.play(s); // nav�ٿ� �������� �����ͼ� ����
		
		
		//�÷��� ����Ʈ �����ͼ� �߰�
		MusicListVo mlv = dao.playList(mId);
		mlv.setMusic_serial(Integer.toString(vo.getMusic_serial())+"," );
		System.out.println("mId:"+mId);
		System.out.println("ms:"+mlv.getMusic_serial());
		mlv.setmId(mId);
		dao.addList(mlv);
		
		
		
		
		
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
		
		
		String mId = req.getParameter("mId"); // mId �����ͼ�

		
		MusicListVo vo = dao.playList(mId); // �÷��̸���Ʈ ��������

		
		String ml = vo.getMusic_list(); // ����Ʈ �־��ش㿡

		System.out.println("ml = " + ml);
		String[] num = ml.split(","); // (,) �ĸ� �׿���
		
		
		int[] nums = new int[num.length]; // �迭�� �־��ص�
		
		for(int i=0; i<num.length; i++) {
			nums[i] = Integer.parseInt(num[i].trim()); // ���鰪 ������ ������ ���̰�
		}
		
	
		
		List<MusicVo> list = dao.pL_music(nums); // �� ���� ����Ʈ�� ��������
		
		String list2 =  gson.toJson(list);
		
		
		System.out.println(list2);
		
		return list2;	
	}
	
	@RequestMapping(value="/sb_music/sb_kimchi.mu", method= {RequestMethod.GET, RequestMethod.POST})
	public String kimchi(HttpServletRequest req) {
		String str = null;
		
		
		String mId = req.getParameter("mId");
		String ms = req.getParameter("m_serial");
		
		MusicListVo vo = dao.playList(mId);
		vo.setMusic_serial(ms);
		System.out.println(vo.getMusic_serial());
		System.out.println(vo.getmId());
		
		dao.addList(vo);
		
		str = "�÷��� ����Ʈ�� �����ϴ�.";
		
		return str;
		
	}
	
	@RequestMapping(value="/sb_music/sb_delList.mu", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String delList(HttpServletRequest req) {
		
	Gson gson = new GsonBuilder().create();
		

		String mId = req.getParameter("mId"); // mId �����ͼ�
		String ms = req.getParameter("m_serial"); // ���� �ø��� �����ͼ�
		System.out.println("mid="+mId);
		
		MusicListVo vo = dao.playList(mId); // �÷��̸���Ʈ ��������
		vo.setmId(mId); // mid �־��ְ�
		vo.setMusic_serial(ms); // music_serial �־��ְ�
		
		System.out.println("mId =" + vo.getmId()+" / ms = " + vo.getMusic_serial());
		
		
		dao.delList(vo); // �÷��̸���Ʈ x������ ����
		
		MusicListVo vo2 = dao.playList(mId);
		
		String ml = vo2.getMusic_list(); // ����Ʈ �־��ش㿡
		System.out.println("ml: " + ml);
		
		String[] num = ml.split(","); // (,) �ĸ� �׿���
		
		
		int[] nums = new int[num.length]; // �迭�� �־��ص�
		
		for(int i=0; i<num.length; i++) {
			nums[i] = Integer.parseInt(num[i].trim()); // ���鰪 ������ ������ ���̰�
		}
		
	
		
		List<MusicVo> list = dao.pL_music(nums); // �� ���� ����Ʈ�� ��������
		
		String list2 =  gson.toJson(list);
		
		
		System.out.println(list2);
		
		return list2;	
	}
	
	
 
}
