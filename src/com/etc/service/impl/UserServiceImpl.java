package com.etc.service.impl;
import java.util.ArrayList;
import java.util.List;
import com.etc.dao.UserDAO;
import com.etc.dao.impl.UserDAOImpl;
import com.etc.entity.Auser;
import com.etc.entity.Comment;
import com.etc.entity.Data;
import com.etc.entity.Message;
import com.etc.entity.User;
import com.etc.service.UserService;

public class UserServiceImpl implements UserService {

	
	private	UserDAO userDAO;
	
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}



	public User login(String username, String password) {
		
		
		User user = userDAO.findUser(username, password);
		
		if(user!=null){  
			return user;}
		return null;
		
	}

	public User register(User user) {
		
		if(userDAO.insertUser(user)){   
			user = userDAO.findUser(user.getUsername(), user.getPassword());
			return user;
		}
		return null;
	}

	public Auser alogin(String username, String password) {
		Auser user = userDAO.findaUser(username, password);
		
		if(user!=null){  
			return user;}
		return null;
	}



	public Auser aregister(Auser user) {
		if(userDAO.insertaUser(user)){   
			user = userDAO.findaUser(user.getUsername(), user.getPassword());
			return user;
		}
		return null;
	}
     public boolean checkaUsername(String username) {
		
		return userDAO.findaUsername(username);
	}
     

	public boolean checkUsername(String username) {
		
		return userDAO.findUsername(username);
	}

	public List<Data> iLoading(int rownum) {
		List<Data> list=userDAO.findData(rownum);
		
		return list;
	}
	public List<Data> aiLoading(int rownum) {
		List<Data> list=userDAO.afindData(rownum);
		
		return list;
	}
	public List<Comment> cLoading(int rownum,int blogid) {
		List<Comment> list=userDAO.findComment(rownum,blogid);
		
		return list;
	}

	public String getUserName(int userid) {
        
		return userDAO.getUserName(userid);
	}
    //用户主页跳转
	public List<com.etc.entity.Data> uiLoading(int userid,int rownum) {
		List<Data> userlist=userDAO.findUserData(rownum,userid);
		return userlist;
	}
	    //提交博客内容：
		public boolean submitbo(Data data) {
			if(userDAO.insertData(data)){   
				return true;
			}
			   return false;
			
		}
		public boolean submitcomment(Comment comment) {
			if(userDAO.insertcomment(comment)){   
				return true;
			}
			   return false;
			
		}
	    //删除博客信息：
		  public boolean deleteData(int dataid) {
			// TODO Auto-generated method stub
			return userDAO.deleteData(dataid);
		}
		  public boolean deleteUser(int userid) {
				// TODO Auto-generated method stub
				return userDAO.deleteUser(userid);
			}
	     //显示博客内容：
		public com.etc.entity.Data showbo(int dataid) {
			// TODO Auto-generated method stub
			return userDAO.showbo(dataid);
		}

		public boolean updateboke(Data data) {
			// TODO Auto-generated method stub
			return userDAO.updateboke(data);
		}



		public List<Message> sLoading(int rownum, int sendid) {
			List<Message> list=userDAO.findSendMessage(rownum,sendid);
			
			return list;
		}



		public List<Message> aLoading(int rownum, int acceptid) {
            List<Message> list=userDAO.findAcceptMessage(rownum,acceptid);
			
			return list;
		}



		public int checkacceptname(String acceptname) {
			int acceptid=userDAO.findacceptid(acceptname);
			return acceptid;
		}



		public boolean submitMessage(Message message) {
			if(userDAO.insertMessage(message)){   
				return true;
			}
			   return false;
		}



		public Message showMessage(int messageid) {
			// TODO Auto-generated method stub
			return userDAO.showMessage(messageid);
		}



		public List<User> auserLoading(int rownum) {
			List<User> list=userDAO.findUserdata(rownum);
			
			return list;
		}



	    
     

	

	

}
