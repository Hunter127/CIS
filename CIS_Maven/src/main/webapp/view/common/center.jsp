<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/Page.css">
</head>
<body id="main">
	<div id="wapper">
		<div id="main-contents">
			<%@ include file="/view/common/mian.jsp"%>
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<h2>情报中心</h2>
					</div>
					<!-- /.col-lg-6 -->
					<div class="col-sm-2"></div>
					<div class="col-sm-6">

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
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<ul class="nav navbar-nav">
							<li class="active"><a
								href="<%=request.getContextPath()%>/view/common/cPage.jsp">主页<span
									class="sr-only">(current)</span></a></li>
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
									<li><a href="#">业界</a></li>
									<li><a href="#">通信</a></li>
									<li><a href="#">电商</a></li>
									<li><a href="#">科学探索</a></li>
									<li><a href="#">数码之家</a></li>
									<li><a href="#">安卓之家</a></li>
									<li><a href="#">智能时代</a></li>
									<li><a href="#">微软系列</a></li>
									<li><a href="#">苹果</a></li>

									<li class="divider"></li>
									<li><a href="#">最新资讯</a></li>
								</ul></li>

							<ul class="nav navbar-nav">


								<li class="t0"><a
									href="<%=request.getContextPath()%>/view/common/center.jsp">个人心中</a></li>
								<li class="t0"><a
									href="<%=request.getContextPath()%>/view/common/center.jsp">消息中心</a></li>


							</ul>


							<!-- <li><a href="#">人才租凭</a></li> -->
						</ul>


						<ul class="nav navbar-nav navbar-right">


							<li class="t0"><a href="logout">退出</a></li>


						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid --> </nav>
				<div class="myBox6"></div>
				<br>
				<div class="row">
					<div class="col-lg-9">
					  
					    <div class="myBox7">
					  
					    </div>
					</div>
					
					<div class="col-lg-3">
					   <div class="myBox8">
					   
					   </div>
					</div>
					</div>
				</div>

			</div>
		</div>
		<!--主体结束  -->
		<br> <br>

		<div id="footer" class="myBox5">
			<hr>
			<div class="container">
				<center>
					<p>
						<a href="#">关于我们</a> | <a href="#">联系我们</a> | <a href="about.html">人才招聘</a>
						| <a href="faqs.html">网站地图</a> | <a href="checkout.html">免责条款</a>
						| <a href="contact.html"></a>
					</p>
					<p>
						公司名称 <a href="#">企业服务平台</a>| 桂林理工大学<a href="#">云计算课题组</a>版权所有
					</p>
				</center>
			</div>
		</div>
		<!--页脚结束  -->
	</div>
</body>
</html>