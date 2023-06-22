package com.ojt.jdbc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ojt.jdbc.bl.dto.PostDto;
import com.ojt.jdbc.bl.services.post.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;
	
	@RequestMapping("/post/list")
	public ModelAndView getAllPosts() {
		List<PostDto> postDtoList = this.postService.getAllPost();
		ModelAndView mv = new ModelAndView();
		mv.addObject("postList", postDtoList);
		return mv;
	}

}
