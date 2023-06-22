package com.ojt.jdbc.bl.services.post;

import java.util.List;

import com.ojt.jdbc.bl.dto.PostDto;
import com.ojt.jdbc.bl.dto.UserDto;
import com.ojt.jdbc.persistences.entity.Post;
import com.ojt.jdbc.web.forms.PostForm;
import com.ojt.jdbc.web.forms.UserForm;

public interface PostService {
	
	List<PostDto> getAllPost();
	void deletePostbyId(int id);
	void savePost(PostForm postForm);

	void updatePost(PostForm postForm);

	

}




