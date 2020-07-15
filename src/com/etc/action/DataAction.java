package com.etc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.etc.entity.Data;
import com.etc.entity.User;
import com.etc.service.UserService;
import com.etc.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class DataAction extends BaseAction implements ModelDriven<Data>{
	
	private Data data=new Data();
	private UserService userService;
	private String targetPage;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//提交博客
    public String submitbo() throws Exception {
    	data.setUserid(((User) session.get("user")).getUserid());
	    if(userService.submitbo(data)){
	    	targetPage="showboke.jsp";
    		session.put("data", data);
		return Action.SUCCESS;
	   }
	    this.addActionError("<script>alert('对不起，提交失败！');history.back()</script>");
	    //targetPage="submit.jsp";
	    return Action.ERROR;
	
	}
    //更新博客
    public String updateboke(){
    	data.setDataid(((Data)session.get("correctdata")).getDataid());
    	if(userService.updateboke(data)){
    		targetPage="showboke.jsp";
    		session.put("data", data);
    		return Action.SUCCESS;
    	}
    	 this.addActionError("<script>alert('对不起，更新失败！');history.back()</script>");
 	    targetPage="correct.jsp";
 	    return Action.ERROR;
    }
    //显示博客内容：
    public String showbo(){
    	data=userService.showbo(data.getDataid());
    	if(data!=null){
    		session.put("data",data);
    		targetPage="showboke.jsp";
    		return Action.SUCCESS;
    	}
    	 targetPage="showboke.jsp";
    	 this.addActionError("加载失败");
  	     return Action.ERROR;
    	
    }
     //删除博客信息
      public String delete() throws Exception {
    	  
    	/* System.out.println("delete");
    	  
    	HttpServletResponse response = ServletActionContext.getResponse();
  		response.setCharacterEncoding("UTF-8");  
  		response.setContentType("text/plain; charset=utf-8"); 
  		response.setHeader("pragma", "no-cache");
  		response.setHeader("cache-control", "no-cache");
  		response.setHeader("expires", "0");
		PrintWriter out = response.getWriter();*/
		//调用业务层的方法
		if(userService.deleteData(data.getDataid())){
			/*out.append("success");*/
			targetPage="userindex.jsp";
			return Action.SUCCESS;
			
		}else{
			targetPage="userindex.jsp";
			 this.addActionError("<script>alert('对不起，删除失败！');</script>");
			 return Action.ERROR;
			/*out.append("error");*/
		}
		/*if(out!=null){
			out.close();
		}*/
	
	}
    //correctjump
    public String correct(){
    	data=userService.showbo(data.getDataid());
    	if(data!=null){
    		session.put("correctdata",data);
    		targetPage="correct.jsp";
    		return Action.SUCCESS;
    	}
    	 targetPage="correct.jsp";
    	 this.addActionError("加载失败");
  	     return Action.ERROR;
    }
	
	

	public Data getModel() {
		return data;
	}
	public String getTargetPage() {
		return targetPage;
	}
	public void setTargetPage(String targetPage) {
		this.targetPage = targetPage;
	}
	

}