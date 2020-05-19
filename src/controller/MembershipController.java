package controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value="/sb_music/Register.ms", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Register(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		MembershipVo vo = null;
		String str = null;
		
		String mId = req.getParameter("mId");
		String pwd = req.getParameter("pwd");
		String mName = req.getParameter("mName");
		String birth = req.getParameter("birth");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		int gender = Integer.parseInt(req.getParameter("gender"));
		
		vo.setmId(mId);
		vo.setPwd(pwd);
		vo.setmName(mName);
		vo.setBirth(birth);
		vo.setPhone(phone);
		vo.setAddress(address);
		vo.setGender(gender);
	
		str = dao.Regester(vo);
		
		return mv;
	}
	
	@RequestMapping(value="/sb_music/CK_id.ms", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public int CK_id(HttpServletRequest req) {
		int cp = 0;
		
		String mId = req.getParameter("mId");
		System.out.println("mId:"+mId);
		
		String compare = dao.CK_id(mId);
		System.out.println("compare: " + compare);
		
		
		if(compare == mId) {
			cp = 1;
		}else {
			cp = 2;
		}
		
		
		return cp;
	}
	
	
}
