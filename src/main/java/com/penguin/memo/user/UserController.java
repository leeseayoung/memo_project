package com.penguin.memo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/user")
//view 페이지를 위한 Controller
@Controller
public class UserController {

	@GetMapping("/join-view")
	public String joinInput() {
		
		return "user/join";
	}
	

	
	
	//로그인 페이지
	@GetMapping("/login-view")
	public String loginInput() {
		
		return "user/login";
	}
	
	
	//로그아웃 페이지
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		return "redirect:/user/login-view";
		
	}
	
	
	
	
	
}
