            var rownum=0;
            var obj =new Object; 
            var sendoraccept=true;
		    window.onload=function(){
		    	getInfoaccept();
		    	
		    }
		    function clicksendmessage(){
		    	var sendmessage=document.getElementById("sendmessage");
		    	sendmessage.className="centerc";
		    	var acceptmessage=document.getElementById("accpetmessage");
		    	acceptmessage.className="centern";
		    	rownum=0;
		    	sendoraccept=false;
		    	getInfosend();
		    	
		    }
            function clickacceptmessage(){
            	var acceptmessage=document.getElementById("accpetmessage");
		    	acceptmessage.className="centerc";
		    	var sendmessage=document.getElementById("sendmessage");
		    	sendmessage.className="centern";
		    	rownum=0;
		    	sendoraccept=true;
		    	getInfoaccept();
		    }
		    function onerror(){
		    	var warning=document.getElementById("warning");
		    	warning.style.height=30+'px';
		    	warning.innerText="加载有误！";
		    }
		    function getInfosend(){
		    	var loader=new net.AjaxRequest("message_sLoading?rownum="+rownum,deal_getInfo,onerror,"GET");
		    }
		    function getInfoaccept(){
		    	var loader=new net.AjaxRequest("message_aLoading?rownum="+rownum,deal_getInfo,onerror,"GET");
		    }
		   
		    
		    function deal_getInfo(){
		    	var info=this.req.responseText;
		    	info=eval("("+info+")");
		    	
		    	if(info.message.length!=0){
		    		console.log(info);
		    		console.log("info!=0");
		    		var warning=document.getElementById("warning");
			    	warning.innerText="";warning.style.height=13+'px';
			    	
		    		var frag=document.createDocumentFragment();
		    		var ul=document.createElement("ul");
		    		ul.id="ul";
		    		ul.className="ul";
			    	for(var i=0;i<info.message.length;i++){
			    		
			    		var li=document.createElement("li");
			    		li.className="li";
			    		
			    		var divlileft=document.createElement("div");
			    		divlileft.className="li_left";
			    	
			    		var alilefta=document.createElement("a");
			    		alilefta.className="li_left_a";
			    		alilefta.href="message_showMessage?messageid="+info.message[i].messageid+"&showname="+info.name[i];
			    		alilefta.innerText=info.name[i];
			    		
			    		
			    		var divliright=document.createElement("div");
			    		 divliright.className="li_right";
			    		 
			    		var messagecontent=document.createElement("div");
			    		messagecontent.className="deal";
			    		messagecontent.innerText=info.message[i].content;
			    		
			    		divlileft.appendChild(alilefta);
			    		divliright.appendChild(messagecontent);
			    		
			    		
			    		li.appendChild(divlileft);li.appendChild(divliright);
			    		
			    		frag.appendChild(li);
			    	   
			    	} 
			    	  
			    	   ul.appendChild(frag);
			    	   var ull=document.getElementById("ul");
			    	   ull.parentNode.replaceChild(ul,ull);
			    
		    	}else {
		    		console.log("info=0");
		    		changewarning();
		    		rownum--;
		    	
		    	}
		    	
		    }
		    
		 
		    
		    
		    
		    
		    function pageup(){
		    	rownum--;
		    	if(rownum==-1){
		    		changewarning();
		    		rownum++;
		    	}else{
		    		if(sendoraccept){
		    			getInfoaccept();
		    		}else{
		    			getInfosend();
		    		}
		    	   
		    	}
		    }
		    function pagedown(){
		    	rownum++;
		    	console.log("pagedown");
		    	if(sendoraccept){
	    			getInfoaccept();
	    		}else{
	    			getInfosend();
	    		}
		    }
		    function changewarning(){
		    	var warning=document.getElementById("warning");
		    	warning.style.height=30+'px';
		    	warning.innerText="没有更多数据";
		    }
		

		    
		    