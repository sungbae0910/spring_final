package shopController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {
	private static final String HttpServletRequest = null;
	ShopDao dao;
	
	public ShopController(ShopDao dao) {
		this.dao = dao;
	}
	
	String url = "./shop/";
	
	@RequestMapping(value="/main.shop", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView shopMain(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		ShopItemVo sVo = new ShopItemVo();

		List<ShopItemVo> earringList = dao.earringMainSelect(sVo);
		List<ShopItemVo> necklaceList = dao.necklaceMainSelect(sVo);
		List<ShopItemVo> ringList = dao.ringMainSelect(sVo);
		List<ShopItemVo> braceletList = dao.braceletMainSelect(sVo);
		
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
		int item_category = Integer.parseInt(req.getParameter("item_category"));
		List<ShopItemVo> moreList = dao.MoreSelect(item_category);
		mv.addObject("moreList", moreList);
		mv.setViewName("shop_itemMore");
		return mv;
	}
	
	@RequestMapping(value="/view.shop", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView shopView(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		ShopItemVo sVo = new ShopItemVo();
		String item_id = req.getParameter("item_id");
		sVo.setItem_id(item_id);
				
		ShopItemVo vo = dao.itemDetailView(item_id);
	 	List<ShopItemVo> typeOption = dao.typeOption(sVo);
		List<ShopItemVo> colorOption = dao.colorOption(sVo);
		List<ShopItemVo> sizeOption = dao.sizeOption(sVo);
		List<ShopItemVo> typeValue = dao.typeValue(sVo);
		List<ShopItemVo> colorValue = dao.colorValue(sVo);
		List<ShopItemVo> sizeValue = dao.sizeValue(sVo);
		List<ShopItemVo> photo = dao.itemPhoto(item_id);
		
		mv.addObject("vo", vo);
		mv.addObject("typeOption", typeOption);
		mv.addObject("colorOption", colorOption);
		mv.addObject("sizeOption", sizeOption);
		mv.addObject("typeValue", typeValue);
		mv.addObject("colorValue", colorValue);
		mv.addObject("sizeValue", sizeValue);
		mv.addObject("photo", photo);
		mv.setViewName("shop_itemView");
		
		return mv;
	}

	@RequestMapping(value="/itemLike.shop", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public void itemLike(HttpServletRequest req) {
		ShopItemVo vo = new ShopItemVo();
		vo.setmId(req.getParameter("mId"));
		vo.setItem_id(req.getParameter("item_id"));
		dao.itemLike(vo);
		
		return;
	}
	
	@RequestMapping(value="/itemLikeDelete.shop", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public void itemLikeDelete(HttpServletRequest req) {
		ShopItemVo vo = new ShopItemVo();
		vo.setItem_id(req.getParameter("item_id"));
		dao.itemLikeDelete(vo);
		
		return;
	}
	
	@RequestMapping(value="/basket.shop", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView shopBasket(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("shop_basket");
		return mv;
	}
	
	@RequestMapping(value="/myPage.shop", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView shopMyPage(HttpServletRequest req) {
		System.out.println(10101010);
		ModelAndView mv = new ModelAndView();
		
		System.out.println(202020);
		String mId = req.getParameter("mId");
		System.out.println("myPage : " + mId);
		
		List<ShopItemVo> itemLikeList = dao.itemLikeList(mId);
		
		mv.addObject("itemLikeList", itemLikeList);
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