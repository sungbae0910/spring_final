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
	
	
}