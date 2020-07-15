            function onerror(){
		    	alert("网络有误，请稍后再试！");
		    }
		    function getInfo(param){
		    	var loader=new net.AjaxRequest("admin_alogin",deal_getInfo,0,"POST",param);
		    }
		    function deal_getInfo(){
		    	var info=this.req.responseText;
		    	console.log("aaa"+info.toString());
		    	if(info!=""){
					var erruser = document.getElementById("err_tip");
					var errtip=document.getElementById("error_con");
					var lab=document.getElementById("lab1");
						errtip.innerHTML=info.toString();
						erruser.style.display="block";
						lab.className="labs";
		    	}else{
		    		window.location.href="adminindex.jsp";
		    	}
		    	
		    }
             
			function checkInfo(){
				var username =document.getElementById("user");
				var password=document.getElementById("pwd");
				
				var erruser = document.getElementById("err_tip");
				var errtip=document.getElementById("error_con");
				var lab=document.getElementById("lab1");
				var lab2=document.getElementById("lab2");
				if(username.value==""||username.value==null){					
					errtip.innerHTML="用户名不能为空，请重新输入！";
					erruser.style.display="block";
					lab.className="labs";
					return false;
				}else{
					if(password.value==""||username.value==null){
						errtip.innerHTML="密码不能为空！";
						erruser.style.display="block";
						lab2.className="labs";
						return false;
					}
					
				}
				
					
				var param="username="+username.value+"&password="+password.value;
				getInfo(param);
				return false;
					
				
			}
			
			function changeStyle(event){
				  var erruser = document.getElementById("err_tip");
				  if(window.event&&erruser.style.display=="block"){
				  	var lab=document.getElementById("lab1");
				  	var lab2=document.getElementById("lab2");
				  	erruser.style.display="none";
				    lab.className="lab";
				    lab2.className="lab";
				  }else if(event.which&&erruser.style.display=="block"){
				  	var lab=document.getElementById("lab1");
				  	var lab2=document.getElementById("lab2");
				  	erruser.style.display="none";
				    lab.className="lab";
				    lab2.className="lab";
				  }
				  return true ;
					
			}
			
//			function changeStyle1(event){
//				  var erruser = document.getElementById("err_tip");
//				  if(window.event&&erruser.style.display=="block"){
//				  	var lab=document.getElementById("lab1");
//				  	erruser.style.display="none";
//				    lab.className="lab";
//				   
//				  }else if(event.which&&erruser.style.display=="block"){
//				  	var lab=document.getElementById("lab1");
//				  	erruser.style.display="none";
//				    lab.className="lab";
//				    lab2.className="lab";
//				  }
//				  return true ;
//					
//			}
			
			
		   function clicks(){
		     	var user =document.getElementById("user");
		     	var erruser = document.getElementById("err_tip");
		     	if(user.value==""&&erruser.style.display=="block"){
		     		var lab=document.getElementById("lab1");
				  	erruser.style.display="none";
				    lab.className="lab";
		     		
		     	}
		     	
		     }