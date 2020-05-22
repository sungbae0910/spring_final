package w_foodcontroller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class FoodController {
  
  FoodDao dao = new FoodDao();
  
  public FoodController(FoodDao dao) {
	  this.dao = dao;
  }
  
  
    
  @RequestMapping(value = "/w_select.fd", method= {RequestMethod.GET,RequestMethod.POST})
  public ModelAndView select(HttpServletRequest req) {
	 ModelAndView mv = new ModelAndView();
	 
	 
	 String type = req.getParameter("type");
	 
	 List<FoodVo> list = dao.select(type);
	 
	 mv.addObject("list",list);
	 
	 mv.setViewName("w_foodimageview");
	 
	 return mv;
  }
  
  public w_MemberService memberService;
	
	@RequestMapping(value = "/w_LoginCheck.fd", method = {RequestMethod.POST})
	public String w_LoginCheck (FoodVo vo , Model model , HttpSession session) {
		
		System.out.println(1234);
		FoodVo w_result = memberService.w_LoginCheck(vo);
		
		if(w_result==null){
			model.addAttribute("message","ID나PW가 틀립니다.");
			return "w_login";
		}else{
			session.setAttribute("loginId", w_result.getW_mid());
			return "w_index";
		}
	}
	
	@RequestMapping(value = "/w_logout", method = RequestMethod.GET)
	public String w_logout(FoodVo vo, Model model, HttpSession session) {
		session.invalidate();		
	//session.setAttribute("loginId",null); 으로 해줘도 된다.
			return "w_index";
	}
	
  
}
