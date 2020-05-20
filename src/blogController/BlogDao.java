package blogController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.Session;
import org.apache.ibatis.session.SqlSession;

import mybatis.Factory;

public class BlogDao {
	SqlSession sqlSession;
	
	public BlogDao() {
		sqlSession = Factory.getFactory().openSession();
	}

	public List<BlogBoardVo> bestBrdSelect(String[] tag) {
		List<BlogBoardVo> brdNo = null;
		List<BlogBoardVo> bestBrdList = null;
		try {
			//태그에 해당하는 게시물번호 조회
			brdNo = sqlSession.selectList("blog.tag", tag);
			//주제별 인기있는 게시물 조회
			bestBrdList = sqlSession.selectList("blog.mainBestBrd", brdNo);
			//주제별 게시물 전체 조회
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bestBrdList;
	}
	
	public List<BlogBoardVo> brdListSelect(String[] tag) {
		List<BlogBoardVo> brdNo = null;
		List<BlogBoardVo> brdList = null;
		try {
			//태그에 해당하는 게시물번호 조회
			brdNo = sqlSession.selectList("blog.tag", tag);
			//주제별 게시물 전체 조회
			brdList = sqlSession.selectList("blog.mainBrd", brdNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brdList;
	}
	
	public List<BlogVo> category(int bNo) {
		List<BlogVo> category = null;
		try {
			//해당 블로그 카테고리
			category = sqlSession.selectList("blog.category", bNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}
	
	public BlogBoardVo brdView(int brdNo) {
		BlogBoardVo brdVo = null;
		try {
			brdVo = sqlSession.selectOne("blog.brdView", brdNo);
			//선택한 게시물 조회
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brdVo;
	}
	/*public BlogBoardVo brdView(String brdLike,String brdNo, String mId) {
		BlogBoardVo brdVo = null;
		try {
			if(mId != null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("brdLike", brdLike);
				map.put("brdNo", brdNo);
				map.put("likeMid", mId);
				sqlSession.update("blog.brdLike_update", map);
				sqlSession.insert("blog.Like_insert", map);
				sqlSession.commit();
			}
			//선택한 게시물 조회
			brdVo = sqlSession.selectOne("blog.brdView", brdNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brdVo;
	}*/
}
