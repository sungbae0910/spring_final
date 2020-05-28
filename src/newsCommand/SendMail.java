package newsCommand;

import org.apache.commons.mail.HtmlEmail;

public class SendMail {
	
	public static void sendMial(String eMail, String subject, String msg) throws Exception{
		
		//Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com"; //서버명
		String hostSMTPid = "manpa20192b_05"; //아이디
		String hostSMTPpwd = "manpa2019"; 
		
		// 보내는 사람
		String fromEmail = "manpa20192b_05@naver.com";
		String fromName = "안녕";
		
		//eMail 전송
		try {
			HtmlEmail mail = new HtmlEmail();
			mail.setDebug(true);
			mail.setCharset(charSet);
			mail.setSSLOnConnect(true);
			mail.setHostName(hostSMTP);
			mail.setSmtpPort(465);
			
			mail.setAuthentication(hostSMTPid, hostSMTPpwd);
			mail.setStartTLSEnabled(true);
			mail.addTo(eMail);
			mail.setFrom(fromEmail, fromName, charSet);
			mail.setSubject(subject);
			mail.setHtmlMsg(msg);
			mail.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String createKey() throws Exception{
		StringBuffer key = new StringBuffer();
		char[] charSet = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
					'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'
					, 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'Z', '!'
					, '@', '#', '$'};
		for(int i=0; i<10; i++) {
			int idx = (int) (charSet.length * Math.random());
			key.append(charSet[idx]);
		}
		
		return key.toString();
	}

}
