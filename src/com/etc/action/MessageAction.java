package com.etc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.etc.entity.Comment;
import com.etc.entity.Data;
import com.etc.entity.Message;
import com.etc.entity.User;
import com.etc.service.UserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

public class MessageAction extends BaseAction implements ModelDriven<Message>{
    private Message message=new Message();
    private int rownum;
    private UserService userService;
	private String targetPage;
	private String acceptname;
	private String showname;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	 public String showMessage(){
	    	message=userService.showMessage(message.getMessageid());
	    	if(message.getContent()!=null){
	    		session.put("showmessage",message.getContent());
	    		session.put("showname",showname );
	    		targetPage="showmessage.jsp";
	    		return Action.SUCCESS;
	    	}
	    	 targetPage="showmessage.jsp";
	    	 this.addActionError("加载失败");
	  	     return Action.ERROR;
	    	
	    }
	 
	public void checkacceptname() throws IOException{
		int acceptid=0;
		acceptid=userService.checkacceptname(acceptname);
		System.out.println(acceptid);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/plain; charset=utf-8"); 
		
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		
		PrintWriter out = response.getWriter();
		
			out.write(acceptid+"");
		
		if (out!= null) 
		    out.close();
	}
	public void submitMessage() throws IOException{
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/plain; charset=utf-8"); 
		
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		PrintWriter out = response.getWriter();
		System.out.println(message.getAcceptid());
		if(userService.submitMessage(message)){
			out.write("发送成功");
		}else{
			out.write("发送失败");
		}
		if (out!= null) 
		    out.close();
	}
	
    public String  sLoading() throws IOException{
    	
		System.out.println(rownum);
		List<Message> list=userService.sLoading(rownum,((User) session.get("user")).getUserid());
		List<String> username = null;
		
		if(list!=null) {
			username=new ArrayList<String>();
			for(int i=0;i<list.size();i++){
				username.add(userService.getUserName(list.get(i).getAcceptid()));
		    }
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			PrintWriter out = response.getWriter();
			JSONObject jsonObject=new JSONObject();
		    Map<String,Object> res = new HashMap<String,Object>();
		    res.put("message",list);
			res.put("name",username);
			jsonObject=JSONObject.fromObject(res);
			out.append(jsonObject.toString()); 
		    	      
		    if (out != null) 
		    out.close();
		} 
		return null;
	}
   public String  aLoading() throws IOException{
    	
		System.out.println(rownum);
		List<Message> list=userService.aLoading(rownum,((User) session.get("user")).getUserid());
		List<String> username = null;
		
		if(list!=null) {
			username=new ArrayList<String>();
			for(int i=0;i<list.size();i++){
				username.add(userService.getUserName(list.get(i).getSendid()));
		    }
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");  
			PrintWriter out = response.getWriter();
			JSONObject jsonObject=new JSONObject();
		    Map<String,Object> res = new HashMap<String,Object>();
		    res.put("message",list);
			res.put("name",username);
			jsonObject=JSONObject.fromObject(res);
			out.append(jsonObject.toString()); 
		    	      
		    if (out != null) 
		    out.close();
		} 
		return null;
	}
	public Message getModel() {
		// TODO Auto-generated method stub
		return message;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getTargetPage() {
		return targetPage;
	}
	public void setTargetPage(String targetPage) {
		this.targetPage = targetPage;
	}
	
	public String getAcceptname() {
		return acceptname;
	}
	public void setAcceptname(String acceptname) {
		this.acceptname = acceptname;
	}
	public String getShowname() {
		return showname;
	}
	public void setShowname(String showname) {
		this.showname = showname;
	}
	

}
