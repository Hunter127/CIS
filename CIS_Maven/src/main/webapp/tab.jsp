<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap3/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="bootstrap3/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="bootstrap3/js/jquery-1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<ul class="nav nav-tabs" id="myTab"> 
      <li class="active"><a href="#home">Home</a></li> 
      <li><a href="#profile">Profile</a></li> 
      <li><a href="#messages">Messages</a></li> 
      <li><a href="#settings">Settings</a></li> 
    </ul> 
       
    <div class="tab-content"> 
      <div class="tab-pane active" id="home">
      
      </div> 
      <div class="tab-pane" id="profile">李四</div> 
      <div class="tab-pane" id="messages">11223</div> 
      <div class="tab-pane" id="settings">456445</div> 
    </div> 
     </div>  
    <script> 
      $(function () { 
        $('#myTab a:last').tab('show');//初始化显示哪个tab 
      
       
        $('#myTab a').mouseover(function (e) { 
          e.preventDefault();//阻止a链接的跳转行为 
          $(this).tab('show');//显示当前选中的链接及关联的content 
        }) 
      }) 
    </script>
</body>
</html>