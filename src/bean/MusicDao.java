package bean;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Factory;
import mybatis.MusicListVo;
import mybatis.MusicVo;

public class MusicDao {
	
	SqlSession sqlSession;
	
	public MusicDao() {
		sqlSession = Factory.getFactory().openSession();
	}
	
	
	//TOP 10
	public List<MusicVo> top10(){
		List<MusicVo> list = null;
		try {
			list = sqlSession.selectList("music.home");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
	}
	
	public List<MusicVo> top100(){
		List<MusicVo> list= null;
		try {
			list = sqlSession.selectList("music.top100");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
		
	}
	
	public MusicVo info(int serial) {
		MusicVo vo = null;
		
		try {
			vo = sqlSession.selectOne("music.info",serial);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return vo;
		}
	}
	
	
	public MusicVo movie(int serial) {
		MusicVo vo = null;	
		try {
			vo = sqlSession.selectOne("music.movie", serial);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			return vo;
		}
	}
	
	public MusicVo play(int serial) { // ���� ���� ��������
		MusicVo vo = null;
		try {
			vo = sqlSession.selectOne("music.play", serial);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return vo;
		}
	}
	
	public MusicListVo playList(String mId){ // �ش� ID�� �÷��� ����Ʈ �޾ƿ���
		MusicListVo list = null;
		
		try {
			list = sqlSession.selectOne("music.playList", mId);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<MusicVo> mL_music(int[] num) { //�޾ƿ� �÷��̸���Ʈ �� ���� ���̺� �ִ°�
		List<MusicVo> vo = null;
		
		try {
			vo = sqlSession.selectList("music.mL_music", num);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return vo;			
		}
	}
	
	public MusicVo pL_music(int num) { //�޾ƿ� �÷��̸���Ʈ �� ���� ���̺� �ִ°�
		MusicVo vo = null;
		
		try {
			vo = sqlSession.selectOne("music.pL_music", num);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return vo;			
		}
	}
	
	public void addList(MusicListVo vo) { // ��ų� ����� �÷��� ����Ʈ�� ���� �߰�
		
		try {
			
			sqlSession.update("music.addList", vo);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} 
		
	}
	
	public void delList(MusicListVo vo) { // x��ư���� ���� ����
		
		try {
			sqlSession.update("music.delList", vo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
	}
	
	public List<MusicVo> search(String str) {
		List<MusicVo> list = null;
		try {
			list = sqlSession.selectList("music.search", str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
		
	}
	
	public void ChDrag(MusicListVo vo) {
		
		try {
			sqlSession.update("music.change", vo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
	}

	public void removeAll(String mId) {
		
		try {
			sqlSession.update("music.removeAll", mId);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
	}
	
}
