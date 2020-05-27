package newsCommand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import newsController.NewsDao;
import newsController.NewsPhotoVo;
import newsController.NewsVo;

public class NewsCrawling2 {
	NewsDao dao;
	
/*	@Autowired
	public NewsService(NewsDao newsDao) {
		this.dao = newsDao;
	}
	*/
	public NewsCrawling2() {
	}
	
	public void insert() throws IOException{
		String con = "";
		String msg = "";
		String url = "https://news.v.daum.net/v/20200527005210100";
		String company = "";
		Document doc = null; 
		Elements element; // 크롤링한 정보를 담기 위한 객체
		NewsVo vo = new NewsVo();
		NewsPhotoVo phoVo = new NewsPhotoVo();
		int cnt = 0;
		List<NewsPhotoVo> list = new ArrayList<NewsPhotoVo>();
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 타이틀 및 뉴스사		
		Elements elements = doc.select("div.head_view");
		
		element = elements.select("h3.tit_view");
		vo.setnTitle(element.get(0).text());
		
		element = elements.select("span.txt_info");
		vo.setnRepoter(element.get(0).text());
		
		element = elements.select("img");
		for(Element ele : element) {
			company = ele.getElementsByAttribute("alt").attr("alt");
			vo.setnCompany(company);
		}
		
		// 카테고리
		elements = doc.select("div#kakaoContent");
		element = elements.select("h2.screen_out");
		vo.setnCategory(element.get(0).text());
		
		
		// 기사 내용 및 사진
		elements = doc.select("div.news_view");
		vo.setnContent(elements.html());
		
		elements = doc.select("p.link_figure");
		element = elements.select("img");
		for(Element el : element) {
			String imgUr = el.getElementsByAttribute("src").attr("src");
			String figure = el.getElementsByAttribute("alt").attr("alt");
			URL imgUrl = new URL(imgUr);
			
			//db에 저장하기 위한 이미지파일 이름 저장
			//	이미지 이름을 구분하기 위해 뒤에서부터 글자를 잘라옴 
			imgUr = imgUr.substring(imgUr.length()-10, imgUr.length());
			phoVo.setpName(imgUr);
			phoVo.setpContent(figure);
			
			HttpsURLConnection conn = (HttpsURLConnection) imgUrl.openConnection();
			System.out.println(conn.getContentLength());
			
			InputStream is = conn.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			FileOutputStream os = new FileOutputStream("C:\\Users\\JHTA\\eclipse-workspace\\spring_final\\WebContent\\news\\img\\newsImages\\"+imgUr);
			BufferedOutputStream bos =  new BufferedOutputStream(os);
			int byteImg;
			
			byte[] buf = new byte[conn.getContentLength()];
			while((byteImg = bis.read(buf))!=-1) {
				bos.write(buf, 0, byteImg);
			}
			
			cnt+=1;
			phoVo.setFlag(2);
			
			bos.close();
			os.close();
			bis.close();
			is.close();
			
			list.add(phoVo);
			break;
		}
		
		dao = new NewsDao();
		dao.insert(vo, list);
		
	}
	
	
	
	public static void main(String[] args) {
		NewsCrawling2 news = new NewsCrawling2();
		
		try {
			news.insert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

