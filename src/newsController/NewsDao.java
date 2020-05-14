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

}
