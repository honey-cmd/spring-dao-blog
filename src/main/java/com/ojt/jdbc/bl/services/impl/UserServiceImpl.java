package com.ojt.jdbc.bl.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ojt.jdbc.bl.dto.UserDto;
import com.ojt.jdbc.bl.services.post.UserService;
import com.ojt.jdbc.persistences.dao.post.UserDao;
import com.ojt.jdbc.persistences.entity.User;
import com.ojt.jdbc.web.forms.UserForm;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<UserDto> getAllUser() {

		List<User> userList = userDao.getAllUser();
		if (userList == null) {
			return null;
		}
		return userList.stream().map(obj -> new UserDto(obj)).toList();
	}

	@Override
	public void saveUser(UserForm userForm) {
		userDao.saveUser(userForm);

	}

	@Override
	public void updateUser(UserForm userForm) {
		userDao.updateUser(userForm);

	}

	@Override
	public UserDto getUserById(int id) {

		User user = userDao.getUserById(id);
		return new UserDto(user);
	}

	@Override
	public void deleteUserById(int id) {
		userDao.deleteUser(id);

	}

}
