package controller;

import java.sql.Date;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.MembershipDao;
import blogController.BlogBoardVo;
import mybatis.MembershipVo;
import mybatis.sb_clientVo;
import newsCommand.SendMail;

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
	
	@RequestMapping(value="/sb_music/login.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(HttpServletRequest req) {

		ModelAndView mv = new ModelAndView();
		String result = "";
		String id = req.getParameter("lId");
		String password = req.getParameter("lPwd");
		HttpSession httpSession = req.getSession(true);
		int ck = 0;
		
		ck = dao.confirmId(id);
		
		if(ck==0){
			ck = dao.userCheck(id, password);
			if(ck==1) {
				httpSession.setAttribute("mId", id);
				System.out.println("로그인 완료");
				mv.setViewName("login");
			}else {
				result = "아이디 비밀번호를 확인해주세요";
			}
		}else {
			result = "아이디 비밀번호를 확인해주세요";
		}
		
		mv.addObject("reuslt", result);
		mv.setViewName("index");
		
		mv.addObject("result", result);
		mv.setViewName("index");
		return mv;
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
	public ModelAndView musicLogout(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		req.getSession().invalidate();
		
		mv.setViewName("/sb_music/sb_main");
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
	
	@RequestMapping(value="/sb_music/sb_Membership.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Membership(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		String mId = req.getParameter("mId");
		
		MembershipVo vo = dao.Membership(mId);
		
		mv.addObject("vo", vo);
		
		
		mv.setViewName("/sb_music/sb_myPage");
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
	
	
	@RequestMapping(value="/sb_music/IndexInfo.mem", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String IndexInfo(HttpServletRequest req) {
		String str = "";
		Gson gson = new GsonBuilder().create();
		try {
			MembershipVo vo = new MembershipVo();
			String mId = req.getParameter("mId");
			
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
		List<BlogBoardVo> blogList = dao.blogSelect();
		
		mv.addObject("blogList", blogList);
		mv.setViewName("main");
		return mv;
	}
}






