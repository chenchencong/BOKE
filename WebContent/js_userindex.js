            var rownum=0;
            var obj =new Object; 
		    window.onload=function(){
		    	getInfo();
		    	
		    }
		    function onerror(){
		    	var warning=document.getElementById("warning");
		    	warning.style.height=30+'px';
		    	warning.innerText="加载有误！";
		    }
		    function getInfo(){
		    	var loader=new net.AjaxRequest("user_uiLoading?rownum="+rownum,deal_getInfo,onerror,"GET");
		    }
		    function deal_getInfo(){
		    	var info=this.req.responseText;
		    	info=eval(info);
		    	console.log(info);
		    	if(info.length!=0){
		    		var warning=document.getElementById("warning");
			    	warning.innerText="";warning.style.height=13+'px';
			    	
		    		var frag=document.createDocumentFragment();
		    		var ul=document.createElement("ul");
		    		ul.id="ul";
		    		ul.className="ul";
			    	for(var i=0;i<info.length;i++){
			    		
			    		var li=document.createElement("li");
			    		li.className="li";
			    	
			    		var divlileft=document.createElement("div");
			    		divlileft.className="li_left";
			    	
			    		var alilefta=document.createElement("a");
			    		alilefta.className="li_left_a";
			    		alilefta.href="data_showbo?dataid="+info[i].dataid;
			    		alilefta.innerText=info[i].title;
			    		
			    		
			    		var divliright=document.createElement("div");
			    		 divliright.className="li_right";
			    		 
			    		var adeald=document.createElement("a");
			    		adeald.className="deal";
			    		adeald.href="data_delete?dataid="+info[i].dataid;
			    		adeald.innerText="删除";
			    		
			    		var adeala=document.createElement("a");
			    		adeala.className="deal";
			    		adeala.href="data_correct?dataid="+info[i].dataid;
			    		adeala.innerText="修改";
			    		
			    
			    		
			    		
			    		divlileft.appendChild(alilefta);
			    		divliright.appendChild(adeald);divliright.appendChild(adeala);
			    		
			    		
			    		li.appendChild(divlileft);li.appendChild(divliright);
			    		
			    		frag.appendChild(li);
			    	   
			    	} 
			    	  
			    	   ul.appendChild(frag);
			    	   var ull=document.getElementById("ul");
			    	   ull.parentNode.replaceChild(ul,ull);
			    	
		    	}else {
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
		    	   getInfo();
		    	}
		    }
		    function pagedown(){
		    	rownum++;
		    	getInfo();
		    }
		    function changewarning(){
		    	var warning=document.getElementById("warning");
		    	warning.style.height=30+'px';
		    	warning.innerText="没有更多数据";
		    }
		
		    
		    
		    
		  

		    
		    