package bean;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.apache.ibatis.session.SqlSession;

import blogController.BlogBoardVo;
import mybatis.Factory;
import mybatis.MembershipVo;
import mybatis.sb_clientVo;

public class MembershipDao {

	SqlSession sqlSession;
	
	
	public MembershipDao() {
		sqlSession = Factory.getFactory().openSession();
	}
	
	public String register(MembershipVo vo) {
		
		String str = "회원가입 완료!!";
			
		try {
			int ck = sqlSession.insert("membership.register",vo);
			if(ck<1) {
				throw new Exception("회원가입중 오류 발생!!");
			}
			sqlSession.commit();
		} catch (Exception e) {
			str = e.getMessage();
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			return str;
		}
		
	}
	
	public void sb_client(sb_clientVo vo) {
		
		try {
			sqlSession.insert("membership.sb_client", vo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
		
	}
	
	public void sb_playlist(sb_clientVo vo) {
		try {
			sqlSession.insert("membership.sb_playlist", vo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
	}
	
	public String ck_id(String mId) {
		
		String str = null;
		try {
			System.out.println(mId);
			str = sqlSession.selectOne("membership.ck_id", mId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return str;
		}
		
	}
	
	public int confirmId(String mId) {
		int ck = 0;
		
		try {
			ck = sqlSession.selectOne("membership.login_id_ck", mId);
			
			if(ck == 1) {
				ck = 0;
			}else {
				ck = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ck;
	}
	
	public int userCheck(String mId, String pwd) {
		int ck = 0;
		String pass = "";
		try {
			pass = sqlSession.selectOne("membership.login_pass_ck", mId);
			if(pwd.equals(pass)) {
				ck = 1;
			}else {
				ck = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ck;
	}
	
	public void payMembership(String mId) {

		try {
			sqlSession.update("membership.payMembership", mId);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
	}
	
	public MembershipVo Membership(String mId) {
		MembershipVo vo = new MembershipVo();
		try {
			vo = sqlSession.selectOne("membership.membership", mId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public Timestamp IsMembership(String mId) {
		Timestamp date = new Timestamp(0);
		
		try {
			date = sqlSession.selectOne("membership.IsMembership", mId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return date;
		
	}

	public List<BlogBoardVo> blogSelect() {
		List<BlogBoardVo> blogList = null;
		try {
			blogList = sqlSession.selectList("membership.blogSelect");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return blogList;
	}
	
}

