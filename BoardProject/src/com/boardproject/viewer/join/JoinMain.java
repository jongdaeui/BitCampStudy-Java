package com.boardproject.viewer.join;

import com.boardproject.dao.member.MemberDAO;
import com.boardproject.dto.MemberDTO;

// 회원가입 진행 메인 클래스
public class JoinMain {
	private InputJoinInfo inputJoinInfo;
	private MemberDAO memberDAO;
	
	public JoinMain() {
		inputJoinInfo = new InputJoinInfo();
		memberDAO = new MemberDAO();
	}
	
	public void joinMemberMenu() {
		
		MemberDTO userInputInfo = inputJoinInfo.inputJoinInfo(); // 회원가입을 위한 정보 입력 요청
		
		if (userInputInfo.getMemberId().isBlank()) return; // 회원가입을 취소한 경우 null 대신 비어있는 객체를 리턴
		
		if(memberDAO.insert(userInputInfo) == 1) { // 입력된 정보를 이용 회원 가입 진행
			System.out.println("회원가입이 완료되었습니다.");
			return;
		};
		System.out.println("회원가입 실패!");
	}
}
