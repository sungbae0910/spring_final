package newsCommand;

import java.util.List;

import org.springframework.stereotype.Service;

import newsController.NewsDao;
import newsController.NewsPhotoVo;
import newsController.NewsVo;

@Service
public class NewsService {

	public NewsService() {}
	
	public List<NewsVo> selectI() {
		NewsDao dao = new NewsDao();
		List<NewsVo> list = null;
		List<NewsPhotoVo> list2 = null;
		
		list = dao.selectI();
		list2 = dao.selectP();
		
		return list;
	}
	public List<NewsPhotoVo> selectP() {
		NewsDao dao = new NewsDao();
		List<NewsPhotoVo> list = null;
		list = dao.selectP();
		
		return list;
	}
	
}
