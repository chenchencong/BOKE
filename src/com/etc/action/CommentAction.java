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
import com.etc.entity.User;
import com.etc.service.UserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

public class CommentAction extends BaseAction implements ModelDriven<Comment>{
	
	private Comment comment=new Comment();
	private String targetPage;
	private int rownum;
	private  int blogid;
	
    public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String  cLoading() throws IOException{
		
		System.out.println(rownum);
		List<Comment> list=userService.cLoading(rownum,blogid);
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
		    res.put("comment",list);
			res.put("username",username);
			jsonObject=JSONObject.fromObject(res);
			out.append(jsonObject.toString()); 
		    	      
		    if (out != null) 
		    out.close();
		}  
		return null;
	}
	 public String submitcomment() throws Exception {
		 
		   HttpServletResponse response = ServletActionContext.getResponse();
			
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("text/plain; charset=utf-8"); 
			response.setHeader("pragma", "no-cache");
			response.setHeader("cache-control", "no-cache");
			response.setHeader("expires", "0");
			
			PrintWriter out = response.getWriter();
		    if(userService.submitcomment(comment)){
		    	out.write("发送成功");
		   }else{
			   out.write("发送失败");
		   }
		    if (out != null) 
			    out.close();  
		    return null;
		
		}
	public String getTargetPage() {
		return targetPage;
	}

	public void setTargetPage(String targetPage) {
		this.targetPage = targetPage;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public Comment getModel() {
		// TODO Auto-generated method stub
		return comment;
	}


  
}
