<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业服务平台</title>
<link rel="stylesheet" href="bootstrap3/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="bootstrap3/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="bootstrap3/js/jquery-1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap3/js/bootstrap.min.js"></script>

<!-- <link rel="stylesheet" href="css/1.css">  -->
</head>
<body>
<%@ include file="view/common/mian.jsp"%>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h2>企业情报系统</h2>
			</div>
			<!-- /.col-lg-6 -->
			<div class="col-sm-2"></div>
			<div class="col-sm-6">
				<div class="input-group">
					<input type="text" class="form-control" size="20"
						placeholder="请输入关键词..."> <span class="input-group-btn">
						<button class="btn btn-default" type="submit">查 找</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
		</div>
	</div>
	<!--搜索结束  -->
	<br>

	<!-- ***************************************************导航条*********************-->
	<div class="container">
		<nav class="navbar navbar-default "><!-- carousel就无法影响top的按钮 -->
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">主页<span class="sr-only">(current)</span></a></li>
				</ul>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<ul class="nav navbar-nav">

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">IT·互联网<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="">业界</a></li>
							<li><a href="#">通信行业</a></li>
							<li><a href="#">电商行业</a></li>
							<li><a href="#">科学探索</a></li>
							<li><a href="#">数码之家</a></li>
							<li><a href="#">安卓之家</a></li>
							<li><a href="#">智能时代</a></li>
							<li><a href="#">微软系列</a></li>
							<li><a href="#">苹果</a></li>

							<li class="divider"></li>
							<li><a href="#">最新资讯</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">金融<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">宏观</a></li>

							<li><a href="#">证卷</a></li>
							<li><a href="#">国际</a></li>
							<li><a href="#">财经</a></li>
							<li><a href="#">基金</a></li>
							<li><a href="#">理财</a></li>

							<li><a href="#">保险</a></li>

							<li class="divider"></li>
							<li><a href="#">最新资讯</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">房产<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">家具行业</a></li>
							<li><a href="#">家电行业</a></li>
							<li><a href="#">城建</a></li>
							<li><a href="#">政策</a></li>
							<li><a href="#">要闻</a></li>
							<li class="divider"></li>
							<li><a href="#">最新资讯</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">消费行业<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Spark SQL</a></li>
							<li><a href="#">Spark Streaming</a></li>
							<li><a href="#">Mlib(machine leaming)</a></li>
							<li><a href="#">Graph</a></li>
							<li class="divider"></li>
							<li><a href="#">最新资讯</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">汽车·制造<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Spark SQL</a></li>
							<li><a href="#">Spark Streaming</a></li>
							<li><a href="#">Mlib(machine leaming)</a></li>

							<li class="divider"></li>
							<li><a href="#">最新资讯</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">医疗·化工<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Spark SQL</a></li>
							<li><a href="#">Spark Streaming</a></li>
							<li><a href="#">Mlib(machine leaming)</a></li>
							<li><a href="#">Graph</a></li>
							<li class="divider"></li>
							<li><a href="#">最新资讯</a></li>
						</ul></li>
					<!-- <li><a href="#">人才租凭</a></li> -->
				</ul>


				<ul class="nav navbar-nav navbar-right">

					<li class="t1"><a
						href="<%=request.getContextPath()%>/view/common/center.jsp">个人中心</a></li>
					<li class="t1"><a href="logout">退出</a></li>


				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
	</div>
	<div class="container"><br><!-- <h4> &nbsp;&nbsp;&nbsp;&nbsp;最新资讯</h4> -->
		
			<%-- <div class="col-lg-4">
			<c:forEach var="message" items="${ToBean.suiji}">
									
										<h5>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h5>
									
									<hr>
								</c:forEach>
			</div> --%>
			
				<!-- ***************************************************翻滚画面******** -->
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel"  align="middle">
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"
							class=""></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"
							class=""></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div align="middle" class="item next left">
							<img style="width: 100%"
								data-src="holder.js/900x500/auto/#777:#555/text:First slide"
								alt="First slide [1920x1080]" src="image/2.jpg"
								data-holder-rendered="true">
						</div>
						<div align="middle" class="item">
							<img style="width: 100%"
								data-src="holder.js/900x500/auto/#666:#444/text:Second slide"
								alt="Second slide [1920x1080]" src="image/6.jpg"
								data-holder-rendered="true">
						</div>
						<div align="middle" class="item active left">
							<img style="width: 100%"
								data-src="holder.js/900x500/auto/#555:#333/text:Third slide"
								alt="Third slide [1920x1080]" src="image/3.jpg"
								data-holder-rendered="true">
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
				<!-- 滚动画面结束 -->
		
	</div>
	<!--容器结束  -->


	<br><br>
	<div class="container Box1" >
		<div class="row">
			<div class="col-sm-7"><hr>
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a href="#home">最新IT</a></li>
					<li><a href="#profile">电商</a></li>
					 <li ><a href="messages">硬件</a></li>
					<li><a href="#settings">通信</a></li> 
				</ul>

				<div class="tab-content" style="font-size:5px">
					<div class="tab-pane active" id="home">
					<c:forEach var="message" items="${ToBean.IT}">
									
										<h4>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h4>
										<p>&nbsp;&nbsp;&nbsp;&nbsp;${message.content}</p>

									<hr>
								</c:forEach>
					</div>
					<div class="tab-pane" id="profile" style="font-size:5px">
					<c:forEach var="message" items="${ToBean.electricity}">
									
										<h4>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h4>
										<p  >&nbsp;&nbsp;&nbsp;&nbsp;${message.content}</p>

									<hr>
								</c:forEach>
					</div>
					<div class="tab-pane" id="messages" style="font-size:5px">
					<c:forEach var="message" items="${ToBean.hardware}">
									
										<h4>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h4>
										<p  >&nbsp;&nbsp;&nbsp;&nbsp;${message.content}</p>

									<hr>
								</c:forEach>
					</div>
					<div class="tab-pane" id="settings" style="font-size:5px">
					
					<c:forEach var="message" items="${ToBean.communication}">
									
										<h4>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h4>
										<p  >&nbsp;&nbsp;&nbsp;&nbsp;${message.content}</p>

									<hr>
								</c:forEach></div>
				</div>
			</div>


			<!-- /.col-sm-6 -->
			<div class="col-sm-5"><hr>
				<ul class="nav nav-tabs" id="myTab1">
					<li class="active"><a href="#home1">金融</a></li>
					<li><a href="profile1">股票</a></li>
					<!-- <li><a href="#messages1">基金</a></li>
					<li><a href="#settings1">宏观</a></li> -->
				</ul>

				<div class="tab-content" style="font-size:5px">
					<div class="tab-pane active" id="home1">
						<c:forEach var="message" items="${ToBean.financial}">
									
										<h4>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h4>
										<p>&nbsp;&nbsp;&nbsp;&nbsp;${message.content}</p>

									<hr>
								</c:forEach>
					</div>
					<div class="tab-pane" id="profile1" style="font-size:5px">
						<c:forEach var="message" items="${ToBean.stock}">
									
										<h4>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h4>
										<p>&nbsp;&nbsp;&nbsp;&nbsp;${message.content}</p>

									<hr>
								</c:forEach>
					</div>
					<div class="tab-pane" id="messages1">11223</div>
					<div class="tab-pane" id="settings1">456445</div>
				</div>
			</div>
			<!-- /.col-sm-6 -->
		</div>
	</div>
	<div class="container Box1" >
		<div class="row">
			<div class="col-sm-7"><hr>
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a href="#home">家具</a></li>
					<!-- <li><a href="#profile">电商</a></li> -->
					<!-- <li ><a href="#messages">硬件</a></li>
					<li><a href="#settings">通信</a></li> -->
				</ul>

				<div class="tab-content" style="font-size:5px">
					<div class="tab-pane active" id="home">
					<c:forEach var="message" items="${ToBean.furniture}">
									
										<h4>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h4>
										<p>&nbsp;&nbsp;&nbsp;&nbsp;${message.content}</p>

									<hr>
								</c:forEach>
					</div>
					<div class="tab-pane" id="profile" style="font-size:5px">
					<c:forEach var="message" items="${ToBean.electricity}">
									
										<h4>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h4>
										<p  >&nbsp;&nbsp;&nbsp;&nbsp;${message.content}</p>

									<hr>
								</c:forEach>
					</div>
					<div class="tab-pane" id="messages">11223</div>
					<div class="tab-pane" id="settings">456445</div>
				</div>
			</div>


			<!-- /.col-sm-6 -->
			<div class="col-sm-5"><hr>
				<ul class="nav nav-tabs" id="myTab1">
					<li class="active"><a href="#home1">机械</a></li>
				<!--	<li><a href="#profile1">股票</a></li> -->
					<!-- <li><a href="#messages1">基金</a></li>
					<li><a href="#settings1">宏观</a></li> -->
				</ul>

				<div class="tab-content" style="font-size:5px">
					<div class="tab-pane active" id="home1">
						<c:forEach var="message" items="${ToBean.suiji}">
									
										<h4>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h4>
										<p>&nbsp;&nbsp;&nbsp;&nbsp;${message.content}</p>

									<hr>
								</c:forEach>
					</div>
					<div class="tab-pane" id="profile1" style="font-size:5px">
						<c:forEach var="message" items="${ToBean.stock}">
									
										<h4>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h4>
										<p>&nbsp;&nbsp;&nbsp;&nbsp;${message.content}</p>

									<hr>
								</c:forEach>
					</div>
					<div class="tab-pane" id="messages1">11223</div>
					<div class="tab-pane" id="settings1">456445</div>
				</div>
			</div>
			<!-- /.col-sm-6 -->
		</div>
	</div>
	<div class="container">
	
	</div>
	<hr>
	<%@ include file="view/common/footer.jsp"%>
	<script src="js/Dropdown.js" type="text/javascript"></script>
	 <script> 
	 
      $(function () { 
        $('#myTab a:last').tab('show');//初始化显示哪个tab 
    
        $('#myTab a').mouseover(function (e) { 
          e.preventDefault();//阻止a链接的跳转行为 
          $(this).tab('show');//显示当前选中的链接及关联的content 
        }) 
      }) 
      $(function () { 
        $('#myTab1 a:last').tab('show');//初始化显示哪个tab 
     $('#myTab1 a').mouseover(function (e) { 
          e.preventDefault();//阻止a链接的跳转行为 
          $(this).tab('show');//显示当前选中的链接及关联的content 
        }) 
      }) 
    </script>
<script type="text/javascript">
 var pPath="<%=session.getAttribute("username")%>";  

 $(document).ready(function() {
		$(".t1").hide();
	});
/*  if (contextPath == null || contextPath == "null") {
		$(document).ready(function() {
	} else {
		$(document).ready(function() {
			
			$(".t0").show();
			$(".t1").show();
		});
	} */
 	
	</script>
</body>
</html>