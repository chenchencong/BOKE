        
           function onerror(){
		    	alert("网络有误，请稍后再试！");
		    }
		    function getInfo(param){
		    	var loader=new net.AjaxRequest("user_register.action",deal_getInfo,onerror,"POST",param);
		    }
		    function deal_getInfo(){
		    	var info=this.req.responseText;
		    	if(info!=""){
		    		switch(info){
		    		case "s":ajaxwarningimgid();break;
		    		case "ss": ajaxwarningusername();break;
		    		case "sss":ajaxwarningusername();ajaxwarningimgid();break;
		    		case "ssssss":alert("注册失败，请稍后再试！");break;
		    		}
		    	}else{
		    		window.location.href="index.jsp";
		    	}
		    	
		    }
		    
		    function ajaxwarningusername(){
		    	var erruser2 = document.getElementById("err_tip2");
			    var errtip2=document.getElementById("error_con2");
			    var lab=document.getElementById("lab3");
				errtip2.innerHTML="用户名已存在！";
				erruser2.style.display="block";
				lab.className="lab1s";
		    }
		    function ajaxwarningimgid(){
		    	var erruser1 = document.getElementById("err_tip1");
			    var errtip1=document.getElementById("error_con1");
			     var lab=document.getElementById("lab2");
				errtip1.innerHTML="验证码错误！";
				erruser1.style.display="block";
				lab2.className="lab2s";
		    }
		    

		 function checkInfo(){
				var userpassward =document.getElementById("passward");
				var imgid =document.getElementById("imgid");
				var name=document.getElementById("username");
				var qrpassward=document.getElementById("qrpassward");
				var tag=true;
				
				if(name.value==""||name.value==null){					
					var erruser2 = document.getElementById("err_tip2");
				    var errtip2=document.getElementById("error_con2");
				    var lab=document.getElementById("lab3");
					errtip2.innerHTML="用户名不能为空，请输入！";
					erruser2.style.display="block";
					lab.className="lab1s";
					tag=false;
				}
				
				if(userpassward.value==""||userpassward.value==null){					
					var erruser = document.getElementById("err_tip");
				    var errtip=document.getElementById("error_con");
				    var lab=document.getElementById("lab1");
					errtip.innerHTML="密码不能为空，请输入！";
					erruser.style.display="block";
					lab.className="lab1s";
					tag=false;
				}
				
				
               if(imgid.value==""||imgid.value==null){					
					
					var erruser1 = document.getElementById("err_tip1");
				    var errtip1=document.getElementById("error_con1");
				     var lab=document.getElementById("lab2");
					errtip1.innerHTML="请输入验证码";
					erruser1.style.display="block";
					lab2.className="lab2s";
					tag=false;
				}
				
				if(qrpassward.value==""||qrpassward.value==null){
					
					  var erruser = document.getElementById("err_tip3");
					  var errtip=document.getElementById("error_con3");
					  var lab=document.getElementById("lab4");
						errtip.innerHTML="确认密码不能为空，请输入！";
						erruser.style.display="block";
						lab.className="lab1s";
						tag=false;
				}else{
					var a=qrpassward.value;
					var b=userpassward.value;
					if(a!=b){
						
						var erruser = document.getElementById("err_tip3");
						var errtip=document.getElementById("error_con3");
						var lab=document.getElementById("lab4");
					    errtip.innerHTML="密码不匹配！";
						erruser.style.display="block";
						lab.className="lab1s";
						tag=false;
					}
				}
				
				if(tag==true){
				var param="username="+name.value+"&password="+userpassward.value+"&valCode="+imgid.value;
				getInfo(param)
				}else{
					var img=document.getElementById("img");
					img.onclick();
				}
				
				
			
		 }
				
				
					
					
				
							
						
		 
		 
		
		     function changeStyle(event){
				  var erruser = document.getElementById("err_tip");
				  var erruser2=document.getElementById("err_tip3");
				  if(window.event&&erruser.style.display=="block"){
				  	var lab=document.getElementById("lab1");
				  	erruser.style.display="none";
				    lab.className="lab1";
				  }else if(event.which&&erruser.style.display=="block"){
				  	var lab=document.getElementById("lab1");
				  	erruser.style.display="none";
				    lab.className="lab1";
				  }else if(window.event&&erruser2.style.display=="block"){
						var lab=document.getElementById("lab4");
					  	erruser2.style.display="none";
					    lab.className="lab1";
				  }else if(event.which&&erruser2.style.display=="block"){
					    var lab=document.getElementById("lab4");
					  	erruser2.style.display="none";
					    lab.className="lab1";
				  }
				  return true ;
					
				}
		     
		     function changeStyle3(event){
				  var erruser = document.getElementById("err_tip3");
				  if(window.event&&erruser.style.display=="block"){
				  	var lab=document.getElementById("lab4");
				  	erruser.style.display="none";
				    lab.className="lab1";
				  }else if(event.which&&erruser.style.display=="block"){
				  	var lab=document.getElementById("lab1");
				  	erruser.style.display="none";
				    lab.className="lab1";
				  }
				  return true ;
					
				}
		     
			 function changeStyle2(event){
				  var erruser = document.getElementById("err_tip2");
				  if(window.event&&erruser.style.display=="block"){
				  	var lab=document.getElementById("lab3");
				  	erruser.style.display="none";
				    lab.className="lab1";
				  }else if(event.which&&erruser.style.display=="block"){
				  	var lab=document.getElementById("lab3");
				  	erruser.style.display="none";
				    lab.className="lab1";
				  }
				  return true ;
					
				}
		     function changeStyle1(event){
				  var erruser = document.getElementById("err_tip1");
				  if(window.event&&erruser.style.display=="block"){
				  	var lab=document.getElementById("lab2");
				  	erruser.style.display="none";
				    lab.className="lab2";
				  }else if(event.which&&erruser.style.display=="block"){
				  	var lab=document.getElementById("lab2");
				  	erruser.style.display="none";
				    lab.className="lab2";
				  }
				  return true ;
					
				}
		     
		  
		    
		     function clicks(){
		     	var userpassward =document.getElementById("passward");
		     	var erruser = document.getElementById("err_tip");
		     	if(userpassward.value==""&&erruser.style.display=="block"){
		     		var lab=document.getElementById("lab1");
				  	erruser.style.display="none";
				    lab.className="lab1";
		     	}
		     	
		     }
		     function clicks4(){
			     	var qrpassward =document.getElementById("qrpassward");
			     	var erruser = document.getElementById("err_tip3");
			     	if(qrpassward.value==""&&erruser.style.display=="block"){
			     		var lab=document.getElementById("lab4");
					  	erruser.style.display="none";
					    lab.className="lab1";
			     	}
			     	
			 }
		     
		       function clicks2(){
		     	var user =document.getElementById("username");
		     	var erruser = document.getElementById("err_tip2");
		     	if(user.value==""&&erruser.style.display=="block"){
		     		var lab=document.getElementById("lab3");
				  	erruser.style.display="none";
				    lab.className="lab1";
		     	}
		     	
		     }
		     function clicks1(){
		     	var imgid =document.getElementById("imgid");
		     	var erruser = document.getElementById("err_tip1");
		     	if(imgid.value==""&&erruser.style.display=="block"){
		     		var lab=document.getElementById("lab2");
				  	erruser.style.display="none";
				    lab.className="lab2";
		     	}
		     	
		     }
		     function changS(){
				var sbm = document.getElementById("submit");
				sbm.style.opacity = 0.6;
			}
			
			function changsbm(){
				var sbm = document.getElementById("submit");
				sbm.style.opacity = 1;
			}
		   
		