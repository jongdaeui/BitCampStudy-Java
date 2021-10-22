package com.boardproject.dto;

public class CommentDTO {
	private int commentNo;
	private String commentContent;
	private String commentRegDate;
	private String commentUpdate;
	private int commentParentNo;
	private int postNo;
	private int memberNo;
	private int boardNo;

	public CommentDTO(int commentNo, String commentContent, String commentRegDate, String commentUpdate,
			int commentParentNo, int postNo, int memberNo, int boardNo) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.commentRegDate = commentRegDate;
		this.commentUpdate = commentUpdate;
		this.commentParentNo = commentParentNo;
		this.postNo = postNo;
		this.memberNo = memberNo;
		this.boardNo = boardNo;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public String getCommentRegDate() {
		return commentRegDate;
	}

	public String getCommentUpdate() {
		return commentUpdate;
	}

	public int getCommentParentNo() {
		return commentParentNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

}
