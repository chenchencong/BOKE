package com.etc.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.etc.dao.UserDAO;
import com.etc.dbutil.HibernateUtil;
import com.etc.entity.Auser;
import com.etc.entity.Comment;
import com.etc.entity.Data;
import com.etc.entity.Message;
import com.etc.entity.User;

public class UserDAOImpl implements UserDAO {
	//session工厂对象
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Auser findaUser(String username, String password) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Auser where username = ? and password = ?").setCacheable(true);
	        query.setParameter(0, username);
	        query.setParameter(1, password);
	        List<Auser> users=query.list();
	        for(Auser user:users){
	        	return user;
	        }
	     
	      
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return null;
	}

	public boolean insertaUser(Auser user) {
          try{
			
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
			
			return true;
			}catch(Exception e){
			
			e.printStackTrace();
		}
		return false;
	}
	public User findUser(String username, String password) {
		
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User where username = ? and password = ?").setCacheable(true);
	        query.setParameter(0, username);
	        query.setParameter(1, password);
	        List<User> users=query.list();
	        for(User user:users){
	        	return user;
	        }
	     
	      
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return null;
		
		
		
	}

	public boolean findUsername(String username) {
		
		try{
			Session session = sessionFactory.getCurrentSession();
		
			Query query=session.createQuery("from User where username = ?").setCacheable(true);
			query.setParameter(0, username);
		    List<User> list=query.list();
		    for(User user:list){
		    	if(user!=null){
		    		return true;
		    	}
		    }
		  
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return false;

	}

	public boolean insertUser(User user) {
	
		try{
			
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
			
			return true;
			}catch(Exception e){
			
			e.printStackTrace();
		}
		return false;
	}

	public List<Data> findData(int rownum) {
		
		try{
			Session session = sessionFactory.getCurrentSession();
			rownum*=5;
			Query query=session.createQuery("from Data order by dataid desc").setCacheable(true);
			query.setFirstResult(rownum);
			query.setMaxResults(5);
			List<Data> data=query.list();
			if(data==null){
				query=session.createQuery("from Data order by dataid desc").setCacheable(true);
				query.setFirstResult(rownum);
				query.setMaxResults(-1);
				data=query.list();
				}
		
			return data;
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
		return null;
		
	}
public List<User> findUserdata(int rownum) {
		
		try{
			Session session = sessionFactory.getCurrentSession();
			rownum*=12;
			Query query=session.createQuery("from User order by userid desc").setCacheable(true);
			query.setFirstResult(rownum);
			query.setMaxResults(12);
			List<User> data=query.list();
			if(data==null){
				query=session.createQuery("from User order by userid desc").setCacheable(true);
				query.setFirstResult(rownum);
				query.setMaxResults(-1);
				data=query.list();
			}
		
			return data;
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
		return null;
		
	}
public List<Data> afindData(int rownum) {
		
		try{
			Session session = sessionFactory.getCurrentSession();
			rownum*=12;
			Query query=session.createQuery("from Data order by dataid desc").setCacheable(true);
			query.setFirstResult(rownum);
			query.setMaxResults(12);
			List<Data> data=query.list();
			if(data==null){
				query=session.createQuery("from Data order by dataid desc").setCacheable(true);
				query.setFirstResult(rownum);
				query.setMaxResults(-1);
				data=query.list();
				}
		
			return data;
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
		return null;
		
	}
public List<Comment> findComment(int rownum,int blogid) {
	   List<Comment> comments=null;
		try{
			Session session = sessionFactory.getCurrentSession();
			rownum*=5;
			Query query=session.createQuery("from Comment where dataid = ? order by commentid desc").setCacheable(true);
			query.setParameter(0, blogid);
			query.setFirstResult(rownum);
			query.setMaxResults(5);
			comments=query.list();
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
		return comments;
		
	}
	//得到用户名
	public String getUserName(int userid) {
		
		try{
			Session session = sessionFactory.getCurrentSession();
			
			User user=(User) session.get(User.class, userid);
			if(user!=null){
				return user.getUsername();
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return null;
		
	}

	public List<Data> findUserData(int rownum,int userid) {
		
		try{
			Session session = sessionFactory.getCurrentSession();
			
			rownum*=12;
			Query query=session.createQuery("from Data where userid = ? order by dataid desc").setCacheable(true);
			query.setParameter(0, userid);
			query.setFirstResult(rownum);
			query.setMaxResults(12);
			List<Data> data=query.list();
			
//			if(data==null){
//				query=session.createQuery("from Data order by dataid desc").setCacheable(true);
//				query.setFirstResult(rownum);
//				query.setMaxResults(-1);
//				data=query.list();
//				}
			
			return data;
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return null;
		
	}
	  //插入提交博客的内容
		public boolean insertData(Data data) {
			
			try{
				Session session = sessionFactory.getCurrentSession();
				session.save(data);
				
				return true;
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return false;
			
		}
	public boolean insertcomment(Comment comment) {
			
			try{
				Session session = sessionFactory.getCurrentSession();
				session.save(comment);
				
				return true;
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return false;
			
		}
	    //删除博客信息：
		public boolean deleteData(int dataid) {
			
			try{
				Session session = sessionFactory.getCurrentSession();
				Data data=(Data) session.get(Data.class, dataid);
				session.delete(data);
				
				return true;
				
			}catch(Exception e){
			
				e.printStackTrace();
				}
			return false;
			
			
		}
        public boolean deleteUser(int userid) {
			
			try{
				Session session = sessionFactory.getCurrentSession();
				User user=(User) session.get(User.class, userid);
				session.delete(user);
				
				return true;
				
			}catch(Exception e){
			
				e.printStackTrace();
			}
			return false;
			
			
		}
	  //显示博客内容：
		public Data showbo(int dataid) {
		
			try{
				Session session = sessionFactory.getCurrentSession();
				Query query=session.createQuery("from Data where dataid = ?").setCacheable(true);
				query.setParameter(0, dataid);
				List<Data> list=query.list();
				for(Data data:list){
					return data;
				}
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return null;
		}

		public boolean updateboke(Data data) {
		
			try{
				Session session = sessionFactory.getCurrentSession();
				
				session.update(data);
				
				return true;
			
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return false;
		}

		public List<Message> findSendMessage(int rownum, int userid) {
			try{
				Session session = sessionFactory.getCurrentSession();
				
				rownum*=12;
				Query query=session.createQuery("from Message where sendid = ? order by messageid desc").setCacheable(true);
				query.setParameter(0, userid);
				query.setFirstResult(rownum);
				query.setMaxResults(12);
				List<Message> data=query.list();
				
				if(data==null){
					query=session.createQuery("from Data order by dataid desc").setCacheable(true);
					query.setFirstResult(rownum);
					query.setMaxResults(-1);
					data=query.list();
					}
				
				return data;
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return null;
		}

		public List<Message> findAcceptMessage(int rownum, int acceptid) {
			try{
				Session session = sessionFactory.getCurrentSession();
				
				rownum*=12;
				Query query=session.createQuery("from Message where acceptid = ? order by messageid desc").setCacheable(true);
				query.setParameter(0, acceptid);
				query.setFirstResult(rownum);
				query.setMaxResults(12);
				List<Message> data=query.list();
				
				if(data==null){
					query=session.createQuery("from Data order by dataid desc").setCacheable(true);
				    query.setFirstResult(rownum);
				    query.setMaxResults(-1);
					data=query.list();
					}
			
				return data;
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return null;
		}

		public int findacceptid(String acceptname) {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User where username = ? ").setCacheable(true);
			query.setParameter(0, acceptname);
			List<User> users=query.list();
			for(User user:users){
				return user.getUserid();
			}
			return 0;
		}

		public boolean insertMessage(Message message) {
			try{
				Session session = sessionFactory.getCurrentSession();
				session.save(message);
				return true;
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return false;
		}

		public Message showMessage(int messageid) {
			try{
				Session session = sessionFactory.getCurrentSession();
				Query query=session.createQuery("from Message where messageid = ?").setCacheable(true);
				query.setParameter(0, messageid);
				List<Message> list=query.list();
				for(Message message:list){
					return message;
				}
				
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return null;
		}

		public boolean findaUsername(String username) {
			try{
				Session session = sessionFactory.getCurrentSession();
			
				Query query=session.createQuery("from Auser where username = ?").setCacheable(true);
				query.setParameter(0, username);
			    List<Auser> list=query.list();
			    for(Auser user:list){
			    	if(user!=null){
			    		return true;
			    	}
			    }
			  
			}catch(Exception e){
				
				e.printStackTrace();
			}
			return false;
		}

	
		
	

	

	

	

}
