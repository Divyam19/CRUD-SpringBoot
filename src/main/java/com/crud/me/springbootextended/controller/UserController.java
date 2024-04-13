package com.crud.me.springbootextended.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.me.springbootextended.entity.Student;
import com.crud.me.springbootextended.entity.User;
import com.crud.me.springbootextended.service.StudentService;
import com.crud.me.springbootextended.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
	
	
	@GetMapping("/hi")
	public String sayHi() {
		return"hiiiiii";
	}
	
	@Autowired
	private final UserService userService;
	
	private UserController(UserService userService) {
		this.userService=userService;
	}
	
	
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	@GetMapping("/getAllUsers")
	private ResponseEntity<List<User>> getAllUsersService(){
		return userService.getAllUsers();
	}
	
	
	

}
