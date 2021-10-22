package com.boardproject.dto;

public class CategoryDTO {
	private int categoryNo;
	private String categoryName;
	
	public CategoryDTO(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}
	
	
}
