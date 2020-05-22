package bean;

import org.apache.ibatis.session.SqlSession;

import mybatis.MembershipVo;

public class MembershipDao {

	SqlSession sqlsession;
	
	
	public String Regester(MembershipVo vo) {
		
		String str = "회원가입 완료!";
			
		try {
			sqlsession.insert("membership.register",vo);
			
			sqlsession.commit();
		} catch (Exception e) {
			sqlsession.rollback();
		} finally {
			return str;
		}
		
	}
	
	public String CK_id(String mId) {
		
		String str = null;
		
		
		try {
			sqlsession.selectOne("membership.CH_id", mId);
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
		} finally {
			return str;
		}
		
		
		
	}
	
	
	
}
