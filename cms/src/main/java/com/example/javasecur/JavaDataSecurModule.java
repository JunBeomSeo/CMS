package com.example.javasecur;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JavaDataSecurModule {
	
	public static String getSHA256(String data) {
		//1. 암호화 도구 구입
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); //괄호안에는 어떤 방식으로 암호화를 진행할건지 방식 지정
			//2. 암호화할 데이터를 갱신할 때 사용
			md.update(data.getBytes());
			//3. update 후에 해시계산이 완료된 결과를 반환 받을 때 사용 (암호화된 수행 결과를 반환받을때 사용)
			byte bytes[] = md.digest();
			//4. 바이트 단위를 16진수로 변환
			StringBuffer sb = new StringBuffer(); // StringBuffer는 문자열을 더하거나 이어붙일 때(문자열 결합) 사용하는 클래스
			for(byte temp:bytes) {
				sb.append(String.format("%02x", temp));
			}
			return sb.toString(); //StringBuffer에 누적시켜놓은 16진수 암호화 문자열을 진짜 문자열(String) 형태로 변환해서 반환하라”는 뜻이야
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}