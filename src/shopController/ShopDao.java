package shopController;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Factory;

public class ShopDao {
	SqlSession sqlSession;
	
	public ShopDao() {
		sqlSession = Factory.getFactory().openSession();
		/*sqlSession = Factory.getFactory().openSession();*/
	}

	public List<ShopItemVo> earringMainSelect(){
		List<ShopItemVo> earringList = null;
		try {
			earringList = sqlSession.selectList("shop.main_earring_select");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return earringList;
		}
	}
	
	public List<ShopItemVo> necklaceMainSelect(){
		List<ShopItemVo> necklaceList = null;
		try {
			necklaceList = sqlSession.selectList("shop.main_necklace_select");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return necklaceList;
		}
	}
	
	public List<ShopItemVo> ringMainSelect(){
		List<ShopItemVo> ringList = null;
		try {
			ringList = sqlSession.selectList("shop.main_ring_select");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return ringList;
		}
	}
	
	public List<ShopItemVo> braceletMainSelect(){
		List<ShopItemVo> braceletList = null;
		try {
			braceletList = sqlSession.selectList("shop.main_bracelet_select");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return braceletList;
		}
	}
	
	public List<ShopItemVo> MoreSelect(int item_category){
		List<ShopItemVo> list = null;
		try {
			list = sqlSession.selectList("shop.item_more_select", item_category);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return list;
		}
	}
	
	public ShopItemVo itemDetailView(String item_id) {
		ShopItemVo vo = null;
		try {
			vo = sqlSession.selectOne("item_detail_view", item_id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return vo;
		}
	}
	
	public List<ShopItemVo> typeOption(ShopItemVo vo){
		List<ShopItemVo> typeOption = null;
		vo.setOption_name(0);
		try {
			typeOption = sqlSession.selectList("shop.item_option", vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return typeOption;
		}
	}
	
	public List<ShopItemVo> colorOption(ShopItemVo vo){
		List<ShopItemVo> colorOption = null;
		vo.setOption_name(1);
		try {
			colorOption = sqlSession.selectList("shop.item_option", vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return colorOption;
		}
	}
	
	public List<ShopItemVo> sizeOption(ShopItemVo vo){
		List<ShopItemVo> sizeOption = null;
		vo.setOption_name(2);
		try {
			sizeOption = sqlSession.selectList("shop.item_option", vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return sizeOption;
		}
	}
	
	public List<ShopItemVo> typeValue(ShopItemVo vo){
		List<ShopItemVo> typeValue = null;
		vo.setOption_name(0);
		try {
			typeValue = sqlSession.selectList("shop.item_option_value", vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally { 
			return typeValue;
		}
	}
	
	public List<ShopItemVo> colorValue(ShopItemVo vo){
		List<ShopItemVo> colorValue = null;
		vo.setOption_name(1);
		try {
			colorValue = sqlSession.selectList("shop.item_option_value", vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return colorValue;
		}
	}
	
	public List<ShopItemVo> sizeValue(ShopItemVo vo){
		vo.setOption_name(2);
		List<ShopItemVo> sizeValue = null;
		try {
			sizeValue = sqlSession.selectList("shop.item_option_value", vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return sizeValue;
		}
	}
	
	public List<ShopItemVo> itemPhoto(String item_id){
		List<ShopItemVo> photo = null;
		try {
			photo = sqlSession.selectList("shop.item_detail_photo", item_id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return photo;
		}
	}
}