package newsController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Factory;

public class NewsDao {
	SqlSession sqlSession;
	String path = "C:\\Users\\JHTA\\eclipse-workspace\\spring_final\\WebContent\\news\\img\\newsImages\\";
	public NewsDao() {
		sqlSession = Factory.getFactory().openSession();
	}
	
	//크롤링 정보 insert
	public String insert(NewsVo vo, List<NewsPhotoVo> phoVo) {
		String msg = "";	
		System.out.println(vo.getnCompany());
		try {
			int cnt = sqlSession.insert("news.news_insert", vo);
			if(cnt<1) {
				throw new Exception("정보 저장 중 오류 발생");
			}
			
			for(NewsPhotoVo list : phoVo) {
				cnt = sqlSession.insert("news.news_photo_insert", list);
				if(cnt<1) {
					throw new Exception("사진 정보 저장 중 오류 발생");
				}
			}
			
			sqlSession.commit();
		} catch (Exception e) {
			delFile(phoVo);
			e.printStackTrace();
			msg = e.getMessage();
			sqlSession.rollback();
		}
		return msg;
	}
	
	
	public void delFile(List<NewsPhotoVo> phoVo) {
		for(NewsPhotoVo list: phoVo) {
			File f = new File(path+list.getpName());
			if(f.exists()) f.delete();
		}
	}
	
	//뉴스 최상단 글 조회
	public List<NewsVo> selectI() {
		List<NewsVo> vo = new ArrayList<NewsVo>();
		try {
			vo = sqlSession.selectList("news.main_t_news_i");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	//뉴스 최상단 사진 조회	
	public List<NewsPhotoVo> selectP(){
		List<NewsPhotoVo> photo = new ArrayList<NewsPhotoVo>();
		try {
			photo = sqlSession.selectList("news.main_t_news_p");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return photo;
	}
	
	//뉴스 카테고리 랜덤 조회
	public List<NewsVo> selectCateA(){
		List<NewsVo> vo = new ArrayList<NewsVo>();
		try {
			vo = sqlSession.selectList("news.main_cate_All");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	// 뉴스 카테고리 상세 조회
	public List<NewsVo> selectCateDe(String cateName){
		List<NewsVo> vo = new ArrayList<NewsVo>();
		try {
			vo = sqlSession.selectList("news.main_cate_de", cateName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	//댓글 갯수
	public String commentCnt(String nSerial) {
		String cnt = "";
		
		try {
			cnt = sqlSession.selectOne("news.comment_cnt", nSerial);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public List<NewsVo> weekly(){
		List<NewsVo> vo = new ArrayList<NewsVo>();
		try {
			vo = sqlSession.selectList("news.main_hit_desc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public NewsVo newsDetail(String nSerial){
		NewsVo vo = new NewsVo();
		
		try {
			vo = sqlSession.selectOne("news.detailView", nSerial);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public List<NewsVo> newsDetailSide(String nCategory) {
		List<NewsVo> list = new ArrayList<NewsVo>();
		
		try {
			list = sqlSession.selectList("detail_side", nCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//댓글
/*	public List<CommentVo> commentView(String nSerial){
		List<CommentVo> comment = new ArrayList<CommentVo>();
		
		try {
			comment = sqlSession.selectList("news.comment_List", nSerial);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return comment;
	}*/
	
	public List<CommentVo> commentView(Page p){
		List<CommentVo> comment = new ArrayList<CommentVo>();
		
		try {
			int totList = sqlSession.selectOne("news.comment_cnt_s", p.getnSerial());
			p.setTotListSize(totList);
			p.pageCompute();
			comment = sqlSession.selectList("news.comment_list", p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment;
	}
	
	//대댓글
	public List<CommentVo> reComment(String nSerial){
		List<CommentVo> reComment = new ArrayList<CommentVo>();
		
		try {
			reComment = sqlSession.selectList("news.re_comment_list", nSerial);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reComment;
	}
	 
	public void commentInsert(CommentVo vo ) {
		
		try {
			int cnt = sqlSession.insert("news.comment_insert", vo);
			
			if(cnt<1) {
				throw new Exception("댓글입력중 오류 발생");
			}
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
	}
	
	public void reCommentInsert(CommentVo vo) {
		try {
			int cnt = sqlSession.insert("news.comment_re_insert", vo);
			
			if(cnt<1) {
				throw new Exception("대댓글 입력중 오류 발생");
			}
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
	}
	
/*	public List<CommentVo> commentCnt(String nSerial) {
		List<CommentVo> comment = new ArrayList<CommentVo>();
		List<CommentVo> cnt =  new ArrayList<CommentVo>();
		try {
			comment = sqlSession.selectList("news.re_comment_li", nSerial);
			
			for(CommentVo vo : comment) {
				cnt = sqlSession.selectList("news.comment_rv", vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}*/
	
	public void commentDeletes(String cSerial) {
		try {
			int cnt = sqlSession.delete("news.comment_delete_s", cSerial);
			
			if(cnt<1) {
				throw new Exception("대댓글 삭제중 오류 발생");
			}
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
	}
	
	public void commentDelete(String cGroup) {
		try {
			int cnt = sqlSession.delete("news.comment_delete", cGroup);
			
			if(cnt<1) {
				throw new Exception("댓글 삭제 중 오류 발생");
			}
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
	}
	
	// 좋아요 확인
	public int likeCheck(LikeVo vo) {
		int check = 0;
			
		try {
			check = sqlSession.selectOne("news.un_like_check", vo);
			if(check == 0) {
				check = sqlSession.selectOne("news.like_check", vo);
			}else {
				check = 100;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}
	
	// 좋아요 클릭
	public String likeIn(LikeVo vo) {
		String likeCnt = "";
		int ck = 0;
		try {
			ck = sqlSession.insert("news.like_in", vo);
			
			if(ck<1) {
				throw new Exception("좋아요 하는 중 오류 발생");
			}
			
			ck = sqlSession.update("news.like_in_update", vo);
			
			if(ck<1) {
				throw new Exception("좋아요 하는 중 오류 발생");
			}
			
			likeCnt = sqlSession.selectOne("news.like_cnt", vo);
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		return likeCnt;
	}
	
	//좋아요 취소
	public String likeOut(LikeVo vo) {
		String likeCnt = "";
		int ck = 0;
		try {
			
			ck = sqlSession.delete("news.like_delete", vo);
			
			if(ck<1) {
				throw new Exception("좋아요 취소 중 오류 발생");
			}
			
			ck = sqlSession.update("news.like_out_update", vo);
			
			if(ck<1) {
				throw new Exception("좋아요 취소 업데이트중 오류 발생");
			}
			
			likeCnt = sqlSession.selectOne("news.like_cnt", vo);
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		return likeCnt;
	}
	
	//싫어요 확인
	public int unLikeCheck(LikeVo vo) {
		int check = 0;
		
		try {
			check = sqlSession.selectOne("news.like_check", vo);
			if(check == 0) {
				check = sqlSession.selectOne("news.un_like_check", vo);
			}else {
				check = 100;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	// 싫어요 클릭
	public String unLikeIn(LikeVo vo) {
		String likeCnt = "";
		int ck = 0;
		try {
			ck = sqlSession.insert("news.un_like_in", vo);
			if(ck<1) {
				throw new Exception("싫어요 클릭 중 오류발생");
			}
			
			ck = sqlSession.update("news.un_like_in_update", vo);
			if(ck<1) {
				throw new Exception("싫어요 업데이트 중 오류발생");
			}
			
			likeCnt = sqlSession.selectOne("news.un_like_cnt", vo);
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		
		return likeCnt;
	}
	
	// 싫어요 취소
	public String unLikeOut(LikeVo vo) {
		String likeCnt = "";
		int ck = 0;
		try {
			ck = sqlSession.delete("news.like_delete", vo);
			if(ck<1) {
				throw new Exception("좋아요 삭제 중 오류 발생");
			}
			
			ck = sqlSession.update("news.un_like_out_update", vo);
			if(ck<1) {
				throw new Exception("취소 업데이트 중 오류 발생");
			}
			
			likeCnt = sqlSession.selectOne("news.un_like_cnt", vo); 
					
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		
		return likeCnt;
	}
	
	// 뉴스 검색 정보
	public List<NewsVo> newsSearch(Page page){
		List<NewsVo> list = new ArrayList<NewsVo>();
		
		try {
			int totList = sqlSession.selectOne("news.news_search_cnt", page);
			page.setTotListSize(totList);
			page.pageCompute();
			list = sqlSession.selectList("news.news_search_info", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//뉴스 검색 사진
	public NewsPhotoVo newsSearchPho(int nSerial){
		NewsPhotoVo list = new NewsPhotoVo();
		try {
			list = sqlSession.selectOne("news.news_search_photo", nSerial);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 조회수 증가(쿠키를 사용하여 중복 조회 방지)
	public void upHit(String nSerial) {
		int result = 0;
		try {
			result = sqlSession.update("news.up_hit", nSerial);
			
			if(result<1) {
				throw new Exception("조회수 증가 문제 발생");
			}
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		
	}
	
	public List<LikeVo> likeCk(String mId){
		List<LikeVo> likeCk = new ArrayList<LikeVo>();
		
		try {
			likeCk = sqlSession.selectList("news.like_ck_l", mId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return likeCk;
	}
	
	public List<LikeVo> likeCd(String mId){
		List<LikeVo> likeCd = new ArrayList<LikeVo>();
		
		try {
			likeCd = sqlSession.selectList("news.like_ck_cl", mId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return likeCd;
	}
}