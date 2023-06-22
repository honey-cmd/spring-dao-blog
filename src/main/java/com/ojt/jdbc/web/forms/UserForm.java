package com.ojt.jdbc.web.forms;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotBlank;

import com.ojt.jdbc.bl.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class UserForm {

	private int id;
	@NotBlank(message = "Name field is required")
	private String name;
	@NotBlank(message = "Email field is required")
	private String email;
	@NotBlank(message = "Password field is required")
	private String password;

	public UserForm(UserDto userDto) {
		this.id = userDto.getId();
		this.name = userDto.getName();
		this.email = userDto.getEmail();
		this.password = userDto.getPassword();

	}

	public UserForm() {
		// TODO Auto-generated constructor stub
	}

	public UserForm(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
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

}
