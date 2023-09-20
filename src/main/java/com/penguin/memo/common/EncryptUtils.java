package com.penguin.memo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {

	// md5 암호화 기능
	//암화화할 문자열을 전달 받고 암호화된 문자열을 돌려준다.
	//static 객체 생성 없이 사용 가능! 메소드만 호출
	public static String md5(String message) {
		
		String resultString = "";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			
			byte[] bytes = message.getBytes();
			md.update(bytes);
			
			
			byte[] digest =	md.digest();
			
			for(int i = 0; i< digest.length; i++ ) {
				// 비트연산
				resultString += Integer.toHexString(digest[i] & 0xff);
			}
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			return null;
		}
		
		return resultString;
		
	}
	
}
