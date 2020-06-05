package bean;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.apache.ibatis.session.SqlSession;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import blogController.BlogBoardVo;
import mybatis.Factory;
import mybatis.MembershipVo;
import mybatis.sb_clientVo;
import mybatis.searchVo;
import newsController.NewsPhotoVo;
import newsController.NewsVo;
import shopController.ShopItemVo;

public class MembershipDao {

	SqlSession sqlSession;
	
	
	public MembershipDao() {
		sqlSession = Factory.getFactory().openSession();
	}
	
	public String register(MembershipVo vo) {
		
		String str = "회원가입 완료!!";
			
		try {
			int ck = sqlSession.insert("membership.register",vo);
			if(ck<1) {
				throw new Exception("회원가입중 오류 발생!!");
			}
			sqlSession.commit();
		} catch (Exception e) {
			str = e.getMessage();
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			return str;
		}
		
	}
	
	public void sb_client(sb_clientVo vo) {
		
		try {
			sqlSession.insert("membership.sb_client", vo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
		
	}
	
	public void sb_playlist(sb_clientVo vo) {
		try {
			sqlSession.insert("membership.sb_playlist", vo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
	}
	
	public String ck_id(String mId) {
		
		String str = null;
		try {
			System.out.println(mId);
			str = sqlSession.selectOne("membership.ck_id", mId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return str;
		}
		
	}
	
	public int confirmId(String mId) {
		int ck = 0;
		
		try {
			ck = sqlSession.selectOne("membership.login_id_ck", mId);
			
			if(ck == 1) {
				ck = 0;
			}else {
				ck = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ck;
	}
	
	public int userCheck(String mId, String pwd) {
		int ck = 0;
		String pass = "";
		try {
			pass = sqlSession.selectOne("membership.login_pass_ck", mId);
			if(pwd.equals(pass)) {
				ck = 1;
			}else {
				ck = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ck;
	}
	
	public void payMembership(String mId) {

		try {
			sqlSession.update("membership.payMembership", mId);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
	}
	
	public MembershipVo Membership(String mId) {
		MembershipVo vo = new MembershipVo();
		try {
			vo = sqlSession.selectOne("membership.membership", mId);
		} catch (Exception e) {
			System.out.println("비 로그인");
		}
		
		return vo;
	}
	
	public Timestamp IsMembership(String mId) {
		Timestamp date = new Timestamp(0);
		
		try {
			date = sqlSession.selectOne("membership.IsMembership", mId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return date;
		
	}

	public List<BlogBoardVo> blogLife() {
		List<BlogBoardVo> blogLife = null;
		try {
			String[] tag = {"일상", "데일리", "라이프", "날씨"};
			blogLife = sqlSession.selectList("membership.blogSelect", tag);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return blogLife;
	}
	
	public List<BlogBoardVo> blogTravel() {
		List<BlogBoardVo> blogTravel = null;
		try {
			String[] tag = {"여행", "제주도", "맛집", "먹거리"};
			blogTravel = sqlSession.selectList("membership.blogSelect", tag);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return blogTravel;
	}
	
	public List<BlogBoardVo> blogIt() {
		List<BlogBoardVo> blogIt = null;
		try {
			String[] tag = {"it", "IT", "컴퓨터", "전자기기", "핸드폰", "아이폰", "갤럭시"};
			blogIt = sqlSession.selectList("membership.blogSelect", tag);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return blogIt;
	}
	
	public List<searchVo> Search(String query){
		String clientID = "nUaA_ODtTxwyOvPV3Bqx";
		String clientSecret = "QM5FKfGNfj";
				
		
		List<searchVo> list = null;
		
		try {
			URL url;
            url = new URL("https://openapi.naver.com/v1/search/"
                    + "news.xml?query=" 
            		+ URLEncoder.encode(query, "UTF-8")
            		+ "&display=5"
            		);
 
            URLConnection urlConn = url.openConnection();
            urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
            urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(
                    new InputStreamReader(urlConn.getInputStream())
                    );
            
            int eventType = parser.getEventType();
            searchVo vo = null;
            while(eventType != XmlPullParser.END_DOCUMENT) {
            	switch (eventType) {
	                case XmlPullParser.END_DOCUMENT: // 문서의 끝
	                    break;
	                case XmlPullParser.START_DOCUMENT:
	                    list = new ArrayList<searchVo>();
	                    break;
	                case XmlPullParser.END_TAG: {
	                    String tag = parser.getName();
	                    if(tag.equals("item"))
	                    {
	                        list.add(vo);
	                        vo = null;
	                    }
	
	                }
	                case XmlPullParser.START_TAG: {
	                	String tag = parser.getName();
	                	switch (tag) {
						case "item":
							vo = new searchVo();
							break;
						case "title":
							if(vo != null)
								vo.setTitle(parser.nextText());
							break;
						case "link":
							if(vo != null)
								vo.setLink(parser.nextText());
							break;
						case "originallink":
							if(vo != null)
								vo.setOriginallink(parser.nextText());
							break;
						case "description":
							if(vo != null)
								vo.setDescription(parser.nextText());
							break;
	                	}
	                }
	        	
	        	}
            	eventType = parser.next();
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
	}
	
	public List<searchVo> kin(String query){
		List<searchVo> list = null;
		String clientID = "nUaA_ODtTxwyOvPV3Bqx";
		String clientSecret = "QM5FKfGNfj";
		
		
		try {
			URL url;
            url = new URL("https://openapi.naver.com/v1/search/"
                    + "kin.xml?query=" 
            		+ URLEncoder.encode(query, "UTF-8")
            		+ "&display=5"
            		);
 
            URLConnection urlConn = url.openConnection();
            urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
            urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(
                    new InputStreamReader(urlConn.getInputStream())
                    );
            
            int eventType = parser.getEventType();
            searchVo vo = null;
            while(eventType != XmlPullParser.END_DOCUMENT) {
            	switch (eventType) {
	                case XmlPullParser.END_DOCUMENT: // 문서의 끝
	                    break;
	                case XmlPullParser.START_DOCUMENT:
	                    list = new ArrayList<searchVo>();
	                    break;
	                case XmlPullParser.END_TAG: {
	                    String tag = parser.getName();
	                    if(tag.equals("item"))
	                    {
	                        list.add(vo);
	                        vo = null;
	                    }
	
	                }
	                case XmlPullParser.START_TAG: {
	                	String tag = parser.getName();
	                	switch (tag) {
						case "item":
							vo = new searchVo();
							break;
						case "title":
							if(vo != null)
								vo.setTitle(parser.nextText());
							break;
						case "link":
							if(vo != null)
								vo.setLink(parser.nextText());
							break;
						case "description":
							if(vo != null)
								vo.setDescription(parser.nextText());
							break;
	                	}
	                }
	        	
	        	}
            	eventType = parser.next();
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
	}
	
	public List<searchVo> SearchBlog(String query){
		List<searchVo> list = null;
		String clientID = "nUaA_ODtTxwyOvPV3Bqx";
		String clientSecret = "QM5FKfGNfj";
		
		
		try {
			URL url;
            url = new URL("https://openapi.naver.com/v1/search/"
                    + "blog.xml?query=" 
            		+ URLEncoder.encode(query, "UTF-8")
            		+ "&display=5"
            		);
 
            URLConnection urlConn = url.openConnection();
            urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
            urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(
                    new InputStreamReader(urlConn.getInputStream())
                    );
            
            int eventType = parser.getEventType();
            searchVo vo = null;
            while(eventType != XmlPullParser.END_DOCUMENT) {
            	switch (eventType) {
	                case XmlPullParser.END_DOCUMENT: // 문서의 끝
	                    break;
	                case XmlPullParser.START_DOCUMENT:
	                    list = new ArrayList<searchVo>();
	                    break;
	                case XmlPullParser.END_TAG: {
	                    String tag = parser.getName();
	                    if(tag.equals("item"))
	                    {
	                        list.add(vo);
	                        vo = null;
	                    }
	
	                }
	                case XmlPullParser.START_TAG: {
	                	String tag = parser.getName();
	                	switch (tag) {
						case "item":
							vo = new searchVo();
							break;
						case "title":
							if(vo != null)
								vo.setTitle(parser.nextText());
							break;
						case "link":
							if(vo != null)
								vo.setLink(parser.nextText());
							break;
						case "description":
							if(vo != null)
								vo.setDescription(parser.nextText());
							break;
						case "bloggername":
							if(vo != null)
								vo.setBloggername(parser.nextText());
							break;
						case "bloggerlink":
							if(vo != null)
								vo.setBloggerlink(parser.nextText());
							break;
	                	}
	                }
	        	
	        	}
            	eventType = parser.next();
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
		
	}
	
	
	public List<searchVo> SearchShop(String query){
		List<searchVo> list = null;
		String clientID = "nUaA_ODtTxwyOvPV3Bqx";
		String clientSecret = "QM5FKfGNfj";
		
		
		try {
			URL url;
            url = new URL("https://openapi.naver.com/v1/search/"
                    + "shop.xml?query=" 
            		+ URLEncoder.encode(query, "UTF-8")
            		+ "&display=6"
            		);
 
            URLConnection urlConn = url.openConnection();
            urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
            urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(
                    new InputStreamReader(urlConn.getInputStream())
                    );
            
            int eventType = parser.getEventType();
            searchVo vo = null;
            while(eventType != XmlPullParser.END_DOCUMENT) {
            	switch (eventType) {
	                case XmlPullParser.END_DOCUMENT: // 문서의 끝
	                    break;
	                case XmlPullParser.START_DOCUMENT:
	                    list = new ArrayList<searchVo>();
	                    break;
	                case XmlPullParser.END_TAG: {
	                    String tag = parser.getName();
	                    if(tag.equals("item"))
	                    {
	                        list.add(vo);
	                        vo = null;
	                    }
	
	                }
	                case XmlPullParser.START_TAG: {
	                	String tag = parser.getName();
	                	switch (tag) {
						case "item":
							vo = new searchVo();
							break;
						case "title":
							if(vo != null)
								vo.setTitle(parser.nextText());
							break;
						case "link":
							if(vo != null)
								vo.setLink(parser.nextText());
							break;
						case "description":
							if(vo != null)
								vo.setDescription(parser.nextText());
							break;
						case "image":
							if(vo != null)
								vo.setImage(parser.nextText());
							break;	
						case "lprice":
							if(vo != null)
								vo.setLprice(Integer.parseInt(parser.nextText()));
							break;
						case "hprice":
							if(vo != null)
								vo.setHprice(Integer.parseInt(parser.nextText()));
							break;
	                	}
	                }
	        	
	        	}
            	eventType = parser.next();
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
		
	}
	
	public List<NewsVo> selectI(){
		List<NewsVo> vo = new ArrayList<NewsVo>();
		
		try {
			vo = sqlSession.selectList("news.main_t_news_i");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public List<NewsPhotoVo> selectP(){
		List<NewsPhotoVo> photo = new ArrayList<NewsPhotoVo>();
		try {
			photo = sqlSession.selectList("news.main_t_news_p");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return photo;
	}
	
	public List<ShopItemVo> earringList(ShopItemVo vo){
		List<ShopItemVo> earringList = null;
		vo.setItem_category(0);
		try {
			earringList = sqlSession.selectList("membership.main_shopItem_select", vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return earringList;
		}
	}
	
	public List<ShopItemVo> necklaceList(ShopItemVo vo){
		List<ShopItemVo> necklaceList = null;
		vo.setItem_category(1);
		try {
			necklaceList = sqlSession.selectList("membership.main_shopItem_select", vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return necklaceList;
		}
	}
	
	public List<ShopItemVo> ringList(ShopItemVo vo){
		List<ShopItemVo> ringList = null;
		vo.setItem_category(2);
		try {
			ringList = sqlSession.selectList("membership.main_shopItem_select", vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return ringList;
		}
	}
	
	public List<ShopItemVo> braceletList(ShopItemVo vo){
		List<ShopItemVo> braceletList = null;
		vo.setItem_category(3);
		try {
			braceletList = sqlSession.selectList("membership.main_shopItem_select", vo);
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			return braceletList;
		}
	}
	
}

