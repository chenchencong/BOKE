<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="AjaxRequest1.js" charset="gbk"></script>

<script type="text/javascript">

  function onerror(){
	alert("加载有误");
  }
  function getInfo(){
	var loader=new net.AjaxRequest("user_test.action",deal_getInfo,0,"GET");
  }
  function deal_getInfo(){
  	
    document.getElementById("show").innerText=this.req.responseText;
  }

</script>
</head>
<body>
action="data_updateboke"
 value="${sessionScope.correctdata.title}
 ${sessionScope.correctdata.content}
 <a href="javascript:getInfo()">ceshi</a>
<a href="user_test.action">ceshi</a>
<p id="show"></p>

</body>
</html>