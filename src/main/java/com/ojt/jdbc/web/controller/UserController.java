package com.ojt.jdbc.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ojt.jdbc.bl.dto.UserDto;
import com.ojt.jdbc.bl.services.post.UserService;
import com.ojt.jdbc.persistences.entity.User;
import com.ojt.jdbc.web.forms.UserForm;

import lombok.Getter;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

@GetMapping("/list")
	public ModelAndView getUserList() {
		ModelAndView mv = new ModelAndView();
		List<UserDto> userList = this.userService.getAllUser();
		mv.addObject("userLists", userList);
		return mv;
	}

	@RequestMapping(value = "/create")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("saveForm", new UserForm());

		return mv;
	}

	@RequestMapping(value = "/create/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("saveForm") @Valid UserForm userForm, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		userService.saveUser(userForm);
		mv.setViewName("redirect:/user/list");
		return mv;
	}

	@RequestMapping(value = "/update")
	public ModelAndView updateUser(@RequestParam int updateId) {
		ModelAndView mv = new ModelAndView();
		UserDto userDto = userService.getUserById(updateId);
		mv.addObject("updateUser", new UserForm(userDto));

		return mv;

	}

	@RequestMapping(value = "/update/save", method = RequestMethod.POST)
	public ModelAndView saveUpdateUser(@ModelAttribute("updateUser") UserForm userForm) {
		ModelAndView mv = new ModelAndView();
		userService.updateUser(userForm);
		System.out.println(userForm.getId());

		mv.setViewName("redirect:/list");
		return mv;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		userService.deleteUserById(id);
		mv.setViewName("redirect:/list");
		return mv;
	}

}
