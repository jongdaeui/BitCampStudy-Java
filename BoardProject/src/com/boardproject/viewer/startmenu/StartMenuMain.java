package com.boardproject.viewer.startmenu;

import com.boardproject.util.MenuUtil;
import com.boardproject.viewer.board.SelectBoard;
import com.boardproject.viewer.join.JoinMain;
import com.boardproject.viewer.login.LoginMain;

public class StartMenuMain {
	private MenuUtil menuUtil;
	private LoginMain loginMain;
	private JoinMain joinMain;
	private SelectBoard selectBoard;

	public StartMenuMain() {
		menuUtil = new MenuUtil();
		loginMain = new LoginMain();
		joinMain = new JoinMain();
		selectBoard = new SelectBoard();
	}

	public int mainViewer() {
		int userChoice = menuUtil.printMainMenu(new String[] { "1. 로그인", "2. 회원가입", "3. 비회원", "[0] 프로그램 종료" });
		if (userChoice == 1) loginMain.loginMain(); // 로그인 이동
		if (userChoice == 2) joinMain.joinMemberMenu(); // 회원가입 이동
		if (userChoice == 3) selectBoard.selectBoard();// 비회원 이동
		if (userChoice == 0) return 0;
		return mainViewer();
	}
	
	
}
