package com.penguin.memo.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penguin.memo.common.EncryptUtils;
import com.penguin.memo.user.domain.User;
import com.penguin.memo.user.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired	
	private UserRepository userRepository;
	
	//같은거 찾는 기능!
	public User getUser(String loginId, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		Optional<User> optionalUser = userRepository.findByLoginIdAndPassword(loginId, encryptPassword);
		User user = optionalUser.orElse(null);
		
		
		return user;
		
	}
	
	
	
	
	
	
	
	
	public User addUser(
			String loginId
			, String password
			, String name
			, String email) {
		
		
		//비밀번호 암호화
	    String encryptPassword = EncryptUtils.md5(password);
		
		
		User user = User.builder()
								   //값
						.loginId(loginId)
						.password(encryptPassword)
						.name(name)
						.email(email)
						.build();
		
		
		
		return userRepository.save(user);
		
	}
	
	
}
