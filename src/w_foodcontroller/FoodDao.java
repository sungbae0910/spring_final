package w_foodcontroller;

import java.io.File;
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
	
  public String insert(FoodVo vo , List<w_AttVo> attList) {
	  String msg = "정상적으로 입력되었습니다.";
	  
	  try {
		int cnt = sqlSession.insert("food.w_insert",vo);
		  if(cnt<1) {
			  throw new Exception("본문저장중 오류");
		  }
		  for(w_AttVo attVo : attList) {
			  cnt = sqlSession.insert("food.w_att_insert",attVo);
			  if(cnt<1) {
				  throw new Exception("첨부 데이터 저장시 오류 발생");
			  }
		  }
		  
		  sqlSession.commit();
	} catch (Exception ex) {
		// TODO: handle exception
		msg = ex.getMessage();
		sqlSession.rollback();
		delFile(attList);
        ex.printStackTrace();
	}finally {
		return msg;
	}
	  
  }
  
  public FoodVo view(String foodCode) {
	  FoodVo vo = new FoodVo();
	  
	  try {
		vo = sqlSession.selectOne("food.w_view", foodCode);
		
	} catch (Exception e) {
	    e.printStackTrace();
	    
	}finally {
		return vo;
	}
	  
	  
  }
  
  
  
  
  public void delFile(List<w_AttVo> delList) {
	  for(w_AttVo attVo : delList) {
		  File f = new File(FileUpload.upload + attVo.getSysFile());
		  if(f.exists()) f.delete();
		  
	  }
  }
  
}
