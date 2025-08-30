package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;



@Controller
@RequestMapping("/user")
public class UserListController {
	
	@Autowired
	private UserService userService;
	
	/** ユーザー一覧画面表示 **/
	@GetMapping("/list")
	public String getUserList(Model model) {
		List<MUser> userList = userService.getUsers();
		model.addAttribute("userList", userList);
		// ユーザー一覧画面表示
		return "user/list";
	}
}
