package com.group.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.group.system.model.Usuario;
import com.group.system.repository.UserRepository;
import com.group.system.service.UserService;
import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Usuario saveUser(Usuario user) {
			Usuario userSave = this.userRepository.save(user);
		return userSave;
	}

	@Override
	public List<Usuario> findAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user =  this.userRepository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getUsername(), user.getPassword(), emptyList());
	}

}
