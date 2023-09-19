package com.penguin.memo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.penguin.memo.user.domain.User;

@Repository                                           //직접 만든친구
public interface UserRepository extends JpaRepository<User, Integer> {

	
	
	
}
