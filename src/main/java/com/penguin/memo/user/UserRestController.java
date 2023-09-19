package com.penguin.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.penguin.memo.user.domain.User;
import com.penguin.memo.user.service.UserService;


// API를 만들기 위한 Controller
@RestController  //@Controller + @ResponsseBody
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			,	@RequestParam("password") String password
			, 	@RequestParam("name") String name
			, 	@RequestParam("email") String email) {
		
		
		User user = userService.addUser(loginId, password, name, email);
		
		
		
		
		Map<String, String> resultMap  = new HashMap<>();
		
		if(user != null) {
			resultMap.put("result", "success");
			
		} else {
			resultMap.put("result", "fail");
			
		}
		
		return resultMap;
		
		
		
	}
	
	
	
	
}
