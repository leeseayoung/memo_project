package com.penguin.memo.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.penguin.memo.common.FileManager;
import com.penguin.memo.post.domain.Post;
import com.penguin.memo.post.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	
	//삭제 2
	public int deletePost(int postId, int userId) {
		
		Post post = postRepository.selectPost(postId);
		
		
		if(post.getUserId() != userId) {
			return 0;
			
		}
		
		FileManager.removeFile(post.getImagePath());
		
		return postRepository.deletePost(postId);
	}
	
	
	
	
	
	//업데이트 두번째
	public int updatePost(int postId, String title, String content) {
		
		return postRepository.updatePost(postId, title, content);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int addPost(int userId, String title, String content, MultipartFile file) {
		//file을 특정 디렉토리(폴더)에 저장하고,
		//저장된파일을 접근할수 있는 url 경로를 만들고 table
		//, MultipartFile file
		String imagePath = FileManager.saveFile(userId, file);
		
		return postRepository.insertPost(userId, title, content, imagePath);
		
	}
	
	public List<Post> getPostList(int userId) {
		
		return postRepository.selectPostList(userId);
		
	}

	
	//아이디가 일치하는 메모 내용
	public Post getPost(int id) {
		
		return postRepository.selectPost(id);
		
		
	}
	
	
}
