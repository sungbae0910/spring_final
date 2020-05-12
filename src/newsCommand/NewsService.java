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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import newsController.NewsDao;
import newsController.NewsVo;

@Service
public class NewsService {
	NewsDao dao;
	
	@Autowired
	public NewsService(NewsDao newsDao) {
		this.dao = newsDao;
	}
	
	public NewsService() {
	}
	
	public String insert() throws IOException{
		String con = "";
		String msg = "";
		String url = "https://news.v.daum.net/v/20200512090958223";
		Document doc = null; 
		Elements element; // 크롤링한 정보를 담기 위한 객체
		NewsVo vo = new NewsVo();
		int cnt = 0;
		List<NewsVo> list = new ArrayList<NewsVo>();
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 타이틀 부분		
		Elements elements = doc.select("div.head_view");
		
		element = elements.select("h3.tit_view");
		vo.setnTitle(element.get(0).text());
		
		element = elements.select("span.txt_info");
		vo.setnRepoter(element.get(0).text());
		
		// 카테고리
		elements = doc.select("div#kakaoContent");
		element = elements.select("h2.screen_out");
		vo.setnCategory(element.get(0).text());
		System.out.println(vo.getnCategory());
		
		
		// 기사 내용 및 사진
		elements = doc.select("div.news_view");
		element = elements.select("div#harmonyContainer p");
		for(Element e : element) {
			con += e.text()+"\r";
		}
		vo.setnContent(con);
		
		
		
		Element imgEle = doc.select("p.link_figure").get(0);
		element = imgEle.select("img");
		for(Element el : element) {
			String imgUr = el.getElementsByAttribute("src").attr("src");
			System.out.println(imgUr);
			
			URL imgUrl = new URL(imgUr);
			
			HttpsURLConnection conn = (HttpsURLConnection) imgUrl.openConnection();
			System.out.println(conn.getContentLength());
			
			InputStream is = conn.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			FileOutputStream os = new FileOutputStream("C:\\Users\\JHTA\\eclipse-workspace\\spring_final\\WebContent\\images\\news\\"+vo.getnCategory()+".jpg");
			BufferedOutputStream bos =  new BufferedOutputStream(os);
			int byteImg;
			
			byte[] buf = new byte[conn.getContentLength()];
			while((byteImg = bis.read(buf))!=-1) {
				bos.write(buf, 0, byteImg);
			}
			cnt+=1;
			
			bos.close();
			os.close();
			bis.close();
			is.close();
			
		}
		
		/*			BufferedImage jpg = ImageIO.read(imgUrl);
			File file = new File("C:\\Users\\JHTA\\eclipse-workspace\\spring_final\\WebContent\\images\\news");
			ImageIO.write(jpg, "jpg", file);*/
//		System.out.println(vo.getnContent()+"\r");
		
		
		return msg;
	}
	
	public static void main(String[] args) {
		NewsService news = new NewsService();
		
		try {
			news.insert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
