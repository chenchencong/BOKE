package com.etc.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class User implements Serializable{

	private String username;
	private String password;
	private int userid;
	private Set<Data> data=new HashSet<Data>();
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
	public Set<Data> getData() {
		return data;
	}
	public void setData(Set<Data> data) {
		this.data = data;
	}
	


	
}
