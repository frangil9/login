package com.group.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.system.model.Usuario;
import com.group.system.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/signup")
	public Usuario saveUser(@RequestBody Usuario user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return this.userService.saveUser(user);
	}
	
	@GetMapping("/users")
	public List<Usuario> findAllUsers(){
		return this.userService.findAllUsers();
	}
}
