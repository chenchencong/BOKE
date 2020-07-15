package com.etc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
public class Data implements Serializable {
	private int dataid;
	private String title;
	private String content;
	private int userid;
   /* private User user;//多对一
*/	
	public int getDataid() {
		return dataid;
	}
	public void setDataid(int dataid) {
		this.dataid = dataid;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
/*	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	

}
