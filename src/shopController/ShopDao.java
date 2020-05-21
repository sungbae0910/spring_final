package shopController;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Factory;

public class ShopDao {
	SqlSession sqlSession;
	
	public ShopDao() {
		sqlSession = Factory.getFactory().openSession();
	}
	
	public List<ShopItemVo> itemSelect(){
		List<ShopItemVo> list = null;
		try {
			System.out.println(1);
			list = sqlSession.selectList("shop.item_select");
			System.out.println(2);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return list;
		}
	}
}
