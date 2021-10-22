package com.boardproject.dto;

public class BoardListDTO {
	private int boardNo;
	private String boardName;
	private String boardOpeningDate;
	private int categoryNo;

	public BoardListDTO(int boardNo, String boardName, String boardOpeningDate, int categoryNo) {
		super();
		this.boardNo = boardNo;
		this.boardName = boardName;
		this.boardOpeningDate = boardOpeningDate;
		this.categoryNo = categoryNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public String getBoardName() {
		return boardName;
	}

	public String getBoardOpeningDate() {
		return boardOpeningDate;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

}
