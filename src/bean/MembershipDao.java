package bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import blogController.BlogBoardVo;
import lolVo.GameIdVo;
import lolVo.LeagueVo;
import lolVo.ParticipantStatsVo;
import lolVo.ParticipantVo;
import lolVo.PlayerVo;
import lolVo.SummonerVo;
import mybatis.Factory;
import mybatis.MembershipVo;
import mybatis.dictionaryVo;
import mybatis.sb_clientVo;
import mybatis.searchVo;
import newsController.NewsPhotoVo;
import newsController.NewsVo;
import shopController.ShopItemVo;

public class MembershipDao {

	SqlSession sqlSession;
	
	String[] champions = {"Aatrox",	"Ekko",	"Jinx",	"MissFortune",	"Shen",	"Varus",
			"Ahri",	"Elise",	"Kalista",	"Mordekaiser",	"Shyvana",	"Vayne",
			"Akali",	"Evelynn",	"Karma",	"Morgana",	"Singed",	"Veigar",
			"Alistar",	"Ezreal",	"Karthus",	"Nami",	"Sion",	"Velkoz",
			"Amumu",	"Fiddlesticks",	"Kassadin",	"Nasus",	"Sivir",	"Vi",
			"Anivia",	"Fiora",	"Katarina",	"Nautilus",	"Skarner",	"Viktor",
			"Annie",	"Fizz",	"Kayle",	"Nidalee",	"Sona",	"Vladimir",
			"Ashe",	"Galio",	"Kennen",	"Nocturne",	"Soraka",	"Volibear",
			"AurelionSol",	"Gangplank",	"Khazix",	"Nunu",	"Swain",	"Warwick",
			"Azir",	"Garen",	"Kindred",	"Olaf",	"Syndra",	"MonkeyKing",
			"Bard",	"Gnar",	"Kled",	"Orianna",	"TahmKench",	"Xerath",
			"Blitzcrank",	"Gragas",	"KogMaw",	"Pantheon",	"Taliyah",	"XinZhao",
			"Brand",	"Graves",	"Leblanc",	"Poppy",	"Talon",	"Yasuo",
			"Braum",	"Hecarim",	"LeeSin",	"Quinn",	"Taric",	"Yorick",
			"Caitlyn","Heimerdinger",	"Leona",	"Rammus",	"Teemo",	"Zac",
			"Camille",	"Illaoi",	"Lissandra",	"RekSai",	"Thresh",	"Zed",
			"Cassiopeia",	"Irelia",	"Lucian",	"Renekton",	"Tristana",	"Ziggs",
			"Chogath",	"Ivern",	"Lulu",	"Rengar",	"Trundle",	"Zilean",
			"Corki",	"Janna",	"Lux",	"Riven",	"Tryndamere",	"Zyra",
			"Darius",	"JarvanIV",	"Malphite",	"Rumble",	"TwistedFate",
			"Diana",	"Jax",	"Malzahar",	"Ryze",	"Twitch",	
			"DrMundo",	"Jayce",	"Maokai",	"Sejuani",	"Udyr",	
			"Draven",	"Jhin",	"MasterYi",	"Shaco",	"Urgot",
			"Sett", "Aphelios", "Senna", "Qiyana", "Yuumi", "Sylas", "Neeko", "Pyke", "Kaisa", "Zoe",
			"Ornn", "Kayn", "Rakan", "Xayah"
	};
	

	public MembershipDao() {
		sqlSession = Factory.getFactory().openSession();
	}

	public String register(MembershipVo vo) {

		String str = "회원가입 완료!!";

		try {
			int ck = sqlSession.insert("membership.register", vo);
			if (ck < 1) {
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

			if (ck == 1) {
				ck = 0;
			} else {
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
			if (pwd.equals(pass)) {
				ck = 1;
			} else {
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
			url = new URL("https://openapi.naver.com/v1/search/" + "news.xml?query=" + URLEncoder.encode(query, "UTF-8")
					+ "&display=5");

			URLConnection urlConn = url.openConnection();
			urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
			urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new InputStreamReader(urlConn.getInputStream()));

			int eventType = parser.getEventType();
			searchVo vo = null;
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				case XmlPullParser.END_DOCUMENT: // 문서의 끝
					break;
				case XmlPullParser.START_DOCUMENT:
					list = new ArrayList<searchVo>();
					break;
				case XmlPullParser.END_TAG: {
					String tag = parser.getName();
					if (tag.equals("item")) {
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
						if (vo != null)
							vo.setTitle(parser.nextText());
						break;
					case "link":
						if (vo != null)
							vo.setLink(parser.nextText());
						break;
					case "originallink":
						if (vo != null)
							vo.setOriginallink(parser.nextText());
						break;
					case "description":
						if (vo != null)
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

	public List<dictionaryVo> dictionary(String query) {
		List<dictionaryVo> list = null;
		String clientID = "nUaA_ODtTxwyOvPV3Bqx";
		String clientSecret = "QM5FKfGNfj";
		System.out.println("q = "+query);
	
		try {
			URL url;
			url = new URL("https://openapi.naver.com/v1/search/" + "encyc.xml?query=" + URLEncoder.encode(query, "UTF-8")
					+ "&display=10"
					);

			URLConnection urlConn = url.openConnection();
			urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
			urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new InputStreamReader(urlConn.getInputStream()));

			int eventType = parser.getEventType();
			dictionaryVo vo = null;
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				case XmlPullParser.END_DOCUMENT: // 문서의 끝
					
					break;
				case XmlPullParser.START_DOCUMENT:
					list = new ArrayList<dictionaryVo>();
					break;
				case XmlPullParser.END_TAG: {
					String tag = parser.getName();
					if (tag.equals("item")) {
						list.add(vo);
						vo = null;
					}

				}
				case XmlPullParser.START_TAG: {
					String tag = parser.getName();
					switch (tag) {
					case "item":
						vo = new dictionaryVo();
						break;
					case "title":
						if (vo != null)
							vo.setTitle(parser.nextText());
						break;
					case "link":
						if (vo != null)
							vo.setLink(parser.nextText());
						break;
					case "description":
						if (vo != null)
							vo.setDescription(parser.nextText());
						break;
					case "thumbnail":
						if (vo != null)
							vo.setThumnail(parser.nextText());
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

	public List<searchVo> movie(String query) {
		List<searchVo> list = null;
		String clientID = "nUaA_ODtTxwyOvPV3Bqx";
		String clientSecret = "QM5FKfGNfj";

		try {
			URL url;
			url = new URL("https://openapi.naver.com/v1/search/" + "movie.xml?query="
					+ URLEncoder.encode(query, "UTF-8") + "&display=10");

			URLConnection urlConn = url.openConnection();
			urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
			urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new InputStreamReader(urlConn.getInputStream()));

			int eventType = parser.getEventType();
			searchVo vo = null;
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				case XmlPullParser.END_DOCUMENT: // 문서의 끝
					break;
				case XmlPullParser.START_DOCUMENT:
					list = new ArrayList<searchVo>();
					break;
				case XmlPullParser.END_TAG: {
					String tag = parser.getName();
					if (tag.equals("item")) {
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
						if (vo != null)
							vo.setTitle(parser.nextText());
						break;
					case "link":
						if (vo != null)
							vo.setLink(parser.nextText());
						break;
					case "image":
						if (vo != null)
							vo.setImage(parser.nextText());
						break;
					case "subtitle":
						if (vo != null)
							vo.setSubtitle(parser.nextText());
						break;
					case "pubDate":
						if (vo != null)
							vo.setSubtitle(parser.nextText());
						break;
					case "director":
						if (vo != null)
							vo.setDirector(parser.nextText());
						break;
					case "actor":
						if (vo != null)
							vo.setActor(parser.nextText());
						break;
					case "userRating":
						if (vo != null)
							vo.setUserRating(Double.parseDouble(parser.nextText()));
						;
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

	public List<searchVo> kin(String query) {
		List<searchVo> list = null;
		String clientID = "nUaA_ODtTxwyOvPV3Bqx";
		String clientSecret = "QM5FKfGNfj";

		try {
			URL url;
			url = new URL("https://openapi.naver.com/v1/search/" + "kin.xml?query=" + URLEncoder.encode(query, "UTF-8")
					+ "&display=5");

			URLConnection urlConn = url.openConnection();
			urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
			urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new InputStreamReader(urlConn.getInputStream()));

			int eventType = parser.getEventType();
			searchVo vo = null;
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				case XmlPullParser.END_DOCUMENT: // 문서의 끝
					break;
				case XmlPullParser.START_DOCUMENT:
					list = new ArrayList<searchVo>();
					break;
				case XmlPullParser.END_TAG: {
					String tag = parser.getName();
					if (tag.equals("item")) {
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
						if (vo != null)
							vo.setTitle(parser.nextText());
						break;
					case "link":
						if (vo != null)
							vo.setLink(parser.nextText());
						break;
					case "description":
						if (vo != null)
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

	public List<searchVo> SearchBlog(String query) {
		List<searchVo> list = null;
		String clientID = "nUaA_ODtTxwyOvPV3Bqx";
		String clientSecret = "QM5FKfGNfj";

		try {
			URL url;
			url = new URL("https://openapi.naver.com/v1/search/" + "blog.xml?query=" + URLEncoder.encode(query, "UTF-8")
					+ "&display=5");

			URLConnection urlConn = url.openConnection();
			urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
			urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new InputStreamReader(urlConn.getInputStream()));

			int eventType = parser.getEventType();
			searchVo vo = null;
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				case XmlPullParser.END_DOCUMENT: // 문서의 끝
					break;
				case XmlPullParser.START_DOCUMENT:
					list = new ArrayList<searchVo>();
					break;
				case XmlPullParser.END_TAG: {
					String tag = parser.getName();
					if (tag.equals("item")) {
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
						if (vo != null)
							vo.setTitle(parser.nextText());
						break;
					case "link":
						if (vo != null)
							vo.setLink(parser.nextText());
						break;
					case "description":
						if (vo != null)
							vo.setDescription(parser.nextText());
						break;
					case "bloggername":
						if (vo != null)
							vo.setBloggername(parser.nextText());
						break;
					case "bloggerlink":
						if (vo != null)
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

	public List<searchVo> SearchShop(String query) {
		List<searchVo> list = null;
		String clientID = "nUaA_ODtTxwyOvPV3Bqx";
		String clientSecret = "QM5FKfGNfj";

		try {
			URL url;
			url = new URL("https://openapi.naver.com/v1/search/" + "shop.xml?query=" + URLEncoder.encode(query, "UTF-8")
					+ "&display=6");

			URLConnection urlConn = url.openConnection();
			urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
			urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new InputStreamReader(urlConn.getInputStream()));

			int eventType = parser.getEventType();
			searchVo vo = null;
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				case XmlPullParser.END_DOCUMENT: // 문서의 끝
					break;
				case XmlPullParser.START_DOCUMENT:
					list = new ArrayList<searchVo>();
					break;
				case XmlPullParser.END_TAG: {
					String tag = parser.getName();
					if (tag.equals("item")) {
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
						if (vo != null)
							vo.setTitle(parser.nextText());
						break;
					case "link":
						if (vo != null)
							vo.setLink(parser.nextText());
						break;
					case "description":
						if (vo != null)
							vo.setDescription(parser.nextText());
						break;
					case "image":
						if (vo != null)
							vo.setImage(parser.nextText());
						break;
					case "lprice":
						if (vo != null)
							vo.setLprice(Integer.parseInt(parser.nextText()));
						break;
					case "hprice":
						if (vo != null)
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
	String API_KEY = "RGAPI-1e2b935e-9f88-45c7-8c31-313b65dfa503";
	
	// 소환사 레벨 닉네임
	public SummonerVo searchSummoner(Model model, HttpServletRequest httpServletRequest) {
		BufferedReader br = null;
		String SummonerName = httpServletRequest.getParameter("findStr");
		System.out.println("소환사명: " + SummonerName);
		
		SummonerVo temp = null;
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + SummonerName
					+ "?api_key=" + API_KEY;
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			// 여기에 문자열을 받아와라.
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				// 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			}
			JsonParser jsonParser = new JsonParser();
			JsonObject k = (JsonObject) jsonParser.parse(result);
			int profileIconId = k.get("profileIconId").getAsInt();
			String name = k.get("name").getAsString();
			String puuid = k.get("puuid").getAsString();
			long summonerLevel = k.get("summonerLevel").getAsLong();
			long revisionDate = k.get("revisionDate").getAsLong();
			String id = k.get("id").getAsString();
			String accountId = k.get("accountId").getAsString();
			temp = new SummonerVo(accountId, profileIconId, revisionDate, name, id, puuid, summonerLevel);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return temp;
	}
	// 소환사 랭크 정보
	public LeagueVo SummonerRank(Model model, HttpServletRequest httpServletRequest, String Id) {
		BufferedReader br = null;
		
		LeagueVo lVo = null;
		
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + Id
					+ "?api_key=" + API_KEY;
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			// 여기에 문자열을 받아와라.
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				// 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			}
			JsonParser jsonParser = new JsonParser();
			JsonArray arr = (JsonArray) jsonParser.parse(result);
			JsonObject k = (JsonObject) arr.get(0);
			
			int wins = k.get("wins").getAsInt();
			int losses = k.get("losses").getAsInt();
			String rank = k.get("rank").getAsString();
			String tier = k.get("tier").getAsString();
			String queueType = k.get("queueType").getAsString();
			int leaguePoints = k.get("leaguePoints").getAsInt();
			String leagueId = k.get("leagueId").getAsString();
			lVo = new LeagueVo( leagueId, queueType, wins, losses, rank, tier, leaguePoints);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return lVo;
	}
	
	// 개인 게임 전적
	public List<Long> GameId(Model model, HttpServletRequest httpServletRequest, String Id) {
		BufferedReader br = null;
		List<Long> list = new ArrayList<Long>();

		
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/match/v4/matchlists/by-account/"
					+ Id
					+ "?endIndex=10&"
					+ "&api_key=" + API_KEY;
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			// 여기에 문자열을 받아와라.
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				// 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			}
			
			
			Gson gson = new Gson();
			
			JsonParser parser=new JsonParser();
			JsonArray array = parser.parse(result).getAsJsonObject().get("matches").getAsJsonArray();
			ArrayList<GameIdVo> Ar;
			

			Type t = new TypeToken<ArrayList<GameIdVo>>(){}.getType();

			
			Ar = gson.fromJson(array, t);
			
			
			
			for(GameIdVo vo : Ar) {
				list.add(vo.getGameId());
			}
			
		} catch (Exception e) {
			System.out.println("개인전적 오류");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return list;	
	}
	

	public List<PlayerVo> Match(Model model, HttpServletRequest httpServletRequest, List<Long> id) {
		BufferedReader br = null;
		List<PlayerVo> Players = new ArrayList<PlayerVo>();

		String findStr = httpServletRequest.getParameter("findStr");
		
		try {
			
			String urlstr = "https://kr.api.riotgames.com/lol/match/v4/matches/"
					+ id.get(0)
					+ "?api_key=" + API_KEY;
					
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			// 여기에 문자열을 받아와라.
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				// 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			}

			JsonParser p=new JsonParser();
			JsonArray array = p.parse(result).getAsJsonObject().get("participantIdentities").getAsJsonArray();

			
			// 소환사 이름 10명 가져오기
			for(int in = 0; in<array.size(); in++) {
				JsonElement je = array.get(in).getAsJsonObject();
				
				JsonObject jo = je.getAsJsonObject();
				JsonObject jo2 = jo.get("player").getAsJsonObject();
				String sumName = jo2.get("summonerName").getAsString();
				int Icon = jo2.get("profileIcon").getAsInt();
				
				PlayerVo vo = new PlayerVo(sumName, Icon);
				
				
				Players.add(vo);
			}
			
			
		} catch (Exception e) {
			System.out.println("MATCH 오류");
			e.printStackTrace();
		}
		
		return  Players;
	}
	
	public ParticipantVo LOLInfo(Model model, HttpServletRequest httpServletRequest, List<Long> id) {
		BufferedReader br = null;
		ParticipantVo vo = null;
		List<Integer> playerChamp = new ArrayList<Integer>();
		String findStr = httpServletRequest.getParameter("findStr");
		ParticipantStatsVo stats = null;
		
		try {
			
			String urlstr = "https://kr.api.riotgames.com/lol/match/v4/matches/"
					+ id.get(0)
					+ "?api_key=" + API_KEY;
					
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			// 여기에 문자열을 받아와라.
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				// 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			}
			
			JsonParser p = new JsonParser();
			JsonArray array = p.parse(result).getAsJsonObject().get("participantIdentities").getAsJsonArray();
			JsonArray array2 = p.parse(result).getAsJsonObject().get("participants").getAsJsonArray();


			// 검색 플레이어 게임정보
			for(int in = 0; in<array.size(); in++) {
				JsonElement je = array.get(in).getAsJsonObject();
				JsonObject jo = je.getAsJsonObject();
				String jid = jo.get("participantId").getAsString(); // 이걸로 participants 조회
				JsonObject jo2 = jo.get("player").getAsJsonObject();
				String sumName = jo2.get("summonerName").getAsString();
				
				JsonElement el = array2.get(in).getAsJsonObject();
				JsonObject ob = el.getAsJsonObject();

				
				playerChamp.add(in, ob.get("championId").getAsInt());
				
				
				if(sumName.equals(findStr)) {
					JsonElement je2 = array2.get(in).getAsJsonObject();
					JsonObject jo3 = je2.getAsJsonObject();
	
					JsonObject statJO = jo3.get("stats").getAsJsonObject();
					
					
					stats = new ParticipantStatsVo(statJO.get("kills").getAsInt(), statJO.get("deaths").getAsInt(), statJO.get("assists").getAsInt(), statJO.get("win").getAsBoolean(), statJO.get("item0").getAsInt(),statJO.get("item1").getAsInt(),statJO.get("item2").getAsInt(),statJO.get("item3").getAsInt(),statJO.get("item4").getAsInt(),statJO.get("item5").getAsInt(),statJO.get("item6").getAsInt() );
					vo = new ParticipantVo(jo3.get("championId").getAsInt(), jo3.get("spell1Id").getAsInt(), jo3.get("spell2Id").getAsInt(), stats);
					
				}
				
			}
			vo.setPlayerten(playerChamp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return vo;
	}
	
	public String Champion(int num) {
		BufferedReader br = null;
		int compare = num;
		String str = "";
		int eq = 0;
		String urlstr = "http://ddragon.leagueoflegends.com/cdn/10.11.1/data/ko_KR/champion.json";
		System.out.println("찾을 챔피언 번호 : " + num);
		try {
			
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			// 여기에 문자열을 받아와라.
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				// 그 받아온 문자열을 계속 br에서 줄단위로 받고 출력하겠다.
				result = result + line;
			}
			
			JsonParser p = new JsonParser();
			JsonObject jo = p.parse(result).getAsJsonObject();
			
			
			JsonObject jo2 = jo.get("data").getAsJsonObject();
			
			JsonObject jo3 = new JsonObject();
			
			
			for(int i=0; i<champions.length; i++) {
				jo3 = jo2.get(champions[i]).getAsJsonObject();

				eq = jo3.get("key").getAsInt();
				
				if(compare == eq) {
					str = jo3.get("id").getAsString();
					System.out.println("챔프 - "+str);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("str = " + str);
		
		return str;
	}
	

	public List<NewsVo> selectI() {
		List<NewsVo> vo = new ArrayList<NewsVo>();

		try {
			vo = sqlSession.selectList("news.main_t_news_i");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public List<NewsPhotoVo> selectP() {
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
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return earringList;
		}
	}

	public List<ShopItemVo> necklaceList(ShopItemVo vo) {
		List<ShopItemVo> necklaceList = null;
		vo.setItem_category(1);
		try {
			necklaceList = sqlSession.selectList("membership.main_shopItem_select", vo);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return necklaceList;
		}
	}

	public List<ShopItemVo> ringList(ShopItemVo vo) {
		List<ShopItemVo> ringList = null;
		vo.setItem_category(2);
		try {
			ringList = sqlSession.selectList("membership.main_shopItem_select", vo);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return ringList;
		}
	}

	public List<ShopItemVo> braceletList(ShopItemVo vo) {
		List<ShopItemVo> braceletList = null;
		vo.setItem_category(3);
		try {
			braceletList = sqlSession.selectList("membership.main_shopItem_select", vo);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			return braceletList;
		}
	}
	
}
