package sns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

	@RequestMapping(value = "/auth/joinProc") //어느때 얘를 쓸것인가 에대한 어노태이션 // "/select.brd"가 들어왔는데 get이거나 post로 들어오든 무조건 실행하라
	public String authJoinProc(RedirectAttributes redirectAttributes) {
		System.out.println("실행");

		return "redirect:/auth/login";
	}
}
