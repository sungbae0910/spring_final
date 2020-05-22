package controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.MembershipDao;
import mybatis.MembershipVo;

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
	
		str = dao.register(vo);
		System.out.println(str);
		
		mv.setViewName("sb_register");
		
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
		
		System.out.println("asdad");
		if(ck==0){
			ck = dao.userCheck(id, password);
			if(ck==1) {
				httpSession.setAttribute("mName", id);
				System.out.println("로그인 완료");
				mv.setViewName("login");
			}else {
				result = "아이디나 비밀번호를 확인해주세요";
			}
		}else {
			result = "아이디나 비밀번호를 확인해주세요";
		}
		
		mv.addObject("reuslt", result);
		
		return mv;
	}
}
