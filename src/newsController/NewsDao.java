package newsController;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Factory;

public class NewsDao {
	SqlSession sqlSession;
	
	public NewsDao() {
		sqlSession = Factory.getFactory().openSession();
	}
	
	public String insert(List<NewsVo> news) {
		String msg = "";	
		
		try {
			int cnt = sqlSession.insert("news.news_insert", news);
			if(cnt<1) {
				throw new Exception("정보 저장 중 오류 발생");
			}
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			msg = e.getMessage();
			sqlSession.rollback();
		}
		return msg;
	}
	
	

}
