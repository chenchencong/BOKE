var checkname=false;
var acceptid;
  function checkinfo(){
	var title=document.getElementById("title");
	var article=document.getElementById("article");
	var successorfail=document.getElementById("successorfail");
	if(!checkname){
		return false;
	}else{
		
		
		if(article.value==''){
			successorfail.innerHTML="留言内容不能为空";
			successorfail.style.color="#ff0000";
			successorfail.style.display="inline";
			return false;
		}else{
			
			var lader=new net.AjaxRequest("message_submitMessage?content="+article.value.toString()+
					"&sendid="+userid+"&acceptid="+acceptid,deal_submitmessage,errorsubmit,"post");
			return false;
		}
		
	}
	
	return false;
}
function deal_submitmessage(){
	var successorfail=document.getElementById("successorfail");
	var info=this.req.responseText;
	if(info=="发送成功"){
		successorfail.innerHTML="发送成功";
		successorfail.style.color="#009933";
		successorfail.style.display="inline";
		
	}else{
		successorfail.innerHTML="发送失败";
		successorfail.style.color="#ff0000";
		successorfail.style.display="inline";
		
	}
}
function errorsubmit(){
	var successorfail=document.getElementById("successorfail");
	successorfail.innerHTML="发送失败，请稍后再试";
	successorfail.style.color="#ff0000";
	successorfail.style.display="inline";
}


function checknames(){
	var title=document.getElementById("title");
	var lader=new net.AjaxRequest("message_checkacceptname?acceptname="+title.value,deal_checkname,errorcheckname,"GET");
}



function deal_checkname(){
	var messageprompt=document.getElementById("messageprompt");
	 acceptid=this.req.responseText;
	console.log(acceptid);
	if(acceptid!=0){
		messageprompt.innerHTML="验证成功";
		messageprompt.style.color="#009933";
		messageprompt.style.display="block";
		checkname=true;
	}else{
		messageprompt.innerHTML="验证失败，无此用户";
		messageprompt.style.color="#ff0000";
		messageprompt.style.display="block";
		checkname=false;
	}
}
function errorcheckname(){
	var messageprompt=document.getElementById("messageprompt");
	messageprompt.innerHTML="验证失败，请稍后再试";
	messageprompt.style.color="#ff0000";
	messageprompt.style.display="block";
}

