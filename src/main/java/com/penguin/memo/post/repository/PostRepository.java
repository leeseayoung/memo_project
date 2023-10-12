package com.penguin.memo.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.penguin.memo.post.domain.Post;

@Repository
public interface PostRepository {

	
	
	//삭제3
	public int deletePost(@Param("postId")int postId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	//업데이트 3번째(메소드)
	public int updatePost(
			@Param("postId") int postId
			, @Param("title") String title
			, @Param("contnet") String content);
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int insertPost(
			@Param("userId")int userId
			, @Param("title")String title
			, @Param("content") String content
			, @Param("imagePath") String imagePath);
	
	
	
	public List<Post> selectPostList(@Param("userId")int userId);
	
	
	public Post selectPost(@Param("id")int id);
	
}
