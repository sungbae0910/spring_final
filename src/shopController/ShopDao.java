package shopController;

import org.apache.ibatis.session.SqlSession;

import mybatis.Factory;

public class ShopDao {
	SqlSession sqlSession;
	
	public ShopDao() {
		sqlSession = Factory.getFactory().openSession();
	}
}
