package com.boardproject.viewer.login;

import com.boardproject.dao.member.MemberDAO;
import com.boardproject.dto.MemberDTO;
import com.boardproject.viewer.board.UserMenuMain;

// 로그인 처리 클래스 (정보 입력 요청 전달, 로그인 정보 객체 저장 및 검증을 위한 정보 전달, 로그인 결과 반환)
public class LoginMain {
	private LoginInput loginInput;
	private UserMenuMain userMenuMain;
	private MemberDAO memberDAO;

	public LoginMain() {
		loginInput = new LoginInput();
		userMenuMain = new UserMenuMain();
		memberDAO = new MemberDAO();
	}

	// 계정 검증 메소드를 통해 반환된 값에 따른 분기처리
	// 1 리턴 = 로그인 성공, 일반회원 메뉴로 이동
	// 2 반환 = 관리자 확인, 관리자 메뉴로 이동
	// 0 반환 = 로그인 실패, StartMenu로 리턴
	public int loginMain() {
		int result = -1;
		MemberDTO loginInfo = inputAllInfo();
		if (!loginInfo.getMemberId().isBlank()) result = memberDAO.checkAccount(loginInfo);
		if (result == -1) return result;
		if (result == 1) {
			userMenuMain.setLogin(loginInfo);
			userMenuMain.userMenuMain();
		}
		if (result == 2) ; // 관리자 확인, 관리자 메뉴로 이동
		if (result == 0)  {
			System.out.println(" 로그인에 실패하였습니다.\n 회원정보를 확인 후 다시 시도해주세요");
			return result;
		}
		return loginMain();
	}

	// 입력받은 로그인 정보를 DTO 객체에 저장하는 메소드
	public MemberDTO inputAllInfo() {
		String inputIdByUser = loginInput.requestInputId();
		if (inputIdByUser.isBlank()) {
			System.out.println("로그인을 종료합니다.");
			return new MemberDTO(0, " ", "", "", "", "");
		}
		String inputPwByUser = loginInput.requestInputPw();
		if (inputPwByUser.isBlank()) {
			System.out.println("로그인을 종료합니다.");
			return new MemberDTO(0, " ", "", "", "", "");
		}
		
		return new MemberDTO(0, inputIdByUser, inputPwByUser, null, null, null);
	}
}
