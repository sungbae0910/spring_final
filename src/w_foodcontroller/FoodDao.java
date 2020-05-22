package w_foodcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

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
  
  public FoodVo w_LoginCheck(FoodVo vo) {
	  FoodVo w_result = null;
	   
	   w_foodService w_food = sqlSession.getMapper(w_foodService.class);
	   
	   try {
			w_result = w_food.w_LoginCheck(vo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}

		return w_result;   
  }
  
  
	
}
