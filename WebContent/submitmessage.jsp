<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎进入博客</title>
<link rel="stylesheet" type="text/css" href="css_submitmessage.css" />
<script type="text/javascript" src="AjaxRequest1.js" ></script> 
<script type="text/javascript">

var userid=${sessionScope.user.userid};
</script>
<script type="text/javascript" src="js_submitmessage.js" ></script> 
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
                 <a  href="userindex.jsp">用户主页</a>
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
        

   <div class="cetersubmit">
	    
	<div class="bigbox">
		



		<form  action="message_submitMessage" method="post" onsubmit="return checkinfo()">
			<div class="b">
				   
					<div class="b_word">发送人</div> 
					
					<input class="wenben" id="title" type="text"  onblur="checknames()"  />
					<div id="messageprompt"class="messageprompt"></div>
					 <div class="b_word">留言内容</div> 

					<textarea id="article"class="zhengwen" rows="3" cols="20" name="content"></textarea>
				      <div class="sr">
				    <input type="submit" class="submit"value="立即提交" /><input type="reset" class="abandon"value="舍弃" />
				    <div id="successorfail"class="successorfail"></div>
				    </div>
			</div>
		</form>
	</div>
   </div>
  

	
		<div class="footer">
			<div class="links">
				<a hidefocus="true" href="404">关于博客</a> | <a hidefocus="true"
					href="404">广告服务</a> | <a hidefocus="true" href="404">版权指引</a> | <a
					hidefocus="true" href="404">推广合作</a> | <a hidefocus="true"
					href="404">用户服务协议</a> | <a hidefocus="true" href="404">免责信息</a>
			</div>
			<div class="copyright">
				<p>我们致力于传播正确的信息,广告合作联系网站管理员</p>
				<p>信息网络传播视听节目许可证 888888 增值电信业务经营许可证粤B1-111111111</p>
				 <p>
					Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;2004-2016 BoKe-Inc.All
					Rights Reserved <a hidefocus="true" class="office-verification"
						href="http://netadreg.gzaic.gov.cn/ntmm/WebSear/WebLogoPub.aspx?logo=440106106022006022000209"
						target="_blank"></a>
				</p> 
			</div>
		</div>


	${actionErrors[0]}

</body>
</html>