package com.mms.ssjpa.controller;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mms.ssjpa.model.Role;
import com.mms.ssjpa.model.User;
import com.mms.ssjpa.service.IUserService;

@RestController
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		
		
		Integer uid = userService.saveUser(user).getId();
		return ResponseEntity.ok("User with id "+uid+" was added !");
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Integer userId){
		
		User user = userService.findUser(userId);
		var roles =new HashSet<>(Arrays.asList(new Role("ADMIN"),new Role("USER")));
		user.setRoles(roles);
		Integer uid = userService.updateUser(user).getId();
		return ResponseEntity.ok("User with id "+uid+" was updated !");
		
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestBody Integer userId){
		
		User user = userService.findUser(userId);
		
		userService.deleteUser(user);
		return ResponseEntity.ok("User was deleted !");
		
	}
}
