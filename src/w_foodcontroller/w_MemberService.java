package w_foodcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class w_MemberService {
  
	FoodDao w_dao;
	
	public FoodVo w_LoginCheck (FoodVo vo) {
	
		
		return w_dao.w_LoginCheck(vo);
	}

	
	
	
}
