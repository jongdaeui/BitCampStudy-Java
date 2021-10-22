package com.boardproject.start;

import com.boardproject.viewer.startmenu.StartMenuMain;

public class ProgramStart {

	public static void main(String[] args) {
		StartMenuMain startMenuMain = new StartMenuMain();
		if (startMenuMain.mainViewer() == 0)
			System.out.println("프로그램 종료");

	}

}
