package com.penguin.memo.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penguin.memo.user.domain.User;
import com.penguin.memo.user.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired	
	private UserRepository userRepository;
	
	
	
	
	
	public User addUser(
			String loginId
			, String password
			, String name
			, String email) {
		
		
		//비밀번호 암호화
		
		
		
		User user = User.builder()
								   //값
						.loginId(loginId)
						.password(password)
						.name(name)
						.email(email)
						.build();
		
		
		
		return userRepository.save(user);
		
	}
	
	
}
