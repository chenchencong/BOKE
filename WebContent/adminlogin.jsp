<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta name ="viewport" content="width=device-width,initial-scale=1.0">
		<meta charset="utf-8" />
		<title>欢迎进入博客</title>
		<script type="text/javascript" src="AjaxRequest1.js" ></script>
		 <script type="text/javascript" src="js_adminlogin.js" ></script>
	 <link rel="stylesheet"  type="text/css"  href="css_adminlogin.css"/>	
	</head>
	<body>
		
		<div class="outer">
		<div class="out">
		<div class="f1">
			
				<div class="f111">
					<!-- <img src="img/u.jpg" alt="wrong" class="imgf111" /> -->
				</div>
				<div class="f112"><h4 class="f112h4"><!-- <span class="x">x</span>&nbsp; -->&nbsp;账号登录&nbsp;</h4></div>
			
			</div>
			
		
		
		<div class="f2">
			<form   >
			<div class="bu">
				
			<div class="f21">
				<label class="lab" id="lab1" onclick="clicks()">
				<input type="text"  class="user" id="user" placeholder="请输入用户名" onkeydown="return changeStyle(event)"/>
			    </label>
			</div>
			
	        <div class="f22">
					  <label class="lab" id="lab2" " >
					  	<input type="password" placeholder="请输入密码" id="pwd" onkeydown="return changeStyle(event)" />
					  </label></div>
		    </div>
				  
				  <div class="err_tip" id="err_tip">
				  		<em class="icon_error"></em>
				  		<span class="error_con" id="error_con"></span>
				  </div>
				  
					  <div class="f23">
					  	<input class="sub" type="button"  value="立即登录" onclick=" checkInfo()"/>
					  </div>
			</form>
			
		</div>
		<!--
        	作者：offline
        	时间：2016-09-06
        	描述：3
        -->
		<div class="f3">
			<a class="f231a1"href="adminregister.jsp">注册账号</a><span>|</span>
			<a class="f231a2 href="none" >忘记密码？</a>
			
		</div>
		</div>
		</div>
		
		<!--
        	作者：offline
        	时间：2016-09-07
        	描述：4
        -->
        
		<div class="f4">
		  <p> 简体&nbsp;|&nbsp; <a class="f4a1" href="" target="_blank">常见问题</a>
		  </p>
		  <p >x项目组版权所有<a class="f4a2" href="" target="_blank">天津师范大学</a>14级软件5班</p>
		</div>
	</body>
</html>































