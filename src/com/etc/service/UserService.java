package com.etc.service;
import java.util.List;

import com.etc.entity.User;
import com.etc.entity.Auser;
import com.etc.entity.Comment;
import com.etc.entity.Data;
import com.etc.entity.Message;
public interface UserService {

	
	User login(String username, String password );
	
	
	User register(User user);
    Auser alogin(String username, String password );
	
	
	Auser aregister(Auser user);
	
	
	boolean checkUsername(String username);
	boolean checkaUsername(String username);
	
	List <Data>  iLoading(int rownum);
	List <Data>  aiLoading(int rownum);
	List <User>  auserLoading(int rownum);
	List <Message>  sLoading(int rownum,int sendid);
	List <Message>  aLoading(int rownum,int acceptid);
	List <Comment>  cLoading(int rownum,int blogid);
	//得到用户名
		String getUserName(int userid);
		
		//用户主页跳转
		List<Data> uiLoading(int userid,int rownum);
		//提交博客内容
		boolean submitbo(Data data);
		boolean submitcomment(Comment comment);
		//显示博客内容：
		Data showbo(int dataid);
		Message showMessage(int messageid);
		//删除博客信息：
		boolean deleteData(int dataid);
		boolean deleteUser(int userid);
		//update
		boolean updateboke(Data data);
		int checkacceptname(String acceptname);
		boolean submitMessage(Message message);
}