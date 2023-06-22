package com.ojt.jdbc.web.forms;

import com.ojt.jdbc.bl.dto.PostDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PostForm {
	
	private int id;
	private String title; 
	private String description;
	
	public PostForm (PostDto postDto) {
	this.id=postDto.getId();
	this.title=postDto.getTitle();
	this.description=postDto.getDescription();
	
	

}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
