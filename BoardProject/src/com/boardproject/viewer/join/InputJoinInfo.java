package com.boardproject.viewer.join;

import java.util.ArrayList;
import java.util.List;

import com.boardproject.dao.member.MemberDAO;
import com.boardproject.dto.MemberDTO;
import com.boardproject.util.ScannerUtil;

public class InputJoinInfo {
	private ScannerUtil scannerUtil;
	private MemberDAO memberDAO;
	private List<String> list;

	public InputJoinInfo() {
		scannerUtil = new ScannerUtil();
		memberDAO = new MemberDAO();
		list = new ArrayList<String>();
	}

	public MemberDTO inputJoinInfo() {
		list = requestJoinInfo(createMessageList(), 0);
		if (list.isEmpty()) return new MemberDTO(0, "", "", "", "", "");;
		for (String str : list) {
			System.out.println(str);
		}
		return new MemberDTO(0, list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
	}

	private String[] createMessageList() {
		return new String[] { " 아이디를 입력해주세요. [0] 회원가입 취소", " 비밀번호를 입력해주세요. [0] 회원가입 취소", " 이름을 입력해주세요. [0] 회원가입 취소",
				" 연락처를 입력해주세요. [0] 회원가입 취소", " 이메일을 입력해주세요. [0] 회원가입 취소" };
	}

	private List<String> requestJoinInfo(String[] messageList, int index) {
		int i = index;
		String inputInfo = scannerUtil.nextLineNN(messageList[i]);
		if (index == 0) {
			if (memberDAO.findById(inputInfo) == 1) {
				System.out.println("이미 사용중인 아이디 입니다.");
				return requestJoinInfo(messageList, i);
			}
		}
		if (inputInfo.equals("0")) {
			System.out.println("회원가입을 종료합니다.");
			list.clear();
			return list;
		}
		list.add(inputInfo);

		if (i == 4) return list;

		return requestJoinInfo(messageList, ++i);

	}
}
