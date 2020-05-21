package w_foodcontroller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
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
	 System.out.println("컨트롤러");
	 
	 String type = req.getParameter("type");
	 
	 List<FoodVo> list = dao.select(type);
	 
	 mv.addObject("list",list);
	 
	 mv.setViewName("w_foodimageview");
	 
	 return mv;
  }
  
  
  
}
