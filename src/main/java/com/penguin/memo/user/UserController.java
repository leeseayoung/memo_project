package com.penguin.memo.user;

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
	

}
