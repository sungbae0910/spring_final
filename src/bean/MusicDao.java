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
	
	public MusicVo play(int serial) { // 음악 정보 가져오기
		MusicVo vo = null;
		try {
			vo = sqlSession.selectOne("music.play", serial);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return vo;
		}
	}
	
	public MusicListVo playList(String mId){ // 해당 ID의 플레이 리스트 받아오기
		MusicListVo list = null;
		
		try {
			list = sqlSession.selectOne("music.playList", mId);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<MusicVo> pL_music(int[] num) { //받아온 플레이리스트 각 정보 테이블에 넣는거
		List<MusicVo> vo = null;
		
		try {
			vo = sqlSession.selectList("music.mL_music", num);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return vo;			
		}
	}
	
	public void addList(MusicListVo vo) { // 담거나 실행시 플레이 리스트에 음악 추가
		
		try {
			
			sqlSession.update("music.addList", vo);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} 
		
	}
	
	public void delList(MusicListVo vo) { // x버튼으로 음악 삭제
		
		try {
			sqlSession.update("music.delList", vo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
	}
	

	
}
