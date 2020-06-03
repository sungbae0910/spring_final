package blogController;

import java.io.File;
import java.util.List;

import org.apache.catalina.Session;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
			System.out.println(mId);
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
		int cnt = 0;
		try {
			//게시물 상세보기
			board = sqlSession.selectOne("blog.brdView", brdNo);
			//해당 게시글에 공감 누른 회원 아이디
			List<String> likeMid = sqlSession.selectList("blog.brdLikeMid", brdNo);
			board.setLikeMid(likeMid);
			//게시물 상세보기하면 조회수 +1
			cnt = sqlSession.update("blog.brdHitUp", brdNo);
			
			if (cnt > 0) { //조회수가 정상적으로 update되면
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public void brdLike(BlogBoardVo brdVo, String flag) {
		try {
			if (flag.equals("i")) { //공감 눌렀을 때
				sqlSession.insert("brdLikeInsert", brdVo);				
			} else { //공감 해제 했을 때
				sqlSession.delete("brdLikeDelete", brdVo);
			}

			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
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
	
	public void brdInsertR(BlogBoardVo brdVo, MultipartHttpServletRequest req) {
		try {
			//게시물 입력
			sqlSession.update("blog.brdInsert", brdVo);
			//게시물 태그 값이 있으면 추가
			sqlSession.insert("blog.brdTagInsert", brdVo);
			
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			String delbrdHeader = brdVo.getBrdHeader();
			delHeader(req, delbrdHeader);
			sqlSession.rollback();
		}
	}
	
	public void brdModifyR(BlogBoardVo brdVo, MultipartHttpServletRequest req) {
		String delbrdHeader = null;
		try {
			if (brdVo.getBrdHeader() != "") { //헤더사진을 추가, 변경 하였을 때
				//삭제 할 헤더사진조회
				delbrdHeader = sqlSession.selectOne("blog.brdHeader", brdVo.getBrdNo());
				delHeader(req, delbrdHeader); //서버경로에 파일 삭제
				
				sqlSession.update("blog.brdModify", brdVo);
			} else { //헤더사진을 추가, 변경 하지 않았을 때
				sqlSession.update("blog.brdModifyNoHeader", brdVo);
			}
			
			//태그 내용 입력 또는 수정
			if (!brdVo.gettContent().isEmpty()) { //태그를 입력했을 때
				sqlSession.update("blog.brdTagModify", brdVo);				
				/*//게시물에 태그가 있는 지 확인
				int tagCount = sqlSession.selectOne("blog.tagSelect", brdVo.getBrdNo());
				
				if (tagCount == 0) { //게시물에 태그 존재X
					sqlSession.insert("blog.brdTagInsert", brdVo);
				} else { //게시물에 태그 존재O
				}*/
			}
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			delHeader(req, delbrdHeader);
			sqlSession.rollback();
		}
	}
	
	public void delHeader(MultipartHttpServletRequest req, String delbrdHeader) { //서버경로에 파일 삭제
		String filePath = req.getSession().getServletContext().getRealPath("/blog/blog_image/"); 
		File file = new File(filePath + delbrdHeader);
		System.out.println(filePath);
		if (file.exists()) {
			FileUtils.deleteQuietly(file); //파일 삭제
		}
	}
	
	public void brdDelete(int brdNo) {
		try {			
			int cnt = sqlSession.delete("blog.brdDelete", brdNo);
			if (cnt < 1) {
				throw new Exception();
			}
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
	}
	
	public BlogVo blogManageView(String mId) {
		BlogVo bVo = null;
		try {
			bVo = sqlSession.selectOne("blog.blogManageView", mId);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return bVo;
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
