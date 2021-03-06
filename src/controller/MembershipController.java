package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import bean.MembershipDao;
import blogController.BlogBoardVo;
import lolVo.GameIdVo;
import lolVo.LeagueVo;
import lolVo.LotationVo;
import lolVo.ParticipantStatsVo;
import lolVo.ParticipantVo;
import lolVo.PlayerVo;
import lolVo.SummonerVo;
import mybatis.MembershipVo;
import mybatis.dictionaryVo;
import mybatis.sb_clientVo;
import mybatis.searchVo;
import newsController.NewsPhotoVo;
import newsController.NewsVo;
import shopController.ShopItemVo;

@Controller
public class MembershipController {
	MembershipDao dao;
	
	@Autowired
	public MembershipController(MembershipDao msDao) {
		this.dao = msDao;
	}
	
	@RequestMapping(value="/sb_music/Register.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Register(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		MembershipVo vo = new MembershipVo();
		sb_clientVo cvo = new sb_clientVo();
		String str = null;
		
		String mId = req.getParameter("mId");
		String pwd = req.getParameter("pwd");
		String mName = req.getParameter("mName");
		String birth = req.getParameter("birth");
		String phone = req.getParameter("phone");
		String eMail = req.getParameter("email");
		String address = req.getParameter("address");
		int gender = Integer.parseInt(req.getParameter("gender"));
		
		vo.setmId(mId);
		vo.setPwd(pwd);
		vo.setmName(mName);
		vo.setBirth(birth);
		vo.setPhone(phone);
		vo.setEmail(eMail);
		vo.setAddress(address);
		vo.setGender(gender);
		
		//음악사이트 계정정보 추가
		cvo.setID(mId);
		cvo.setPwd(pwd);
		dao.sb_client(cvo);
		dao.sb_playlist(cvo);
	
		str = dao.register(vo);
		System.out.println(str);
		
		mv.setViewName("index");
		
		return mv;
	}
	
	@RequestMapping(value="/sb_music/mIdCk.mem", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String ck_id(HttpServletRequest req) {
		String cp = "";
		
		String mId = req.getParameter("mId");
		System.out.println("mId:"+mId);
		
		String compare = dao.ck_id(mId);
		System.out.println("compare: " + compare);
		
		
		if(compare.equals("1")) {
			cp = "1";
		}else {
			cp = "2";
		}
		
		
		return cp;
	}
	
	@RequestMapping(value="/login.mem", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String login(HttpServletRequest req) {
		String result = "";
		String id = req.getParameter("lId");
		String password = req.getParameter("lPwd");
		String nSerial = req.getParameter("nSerial");
		JSONObject ob = new JSONObject();
		HttpSession httpSession = req.getSession(true);
		int ck = 0;
		
		ck = dao.confirmId(id);
		
		if(ck==0){
			ck = dao.userCheck(id, password);
			if(ck==1) {
				httpSession.setAttribute("mId", id);
				System.out.println("로그인 완료");
				result = "1";
			}else {
				result = "0";
			}
		}else {
			result = "0";
		}
		
		ob.put("result", result);
		ob.put("nSerial", nSerial);
		ob.put("mId", id);
		
		return ob.toJSONString();
	}
	
	@RequestMapping(value="/sb_music/sb_login.mem", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ModelAndView music_login(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		HttpSession httpSession = req.getSession();
		String cp = "";
		String str;
		
		MembershipDao dao = new MembershipDao();
		String mId = req.getParameter("mId");
		String pwd = req.getParameter("pwd");
		int ck = 0;
		
		ck = dao.confirmId(mId);
		if(ck==0){
			ck = dao.userCheck(mId, pwd);
			if(ck==1) {
				httpSession.setAttribute("mId", mId);
				System.out.println("워멜 로긴");
				cp = "1";
			}else {
				cp = "2";
			}
		}else {
			cp = "2";
		}
		
		if(cp == "1") {
			mv.setViewName("/sb_music/sb_main");
		}else {
			mv.setViewName("/sb_music/sb_login");
		}
		
		
		return mv;
	}
	
	@RequestMapping(value="/sb_music/sb_logout.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public String musicLogout(HttpSession session) {
		
		session.removeAttribute("mId");
	
		return "redirect:/sb_main.jsp";
	}
	
	@RequestMapping(value="/sb_music/logout.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Logout(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		req.getSession().invalidate();
		
		mv.setViewName("index");
		
		return mv;
	}
	
	
	@RequestMapping(value="/sb_music/sb_payMembership.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView payMembership(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String mId = req.getParameter("mId");
		System.out.println("페이후");
		System.out.println(mId);
		dao.payMembership(mId);
		
		System.out.println("페이 완료");
		
		mv.setViewName("/sb_music/sb_main");
		return mv;
	}
	
	@RequestMapping(value="/sb_music/Membership.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Membership(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		String mId = req.getParameter("mId");
		System.out.println(mId);
		MembershipVo vo = dao.Membership(mId);
		
		mv.addObject("vo", vo);
		
		
		mv.setViewName("/root/root_myPage");
		return mv;
	}
	
	@RequestMapping(value="/sb_music/sb_IsMembership.mem", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String IsMembership(HttpServletRequest req) {
		String s = "";
		Gson gson = new GsonBuilder().create();
		
		String mId = req.getParameter("mId");
		
		Timestamp date = new Timestamp(0);
		try {
			date = dao.IsMembership(mId);		
			Timestamp sysdate = new Timestamp(System.currentTimeMillis());
			
			Date cp = new Date();
			cp.setTime(date.getTime());
			
			String fd = new SimpleDateFormat("yyyyMMddHHmm").format(cp);
			System.out.println(fd);
			
			cp.setTime(sysdate.getTime());
			
			String fd2 = new SimpleDateFormat("yyyyMMddHHmm").format(cp);
			System.out.println(fd2);
			
			Double n1 = Double.parseDouble(fd);
			Double n2 = Double.parseDouble(fd2);
			
			
			String result = "";
			if(n1 > n2) {
				result = "y";
			}else {
				result = "n";
			}
			
			System.out.println(result);
			s = gson.toJson(result);
		} catch (Exception e) {
			System.out.println("회원 멤버쉽 날짜 값이 없음");
		} finally {
			return s;			
		}
	}
	
	
	@RequestMapping(value="/IndexInfo.mem", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String IndexInfo(HttpServletRequest req, HttpSession session) {
		String str = "";
		Gson gson = new GsonBuilder().create();
		try {
			MembershipVo vo = new MembershipVo();
			String mId = (String)session.getAttribute("mId");
			
			vo = dao.Membership(mId);
			
			str = gson.toJson(vo);
			
		} catch (Exception e) {
			System.out.println("비로그인 상태");	
		}
		
		return str;
	}

	
	@RequestMapping(value="/main.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		ShopItemVo sVo = new ShopItemVo();
		List<BlogBoardVo> blogLife = dao.blogLife();
		List<BlogBoardVo> blogTravel = dao.blogTravel();
		List<BlogBoardVo> blogIt = dao.blogIt();
		
		List<ShopItemVo> earringList = dao.earringList(sVo);
		List<ShopItemVo> necklaceList = dao.necklaceList(sVo);
		List<ShopItemVo> ringList = dao.ringList(sVo);
		List<ShopItemVo> braceletList = dao.braceletList(sVo);

		List<NewsVo> newsInfo = dao.selectI();
		List<NewsPhotoVo> newsPhoto = dao.selectP();
		
		mv.addObject("newsInfo", newsInfo);
		mv.addObject("newsPhoto", newsPhoto);
		
		mv.addObject("blogLife", blogLife);
		mv.addObject("blogTravel", blogTravel);
		mv.addObject("blogIt", blogIt);
		
		mv.addObject("earringList", earringList);
		mv.addObject("necklaceList", necklaceList);
		mv.addObject("ringList", ringList);
		mv.addObject("braceletList", braceletList);

		mv.setViewName("main");
		
		return mv;
	}
	
	@RequestMapping(value="*/dictionary.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView dictionary(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		try {
			String search = req.getParameter("w_bar");
			
			List<dictionaryVo> list = dao.dictionary(search);
			
			dictionaryVo vo = list.get(0);
			System.out.println("섬 + "+vo.getThumnail());
			
			
			mv.addObject("dictionaryList", list); // 사전
			
		} catch (Exception e) {
			System.out.println("검색값이 공백");
		}
		
		
		
		
		mv.setViewName("root_dictionary");
		return mv;
	}

	@RequestMapping(value="/root/movie.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView movie(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		try {
			String search = req.getParameter("findStr");
			
			List<searchVo> list = dao.movie(search);
			
			mv.addObject("movieList",list);
			
			System.out.println("여기까지");
			mv.setViewName("root_movieSearch");
		} catch (Exception e) {
			System.out.println("영화 검색값 없엉");
		}
		

		return mv;
	}
	
	@RequestMapping(value="/search.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView search(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		try {
			String search = req.getParameter("searchBar");
			
			List<searchVo> list = dao.Search(search); // 뉴스
			List<searchVo> list2 = dao.kin(search); // 지식in
			List<searchVo> list3 = dao.SearchBlog(search); // 블로그
			List<searchVo> list4 = dao.SearchShop(search); // 상점
			
			
			mv.addObject("searchList", list); //뉴스
			mv.addObject("kinList",list2); // 지식in
			mv.addObject("blogList",list3); // 블로그
			mv.addObject("shopList",list4);
			
			mv.setViewName("root/root_search");
		} catch (Exception e) {
			System.out.println("검색값이 공백");
		}
		
		
		return mv;
	}
	
	@RequestMapping(value="/logout.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		
		session.removeAttribute("mId");
		
		return "redirect:index.jsp";
	}
	
	/*@RequestMapping(value="/blogLogout.mem", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String blogLogout(HttpSession session, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String url = req.getHeader("referer");
		session.invalidate();
		return url;
	}*/
	
	@RequestMapping(value="/newsDetail.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public String newsDetail(@RequestParam("s_nserial") String nSerial, @RequestParam("mId") String mId) {
		
		return "redirect:/news/newsDetail.news?nSerial="+nSerial+"&mId="+mId;
	}
	
	@RequestMapping(value="/root/gg.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView gg(Model model, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		LotationVo lotation = dao.lol_lotation();
		String lo1 = "";
		String lo2 = "";
		String lo3 = "";
		String lo4 = "";
		String lo5 = "";
		String lo6 = "";
		String lo7 = "";
		String lo8 = "";
		String lo9 = "";
		String lo10 = "";
		String lo11 = "";
		String lo12 = "";
		String lo13 = "";
		String lo14 = "";
		
		List<Integer> list = new ArrayList<Integer>();
		list = lotation.getFreeChampions();
		lo1 = dao.Champion(list.get(0));
		lo2 = dao.Champion(list.get(1));
		lo3 = dao.Champion(list.get(2));
		lo4 = dao.Champion(list.get(3));
		lo5 = dao.Champion(list.get(4));
		lo6 = dao.Champion(list.get(5));
		lo7 = dao.Champion(list.get(6));
		lo8 = dao.Champion(list.get(7));
		lo9 = dao.Champion(list.get(8));
		lo10 = dao.Champion(list.get(9));
		lo11 = dao.Champion(list.get(10));
		lo12 = dao.Champion(list.get(11));
		lo13 = dao.Champion(list.get(12));
		lo14 = dao.Champion(list.get(13));
		
		mv.addObject("lo1", lo1);
		mv.addObject("lo2", lo2);
		mv.addObject("lo3", lo3);
		mv.addObject("lo4", lo4);
		mv.addObject("lo5", lo5);
		mv.addObject("lo6", lo6);
		mv.addObject("lo7", lo7);
		mv.addObject("lo8", lo8);
		mv.addObject("lo9", lo9);
		mv.addObject("lo10", lo10);
		mv.addObject("lo11", lo11);
		mv.addObject("lo12", lo12);
		mv.addObject("lo13", lo13);
		mv.addObject("lo14", lo14);
		
		
		
		mv.setViewName("root_lol");
		return mv;
	}
	
	
	@RequestMapping(value="/root/lol.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView searchSummoner(Model model, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView();

		SummonerVo temp1 = null;
		LeagueVo temp2 = null;
		GameIdVo temp3 = null;
		ParticipantVo temp4= null;
		ParticipantStatsVo stat = null;
		List<PlayerVo> PlayerList = null;
		
		List<Long> GameIds = new ArrayList<Long>();
		
		temp1 = dao.searchSummoner(model, httpServletRequest);
		String Id = temp1.getId();
		temp2 = dao.SummonerRank(model, httpServletRequest, Id);
		String AccountId = temp1.getAccountId();
		GameIds = dao.GameId(model, httpServletRequest, AccountId);
		
		for(long l : GameIds) {
			System.out.println("게임 번호"+l);
		}
		PlayerList = dao.Match(model, httpServletRequest, GameIds); // 플레이어 이름, 아이콘
		temp4 = dao.LOLInfo(model, httpServletRequest, GameIds);
		
		
		
		List<Integer> ten = temp4.getPlayerten();
		List<String> tenC = new ArrayList<String>();
		
		// 게임한 소환사들 챔피언
		String champ = dao.Champion(temp4.getChampionId());
		String champ1 = dao.Champion(ten.get(0));
		String champ2 = dao.Champion(ten.get(1));
		String champ3 = dao.Champion(ten.get(2));
		String champ4 = dao.Champion(ten.get(3));
		String champ5 = dao.Champion(ten.get(4));
		String champ6 = dao.Champion(ten.get(5));
		String champ7 = dao.Champion(ten.get(6));
		String champ8 = dao.Champion(ten.get(7));
		String champ9 = dao.Champion(ten.get(8));
		String champ10 = dao.Champion(ten.get(9));
		
		tenC.add(0, champ1);
		tenC.add(1, champ2);
		tenC.add(2, champ3);
		tenC.add(3, champ4);
		tenC.add(4, champ5);
		tenC.add(5, champ6);
		tenC.add(6, champ7);
		tenC.add(7, champ8);
		tenC.add(8, champ9);
		tenC.add(9, champ10);
		
		// 이번주 로테이션
		
		
		
		
		
		System.out.println("afterChamp");
		stat = temp4.getStats();
		
		
		
		mv.addObject("summoner", temp1);
		mv.addObject("leagueInfo", temp2);
		
		mv.addObject("tierImgURL", "../main_lib/images/tier/" + temp2.getTier() + ".png");

		mv.addObject("imgURL",
				"http://ddragon.leagueoflegends.com/cdn/9.16.1/img/profileicon/" + temp1.getProfileIconId() + ".png");
		mv.addObject("Players", PlayerList);
		mv.addObject("MyInfo", temp4);
		mv.addObject("champ", champ);
		mv.addObject("stat", stat);
		mv.addObject("tenC", tenC);
		
		
	
		
		mv.setViewName("root_lol_search");
		
		
		return mv;
	}
		
		


}
