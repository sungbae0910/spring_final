package blogCommand;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
	public List<String> tagSplit(String tContent) {
		List<String> tagList = new ArrayList<String>();
		String[] tag = tContent.split(",");

		for (String t : tag) {
			tagList.add(t);
		}
		
		return tagList;
	}
	
}
