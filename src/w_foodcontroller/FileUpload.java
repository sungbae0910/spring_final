package w_foodcontroller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;





public class FileUpload {
	public static String upload = "C:/Users/JHTA/eclipse-workspace/spring_final/WebContent/wpy/w_images/";
	String tempDir = "c:/temp/";
	
	int maxSize = 1024 * 1024 * 50;
	HttpServletRequest req;
	HttpServletResponse resp;
	public FileUpload(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	
	public boolean uploadFormCheck() {
		boolean flag = ServletFileUpload.isMultipartContent(req);
		
		return flag;
	}
	
	public HttpServletRequest uploading() {
		FoodVo vo = new FoodVo();
		w_AttVo attVo = new w_AttVo();
	    w_AttVo delVo = new w_AttVo();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		factory.setRepository(new File(tempDir));
		
		ServletFileUpload sf = new ServletFileUpload(factory); 
		sf.setHeaderEncoding("utf-8");
		sf.setFileSizeMax(maxSize);
		
		try {
			List<FileItem> list = sf.parseRequest(req);
			for(FileItem fi : list) {
				String v = fi.getString("utf-8");
				String k = fi.getFieldName();
				
				if(fi.isFormField()) {
				switch(k) {
				case "foodCode" : 
					vo.setFoodCode(Integer.parseInt(v));
					break;
				
				case "w_foodType" :
					vo.setFoodType(v);
					break;
				case "w_foodName" :
					vo.setFoodName(v);
			
					break;
				case "w_price" :
					vo.setFoodPrice(Integer.parseInt(v));
				    break;
				
				/*case "delFile":
					w_AttVo attVo = new w_AttVo();
					attVo.setSysFile(v);
					delList.add(attVo);break;*/
				}
				} else {
					if(fi.getSize() > 0) {
						String f = fi.getName();
						String sysfile = new Date().getTime() + "-" + f;
						w_AttVo attVo1 = new w_AttVo();
						attVo.setOriFile(f);
						attVo.setSysFile(sysfile);
						attVo.add(attVo1);
						
						File file = new File(upload + sysfile);
						fi.write(file);
						
						fi.delete();
					}
				}
			}
		} catch(Exception e) {
			
		}
		req.setAttribute("vo", vo);
		req.setAttribute("attVo", attVo);
		//req.setAttribute("delList", delList);
		
		return req;
	}
}
