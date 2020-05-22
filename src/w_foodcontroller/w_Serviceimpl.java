package w_foodcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class w_Serviceimpl implements w_Service {
   
	@Autowired
	w_LoginDao dao;
	
	@Override
	public boolean w_LoginCheck(w_LoginVo vo, HttpSession session) {
		
		boolean result =dao.w_LoginCheck(vo);
		if(result == true) {
			session.setAttribute("w_mid",vo.getW_mid());
		}
		return result;
	}
	@Override
	public void w_Logout(HttpSession session) {
		dao.w_Logout(session);
	}
}
