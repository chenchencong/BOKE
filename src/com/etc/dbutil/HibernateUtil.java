package com.etc.dbutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static{
		
		//创建配置对象
		Configuration configuration = new Configuration().configure();
		
		//创建服务注册对象(Hibernate 4.0新增)
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		//创建session工厂对象
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
	}
	
	//获取session对象
	public Session getSession(){
		//通过session工厂获取session对象
		Session session=sessionFactory.openSession();
		System.out.println("session hashCode"+session.hashCode());
		return session;
	}
	
	//步骤1---构造方法私有化
	private HibernateUtil(){
	}

	//步骤2---内部定义一个单一的实例
	//private static HibernateUtil instance = new HibernateUtil();
	private static HibernateUtil instance = null;
	
	//对外提供方法，返回单一的实例
	public static HibernateUtil getInstance(){
		
		//return instance;
		
		if(instance==null){
			 instance = new HibernateUtil();
		}
		
		return instance;
			 
	}
	
}
