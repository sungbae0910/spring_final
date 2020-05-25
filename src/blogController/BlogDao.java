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
	
	public BlogVo myblogHeaderSelect(String mId) {
		BlogVo myblogHeader = null;
		try {
			//블로그 헤더, 카테고리 조회
			myblogHeader = sqlSession.selectOne("blog.myblogHeader", mId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myblogHeader;
	}
	
	public List<BlogBoardVo> myblogBrdSelect(BlogBoardVo boardVo) {
		List<BlogBoardVo> myblogBrdList = null;
		try {
			if (boardVo.getcName() == "" || boardVo.getcName() == null) { //내 블로그 게시물 전체 조회
				myblogBrdList = sqlSession.selectList("blog.myblogBrdSelect", boardVo);
			} else { //내 블로그 카테고리 게시물 조회
				myblogBrdList = sqlSession.selectList("blog.myblogCategoryBrdSelect", boardVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myblogBrdList;
	}
	
	public BlogBoardVo brdView(int brdNo) {
		BlogBoardVo board = null;
		try {
			//게시물 상세보기
			board = sqlSession.selectOne("blog.brdView", brdNo);
			//선택한 게시물 조회
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public List<BlogVo> category(int bNo) {
		List<BlogVo> category = null;
		try {
			//블로그 카테고리 이름 조회
			category = sqlSession.selectList("blog.category", bNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}
	
	public BlogBoardVo brdModify(int brdNo) {
		BlogBoardVo board = null;
		try {
			//게시물 정보 조회
			board = sqlSession.selectOne("blog.brdView", brdNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
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
