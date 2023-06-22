package com.ojt.jdbc.persistences.dao.post;

import java.util.List;

import com.ojt.jdbc.persistences.entity.Post;
import com.ojt.jdbc.web.forms.PostForm;

public interface PostDao {
	List<Post> getAllPost();
	void deletePostById(int id);
	void savePost(PostForm postForm);
	void updatePost(PostForm postForm);
	

	

}
