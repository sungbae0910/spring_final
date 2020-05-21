package w_foodcontroller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Factory;

public class FoodDao {
  SqlSession sqlSession;
  
  public FoodDao() {
	  sqlSession = Factory.getFactory().openSession();
  }
  public List<FoodVo> select(String type){
	  List<FoodVo> list = null;
	 
	  try {
		  List<Integer> foodcode = null;		  
		  /*foodcode = sqlSession.selectList("food.foodcode", type);*/
		  list = sqlSession.selectList("food.w_select",type);
		  
	  }catch(Exception ex) {
		  ex.printStackTrace();
	  } finally {
		return list;  
	  }
  }
	
}
