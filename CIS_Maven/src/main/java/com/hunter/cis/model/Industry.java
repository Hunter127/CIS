package com.hunter.cis.model;

import java.util.HashSet;
import java.util.Set;

public class Industry {
	private long id;
	private String name;
	@Override
	public String toString() {
		return "Industry [id=" + id + ", name=" + name + "]";
	}
	private Set<User> users=new HashSet<User>();
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
