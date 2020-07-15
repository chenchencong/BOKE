
		    var rownum=0;
		    var nomoredata=false;
		    var blogid=${session.data.dataid};
		    window.onload=function(){
		    	
		    	getInfo();
		    	
		    }
		    function onerror(){
	    	    var nonedata=document.getElementById("nonedata");
    		    nonedata.innerHTML="加载失败";
		    }
		    function getInfo(){
		    	
		    	var loader=new net.AjaxRequest("comment_cLoading?rownum="+rownum.toString()+"&blogid="+blogid.toString(),deal_getInfo,onerror,"GET");
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
		    	if(info.data.length!=0){
			    	var frag=document.createDocumentFragment();
			    	for(var i=0;i<info.data.length;i++){
			    		
			    		var li=document.createElement("li");
			    		li.className="li";
			    		var divlitop=document.createElement("div");
			    		divlitop.className="litop";
			    	
			    		var ausername=document.createElement("a");
			    		ausername.className="username";
			    		spanusername.innerText=info.username[i];
			    		
			    		var pshowcomment=document.createElement("p");
			    		pcontent.className="showcomment";
			    		pcontent.innerText=info.data[i].content;
			    		
			    		
			    		
			    		divlitop.appendChild(ausername);
			    		li.appendChild(divlitop);li.appendChild(pshowcomment);
			    		
			    		frag.appendChild(li);
			    		
			    	}
			    	 var ul=document.getElementById("ul");
			    	   ul.appendChild(frag);
			    	  rownum++;
		    	   
			    	/* var json1={"abc":[{"name":"txt1"},{"name","txt2"}]};
			    	for(var i=0;i<json1.abc.length;i++){alert(json1.abc[i].name);} */
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

		
		
		
