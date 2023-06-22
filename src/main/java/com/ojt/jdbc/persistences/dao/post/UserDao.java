package com.ojt.jdbc.persistences.dao.post;

import java.util.List;

import com.ojt.jdbc.bl.dto.UserDto;
import com.ojt.jdbc.persistences.entity.User;
import com.ojt.jdbc.web.forms.UserForm;

public interface UserDao {
	
	List<User> getAllUser();
	void saveUser (UserForm userForm);
	void updateUser(UserForm userForm);
	void deleteUser(int id);
	User getUserById(int id);

}
