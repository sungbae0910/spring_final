package w_foodcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 
	 
	 String type = req.getParameter("type");
	 
	 List<FoodVo> list = dao.select(type);
	 
	 mv.addObject("list",list);
	 
	 mv.setViewName("w_foodimageview");
	 
	 return mv;
  }
  
  @RequestMapping(value="/w_insert.fd", method= {RequestMethod.POST})  
  public ModelAndView insert() {
	  
	  ModelAndView mv = new ModelAndView();
	  
	  mv.setViewName("w_image_insert");
	  return mv;
  }
  
  
  
  @RequestMapping(value="/w_insertR.fd", method= {RequestMethod.POST})
  public ModelAndView insertR(HttpServletRequest req, HttpServletResponse resp) {
	  ModelAndView mv = new ModelAndView();
	  String msg = "게시판 정보가 저장되었습니다.";
	  System.out.println(12341231);
	  //FileUpload
	  FileUpload fu = new FileUpload(req, resp);
	  HttpServletRequest newReq = fu.uploading();
	  FoodVo vo = (FoodVo)newReq.getAttribute("vo");

	  List<w_AttVo> attList = (List<w_AttVo>)newReq.getAttribute("attList");
	  msg = dao.insert(vo, attList);
	  
	  mv.addObject("msg",msg);
	  mv.setViewName("w_index");
	  return mv;  
  }
  
  @RequestMapping(value="/w_view.fd",method = {RequestMethod.POST})
  public ModelAndView view(HttpServletRequest req) {
	  ModelAndView mv = new ModelAndView();

	  FoodVo vo = null;
	  
	  String foodCode = req.getParameter("foodCode");
	  System.out.println(foodCode);
	  vo = dao.view(foodCode);

	  mv.addObject("vo",vo);
	  mv.setViewName("w_image_view");
	  
	  return mv;
  }
  
  
  
  
}
