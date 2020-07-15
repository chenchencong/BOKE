package com.etc.interceptor;

import java.util.Map;

import javax.swing.Action;

import com.etc.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class myinterceptor extends AbstractInterceptor {

	
	public String intercept(ActionInvocation invocation) throws Exception {
        Map<String,Object> session =ActionContext.getContext().getSession();
        User user=(User) session.get("user");
        if(user!=null){
        	return invocation.invoke();
        }
		return "login";
	}

}