package blogCommand;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
	public List<String> tagSplit(String tContent) {
		List<String> tagList = new ArrayList<String>();
		String[] tag = tContent.split(",");

		System.out.println(tContent);
		System.out.println(1);
		System.out.println(tag);
		for(String t : tag) {
			tagList.add(t);
			System.out.println(2);
			System.out.println(tagList);
		}
		
		return tagList;
	}
}
