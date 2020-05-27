package controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;

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
import mybatis.MembershipVo;
import mybatis.sb_clientVo;

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
		
		dao.payMembership(mId);
	
		
		mv.setViewName("/sb_music/sb_main");
		
		return mv;
		
	}
	
	@RequestMapping(value="/sb_music/sb_Membership.mem", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Membership(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		String mId = req.getParameter("mId");
		
		MembershipVo vo = dao.Membership(mId);
		
		mv.addObject("vo", vo);
		
		
		mv.setViewName("/sb_music/sb_membership");
		return mv;
	}
	
	
}






