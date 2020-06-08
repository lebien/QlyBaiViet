package com.lebien.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "new")
public class NewEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name ="image")
	private String image;
	
	@Column(name ="shortdescription")
	private String description;
	
	@Column(name ="content" ,length = 9000)
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity categorys;

	
	
	public NewEntity() {
		super();
	}

	public NewEntity(Long id, String title, String image, String shortdescription, String content,
			CategoryEntity categorys) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.description = shortdescription;
		this.content = content;
		this.categorys = categorys;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CategoryEntity getCategorys() {
		return categorys;
	}

	public void setCategorys(CategoryEntity categorys) {
		this.categorys = categorys;
	}
	
	

}
