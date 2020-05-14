package blogController;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Factory;

public class BlogDao {
	SqlSession sqlSession;
	
	/*public BlogDao() {
		sqlSession = Factory.getFactory().openSession();
	}

	public List<BlogBoardVo> select(String kind) {
		List<BlogBoardVo> boardList = null;
		List<BlogVo> brdNo = null;
		try {
			if (kind.equals("life")) {
				brdNo = sqlSession.selectList("blog.lifeTag"); 				
			} else if (kind.equals("travel")) {
				brdNo = sqlSession.selectList("blog.travelTag");
			}else {
				brdNo = sqlSession.selectList("blog.itTag");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardList;
	}*/
}
