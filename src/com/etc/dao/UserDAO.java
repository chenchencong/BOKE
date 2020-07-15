package com.etc.dao;

import java.util.List;

import com.etc.entity.Auser;
import com.etc.entity.Comment;
import com.etc.entity.Data;
import com.etc.entity.Message;
import com.etc.entity.User;

public interface UserDAO {

	
	User findUser(String username, String password);
	
	

	boolean insertUser(User user);
    Auser findaUser(String username, String password);
	
	

	boolean insertaUser(Auser user);

	
	boolean findUsername(String username);
	boolean findaUsername(String username);
	List<Data> findData(int rownum);
	List<User> findUserdata(int rownum);
	List<Data> afindData(int rownum);
	List<Comment> findComment(int rownum,int blogid);
	//得到用户名
	String getUserName(int userid);
	//用户主页跳转
	 List<Data> findUserData(int rownum,int userid);
	 //插入提交博客的内容findSendMessage
	 boolean insertData(Data data);
	 boolean insertcomment(Comment comment);
	//显示博客的主要内容：
	 Data showbo(int dataid);
	 Message showMessage(int messageid);
	 //删除博客信息
	 boolean deleteData(int dataid);
	 boolean deleteUser(int userid);
	 //updateboke
	 boolean updateboke(Data data);
	 List<Message> findSendMessage(int rownum,int userid);
	 List<Message> findAcceptMessage(int rownum,int acceptid);
	 int findacceptid(String acceptname);
	 boolean insertMessage(Message message);
}
