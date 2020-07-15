<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta property="wb:webmaster" content="26684da7fb4885d5" />
<meta charset="utf-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>欢迎进入博客</title>
<link rel="stylesheet" type="text/css" href="css_showboke.css" />
<script type="text/javascript" src="AjaxRequest1.js"></script>
<script type="text/javascript">

var blogid=${sessionScope.data.dataid};

window.onload=function(){
	
	getInfo();
	
}

</script>
<script type="text/javascript" src="js_showboke.js"></script>
</head>
<body>


	<div class="header">
		<div style="float: left; height: 78px; line-height: 78px;">
			<img class="imgtitle" src="img/title.jpg"></img>
		</div>
		<div class="topNav">

			<c:if test="${sessionScope.user==null}">
				<a href="register.jsp">注册</a>
				<a href="login.jsp">登录</a>
			</c:if>
			<c:if test="${sessionScope.user!=null}">
				<a href="user_exitlogin">退出登录</a>
				<a href="userindex.jsp">欢迎${sessionScope.user.username}</a>
			</c:if>
			<span class="userindex" onclick="uidrop()">用户主页</span> <span
				id="uidropwarning" class="uidropwarning"></span>
		</div>
	</div>

	<div class="navWrap">
		<div class="nav">
			<ul class="homeNav">
				<li style="background: #0c8ed9"><a class="normal"
					href="index.jsp">首页</a></li>
				<li><a class="normal" href="####">专题中心</a></li>
				<li><a class="normal" href="####">最新文章</a></li>
				<li style="float: right; padding: 0;"><a class="normal"
					style="padding-left: 5px; padding-right: 5px;">申请加入</a></li>

			</ul>
		</div>
	</div>

	<div class="center">

		<div class="article">
			<div class="shangbu">
				<div class="title">
					<span class="wenben">${sessionScope.data.title}</span>
				</div>
				<div class="secongtitle">
					<span class="time">2016-12-16 08:58:01</span>
				</div>

				<div class="share">
					<div class="bshare-custom icon-medium-plus">
						<a title="分享到" href="http://www.bShare.cn/" id="bshare-shareto"
							class="bshare-more">分享到</a> <a title="分享到新浪微博"
							class="bshare-sinaminiblog"></a> <a title="分享到腾讯微博"
							class="bshare-qqmb"></a> <a title="分享到QQ空间" class="bshare-qzone"></a>
						<a title="分享到微信" class="bshare-weixin"></a> <a title="更多平台"
							class="bshare-more bshare-more-icon more-style-addthis"></a>
					</div>
					<script type="text/javascript" charset="utf-8"
						src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=2&amp;lang=zh"></script>
					<script type="text/javascript" charset="utf-8"
						src="http://static.bshare.cn/b/bshareC0.js"></script>
				</div>
			</div>
			<pre class="page">${sessionScope.data.content}</pre>
		</div>
	</div>

	<div class="comment_outer">
		<div class="comment_inner">
		   <c:if test="${sessionScope.user==null}">
			<div class="tishi">
				<div class="tishin">
				   <span class="txt">
				         目前您尚未登录，请
				   <a href="login.jsp">登录</a>
				         或
				   <a href="register.jsp">注册</a>
				         后进行评论
				   </span>
				</div>
			</div>
		   </c:if>
		    <c:if test="${sessionScope.user!=null}">
		    <script type="text/javascript">
		    var userid=${sessionScope.user.userid};
		    </script>
			<form id="submitcomment" action="comment_submit" method="post" class="form">

				<textarea id="content" class="comment" rows="3" cols="20"
					name="content"></textarea>
				<div class="sr">
					<input type="reset" class="abandon" value="舍弃" />
					<div class="submit" onclick="subcomment()" > 提交 </div>
				</div>

			</form>
            </c:if>
			<ul id="ul" class="ul">
				<!-- <li class="li">
					 <div class="litop">
						<a class="username">azhafsddh</a><span>评论</span>
					</div>
					<p class="showcomment">网站简介：企博网（www.bokee.net）是基于职业社交关系和高质量内容的社会化
						电子商务营销平台.人脉,编织你的个人商务人脉网络;企业博客,宣传...</p> 

				</li> -->
			</ul>
			<div id="nonedata" class="nonedata" onclick="down()"></div>




		</div>
	</div>






	<div class="footer">
		<div class="links">
			<a hidefocus="true" target="_blank" href="404">关于博客</a> | <a
				hidefocus="true" target="_blank" href="404">广告服务</a> | <a
				hidefocus="true" target="_blank" href="404">版权指引</a> | <a
				hidefocus="true" target="_blank" href="404">推广合作</a> | <a
				hidefocus="true" target="_blank" href="404">用户服务协议</a> | <a
				hidefocus="true" target="_blank" href="404">免责信息</a>
		</div>
		<div class="copyright">
			<p>我们致力于传播正确的信息,广告合作联系网站管理员</p>
			<p>信息网络传播视听节目许可证 888888 增值电信业务经营许可证粤B1-111111111</p>
			<p>
				Copyright&nbsp;&nbsp;&copy;&nbsp;&nbsp;2004-2016 BoKe-Inc.All Rights
				Reserved <a hidefocus="true" class="office-verification"
					href="http://netadreg.gzaic.gov.cn/ntmm/WebSear/WebLogoPub.aspx?logo=440106106022006022000209"
					target="_blank"></a>
			</p>
		</div>
	</div>
</body>
</html>
