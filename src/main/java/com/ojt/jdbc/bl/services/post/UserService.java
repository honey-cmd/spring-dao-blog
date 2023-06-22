package com.ojt.jdbc.bl.services.post;

import java.util.List;



import com.ojt.jdbc.bl.dto.UserDto;
import com.ojt.jdbc.persistences.entity.User;
import com.ojt.jdbc.web.forms.UserForm;

public interface UserService {
	
	List<UserDto> getAllUser();
	void saveUser (UserForm userForm);
	void updateUser(UserForm userForm);
	void deleteUserById(int id);
	UserDto getUserById(int id);
	

}
