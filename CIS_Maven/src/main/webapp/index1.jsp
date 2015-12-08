<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap3/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="bootstrap3/css/bootstrap-theme.min.css">
<!-- //jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="bootstrap3/js/jquery-1.11.2.min.js"></script>
<!-- //最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap3/js/bootstrap.min.js"></script>
<style type="text/css">
li {
	text-decoration:
}
.left1 {
	margin-bottom: 20px;
	text-align: center;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">惠远花店</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">主页</a></li>
				<li><a href="#about">全部鲜花</a></li>
				<li><a href="#contact">开业花篮</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">更多<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">爱情鲜花</a></li>
						<li><a href="#">生日鲜花</a></li>
						<li><a href="#">精致花篮</a></li>
						<li role="separator" class="divider"></li>
						<li class="dropdown-header">土豪花区</li>
						<li><a href="#">高端鲜花</a></li>
						<li><a href="#">名贵鲜花</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="lg1"><a href="login.jsp">登录</a></li>
				<li class="lg2"><a href="#"> ${username}</a></li>
				<li class="lg1"><a href="register.html">注册</a></li>
				<li class="lg2"><a href="logout?outuser=<%=session.getAttribute("username")%>">退出</a></li>
				<li class="lg2"><a href="../navbar-static-top/">购物车</a></li>
				<li class="active lg2"><a href="./">个人中心<span class="sr-only">(current)</span></a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<div class="container">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 sidebar">

					<br>
					<br>
					<div class="list-group">
						<a href="#" class="list-group-item active"> 商品分类 </a> <a href="#"
							class="list-group-item">鲜花速递</a> <a href="#"
							class="list-group-item">花篮DIY专区</a> <a href="#"
							class="list-group-item">卡通花束</a> <a href="#"
							class="list-group-item">盒花，进口鲜花</a> <a href="#"
							class="list-group-item">瓶花，花瓶插花</a> <a href="#"
							class="list-group-item">开业花篮，商务鲜花</a> <a href="#"
							class="list-group-item">植物花卉</a> <a href="#"
							class="list-group-item">节日鲜花</a> <a href="#"
							class="list-group-item">乔迁鲜花</a> <a href="#"
							class="list-group-item">婚庆鲜花</a>
					</div>
				</div>
				<div class="col-sm-9  col-md-10 main">
					<h1 class="page-header">惠远花店</h1>

					<div class="row">

						<c:forEach items="${flowerss.list}" var="fo">
							<%--  <tr>
               <td>
                   <a href=""> </a>
                   <br>
                    ${fo.author}              <!--把作者转为图片路径  -->
                   </td>
                   <td> ${fo.price}</td>
                   <td> <a href="">加入购物车</a></td>
                   </tr> --%>
							<div class="col-lg-4 left1">
								<img src="${fo.author}" alt="Generic placeholder image"
									width="140" height="140">
								<h2>
									<a>${fo.title}</a>
								</h2><p>${fo.price} 元</p>
								<p>鲜花为手工做品，包装因每个地区差异难免会与图片有些出入，但我们保证鲜花的主花材品种、新鲜程度、数量、颜色与说明一致。</p>
								<p>
									<a class="btn btn-default" href="single1.html" role="button">详情介绍 »</a>
								</p>
								<h2>
									<a class="btn btn-default" href="book.jsp" role="button">加入购物车</a>
								</h2>
							</div>
							<!-- /.col-lg-4 -->
						</c:forEach>


					</div>


				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div align="center">
		共 ${flowerss.totalPageNumber } &nbsp;&nbsp; 当前第 ${flowerss.pageNo} 页
		&nbsp;&nbsp;
		<c:if test="${flowerss.hasPrev}">
			<a href="FlowerServlet?method=getBooks&pageNo=1">首页</a>
     &nbsp;&nbsp;
      <a
				href="FlowerServlet?method=getBooks&pageNo=${flowerss.prevPage }">上一页</a>
		</c:if>
		&nbsp;&nbsp;
		<c:if test="${flowerss.hasNext}">
			<a href="FlowerServlet?method=getBooks&pageNo=${flowerss.nextPage }">下一页</a>
     &nbsp;&nbsp;
      <a
				href="FlowerServlet?method=getBooks&pageNo=${flowerss.totalPageNumber }">末页</a>
		</c:if>
	</div>

<script type="text/javascript">
var contextPath="<%=session.getAttribute("username")%>"; 
var error="<%=request.getAttribute("error")%>";

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
			$(document).ready(function() {
				$(".lg2").hide();
			});
		}
</script>
<hr>
<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-3">
						<div class="single-widget">
							<h2>购物指南</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">购物流程</a></li>
								<li><a href="#">会员介绍</a></li>
								<li><a href="#">团购</a></li>
								<li><a href="#">常见问题</a></li>
								<li><a href="#">联系客服</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="single-widget">
							<h2>配送方式</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">上门提醒</a></li>
								<li><a href="#">速递</a></li>
								<li><a href="#">配送查询</a></li>
								<li><a href="#">配送收费标准</a></li>
								
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="single-widget">
							<h2>支付方式</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">货到付款</a></li>
								<li><a href="#">在线支付</a></li>
								<li><a href="#">邮局汇款</a></li>
								<li><a href="#">公司转账</a></li>
								
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="single-widget">
							<h2>售后服务</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">售后政策</a></li>
								<li><a href="#">价格保护</a></li>
								<li><a href="#">退款说明</a></li>
								<li><a href="#">退货</a></li>
								<li><a href="#">取消订单</a></li>
							</ul>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<hr size="3" color="#00ee99">
<div class="footer_bottom">
<div class="container">
<center>

		<p><a href="#">关于我们</a> | <a href="#">联系我们</a> | <a href="about.html">商家入驻</a> | <a href="faqs.html">销售中心</a> | <a href="checkout.html">花店社区</a> | <a href="contact.html">花店公益</a></p>
        <p>公司名称 <a href="#">惠远花店</a> | 友情链接<a href="http://www.hua520.cn/" title="鲜花之家">鲜花之家</a></p>
	</center>
	</div>
	</div>
	
    <div class="cleaner"></div>
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>
	
</body>
</html>