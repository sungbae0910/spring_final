package shopController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {
	ShopDao dao;
	
	public ShopController(ShopDao dao) {
		this.dao = dao;
	}
	
	String url = "./shop/";
	
	@RequestMapping(value="/main.shop", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView shopMain(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		List<ShopItemVo> headerMenu = dao.headerCategoryMenu();
		List<ShopItemVo> earringList = dao.earringMainSelect();
		List<ShopItemVo> necklaceList = dao.necklaceMainSelect();
		List<ShopItemVo> ringList = dao.ringMainSelect();
		List<ShopItemVo> braceletList = dao.braceletMainSelect();
		
		mv.addObject("headerMenu", headerMenu);
		mv.addObject("earringList", earringList);
		mv.addObject("necklaceList", necklaceList);
		mv.addObject("ringList", ringList);
		mv.addObject("braceletList", braceletList);
		mv.setViewName("shop_main");
		return mv;
	}
	
	@RequestMapping(value="/more.shop", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView shopMore(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		ShopItemVo vo = (ShopItemVo)req.getAttribute("vo");
		List<ShopItemVo> moreList = dao.MoreSelect(vo);
		
		mv.addObject("moreList", moreList);
		mv.setViewName("shop_itemMore");
		return mv;
	}
	
	@RequestMapping(value="/view.shop", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView shopView(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		System.out.println(1);
		mv.setViewName("shop_itemView");
		return mv;
	}
	
	@RequestMapping(value="/basket.shop", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView shopBasket(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("shop_basket");
		return mv;
	}
	
	@RequestMapping(value="/myPage.shop", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView shopMyPage(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("shop_myPage");
		return mv;
	}
	
	@RequestMapping(value="/payment.shop", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView shopPayment(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("shop_payment");
		return mv;
	}
}