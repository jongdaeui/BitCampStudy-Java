package com.boardproject.viewer.login;

import com.boardproject.util.ScannerUtil;

// 로그인, 회원가입을 위한 정보입력 요청 클래스
public class LoginInput {
	private ScannerUtil scannerUtil;
	
	public LoginInput() {
		scannerUtil = new ScannerUtil();
	}
	
	// 아이디 입력 요청 메소드
	public String requestInputId() {
		String inputId = scannerUtil.nextLine(" 아이디를 입력해주세요. [0] 로그인 종료");
		return (inputId.equals("0")) ? "" : inputId;
	}
	
	// 비밀번호 입력 요청 메소드
	public String requestInputPw() {
		String inputPw = scannerUtil.nextLine(" 비밀번호를 입력해주세요. [0] 로그인 종료");	
		return (inputPw.equals("0")) ? "" : inputPw;
	}
}
