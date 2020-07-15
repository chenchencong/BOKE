
		    var rownum=0;
		    var nomoredata=false;
		    var loaddown=false;
		    window.onload=function(){
		    	getInfo();
		    }
		    function onerror(){
		    	var nonedata=document.getElementById("nonedata");
	    		nonedata.innerHTML="加载失败";
	    		nonedata.style.display="block";
	    		
		    }
		    function getInfo(){
		    	
		    	var loader=new net.AjaxRequest("user_iLoading?rownum="+rownum.toString(),deal_getInfo,onerror,"GET");
		    	if(!nomoredata){
		    	var nonedata=document.getElementById("nonedata");
	    		nonedata.innerHTML="加载中......";
	    		nonedata.style.display="block";
		    	}
	    		
		    }
		    function deal_getInfo(){
		    	var info=this.req.responseText;
		    	
		    	info=eval("("+info+")");
		    	/*console.log(info);
		    	console.log(info.data.length);*/
		    	if(info.data.length!=0){
			    	
		    		var nonedata=document.getElementById("nonedata");
		    		nonedata.style.display="none";
		    		
			    	var frag=document.createDocumentFragment();
			    	for(var i=0;i<info.data.length;i++){
			    		
			    		var li=document.createElement("li");
			    		li.className="li";
			    		var divcenttxt=document.createElement("div");
			    		divcenttxt.className="CentTxt";
			    		var h3=document.createElement("h3");
			    		var atitle=document.createElement("a");
			    		atitle.className="title";
			    		atitle.href="data_showbo?dataid="+info.data[i].dataid;
			    		atitle.innerText=info.data[i].title;
			    		var spanusername=document.createElement("span");
			    		spanusername.className="spanname";
			    		spanusername.innerText=info.username[i];
			    		var pcontent=document.createElement("p");
			    		pcontent.className="RtCInfo";
			    		pcontent.innerText=info.data[i].content;
			    		
			    		var divRtCRateWrap=document.createElement("div");
			    		divRtCRateWrap.className="RtCRateWrap";
			    		var divRtCRateCent=document.createElement("div");
			    		divRtCRateCent.className="RtCRateCent";
			    		var strong=document.createElement("strong");
			    		strong.innerText="赞数";
			    		var spanzan=document.createElement("span");
			    		spanzan.className="zanshu";
			    		spanzan.innerText="45";
			    		
			    		h3.appendChild(atitle);
			    		h3.appendChild(spanusername);divcenttxt.appendChild(h3);divcenttxt.appendChild(pcontent);
			    		divRtCRateCent.appendChild(strong);divRtCRateCent.appendChild(spanzan);
			    		divRtCRateWrap.appendChild(divRtCRateCent);
			    		li.appendChild(divcenttxt);li.appendChild(divRtCRateWrap);
			    		
			    		frag.appendChild(li);
			    		
			    	}
			    	 var ul=document.getElementById("ul");
			    	   ul.appendChild(frag);
			    	  var outer=document.getElementById("outer");
			    	  rownum++;
			    	   
			    	/* var json1={"abc":[{"name":"txt1"},{"name","txt2"}]};
			    	for(var i=0;i<json1.abc.length;i++){alert(json1.abc[i].name);} */
		    	}else{
			    		if(!nomoredata){
			    		var nonedata=document.getElementById("nonedata");
				    	nonedata.innerHTML="没有更多数据了";
				    	nonedata.style.display="block";
			    		var footer=document.getElementById("footer");
			    		footer.style.display="block";
			    		nomoredata=true;
			    		}
			    		
		    	}
		    	
		    	loaddown=true;
		    }
		    
		   
		    
		   		    
		    
		    


		 function getScrollTop(){
			    var scrollTop = 0, bodyScrollTop = 0, documentScrollTop = 0;
			    if(document.body){
			    bodyScrollTop = document.body.scrollTop;
			    }   
			    if(document.documentElement){
			    documentScrollTop = document.documentElement.scrollTop;
			    }
			    scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;
			    return scrollTop;
		    }

		    //文档的总高度

		    function getScrollHeight(){
			    var scrollHeight = 0, bodyScrollHeight = 0, documentScrollHeight = 0;
			    if(document.body){
			    bodyScrollHeight = document.body.scrollHeight;
			    }
			    if(document.documentElement){
			    documentScrollHeight = document.documentElement.scrollHeight;
			    }
			    scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;
			    return scrollHeight;
		    }

		    //浏览器视口的高度
		    function getWindowHeight(){
			    var windowHeight = 0;
			   if(document.compatMode == "CSS1Compat"){
			    windowHeight = document.documentElement.clientHeight;
			    }else{
			    windowHeight = document.body.clientHeight;
			    }
			    return windowHeight;
		    }

		    window.onscroll = function(){
		    if(getScrollTop() + getWindowHeight() == getScrollHeight()){
		    	if(!nomoredata){
		    	  if(loaddown){
		    	 
		    	  getInfo();
		    	  loaddown=false;
		    	  }
		    	  
		    	}
		      }
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

		
		
		
