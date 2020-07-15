package com.etc.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Auser implements Serializable{

	private String username;
	private String password;
	private int userid;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	


	
}

