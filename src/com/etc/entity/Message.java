package com.etc.entity;

import java.io.Serializable;

public class Message implements Serializable{
	private int messageid;
	private String content;
	private int  sendid;
	private int acceptid;
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSendid() {
		return sendid;
	}
	public void setSendid(int sendid) {
		this.sendid = sendid;
	}
	public int getAcceptid() {
		return acceptid;
	}
	public void setAcceptid(int acceptid) {
		this.acceptid = acceptid;
	}
	

}
