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


import com.ojt.jdbc.persistences.dao.post.PostDao;
import com.ojt.jdbc.persistences.entity.Post;
import com.ojt.jdbc.web.forms.PostForm;
@Service

@Transactional
public class PostDaoImpl implements PostDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Post> getAllPost() {
	String sql = "FROM Post";
	TypedQuery<Post> query=session().createQuery(sql,Post.class);
		return query.getResultList();
	}

	@Override
	public void deletePostById(int id) {
	String sql = "DELETE FROM Post WHERE id=:id";
Query<?> query = session().createQuery(sql);
query.setParameter("id", id);
query.executeUpdate();
	
		
	}

	@Override
	public void savePost(PostForm postForm) {
Post post = new Post();
post.setTitle(postForm.getTitle());
post.setDescription(postForm.getDescription());
post.setCreated_at(new Timestamp(0));
session().save(post);
		
	}

	@Override
	public void updatePost(PostForm postForm) {
		String sql = "UPDATE Post SET description = :description, title = :title, updated_at = :updatedAt WHERE id = :id";
		Query<?> query = session().createQuery(sql);
	    query.setParameter("description", postForm.getDescription());
	    query.setParameter("title", postForm.getTitle());
	    query.setParameter("updatedAt", new Timestamp(0));
	    query.setParameter("id", postForm.getId());
	    query.executeUpdate();
		
		
	}

}
