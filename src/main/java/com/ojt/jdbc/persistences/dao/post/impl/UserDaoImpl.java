package com.ojt.jdbc.persistences.dao.post.impl;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ojt.jdbc.bl.dto.UserDto;
import com.ojt.jdbc.persistences.dao.post.UserDao;
import com.ojt.jdbc.persistences.entity.User;
import com.ojt.jdbc.web.forms.UserForm;

@Transactional
@Service
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session session() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public List<User> getAllUser() {
		String sql = "FROM User";
		TypedQuery<User> query=session().createQuery(sql,User.class);
		return query.getResultList();

	}

	@Override
	public void saveUser(UserForm userForm) {

		User user = new User();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setCreated_at(new Timestamp(0));
		session().save(user);

	}

	@Override
	public void updateUser(UserForm userForm) {
		String sql = "UPDATE User SET name = :name, email = :email, password = :password WHERE id = :id";
		Query<?> query = session().createQuery(sql);
		query.setParameter("name",userForm.getName());
		query.setParameter("email",userForm.getEmail());
		query.setParameter("password",userForm.getPassword());
	
		query.setParameter("id",userForm.getId());
		query.executeUpdate();

	}

	@Override
	public User getUserById(int id) {

		String sql = "FROM User WHERE id = :id";
		Query<User> query = session().createQuery(sql,User.class);
		query.setParameter("id", id);
		User user = query.getSingleResult();
		return user;
	}


	@Override
	public void deleteUser(int id) {
		String sql = "DELETE FROM User WHERE id = :id";
		Query<?> query = session().createQuery(sql);
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

	





}
