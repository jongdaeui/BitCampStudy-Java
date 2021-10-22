package com.boardproject.viewer.board;

import com.boardproject.dto.MemberDTO;
import com.boardproject.util.MenuUtil;

public class UserMenuMain {
		private MenuUtil menuUtil;
		private SelectBoard selectBoard;
		private MemberDTO login;
		
		public UserMenuMain() {
			menuUtil = new MenuUtil();
			selectBoard = new SelectBoard();
		}
		
		
		public void setLogin(MemberDTO login) {
			this.login = login;
			
		}

		public int userMenuMain() {
			int userChoice = menuUtil.printMainMenu(new String[] {"1. 게시판 가기", "2. 회원정보관리", "[0] 로그아웃"});
			if (userChoice == 1) {
				selectBoard.setLogin(this.login);
				selectBoard.selectBoard();
			}
			if (userChoice == 2) {
				// 회원정보 메뉴 이동
			}
			if (userChoice == 0) return 0;// 로그아웃 이동
			return userMenuMain();
		}
}
