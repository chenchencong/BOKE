package com.etc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.etc.entity.Auser;
import com.etc.entity.Data;
import com.etc.entity.User;
import com.etc.service.UserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AdminAction extends BaseAction implements ModelDriven<Auser>{
	private Auser user = new Auser();
	private String valCode;
	private String targetPage;
	private int dataid;
	private int duserid;
	
	private int rownum;
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String deletedata() throws Exception {
    	  
	    	
			if(userService.deleteData(dataid) ){
			
				targetPage="adminindex.jsp";
				return Action.SUCCESS;
				
			}else{
				targetPage="adminindex.jsp";
				 this.addActionError("<script>alert('对不起，删除失败！');</script>");
				 return Action.ERROR;
				
			}
			
		
		}
	public String deleteuser() throws Exception {
  	  
    	
		if(userService.deleteUser(duserid) ){
		
			targetPage="adminindexu.jsp";
			return Action.SUCCESS;
			
		}else{
			targetPage="adminindexu.jsp";
			 this.addActionError("<script>alert('对不起，删除失败！');</script>");
			 return Action.ERROR;
			
		}
		
	
	}
	
	public void  aiLoading() throws IOException{
		
		System.out.println(rownum);
		List<Data> list=userService.aiLoading(rownum);
		
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			PrintWriter out = response.getWriter();
            JSONArray jsonObject=new JSONArray();
		    
		    jsonObject=JSONArray.fromObject(list);
			out.append(jsonObject.toString()); 
		    if (out != null) 
		    out.close();
		
		
	}
    public void  auserLoading() throws IOException{
		
		System.out.println(rownum);
		 List<User> list=userService.auserLoading(rownum);
		
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			PrintWriter out = response.getWriter();
            JSONArray jsonObject=new JSONArray();
		    
		    jsonObject=JSONArray.fromObject(list);
			out.append(jsonObject.toString()); 
		    if (out != null) 
		    out.close();
		
		
	}
  
public String alogin() throws IOException {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/plain; charset=utf-8"); 
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		
		PrintWriter out = response.getWriter();
		
//		System.out.println(user.getUsername()+""+user.getPassword());
//		System.out.println(request.get("username")+""+request.get("password"));
		
		user = userService.alogin(user.getUsername(), user.getPassword());
		
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

	
	
	
	public String aregister() throws Exception {
		     
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/plain; charset=utf-8"); 
		
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		
		PrintWriter out = response.getWriter();
		String tag="";
		
		String valCodeInSession = (String) session.get("valCodeInSession");
	    System.out.println(valCode+"验证码"+valCodeInSession+user.getUsername()+user.getPassword());
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
		
		user = userService.aregister(user);
		
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

	public Auser getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public String getTargetPage() {
		return targetPage;
	}

	public void setTargetPage(String targetPage) {
		this.targetPage = targetPage;
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
	public int getDataid() {
		return dataid;
	}
	public void setDataid(int dataid) {
		this.dataid = dataid;
	}
	public int getDuserid() {
		return duserid;
	}
	public void setDuserid(int duserid) {
		this.duserid = duserid;
	}

}
