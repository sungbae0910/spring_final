package w_foodController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FoodController {
  
  FoodDao1 dao = new FoodDao1();
  
  public FoodController(FoodDao1 dao) {
	  this.dao = dao;
  }
  
  @RequestMapping(value = "/select.food", method= {RequestMethod.GET,RequestMethod.POST})
  public ModelAndView select(HttpServletRequest req) {
	 ModelAndView mv = new ModelAndView();
	 String type = req.getParameter("type");
	 
	 List<FoodVo> list = dao.select(type);
	 
	 mv.addObject("list",list);
	 mv.setViewName("w_foodimageview");
	 
	 return mv;
  }
  
  
  
}
