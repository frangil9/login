package com.group.system.model;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="user")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id", nullable=false)
    private Integer userId;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="last_name", nullable=false)
    private String last_name;

    @Column(name="username", nullable=false)
    private String username;
    
    @Column(name="active")
    private boolean active;
    
    @Column(name="created")
    private Date created;
    
    @Column(name="updated")
    private Date updated;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_profile",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "profile_id") })
    private Set<Profile> perfilSet = new HashSet<Profile>();

	public Usuario() {
		super();
	}

	public Usuario(Integer userId, String password, String name, String last_name, String username, boolean active,
			Date created, Date updated, Set<Profile> perfilSet) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.last_name = last_name;
		this.username = username;
		this.active = active;
		this.created = created;
		this.updated = updated;
		this.perfilSet = perfilSet;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Set<Profile> getPerfilSet() {
		return perfilSet;
	}

	public void setPerfilSet(Set<Profile> perfilSet) {
		this.perfilSet = perfilSet;
	}
    
}
