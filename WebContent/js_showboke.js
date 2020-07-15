
		    var rownum=0;
		    var nomoredata=false;
		   
		  
		    
            function subcomment(){
		    	var article=document.getElementById("content");
		    	
		    	if(article.value==''){
		    		alert("不能为空！");
		    	}else{
		    		var loader2=new net.AjaxRequest("comment_submitcomment?content="+article.value.toString()
		    				+"&userid="+userid+"&dataid="+blogid,submitcommentsuccess,submitcommenterror,"post");
		    	}
		    }
            function submitcommenterror(){
            	alert("提交失败");
            }
            
		    function onerror(){
	    	    var nonedata=document.getElementById("nonedata");
    		    nonedata.innerHTML="加载失败,重新尝试";
		    }
		    function getInfo(){
		    	
		    	var loader=new net.AjaxRequest("comment_cLoading?rownum="+rownum.toString()+"&blogid="+blogid,deal_getInfo,onerror,"GET");
		    	if(!nomoredata){
		    	var nonedata=document.getElementById("nonedata");
	    		nonedata.innerHTML="加载中......";
		    	}
		    }
		    function deal_getInfo(){
                var info=this.req.responseText;
		    	info=eval("("+info+")");
		    	/*console.log(info);
		    	console.log(info.data.length);*/
		    	if(info.comment.length!=0){
			    	var frag=document.createDocumentFragment();
			    	for(var i=0;i<info.comment.length;i++){
			    		
			    		var li=document.createElement("li");
			    		li.className="li";
			    		var divlitop=document.createElement("div");
			    		divlitop.className="litop";
			    	
			    		var ausername=document.createElement("a");
			    		ausername.className="username";
			    		ausername.innerText=info.username[i];
			    		
			    		var pshowcomment=document.createElement("p");
			    		pshowcomment.className="showcomment";
			    		pshowcomment.innerText=info.comment[i].content;
			    		
			    		
			    		
			    		divlitop.appendChild(ausername);
			    		li.appendChild(divlitop);li.appendChild(pshowcomment);
			    		
			    		frag.appendChild(li);
			    		
			    	}
			    	 var ul=document.getElementById("ul");
			    	   ul.appendChild(frag);
			    	  rownum++;
			    	  var nonedata=document.getElementById("nonedata");
			    		nonedata.innerHTML="下拉加载更多";
			    
		    	}else{
			    		var nonedata=document.getElementById("nonedata");
				    	nonedata.innerHTML="没有更多数据了";
			    		nomoredata=true;
		    	}
		    	
		    }
		    
		   function down(){
			  if(!nomoredata)
			   getInfo();
			   
		   }
		    
		    function uidrop(){
		    	var loader=new net.AjaxRequest("user_uidrop",deal_uidrop,0,"GET");
		    }
		    function deal_uidrop(){
		    	var info=this.req.responseText;
		    	if(info=="ss"){
		    		var spanwarning=document.getElementById("uidropwarning");
		    		spanwarning.innerHTML="请先登录！";
		    		spanwarning.style.display="block";
		    	}else{
		    		window.location.href="userindex.jsp";
		    	}
		    }

		 
		    function submitcommentsuccess(){
		    	/*var ul=document.createElement("ul");
		    	ul.className="ul";
		    	var ull=document.getElementById("ul");
		    	ull.parentNode.replaceChild(ul,ull);*/
		    	/*var ul=document.getElementById("ul");
		    	var li=document.getElementsByTagName("li");
		    	if(ul==null)console.log("sfksajfk");
		    	
		    	var length=ul.childNodes.length;
		    	for(var i=0;i<length;i++)
		    		ul.removeChild(li[0]);
		    	rownum=0;
		    	getInfo();*/
		    	location.reload();
		    }
		
		
