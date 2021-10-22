package com.boardproject.viewer.board;

import com.boardproject.dto.MemberDTO;
import com.boardproject.util.MenuUtil;

public class SelectBoard {
	private MemberDTO login;
	private MenuUtil menuUtil;
	private BoardMain boardMain;
	
	
	public SelectBoard() {
		menuUtil = new MenuUtil();
		boardMain = new BoardMain();
	}

	public void setLogin(MemberDTO login) {
		this.login = login;
	}
	
	public int selectBoard() {
		int userChoice = menuUtil.printMainMenu(new String[] {"1. 1번게시판", "2. 2번 게시판", "3. 3번 게시판", "[0]. 뒤로가기"});
		if (userChoice == 0) return 0;
		boardMain.boardMain(userChoice);
		return selectBoard();
		
		
		
	}
}
