package newsCommand;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import newsController.CommentVo;
import newsController.NewsDao;
import newsController.NewsPhotoVo;
import newsController.NewsVo;

@Service
public class NewsService {

	public NewsService() {}
	
	//뉴스 최상단 글 조회
	public List<NewsVo> selectI() {
		NewsDao dao = new NewsDao();
		List<NewsVo> list = null;
		
		list = dao.selectI();
		
		return list;
	}
	//뉴스 최상단 사진 조회	
	public List<NewsPhotoVo> selectP() {
		NewsDao dao = new NewsDao();
		List<NewsPhotoVo> list = null;
		list = dao.selectP();
		
		return list;
	}
	
	// 뉴스 카테고리 랜덤 조회
	public List<NewsVo> selectCateAi() {
		NewsDao dao = new NewsDao();
		List<NewsVo> list = null;
		
		list = dao.selectCateA();
		
		return list;
	}
	
	// 뉴스 카테고리별 조회
	public List<NewsVo> selectCateDe(String cateName){
		NewsDao dao = new NewsDao();
		List<NewsVo> list = null;
		
		list = dao.selectCateDe(cateName);
		
		return list;
	}
	
	public List<NewsVo> weekly(){
		NewsDao dao = new NewsDao();
		List<NewsVo> vo = null;
		
		vo = dao.weekly();
		
		return vo;
	}
	
	public NewsVo newsDetail(String nSerial){
		NewsVo vo = null;
		NewsDao dao = new NewsDao();
		
		vo = dao.newsDetail(nSerial);
		
		return vo;
	}
	
	public List<NewsVo> newsDetailSide(String nCategory) {
		List<NewsVo> list = null;
		NewsDao dao = new NewsDao();
		
		list = dao.newsDetailSide(nCategory);
		
		return list;
	}

	/* 댓글 대댓글 부분 */
	// 댓글
	public List<CommentVo> commentView(String nSerial){
		List<CommentVo> comment = null;
		NewsDao dao = new NewsDao();
		
		comment = dao.commentView(nSerial);
		
		return comment;
	}
	
	//대댓글
	public List<CommentVo> reComment(String nSerial){
		List<CommentVo> reComment = null;
		NewsDao dao = new NewsDao();
		
		reComment = dao.reComment(nSerial);
		
		return reComment;
	}
		
	public void commentInsert(CommentVo vo) {
		NewsDao dao = new NewsDao();
		
		dao.commentInsert(vo);
	}
	
	public List<CommentVo> commentCnt(String nSerial) {
		List<CommentVo> cnt = new ArrayList<CommentVo>();
		NewsDao dao = new NewsDao();
		
		cnt = dao.commentCnt(nSerial);
		
		return cnt;
	}
	
	public void commentDeletes(String cSerial) {
		NewsDao dao = new NewsDao();
				
		dao.commentDeletes(cSerial);		
	}
	
	public void commentDelete(String cGroup) {
		NewsDao dao = new NewsDao();
		
		dao.commentDelete(cGroup);
	}
	
	
	
}
