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
	
	public MusicVo play(int serial) {
		MusicVo vo = null;
		try {
			vo = sqlSession.selectOne("music.play", serial);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return vo;
		}
	}
	
	public MusicListVo playList(String mId){
		MusicListVo list = null;
		
		try {
			list = sqlSession.selectOne("music.playList", mId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<MusicVo> pL_music(int[] num) {
		List<MusicVo> vo = null;
		
		try {
			vo = sqlSession.selectList("music.mL_music", num);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return vo;			
		}
		
	}
	
}
