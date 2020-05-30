package blogCommand;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import blogController.BlogBoardVo;

@Service
public class FileUpload {
	
	public String brdSummernoteImgUploading(MultipartHttpServletRequest req) { //썸머노트 이미지파일 업로드
		JSONObject json = new JSONObject();
		String filePath = req.getSession().getServletContext().getRealPath("/blog/summernoteImage/"); //저장될 외부 파일 경로
		MultipartFile file = req.getFile("file"); //input File의 name
		
		String oriFileName = file.getOriginalFilename(); //오리지널 파일명
		String extension = oriFileName.substring(oriFileName.lastIndexOf(".")); //파일 확장자	
		String sysFileName = UUID.randomUUID() + extension; //저장될 파일명
		File targetFile = new File(filePath + sysFileName);	
		
		try {
				InputStream fileStream = file.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile); //파일 저장
				
				json.put("url", "./summernoteImage/" + sysFileName);
				json.put("responseCode", "success");
		} catch (Exception e) {
			FileUtils.deleteQuietly(targetFile); //저장된 파일 삭제
			json.put("responseCode", "error");
			e.printStackTrace();
		}
		return json.toJSONString();
	}
	
	public BlogBoardVo brdHeaderFileUploading(MultipartHttpServletRequest req) {
		BlogBoardVo brdVo = new BlogBoardVo();
		MultipartFile file = req.getFile("c_brdHeaderImg");
		
		//헤더 사진 업로드
		if (file.getOriginalFilename() != ""){ //헤더 사진을 추가, 수정 했을 때
			String filePath = req.getSession().getServletContext().getRealPath("/blog/blog_image/");
			String oriFileName = file.getOriginalFilename(); 
			String extension = oriFileName.substring(oriFileName.lastIndexOf("."));
			String sysFileName = UUID.randomUUID() + extension;
			File targetFile = new File(filePath + sysFileName);
			
			try {
				InputStream fileStream = file.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile);
				brdVo.setOriBrdHeader(oriFileName);
				brdVo.setBrdHeader(sysFileName);
			} catch(Exception e) {
				FileUtils.deleteQuietly(targetFile);
				e.printStackTrace();
			}
		}
		
		//게시물 정보
		brdVo.setbNo(Integer.parseInt(req.getParameter("c_bNo")));
		brdVo.setBrdNo(Integer.parseInt(req.getParameter("c_brdNo")));
		brdVo.setcName(req.getParameter("c_cName"));
		brdVo.setSubject(req.getParameter("c_subject"));
		brdVo.setContent(req.getParameter("c_content"));
		brdVo.setTContent(req.getParameter("c_tagContent"));
		brdVo.setBasicSet(Integer.parseInt(req.getParameter("c_basicSet")));
		return brdVo;
	}
}
