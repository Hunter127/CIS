<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>情报搜索</title>
<link rel="stylesheet" href="bootstrap3/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="bootstrap3/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="bootstrap3/js/jquery-1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/1.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/1.css"> 
<!-- <script type="text/javascript">
function clickButton()
{    
	/* alert("00000000"); */
    var url = 'ajaxRequest.action';
    var params = {
            name:$('#name').val()
    };
    jQuery.post(url, params, callbackFun, 'json');
}
function callbackFun(data)
{
	
    alert(data.result);//对应HelloWorld类的message属性
        //获取数据后渲染页面
}
	 
</script> -->

<style type="text/css">

#divbox{ width:50px;  background-color:#f00;  } 

</style>
</head>
<body>
<ul class="nav nav-tabs">
  <li role="presentation"  class="active"><a href="#">情报搜索版</a></li>
  <li role="presentation" ><a href="index.jsp">企业服务版</a></li>
  
  	<li class="lg1" id="fg1"><a href="view/common/Pregister.jsp">个人注册</a></li>
    <li  class="lg1" id="fg1"><a href="view/common/login.jsp">登录</a></li>
    <li class="lg2" id="fg2"><a href="#">${username}</a></li>
    
			
          
			<li class="lg1" id="fg1"><a href="view/common/Cregister.jsp">企业注册</a></li>
  
</ul><br>
<div>
<header class="site-header jumbotron">
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<h1>企业搜索引擎</h1>
				 <p>
					专注于的各个行业的信息搜索服务<br> <span class="package-amount">共收录了
						<strong>525300</strong> 个情报
					</span>
				</p>
				<form action="search" role="search" id="Sub1" class="Sub">
					<div class="form-group">
						<input id="name" name="name" type="text" class="form-control search clearable"
							placeholder="情报搜索" value=""  ><a onclick="document.getElementById('Sub1').submit();return false"> <i class="fa x fa-search"><span
							class="glyphicon glyphicon-search" ></span></i></a>

                             <!--这个表单根本不能按搜索原来是用Ajax的  -->
                              <!-- 这里还是不用ajax了，还有表单验证失败了 -->
					</div>
				</form>
			</div>
		</div>
	</div>
	</header>
	</div>
	
<div class="container" >	
<div >
  
	<c:forEach var="message" items="${result}">
	
	<h3><a href="${message.id}"> ${message.title}</a></h3>
	<p>${message.description}</p>
	<h5><a href="${message.id}">${message.id}</a></h5>
	
	</c:forEach>
	
	
	</div>
</div><br>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/validate.js" type="text/javascript"></script>
<script type="text/javascript">
	function chageValidateCode()  
	{  
	    var timenow = new Date().getTime();  
	    $("img.validate").attr("src", "randomImg.action?d="+timenow);  
	}  
 // var contextPath="${username}";
 var contextPath="<%=session.getAttribute("username")%>"; 
 var error="<%=session.getAttribute("error")%>";
 
		if (error == null || error == "null") {
			/*  alert("1"); */
			/* System.out.println("出错了");  */
			if (contextPath == null || contextPath == "null") {
				
				$(document).ready(function() {
					$(".lg2").hide();
					$(".lg1").show();
				});
			} else {
				$(document).ready(function() {
					$(".lg1").hide();
				});
			}
		} else {
			alert(error);
		}
	</script>
</body>
</html>