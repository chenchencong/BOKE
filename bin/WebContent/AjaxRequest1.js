var net=new Object();	//定义一个全局变量net
//编写构造函数
net.AjaxRequest=function(url,onload,onerror,method,params){
  this.req=null;
  this.onload=onload;
  this.onerror=(onerror) ? onerror : this.defaultError;
  this.loadDate(url,method,params);
};
//编写用于初始化XMLHttpRequest对象并指定处理函数，最后发送HTTP请求的方法
net.AjaxRequest.prototype.loadDate=function(url,method,params){
  if (!method){	//设置默认为的请求方式为GET
  method="GET";
  }
	  if (window.XMLHttpRequest){	// Mozilla……等非IE浏览器
	    this.req=new XMLHttpRequest();	//创建XMLHttpRequest对象
	  } else if (window.ActiveXObject){	//IE浏览器
		try{
		this.req=new ActiveXObject("Msxml2.XMLHTTP");	//创建XMLHttpRequest对象
		}catch(e){
		try{
		this.req=new ActiveXObject("Microsoft.XMLHTTP");	//创建XMLHttpRequest对象	
		}catch(e){}
		}
	  }
	  
  if (this.req){
  try{
  var loader=this;
  //指定回调函数
  this.req.onreadystatechange=function(){
  net.AjaxRequest.onReadyState.call(loader);
  };
  this.req.open(method,url,true);	//创建与服务器的连接
    if(method=="POST"){	//当发送POST请求时，设置请求头
    this.req.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");  
  }
 
  this.req.send(params);	//向服务器发送请求
  }catch (err){
  this.onerror.call(this);	//调用错误处理函数
  }
  }
  };

//重构回调函数
net.AjaxRequest.onReadyState=function(){
  var req=this.req;
  var ready=req.readyState;	//获取请求状态
  if (ready==4){
  if (req.status==200 ){
  this.onload.call(this);	//调用回调函数
  }else{
  this.onerror.call(this);	//调用错误处理函数
  }
  }
  };
//重构默认的错误处理函数
	net.AjaxRequest.prototype.defaultError=function(){
	  alert("错误数据\n\n回调状态:"+this.req.readyState+"\n状态: "+this.req.status);
	};