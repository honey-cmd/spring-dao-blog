package com.ojt.jdbc.bl.dto;

import java.sql.Timestamp;

import com.ojt.jdbc.persistences.entity.Post;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

	private int id;
	private String title;
	private String description;
	private Timestamp created_at;

	public PostDto(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.description = post.getDescription();

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

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

}
