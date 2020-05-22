package w_foodcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class w_LoginController {
   
	@Autowired
	private w_Service w_service;
	
	@RequestMapping(value="/w_login.fd")
	public String login() {
		return "w_login";
	}
    
	@RequestMapping(value="/w_LoginCheck.fd")
	public ModelAndView w_LoginCheck(@ModelAttribute w_LoginVo vo ,HttpSession session) {
		
		boolean result = w_service.w_LoginCheck(vo, session);
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("w_login");
		
		if(result) {
			mv.addObject("성공");
		}else {
			mv.addObject("실패");
		}
			return mv;
	}
	@RequestMapping(value="/w_LogOut.fd")
	public ModelAndView w_Logout(HttpSession session) {
		
		w_service.w_Logout(session);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("w_login");
		mv.addObject("msg","w_logout");
		
		return mv;
		
	}
	
	
	
}
