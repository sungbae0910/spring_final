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
	
  public String insert(FoodVo vo , w_AttVo attVo) {
	  String msg = "정상적으로 입력되었습니다.";
	  
	  try {
		int cnt = sqlSession.insert("food.w_insert",vo);
		  if(cnt<1) {
			  throw new Exception("본문저장중 오류");
		  }
		      attVo.setFoodCode(vo.getFoodCode());
			  cnt = sqlSession.insert("food.w_att_insert",attVo);
			  if(cnt<1) {
				  throw new Exception("첨부 데이터 저장시 오류 발생");

		  }
		  
		  sqlSession.commit();
	} catch (Exception ex) {
		// TODO: handle exception
		msg = ex.getMessage();
		sqlSession.rollback();
		/*delFile(attList);*/
        ex.printStackTrace();
	}finally {
		return msg;
	}
	  
  }
  
  public FoodVo view(int foodCode) {
	  FoodVo vo = new FoodVo();
	  
	  try {
		vo = sqlSession.selectOne("food.w_view", foodCode);
		
	} catch (Exception e) {
	    e.printStackTrace();
	    
	}finally {
		return vo;
	}
	  
	  
  }
  
  public String modify(FoodVo vo , w_AttVo attVo) {
	  String msg = "정상적으로 수정 되었습니다.";
	  
	  try {
		int cnt = sqlSession.update("food.w_update",vo);
		if(cnt<1) {
			throw new Exception("수정중 오류 발생");
		}

			attVo.setFoodCode(vo.getFoodCode());

			cnt = sqlSession.update("food.w_att_update2",attVo);
			if(cnt<1) throw new Exception("첨부데이터중 오류");



		sqlSession.commit();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		msg = e.getMessage();
		sqlSession.rollback();
	}
	  return msg;
  }
  
  public List<w_AttVo> getAttList(int foodCode){
	  List<w_AttVo> attList = null;
	  

	  try {
		attList = sqlSession.selectList("food.w_att_list",foodCode);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  return attList;
  }
  
  public String delete(FoodVo vo) {
	  String msg = "게시물이 삭제 되었습니다";
	  int cnt = 0;
	  try {
		cnt = sqlSession.delete("food.w_delete",vo);
		if(cnt<1) {
			throw new Exception("삭제중 오류 발생");
		}
		//w_AttVo delList = (w_AttVo) sqlSession.selectList("food.w_att_list",vo.getFoodCode());
		//cnt = sqlSession.delete("food.w_att_list",delList);

		sqlSession.commit();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		sqlSession.rollback();
		msg = e.getMessage();
		e.printStackTrace();
	} finally {
		return msg;
	}
			  
  }
  
  
  
  public void delFile(w_AttVo delList) {

		  File f = new File(FileUpload.upload + delList.getSysFile());
		  if(f.exists()) f.delete();
		  
	  
  }
  
}
