package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.AllDao;
import newsCommand.SendMail;

@Service
public class AllService {
	AllDao dao;
	
	@Autowired
	public AllService(AllDao allDao) {
		this.dao = allDao;
	}
	
	
	public String codeIssue(HttpServletRequest req) {
		String result = "";
		String keyCode = "";
		String eMail = req.getParameter("eMail");
		System.out.println();
		HttpSession httpSession = req.getSession(true);
		
		try {
			keyCode = SendMail.createKey();
			System.out.println("키발급 : " + keyCode);
			httpSession.setAttribute("keyCode", keyCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 메일 제목
		String subject = "비밀번호 찾기 인증코드";
		// 메일 내용
		String msg = "";
		msg+= "<div align='center' style='border:1px solid black; font-fiamily : verdana'>";
		msg+="<h3 style='color: blue;'> 비밀번호 찾기 코드입니다. </h3>";
		msg+="<div style='font-size: 130%'>";
		msg+="<strong>" + keyCode + "</strong>를 입력해주세요. </div><br/>";
		
		try {
			SendMail.sendMial(eMail, subject, msg);
			result = "코드발급완료!!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int eMailCk(HttpServletRequest req) {
		int ck = 0;
		String eMail = req.getParameter("eMail");
		
		ck = dao.eMailCk(eMail);
		
		return ck;
	}
	
	public int pwdIssue(HttpServletRequest req, HttpSession session) {
		int result = 0;
		int ck = 0;
		String mId = req.getParameter("mId");
		String eMail = req.getParameter("eMail");
		String iKeyCode = req.getParameter("ctf");
		String sKeyCode = (String)session.getAttribute("keyCode");
		
		if(!iKeyCode.equals(sKeyCode)) {
			return 0;
		}
		
		session.removeAttribute("keyCode");
		
		
		try {
			String newPwd = SendMail.createKey();
			ck = dao.pwdChange(mId, newPwd);
			
			// 메일 제목
			String subject = "임시 비밀번호 안내";
			// 메일 내용
			String msg = "";
			msg+= "<div align='center' style='border:1px solid black; font-fiamily : verdana'>";
			msg+="<h3 style='color: blue;'><strong>"+mId;
					msg+="님</strong>의 임시 비밀번호 입니다. 로그인 후 비밀번호를 변경해주세요. </h3>";
			msg+="<p>임시 비밀번호 : <strong>" + newPwd + "</strong></p>";
			
			
			if(ck == 1) {
				SendMail.sendMial(eMail, subject, msg);
				result = 1;
			}else {
				result = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public int pwdPage(HttpServletRequest req, HttpSession session) {
		int result = 0;
		int ck = 0;
		String mId = req.getParameter("mId");
		String eMail = req.getParameter("eMail");
		String iKeyCode = req.getParameter("ctf");
		String sKeyCode = (String)session.getAttribute("keyCode");
		
		if(!iKeyCode.equals(sKeyCode)) {
			result = 0;
		}else {
			result = 1;
		}
		session.removeAttribute("keyCode");
		
		return result;
	}
	
	public int idCk(HttpServletRequest req) {
		int ck = 0;
		String mId = req.getParameter("mId");
		
		ck = dao.idCk(mId);
		
		return ck;
	}
}
