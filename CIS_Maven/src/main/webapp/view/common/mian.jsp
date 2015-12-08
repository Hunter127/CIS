<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap3/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap3/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=request.getContextPath()%>/bootstrap3/js/jquery-1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=request.getContextPath()%>/bootstrap3/js/bootstrap.min.js"></script> 
 <link rel="stylesheet" href="<%=request.getContextPath()%>/css/1.css">  
</head>
<body>

   <div id="main-top">
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="<%=request.getContextPath()%>/1.jsp">情报搜索版</a></li>
			<li role="presentation" class="active"><a href="<%=request.getContextPath()%>/index.jsp">企业服务版</a></li>
			
			<li class="lg1" id="fg1"><a href="<%=request.getContextPath()%>/view/common/Pregister.jsp">注册</a></li>
			
            <li class="lg1" id="fg1"><a href="<%=request.getContextPath()%>/view/common/login.jsp">登录</a></li>
		    <li class="lg2" id="fg2"><a href="<%=request.getContextPath()%>/change.jsp"></a></li>
		</ul>
	</div>
	
	<!-- 模版切换结束 -->
	<script type="text/javascript">
	function chageValidateCode()  
	{  
	    var timenow = new Date().getTime();  
	    $("img.validate").attr("src", "randomImg.action?d="+timenow);  
	}  
 // var contextPath="${username}";
 var pPath="<%=session.getAttribute("username")%>"; 
 
 var error="<%=request.getAttribute("error")%>";
 
		if (error == null || error == "null") {
			/*  alert("1"); */
			/* System.out.println("出错了");  */
			if (pPath == null || pPath == "null") {
				
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
			$(document).ready(function() {
				$(".lg2").hide();
			});
		}
	</script>
</body>
</html>