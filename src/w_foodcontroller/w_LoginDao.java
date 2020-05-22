package w_foodcontroller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class w_LoginDao {
   
   @Autowired
   SqlSession sqlSession;
   
   public boolean w_LoginCheck(w_LoginVo vo) {
	   System.out.println("==>Mybatis로 w_LoginCheck() 기능 처리 ");
	   String w_name = sqlSession.selectOne("food.w_LoginCheck",vo);
	   
	   return (Integer.parseInt(w_name)==0)? false:true;
	   
	   
   }
   public void w_Logout(HttpSession session) {
	   System.out.println("===> 로그아웃 기능 처리");
		session.invalidate();
   }
	
}
