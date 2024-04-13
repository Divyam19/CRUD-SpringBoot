package com.crud.me.springbootextended.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.crud.me.springbootextended.entity.User;
import com.crud.me.springbootextended.reopsitory.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private final UserRepository repository;
	
	private UserService(UserRepository repository) {
		this.repository=repository;
	}
	
	
	public ResponseEntity<List<User>> getAllUsers(){
		try{
			List<User> allUsers=new ArrayList<User>();
			repository.findAll().forEach(allUsers::add);
		
			if(allUsers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
