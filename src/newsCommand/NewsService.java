package newsCommand;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

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
	
	
}
