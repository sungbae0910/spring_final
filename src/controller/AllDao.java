package controller;

import org.apache.ibatis.session.SqlSession;

import mybatis.Factory;
import mybatis.MembershipVo;

public class AllDao {
	SqlSession sqlSession;
	
	public AllDao() {
		sqlSession = Factory.getFactory().openSession();
	}
	
	public int eMailCk(String eMail) {
		int ck = 0;
		
		try {
			ck = sqlSession.selectOne("all.email_ck", eMail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ck;
	}
	
	public int pwdChange(String mId, String newPwd) {
		int result = 0; 
		int ck = 0;
		MembershipVo vo = new MembershipVo();
		vo.setmId(mId);
		vo.setPwd(newPwd);
		
		try {
			ck = sqlSession.update("all.pwd_change", vo);
			if(ck < 1) {
				throw new Exception("비밀번호 변경 중 오류발생");
			}
			
			result = 1;
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int idCk(String mId) {
		int ck = 0;
		
		try {
			ck = sqlSession.selectOne("all.id_ck", mId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ck;
	}
	
	public int phoneCk(String phone){
		int result = 0;
		
		try {
			result = sqlSession.selectOne("all.phone_ck", phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String idFind(String phone) {
		String result = "";
		
		try {
			result = sqlSession.selectOne("all.id_find", phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
