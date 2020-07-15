package newsCommand;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import newsController.CommentVo;
import newsController.LikeVo;
import newsController.NewsDao;
import newsController.NewsPhotoVo;
import newsController.NewsVo;
import newsController.Page;

@Service
public class NewsService {
	NewsDao dao;
	
	@Autowired
	public NewsService(NewsDao newsDao) {
		this.dao = newsDao;
	}
	
	
	//뉴스 최상단 글 조회
	public List<NewsVo> selectI() {
		List<NewsVo> list = null;
		
		list = dao.selectI();
		
		return list;
	}
	//뉴스 최상단 사진 조회	
	public List<NewsPhotoVo> selectP() {
		List<NewsPhotoVo> list = null;
		list = dao.selectP();
		
		return list;
	}
	
	// 뉴스 카테고리 랜덤 조회
	public List<NewsVo> selectCateAi() {
		List<NewsVo> list = null;
		
		list = dao.selectCateA();
		
		return list;
	}
	
	// 뉴스 카테고리별 조회
	public List<NewsVo> selectCateDe(String cateName){
		List<NewsVo> list = null;
		
		list = dao.selectCateDe(cateName);
		
		return list;
	}
	
	//댓글 갯수
	public String commentCnt(String nSerial) {
		String cnt = "";
		
		cnt = dao.commentCnt(nSerial);
		
		return cnt;
	}
	
	public String commentCnt(HttpServletRequest req) {
		String cnt = "";
		String nSerial = req.getParameter("nSerial");
		
		cnt = dao.commentCnt(nSerial);
		
		return cnt;
	}
	
	public List<NewsVo> weekly(){
		List<NewsVo> vo = null;
		
		vo = dao.weekly();
		
		return vo;
	}
	
	public NewsVo newsDetail(String nSerial){
		NewsVo vo = null;
		
		vo = dao.newsDetail(nSerial);
		
		return vo;
	}
	
	public List<NewsVo> newsDetailSide(String nCategory) {
		List<NewsVo> list = null;
		
		list = dao.newsDetailSide(nCategory);
		
		return list;
	}

	/* 댓글 대댓글 부분 */
	// 댓글
/*	public List<CommentVo> commentView(String nSerial){
		List<CommentVo> comment = null;
		NewsDao dao = new NewsDao();
		
		comment = dao.commentView(nSerial);
		
		return comment;
	}*/
	
	public List<CommentVo> commentView(Page p ) {
		List<CommentVo> comment = null;
		
		comment = dao.commentView(p);
		
		return comment;
	}
	
	public List<CommentVo> commentView(HttpServletRequest req) {
		List<CommentVo> comment = null;
		Page p = new Page();
		String nSerial = req.getParameter("nSerial");
		p.setnSerial(nSerial);
		if(req.getParameter("nowPage") == null || req.getParameter("nowPage") == "") {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
		comment = dao.commentView(p);
		
		return comment;
	}
	
	
	
	//대댓글
	public List<CommentVo> reComment(String nSerial){
		List<CommentVo> reComment = null;
		
		reComment = dao.reComment(nSerial);
		
		return reComment;
	}
	
	public List<CommentVo> reComment(HttpServletRequest req){
		List<CommentVo> reComment = null;
		String nSerial = req.getParameter("nSerial");
		
		reComment = dao.reComment(nSerial);
		
		return reComment;
	}
		
	public void commentInsert(CommentVo vo) {
		
		dao.commentInsert(vo);
	}
	
	public void commentInsert(HttpServletRequest req) {
		CommentVo vo = new CommentVo();
		int nSerial = Integer.parseInt(req.getParameter("nSerial"));
		String mName = req.getParameter("mId");
		String cContent = req.getParameter("content");
		
		
		vo.setnSerial(nSerial);
		vo.setmName(mName);
		vo.setcContent(cContent);
		
		dao.commentInsert(vo);
	}

	
/*	public void reCommentInsert(CommentVo vo) {
		NewsDao dao = new NewsDao();
		
		dao.reCommentInsert(vo);
	}*/
	
	public void reCommentInsert(HttpServletRequest req) {
		CommentVo vo = new CommentVo();
		int nSerial = Integer.parseInt(req.getParameter("nSerial"));
		String nSerial2 = req.getParameter("nSerial");
		int cGroup = Integer.parseInt(req.getParameter("cGroup"));
		String mName = req.getParameter("mId");
		String cContent = req.getParameter("reContent");
		
		vo.setnSerial(nSerial);
		vo.setcGroup(cGroup);
		vo.setmName(mName);
		vo.setcContent(cContent);
		
		
		dao.reCommentInsert(vo);
	}
	
/*	public List<CommentVo> commentCnt(String nSerial) {
		List<CommentVo> cnt = new ArrayList<CommentVo>();
		NewsDao dao = new NewsDao();
		
		cnt = dao.commentCnt(nSerial);
		
		return cnt;
	}*/
	
	public void commentDeletes(String cSerial) {
				
		dao.commentDeletes(cSerial);		
	}
	
	public void commentDelete(String cGroup) {
		
		dao.commentDelete(cGroup);
	}
	
	// 좋아요 확인
	public int likeCheck(LikeVo vo) {
		int check = 0;
		
		check = dao.likeCheck(vo);
		
		return check;
	}
	
	
	// 좋아요 클릭
	public String likeIn(LikeVo vo) {
		String likeCnt = "";
		
		likeCnt = dao.likeIn(vo);
		
		return likeCnt;
	}
	
	// 좋아요 취소
	public String likeOut(LikeVo vo) {
		String likeCnt = "";
		
		likeCnt = dao.likeOut(vo);
		
		return likeCnt;
	}
	
	//싫어요 확인
	public int unLikeCheck(LikeVo vo) {
		int check = 0;
		
		check = dao.unLikeCheck(vo);
		
		return check;
	}
	
	// 싫어요 클릭
	public String unLikeIn(LikeVo vo) {
		String likeCnt = "";
		
		likeCnt = dao.unLikeIn(vo);
		
		return likeCnt;
	}
	
	// 싫어요 취소
	public String unLikeOut(LikeVo vo) {
		String likeCnt = "";
		
		likeCnt = dao.unLikeOut(vo);
		
		return likeCnt;
	}
	
	//검색
	public List<NewsVo> neswSearch(Page page){
		List<NewsVo> list = null;
		
		list = dao.newsSearch(page);
		
		return list;
	}
	
	public NewsPhotoVo newsSearchPho(int nSerial){
		NewsPhotoVo list = null;
		
		list = dao.newsSearchPho(nSerial);
		
		return list;
	}
	
	
	// 조회수 증가(쿠키를 사용하여 중복 조회 방지)
	public void upHit(String nSerial) {
		dao.upHit(nSerial);
		
	}
	
	public List<LikeVo> likeCk(String mId){
		List<LikeVo> likeCk = null;
		
		likeCk = dao.likeCk(mId);
		
		return likeCk;
	}
	
	public List<LikeVo> likeCd(String mId){
		List<LikeVo> likeCd = null;
		
		likeCd = dao.likeCd(mId);
		
		return likeCd;
		
	}
}
