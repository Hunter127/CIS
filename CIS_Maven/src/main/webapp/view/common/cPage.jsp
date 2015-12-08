<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>情报中心</title>

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
				<div class="row">
					<div class="col-lg-3 ">

						<div class="col-lg-10">
							<div class="myBox">
								<div class="myBox-1"></div>
								<br>
								<br>
								<h4> ${username}</h4>
								<h5> 您所关注的行业：${industry2}</h5>
								<br>
								<!--  <img alt=""
									style="width: 150px; height: 150px; margin-left: 0;"
									src="image/11.jpg"> -->

							</div>
						</div>
						<div class="col-lg-2"></div>
					</div>

					<div class="col-lg-9">
					<form action="search2" id="Sub2">
						<div class="myBox">
							<div class="search_center">
								<br>
								<div class="ph_left_1_2_in">
									<input type="text" placeholder="搜索情报资源..." name="name" class="pl12_in">
									<div class="pl12_search">
										<a id="searchBtn" class="pl12_s_btn" onclick="document.getElementById('Sub2').submit();return false"><img
											src="<%=request.getContextPath()%>/image/search.png"
											class="pl12_s_img"></a>
									</div>
								</div>
							</div>
							<br> <br>
							<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-5">
									<div class="input-group">
										<span class="input-group-btn">
											<h4>地区 &nbsp;</h4>
										</span> <input type="text" class="form-control"
											placeholder="添加地域限制...">
									</div>
									<!-- /input-group -->
								</div>
								<!-- /.col-lg-6 -->
								<div class="col-lg-5">
									<div class="input-group">
										<span class="input-group-btn">
											<h4>关注企业 &nbsp;</h4>
										</span> <input type="text" class="form-control"
											placeholder="定制服务，添加关注企业...">
									</div>
									<!-- /input-group -->
								</div>
								<!-- /.col-lg-6 -->
								<div class="col-lg-1"></div>
							</div>
							<!-- /.row -->
							<div class="row">
								<div class="col-lg-1"></div>
								<div class="col-lg-5">
									<div class="input-group">
										<span class="input-group-btn">
											<h4>行业 &nbsp;</h4>
										</span> <input type="text" class="form-control"
											placeholder="添加行业限制，默认为...">

									</div>
									<!-- /input-group -->
								</div>
								<!-- /.col-lg-6 -->
								<div class="col-lg-5"></div>
								<!-- /.col-lg-6 -->
								<div class="col-lg-1"></div>
							</div>
							<!-- /.row -->

						</div>
                   </form>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-3 ">

						<div class="col-lg-10">
							<div class="myBox1">
								<h4>您已关注的企业</h4>
								
								<c:forEach var="message" items="${companys}">
									<hr>
										<h6>
											&nbsp;&nbsp;<a href="#"> ${message.name}</a>
										</h6>
									
								</c:forEach>
								<hr>
							</div>
						</div>
						<div class="col-lg-2"></div>
					</div>

					<div class="col-lg-9">
						<div class="myBox2">
							<div id="main-top">
								<ul class="nav nav-tabs">
									<li role="presentation" class="active"><a href="<%=request.getContextPath()%>/change.jsp">最新信息</a></li>
									<li role="presentation"><a href="<%=request.getContextPath()%>/change1.jsp">关注企业</a></li>

									<li role="presentation"><a href="#">国外信息</a></li>
									<li role="presentation"><a href="#">其他</a></li>

								</ul>
							</div>
							<div align="right">
								 当前第 ${PageBean.currentPage} 页
								&nbsp;&nbsp;
								<c:if test="${PageBean.hasPreviousPage}">
									<a href="GetArticleList?page=1">首页</a>
     &nbsp;&nbsp;
      <a href="GetArticleList?page=${PageBean.currentPage-1}">上一页</a>
								</c:if>
								&nbsp;&nbsp;
								<c:if test="${PageBean.hasNextPage}">
									<a href="GetArticleList?page=${PageBean.currentPage+1 }">下一页</a>
     &nbsp;&nbsp;
      <a href="GetArticleList?page=${PageBean.totalPage}">末页</a>
								</c:if>
							</div>
						<!--  <h4>用jquery去做这一步，不用多个页面</h4> -->
							<div><br>
								<c:forEach var="message" items="${PageBean.lists}">
									
										<h3>
											&nbsp;&nbsp;<a href="${message.fromUrl}"> ${message.title}</a>
										</h3>
										<p>&nbsp;&nbsp;&nbsp;&nbsp;${message.content}</p>

									<hr>
								</c:forEach>

							</div><br><br>
							<div align="center">
								共 ${PageBean.allRow }页 &nbsp;&nbsp; 当前第 ${PageBean.currentPage} 页
								&nbsp;&nbsp;
								<c:if test="${PageBean.hasPreviousPage}">
									<a href="GetArticleList?page=1">首页</a>
     &nbsp;&nbsp;
      <a href="GetArticleList?page=${PageBean.currentPage-1}">上一页</a>
								</c:if>
								&nbsp;&nbsp;
								<c:if test="${PageBean.hasNextPage}">
									<a href="GetArticleList?page=${PageBean.currentPage+1 }">下一页</a>
     &nbsp;&nbsp;
      <a href="GetArticleList?page=${PageBean.totalPage}">末页</a>
								</c:if>
							</div>

						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!--主体结束  -->
	<br>
	<br>

	<div id="footer1" class="myBox51">
		<hr>
		<div class="container">
			<center>
				<p>
					<a href="#">关于我们</a> | <a href="#">联系我们</a> | <a href="about.html">人才招聘</a>
					| <a href="faqs.html">网站地图</a> | <a href="checkout.html">免责条款</a> |
					<a href="contact.html"></a>
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