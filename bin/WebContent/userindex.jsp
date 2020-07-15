<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>欢迎进入博客</title>
		<link rel="stylesheet" type="text/css" href="userindex.css"/>
	 	<script type="text/javascript" src="AjaxRequest1.js" ></script>
		<script type="text/javascript" src="js_userindex.js" ></script> 
	
		
	</head>
	<body>
	

        <div class="header">
            <div style="float:left;height:78px;line-height:78px;">
				<img class="imgtitle" src="img/title.jpg"></img>
			</div>
            <div class="topNav">
                
                <c:if test="${sessionScope.user==null}">
	            <a href="register.jsp">注册</a>
                <a  href="login.jsp">登录</a>
                </c:if>
                <c:if test="${sessionScope.user!=null}">
                <a  href="user_exitlogin">退出登录</a>
	            <a  href="userindex.jsp">欢迎${sessionScope.user.username}</a>
                </c:if>
                 
            </div>
        </div>
        
        <div class="navWrap">
            <div class="nav">
                <ul class="homeNav">
                    <li style="background:#0c8ed9"><a class="normal" href="index.jsp">首页</a></li>
                    <li><a class="normal" href="####">专题中心</a></li>
                    <li><a class="normal" href="####">最新文章</a></li>
                    <li style="float:right;padding:0;"><a class="normal" style="padding-left:5px;
				padding-right:5px;" >申请加入</a></li>
                   
                </ul>
            </div>
        </div>
        

        <div class="outer">
			<div class="inner" id="inner">
			
		         <div class="user">
		             <div class="divuserimg" >
		             		<img  class="userimg" src="img/userimg.jpg"></img>
		             </div>
		             <div class="divuserinfo">
				             <div class="username">${sessionScope.user.username}的博客</div>
				              <div class="userinfo">
				              		<div class="information">未填写行业</div><span class="informationspan">|</span>
				                    <div class="information">未填写职位</div><span class="informationspan">|</span>
				                    <div class="information">未填写姓名</div><span class="informationspan">|</span>
				                    <div class="information"style="color:#444">中国</div><span class="informationspan">|</span>
				                    <div class="information">未填写姓名</div><span class="informationspan">|</span>
				                    <div class="information">未填写生日</div><span class="informationspan">|</span>
				              </div>
				               <div class="useroption">
				              		<a  class="option" href="submit.jsp">发表博客</a>
				              </div>
		             </div>
		         
		         </div>
			
			    
			<div class="center_right">
			     <div class="center_right_title" style="height:39px;width:auto;clear:both;
			     border-bottom:1px solid #dcdcdc;margin-bottom:4px">
			     <div class="center_right_title_gl"style="height:39px;width:102px; line-height:39px;" >博客管理</div>
                   <div class="center_right_title_gl" style="margin-top:5px;">信息管理</div>
              <div class="center_right_title_gl"style="margin-top:5px;">评论管理</div>
			     </div>
			    
				<ul id="ul"class ="ul">
	               <!--  <li class="li">
	                  <div class="li_left" style="float:left;height:35px;line-height:35px;overflow:hidden;">
	                  <a class="li_left_a" style="margin:0px;overflow:hidden;">dagdskgadlkgdsklgadsaa</a>
	                  </div>
	                   <div class="li_right" style="float:right;height:35px;line-height:35px;">
	                      <a class="deal">删除</a>
	                      <a class="deal">修改</a>
	                     
	                   </div>
	                </li> -->
	               
				
					
					
				</ul>
				
				<div>
					<div id="warning" style="width:860px;height:13px; font-size: 15px;color:#ff0000;
									   letter-spacing:3px;
									   font-weight:500;line-height:30px;
									   text-align: center;">
					</div>
					<div class="pageswitcher" style="width:860px;height:30px;background-color:#fff;border-radius: 8px;">
						<div style="width:50%;text-align:right;float:left;"> <a class="up" href="javascript:pageup()" 
						         style="width:100%;float:right;font-size:15px;line-height:30px;color:#757575;border-radius: 8px;text-decoration: none;
						         background-color: #f5f5f5;border:1px solid #dcdcdc;">
						         &lt;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
						</div>
						<div style="width:50%;text-align:left;float:right"> <a class="down"href="javascript:pagedown()" 
						         style="width:100%;float:left;font-size:15px;line-height:30px;color:#757575;border-radius: 8px;text-decoration: none;
						         background-color: #f5f5f5;border:1px solid #dcdcdc;">
						         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下一页&nbsp;&nbsp;&gt;</a>
						</div>
					</div>
				</div>
				</div>
			</div>
			
		</div>
		
		
		<!-- <div class="hfouter">
	    <div class="hfinner"> -->
            <div class="footer">
                <div class="links">
                    <a hidefocus="true" target="_blank" href="404" >关于博客</a> | 
                    <a hidefocus="true" target="_blank" href="404" >广告服务</a> | 
                    <a hidefocus="true" target="_blank" href="404">版权指引</a> | 
                    <a hidefocus="true" target="_blank" href="404">推广合作</a> | 
                    <a hidefocus="true" target="_blank" href="404">用户服务协议</a> | 
                    <a hidefocus="true" target="_blank" href="404">免责信息</a>
               </div>
                <div class="copyright">
                    <p>我们致力于传播正确的信息,广告合作联系网站管理员</p>
                    <p>信息网络传播视听节目许可证 888888 增值电信业务经营许可证粤B1-111111111</p>
                    <p>Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;2004-2016 BoKe-Inc.All Rights Reserved
                        <a hidefocus="true" class="office-verification" href="http://netadreg.gzaic.gov.cn/ntmm/WebSear/WebLogoPub.aspx?logo=440106106022006022000209" target="_blank"></a>
                    </p>
                </div>
            </div>
       <!--    </div>
         </div> -->
	</body>
</html>
