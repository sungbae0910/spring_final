package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import command.AllService;

@Controller
public class AllController {
	AllService as;
	
	@Autowired
	public AllController(AllService allService) {
		this.as = allService;
	}
	
	// 비밀번호 찾기 인증번호
	@RequestMapping(value="/codeIssue.all", method= {RequestMethod.POST, RequestMethod.GET}, produces ="application/text; charset=utf8")
	@ResponseBody
	public String codeIssue(HttpServletRequest req) {
		String result = "";
		
		result = as.codeIssue(req);

		return result;
	}
	
	// 비밀번호 변경(이메일 여부 체크)
	@RequestMapping(value="/eMailCk.all", method= {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String eMailCk(HttpServletRequest req) {
		int ck = 0;
		JSONObject obj = new JSONObject();
		ck = as.eMailCk(req);
		
		obj.put("ck", ck);
		
		return obj.toJSONString();
	}
	
/*	@RequestMapping(value="/pwdPage.all", method= {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String pwdPage(HttpServletRequest req, HttpSession session) {
		int result = 0;
		JSONObject obj = new JSONObject();
		String mId = "asd";
		
		result = as.pwdPage(req, session);
		
		obj.put("result", result);
		obj.put("mId", mId);
		
		return obj.toJSONString();
	}
	*/
	@RequestMapping(value="/pwdIssue.all", method= {RequestMethod.POST, RequestMethod.GET}, produces ="application/text; charset=utf8")
	@ResponseBody
	public String pwdIssue(HttpServletRequest req, HttpSession session) {
		int ck = 0;
		String result = "";
		Gson gson =	new GsonBuilder().create();
		
		ck = as.pwdIssue(req, session);
		
		if(ck == 1) {
			result = "1";
		}else {
			result = "0";
		}
		
		return result;
	}
	
	@RequestMapping(value="/idCk.all", method= {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String idCk(HttpServletRequest req) {
		String result = "";
		int ck = 0;
		ck = as.idCk(req);
		
		if(ck == 1) {
			result = "1";
		}else {
			result = "0";
		}
		
		return result;
	}
	
	@RequestMapping(value="/pwPageChange.all", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView pwPageChange(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		String mId = req.getParameter("mId");
		mv.addObject("mId", mId);
		
		mv.setViewName("pwFind");
		return mv;
	}
	
	@RequestMapping(value="/phoneCk.all", method= {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String phoneCk(HttpServletRequest req) {
		String result = "";
		int ck = 0;
		
		ck = as.phoneCk(req);
		if(ck == 1) {
			result = "1";
		}else {
			result= "0";
		}
		
		return result;
	}
	
	@RequestMapping(value="/idFind.all", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView idFind(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String result = "";
		
		result = as.idFind(req);
		
		mv.addObject("result", result);
		
		mv.setViewName("/root/idResult");
		return mv;
	}
}
