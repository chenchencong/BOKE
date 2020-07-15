<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta name ="viewport" content="width=device-width,initial-scale=1.0">
		<meta charset="utf-8" />
		<title>欢迎进入博客</title>
	 <script type="text/javascript" src="js_register.js" ></script>
	 <script type="text/javascript" src="AjaxRequest1.js" ></script>
	 <link rel="stylesheet"  type="text/css"  href="register.css"/>	
	</head>
	<body>
		
		<div class="outer">
			<div class="out">
				<div class="f1">
					
						<div class="f111">
							<!-- <img src="img/u.jpg" alt="wrong" class="imgf111" /> -->
						</div>
						<div class="f112"><h4 class="f112h4">注册<!--  <span class="x">boker</span> -->账号</h4></div>
					
				</div>
					
				
				<div class="center">	
					
					
						<form  >
					
						
							
						<div class="f21">
							<label class="lab1" id="lab3"onclick="clicks2()">
										<input type="text" placeholder="请输入用户名" id="username"class="tel"name="username" 
											 onkeydown="return changeStyle2(event)"  />
							</label>
							
					    </div>
		
		
		                <div class="err_tip" id="err_tip2">
				  	
				  		            <em class="icon_error"></em>
				  		            <span class="error_con" id="error_con2"></span>
				  	
				  		</div>
		
						
							
								
								
						        <div class="f22">
									<label class="lab1" id="lab1" onclick="clicks()">
										<input type="password" placeholder="请输入密码" id="passward"class="tel"name="password" 
											  onkeydown="return changeStyle(event)" />
									</label>
								</div>
								
								
								<div class="err_tip" id="err_tip">
				  	
				  		            <em class="icon_error"></em>
				  		            <span class="error_con" id="error_con"></span>
				  	
				  				</div>
								
								
								
								
								
								 <div class="f22">
									<label class="lab1" id="lab4" onclick="clicks4()">
										<input type="password" placeholder="确认密码" id="qrpassward"class="tel"name="password" 
											  onkeydown="return changeStyle3(event)" />
									</label>
								</div>
								
								
								<div class="err_tip" id="err_tip3">
				  	
				  		            <em class="icon_error"></em>
				  		            <span class="error_con" id="error_con3"></span>
				  	
				  				</div>
								
								
								
								
								
								
								<div class="ss">
								 	<div class="checkimg">
								 		<label class="lab2" id="lab2" onclick="clicks1()">
						                	<input class="code" type="text" id="imgid"autocomplete="off" placeholder="图片验证码"onkeydown="return changeStyle1(event)" name="valCode"/>
						      			</label>
						      			<img id="img"alt="图片验证码"  title="看不清换一张" class="img" src="ValcodeAction" onclick="this.src = this.src + '?' ">
						      			
						      			
						      			
								 	</div>
							 	</div>
							 	
							 	
							 	<div class="err_tip" id="err_tip1">
				  	
				  		            <em class="icon_error"></em>
				  		            <span class="error_con" id="error_con1"></span>
				  	
				  				</div>
							 	
							 	
							 	
							 	
							 	
							 	
								<div class="f23">
										  
									<input class="sub" id="submit" type="button" value="立即注册" onmouseover="changS()" onmouseout="changsbm()" 
									onclick="checkInfo()"
									/>
										  
								</div>
								
								
								</form>
								
							<!--
					        	作者：offline
					        	时间：2016-09-06
					        	描述：3
					        -->
							<div class="f3">
								<span class="warning">点击“立即注册”，即表示您同意并愿意遵守 <a class="f231a1"href="none">用户协议</a>和
									<a class="f231a2"href="none">隐私政策</a>
								</span>
							</div>
						
					</div>
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
	</div>
	</body>
</html>































