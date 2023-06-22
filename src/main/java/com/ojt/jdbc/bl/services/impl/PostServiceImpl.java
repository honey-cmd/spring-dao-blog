package com.ojt.jdbc.bl.services.impl;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojt.jdbc.bl.dto.PostDto;
import com.ojt.jdbc.bl.services.post.PostService;
import com.ojt.jdbc.persistences.dao.post.PostDao;
import com.ojt.jdbc.persistences.entity.Post;
import com.ojt.jdbc.web.forms.PostForm;

@Transactional
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDao postDao;

	@Override
	public List<PostDto> getAllPost() {
		List<Post> posts = this.postDao.getAllPost();
		return posts.stream().map(item -> new PostDto(item)).collect(Collectors.toList());
	}

	@Override
	public void deletePostbyId(int id) {
		postDao.deletePostById(id);

	}

	@Override
	public void savePost(PostForm postForm) {
		postDao.savePost(postForm);

	}

	@Override
	public void updatePost(PostForm postForm) {
		postDao.updatePost(postForm);

	}

}
