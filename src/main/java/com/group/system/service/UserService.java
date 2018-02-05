package com.group.system.service;

import java.util.List;

import com.group.system.model.Usuario;

public interface UserService {
	public Usuario saveUser(Usuario user);
	public List<Usuario> findAllUsers();
}
