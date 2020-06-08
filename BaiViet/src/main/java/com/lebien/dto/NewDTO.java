package com.lebien.dto;

import org.springframework.web.multipart.MultipartFile;

public class NewDTO {
	private Long id;
	
	private String title;
	private String content;
	private String shortdescription;
	private MultipartFile photo;
	private Integer categoryId;
	
	public NewDTO() {
		super();
	}
	
	
	
	public NewDTO(Long id, String title, String content, String shortdescription, MultipartFile photo,
			Integer categoryId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.shortdescription = shortdescription;
		this.photo = photo;
		this.categoryId = categoryId;
	}



	public NewDTO(String title, String content, String shortdescription, MultipartFile photo, Integer categoryId) {
		super();
		this.title = title;
		this.content = content;
		this.shortdescription = shortdescription;
		this.photo = photo;
		this.categoryId = categoryId;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getShortdescription() {
		return shortdescription;
	}
	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	

}
