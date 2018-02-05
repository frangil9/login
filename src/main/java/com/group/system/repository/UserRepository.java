package com.group.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.system.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer>{
	public Usuario findByUsername(String username);
}
