package com.penguin.memo.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.penguin.memo.user.domain.User;

@Repository                                           //직접 만든친구
public interface UserRepository extends JpaRepository<User, Integer> {

	// WHERE `loginId` = ?? AND `password` == ??
	public Optional<User> findByLoginIdAndPassword(String loginId, String password);
	
}
