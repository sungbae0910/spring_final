package w_foodcontroller;

import javax.servlet.http.HttpSession;

public interface w_Service {
  
	public boolean w_LoginCheck(w_LoginVo vo, HttpSession session);
	
	public void w_Logout(HttpSession session);
	
}
