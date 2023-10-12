package com.penguin.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.penguin.memo.post.service.PostService;

@RequestMapping("/post")
@RestController
public class PostRestController {

	@Autowired
	private PostService postService;
	
	//삭제 1
	@DeleteMapping("/delete")
	public Map<String, String> deleteMemo(
			@RequestParam("postId")int postId
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		int count = postService.deletePost(postId, userId);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	

	
	//업데이트 첫번째
	@PutMapping("/update")
	public Map<String, String> updateMemo(
			@RequestParam("postId")int postId
			, @RequestParam("title")String title
			, @RequestParam("content")String content) {
		
		int count = postService.updatePost(postId, title, content);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success"); 
		} else {
			resultMap.put("result", "fail"); 
		}
		return resultMap;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/create")
	public Map<String, String> createMemo(
			@RequestParam("title") String title
			, @RequestParam("content") String content
			, @RequestParam(value="imageFile", required=false) MultipartFile file
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postService.addPost(userId, title, content, file);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}

	
	
	
	
}
