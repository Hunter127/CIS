<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="<%=request.getContextPath()%>/bootstrap3/js/jquery-1.11.2.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/1.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/register.css">
<script src="<%=request.getContextPath()%>/js/jquery.validate.js"
	type="text/javascript"></script>
<%-- <script src="<%=request.getContextPath()%>/js/validate.js"
	type="text/javascript"></script> --%>
	<script src="<%=request.getContextPath()%>/js/yanzheng.js"
	type="text/javascript"></script>
	<script type="text/javascript">
	$(".demoform").Validform();

	</script>
</head>
<body>
	<%@ include file="/view/common/mian.jsp"%>
	<div class="container">
		<h2>企业情报系统</h2>
	</div>
	<div class="w" id="regist">
		<div class="mt"></div>
		<div class="mc">
			<form class="demoform" method="post" action="register" id="registForm">

				<div class="form">
					<div class="item" id="select-regName">
						<span class="label"><b class="ftx04">*</b>用户名：</span>

						<div >
						<table>
						  <tr>
							<td>
								<input type="text" id="regName" name="user.userName"
									maxlength="20" class="text" datatype="s3-8" errormsg="昵称至少3个字符,最多8个字符！" />
							</td>
							<td><div id="accountValidate" class="Validform_checktip"></div></td>
							</tr>
							</table>
						</div>
					</div>
					<div id="o-password">
						<div class="item">
							<span class="label"><b class="ftx04">*</b>设置密码：</span>

							<div >
							  <table>
							     <tr>
							     
								<td><input type="password" name="user.password"
									maxlength="50" class="text" datatype="*6-8" nullmsg="请设置密码密码！" errormsg="密码范围在6~8位之间！" />
									</td>
								
							<td><div id="accountValidate" class="Validform_checktip"></div></td>
							</tr>
							</table>
							</div>
						</div>


						<div class="item">
							<span class="label"><b class="ftx04">*</b>确认密码：</span>
							<div >
							<table>
							<tr>
							  <td>
								<input type="password"  name="password2"
									maxlength="20" class="text" datatype="*" recheck="user.password" nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！">
                                </td>
                                <td><div id="accountValidate" class="Validform_checktip"></div></td>
							</tr>
							
							</table>
							</div>
						</div>
						
						<div class="item" id="dphone">
							<span class="label"><b class="ftx04">*</b>验证邮箱：</span>

							<div>
							   <table>
							      <tr>
							      <td>
								<input type="text" id="phone" maxlength="20" name="user.email"
									class="text" datatype="e" nullmsg="请输入邮箱！" errormsg="请输入正确格式邮箱！">
                         </td>
                          <td><div id="accountValidate" class="Validform_checktip"></div></td>
                          </tr>
                          </table>
							</div>

						</div>
						<div class="item" id="dphone">
							<span class="label"><b class="ftx04">*</b>联系电话：</span>

							<div>
							   <table>
							      <tr>
							      <td>
								<input type="text" id="phone" maxlength="20" name="user.tel"
									class="text" datatype="e" nullmsg="请输入电话！" errormsg="请输入正确格式邮箱！">
                         </td>
                          <td><div id="accountValidate" class="Validform_checktip"></div></td>
                          </tr>
                          </table>
							</div>

						</div>

					</div>
					
					<div class="item">
						<span class="label">公司行业：</span>

						<div >
						<table>
						 <tr>
						   <td>
							<select rel="select" tabindex="21" id="industry" name="indu" datatype="*" nullmsg="请选择行业" errormsg="请选择行业" class="Validform_error">
								<option value>请选择</option>
								<option value="计算机硬件及网络设备">计算机硬件及网络设备</option>
								<option value="计算机软件">计算机软件</option>
								<option value="IT服务（系统/数据/维护）/多领域经营">IT服务（系统/数据/维护）/多领域经营</option>
								<option value="4">互联网/电子商务</option>
								<option value="5">网络游戏</option>
								<option value="6">通讯（设备/运营/增值服务）</option>
								<option value="7">电子技术/半导体/集成电路</option>
								<option value="8">仪器仪表及工业自动化</option>
								<option value="9">金融/银行/投资/基金/证券</option>
								<option value="10">保险</option>
								<option value="11">房地产/建筑/建材/工程</option>
								<option value="12">家居/室内设计/装饰装潢</option>
								<option value="13">物业管理/商业中心</option>
								<option value="14">广告/会展/公关/市场推广</option>
								<option value="15">媒体/出版/影视/文化/艺术</option>
								<option value="16">印刷/包装/造纸</option>
								<option value="17">咨询/管理产业/法律/财会</option>
								<option value="18">教育/培训</option>
								<option value="19">检验/检测/认证</option>
								<option value="20">中介服务</option>
								<option value="21">贸易/进出口</option>
								<option value="22">零售/批发</option>
								<option value="23">快速消费品（食品/饮料/烟酒/化妆品</option>
								<option value="24">耐用消费品（服装服饰/纺织/皮革/家具/家电）</option>
								<option value="25">办公用品及设备</option>
								<option value="26">礼品/玩具/工艺美术/收藏品</option>
								<option value="27">大型设备/机电设备/重工业</option>
								<option value="28">加工制造（原料加工/模具）</option>
								<option value="29">汽车/摩托车（制造/维护/配件/销售/服务）</option>
								<option value="30">交通/运输/物流</option>
								<option value="31">医药/生物工程</option>
								<option value="32">医疗/护理/美容/保健</option>
								<option value="33">医疗设备/器械</option>
								<option value="34">酒店/餐饮</option>
								<option value="35">娱乐/体育/休闲</option>
								<option value="36">旅游/度假</option>
								<option value="37">石油/石化/化工</option>
								<option value="38">能源/矿产/采掘/冶炼</option>
								<option value="39">电气/电力/水利</option>
								<option value="40">航空/航天</option>
								<option value="41">学术/科研</option>
								<option value="42">政府/公共事业/非盈利机构</option>
								<option value="43">环保</option>
								<option value="44">农/林/牧/渔</option>
								<option value="45">跨领域经营</option>
								<option value="46">其它</option>
							</select> 
							</td>
							<td>
							<div class="Validform_checktip Validform_wrong">请选择企业行业！</div>
						   </td>
						   </tr>
						   </table>
						</div>
					</div>
					
					
					 <div class="item" id="authcodeDiv">
                        <span class="label"><b class="ftx04">*</b>验证码：</span>

                        <div class="fl item-ifo">
                            <input type="text" id="authcode"  name="checkcode" class="text text-1" tabindex="6"  maxlength="6">
                           <label class="img">
                                <img class="validate" style="cursor:pointer;width:100px;height:36px;display:block;" alt="" src="randomImg.action" onclick="chageValidateCode()" /> </label>
                           
                        </div>
                    </div>
					<div class="item item-new">
						<span class="label">&nbsp;</span>

						<div class="fl item-ifo">
							<input type="checkbox" class="checkbox" checked="checked"
								id="readme" onclick="agreeonProtocol();"> <label
								for="protocol">我已阅读并同意<a href="#" class="blue"
								id="protocol">《企业服务注册协议》</a></label> <span class="clr"></span> <label
								id="protocol_error" class="error hide">请接受服务条款</label>
						</div>
					</div>

				</div>
				<br>
				<br>
				<div class="btn-group" role="group" style="padding-left: 188px">
					<button type="submit" class="btn btn-default">注册</button>
				</div>
			</form>
		</div>
	</div>
<%@ include file="footer.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/js.js"></script>
<script type="text/javascript">
	$(function() {
		// $(".registForm").Validform();  //就这一行代码！;   

		$("#registForm").Validform({
			tiptype : 3
		});

	});
</script>
</body>
</html>