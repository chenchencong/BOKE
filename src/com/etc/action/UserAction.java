package com.etc.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.etc.entity.Data;
import com.etc.entity.User;
import com.etc.service.UserService;
import com.etc.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserAction extends BaseAction implements ModelDriven<User>{

	
	private User user = new User();
	private String valCode;
	private String targetPage;
	private int rownum;
	
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	

	public String exitlogin(){
		session.remove("user");
		targetPage="index.jsp";
		return Action.SUCCESS;
		
	}
	
	public String uidrop(){
		   Map<String,Object> session =ActionContext.getContext().getSession();
	        User user=(User) session.get("user");
	        if(user==null){
	        	HttpServletResponse response = ServletActionContext.getResponse();
	    		response.setCharacterEncoding("UTF-8");  
	    		response.setContentType("text/plain; charset=utf-8"); 
	    		response.setHeader("pragma", "no-cache");
	    		response.setHeader("cache-control", "no-cache");
	    		response.setHeader("expires", "0");
	    		try {
					PrintWriter out = response.getWriter();
					out.append("ss");
					if (out!=null) 
		 			    out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		 
	        }
	       
			return null;
		
	}
	
	
	
	public String login() throws IOException {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/plain; charset=utf-8"); 
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		
		PrintWriter out = response.getWriter();
		
		user = userService.login(user.getUsername(), user.getPassword());
		
		if(user!=null){   
			session.put("user", user);
			out.write("");
		}else{
			 
			out.write("用户名或密码错误");
		}
		if (out != null) 
		    out.close();  
		
		return null;

	}

	
	
	
	public String register() throws Exception {
		     
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/plain; charset=utf-8"); 
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		PrintWriter out = response.getWriter();
		String tag="";
		String valCodeInSession = (String) session.get("valCodeInSession");
		if(!(valCodeInSession.equalsIgnoreCase(valCode))){
			tag+="s";
		}

		if(userService.checkUsername(user.getUsername())){
			tag+="ss";
		}
		if(tag!=""){
			System.out.println(tag);
			out.write(tag);
			if (out!= null) 
			    out.close();  
			return null;
		}
		user = userService.register(user);
		if(user!=null){  
			session.put("user", user);
			out.write("");
			
		}else{
			tag="ssssss";
			System.out.println(tag);
			out.write(tag);
		}
		
		if (out!=null) 
		    out.close();  
		return null;
	}
     
	
	public String  iLoading() throws IOException{
	
		System.out.println(rownum);
		List<Data> list=userService.iLoading(rownum);
		List<String> username = null;
		
		if(list!=null) {
			username=new ArrayList<String>();
			for(int i=0;i<list.size();i++){
				username.add(userService.getUserName(list.get(i).getUserid()));
		    }
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			PrintWriter out = response.getWriter();
			JSONObject jsonObject=new JSONObject();
		    Map<String,Object> res = new HashMap<String,Object>();
		    res.put("data",list);
			res.put("username",username);
			jsonObject=JSONObject.fromObject(res);
			out.append(jsonObject.toString()); 
		    	      
		    if (out != null) 
		    out.close();
		}  
		return null;
	}
  
    
	public String uiLoading() throws IOException{
		
		System.out.println(rownum);
		List<Data> userlist=userService.uiLoading(((User)session.get("user")).getUserid(),rownum);
		if(userlist!=null){
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			PrintWriter out = response.getWriter();
		    JSONArray jsonObject=new JSONArray();
		    
		    jsonObject=JSONArray.fromObject(userlist);
			out.append(jsonObject.toString()); 
		    	      
		    if (out != null) 
		    out.close();  
			
		}
		return null;
	}
	

	public String getTargetPage() {
		return targetPage;
	}

	public void setTargetPage(String targetPage) {
		this.targetPage = targetPage;
	}


	public User getModel() {
		return user;
	}

	public String getValCode() {
		return valCode;
	}

	public void setValCode(String valCode) {
		this.valCode = valCode;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}


}


