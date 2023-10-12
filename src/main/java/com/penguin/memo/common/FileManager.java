package com.penguin.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {

	
	// 상수(변하지 않은수) 모두 대문자
	public final static String FILE_UPLOAD_PATH = "D:\\Leeseayoung\\springProject\\uplod\\memo";
	
	
	//file을 특정 디렉토리(폴더)에 저장하고,
	// 해당 파일을 접근할 수 있는 url경로를 만들고 리턴
	
	public static String saveFile(int userId, MultipartFile file) {
		
		if(file == null) {
			return null;
		}
		
		
		
		
		
		// 같은 파일이름 처리
		// 디렉토리(폴더)만들어서 파일 저장
		// 로그인 사용자의 userId 를 디렉토리 이름에 포람
		// 현재 시간 정보를 디렉토리 이름에 포함
		// UNIX TIME : 1970년 1월 1일 기준으로 흐른 시간을 mill second(1/1000) 단위로 표현한 방식
		// ex) /2_2131232223
		
		String directoryName =	"/" + userId + "_" + System.currentTimeMillis();
		
		// 디렉토리 생성(폴더 생성)
		
		String directoryPath =  FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(directoryPath);
		
		// 디렉토리 사용법
		if(!directory.mkdir()) {
			//디렉토리 생성 실패
			return null;
		} 
		
		// 파일 저장
		String filePath = directoryPath + "/" + file.getOriginalFilename();		
		
		
		try {
			byte[] bytes = file.getBytes();
			
			Path path = Paths.get(filePath);
			Files.write(path, bytes);
			
		} catch (IOException e) {
			
			
			
			e.printStackTrace();
			
			//파일 저장실패
			return null;
			
		}
		
	
		// 클라이언트에서 접근 가능한 url 규칙을 만들고 해당 문자열을 리턴
		// 파일 경로 : "D:\\Leeseayoung\\springProject\\uplod\\memo"
		// 경로 규칙 : /images/2_2131232223/test.png
		
		return "/images" + directoryName + "/" + file.getOriginalFilename();		

	}	
	
	//파일 삭제 관리
	public static boolean removeFile(String filePath) { // /images/2_2131232223/test.png
		
		if(filePath == null) {
			return false;
		}

		// 이미지 파일 경로에서 /image 제거후
		// uploade 경로를 이어 붙여 준다
		String fullFilePath = FILE_UPLOAD_PATH + filePath.replace("/images", "");
		//사용법
		Path path = Paths.get(fullFilePath);
		
		// 파일이 존재하는지( 존재하면 true, 없으면 fail)
		if(Files.exists(path)) {
			
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
				
				return false;
			}
		} 
		 
		Path dirPath = path.getParent();
		// 디렉토리가 존재하는지
		if(Files.exists(dirPath)) {
			try {
				Files.delete(dirPath);
			} catch (IOException e) {
				
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
}
