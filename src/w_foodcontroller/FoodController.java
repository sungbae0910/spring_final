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

	  //FileUpload
	  FileUpload fu = new FileUpload(req, resp);
	  HttpServletRequest newReq = fu.uploading();
	  FoodVo vo = (FoodVo)newReq.getAttribute("vo");

	  w_AttVo attList = (w_AttVo)newReq.getAttribute("attVo");
	  msg = dao.insert(vo, attList);
	  
	  mv.addObject("msg",msg);
	  mv.setViewName("w_menu");
	  return mv;  
  }
  
  @RequestMapping(value="/w_view.fd",method = {RequestMethod.POST})
  public ModelAndView view(HttpServletRequest req) {
	  ModelAndView mv = new ModelAndView();

	  FoodVo vo = null;
	  
	  int foodCode = Integer.parseInt(req.getParameter("foodCode"));
	  
	  vo = dao.view(foodCode);

	  mv.addObject("vo",vo);
	  mv.setViewName("w_image_view");
	  
	  return mv;
  }
  @RequestMapping(value="/w_modify.fd", method= {RequestMethod.POST})
  public ModelAndView modify(HttpServletRequest req) {
	  ModelAndView mv = new ModelAndView();
	  FoodVo vo = null;
	  
	  int foodCode = Integer.parseInt(req.getParameter("foodCode"));

	  vo = dao.view(foodCode);

	  mv.addObject("vo",vo);
	  mv.setViewName("w_image_modify");
	  
	  return mv;
	  
	  
  }
  
  
  @RequestMapping(value="/w_modifyR.fd",method= {RequestMethod.GET,RequestMethod.POST})
  public ModelAndView modifyR(HttpServletRequest req, HttpServletResponse resp) {
	  ModelAndView mv = new ModelAndView();
	  FoodVo vo = new  FoodVo();
	  w_AttVo attVo = new w_AttVo();
	  FileUpload fu = new FileUpload(req, resp);
	  fu.uploading();

	  
	  vo = (FoodVo)req.getAttribute("vo");

	  attVo = (w_AttVo)req.getAttribute("attVo");

	  
	  String msg = dao.modify(vo, attVo);
	  
	  mv.addObject("msg",msg);
	  mv.setViewName("w_menu");
	  
	  return mv;
  }
  
  @RequestMapping(value="/w_delete.fd",method= {RequestMethod.POST})
  public ModelAndView delete(HttpServletRequest req ) {
	  ModelAndView mv = new ModelAndView();
	  FoodVo vo = new FoodVo();
	  int foodCode = Integer.parseInt(req.getParameter("foodCode"));
	  
      
	  vo.setFoodCode(foodCode);


	  String msg = dao.delete(vo);

	  mv.addObject("msg",msg);
	  mv.setViewName("w_menu");
	  
	  return mv;
  }
  
  
}
