package com.ojt.jdbc.bl.dto;

import java.sql.Timestamp;

import com.ojt.jdbc.persistences.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private Timestamp created_at;

	public UserDto(User user) {
		this.id = user.getId();
		this.name=user.getName();
		this.email=user.getEmail();
		this.password=user.getPassword();
		this.created_at=user.getCreated_at();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	

}
