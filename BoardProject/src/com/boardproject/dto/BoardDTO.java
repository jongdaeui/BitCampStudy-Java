package com.boardproject.dto;

public class BoardDTO {
	private int postNo;
	private String postTitle;
	private String postContent;
	private String postRegDate;
	private String postUpdate;
	private int memberNo;
	private int boardNo;

	public BoardDTO(int postNo, String postTitle, String postContent, String postRegDate, String postUpdate,
			int memberNo, int boardNo) {
		super();
		this.postNo = postNo;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postRegDate = postRegDate;
		this.postUpdate = postUpdate;
		this.memberNo = memberNo;
		this.boardNo = boardNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public String getPostRegDate() {
		return postRegDate;
	}

	public String getPostUpdate() {
		return postUpdate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

}
