<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="bootstrap3/js/jquery-1.11.2.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/register.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/1.css">
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript">
	$(function() {
		// $(".registForm").Validform();  //就这一行代码！;   

		$("#registForm").Validform({
			tiptype : 2
		});

	});
</script>
</head>
<body>
<%-- <%@ include file="/view/common/mian.jsp"%> --%>
<div class="container">
				<h2>企业服务平台</h2>
	</div>
	<div class="w" id="regist">
    <div class="mt">
    </div>
    <div class="mc">
        <form  method="post" action="login" id="registForm"  enctype="multipart/form-data" >
           
            <div class="form" >
                <div class="item" id="select-regName">
                    <span class="label"><b class="ftx04">*</b>用户名：</span>

                    <div class="fl item-ifo">
                    <table>
                    <tr>
                       <div class="o-intelligent-regName">
                            <input type="text" id="regName" name="user.userName" maxlength="20" class="text" datatype="*6-15" nullmsg="请输入帐号！" errormsg="帐号范围在6~15位之间"/>
                        </div> 
                         <td><div id="accountValidate" class="Validform_checktip"></div></td>
                        </tr> </table>      
                    </div>
                </div>
                <div id="o-password">
                    <div class="item">
                    
                        <span class="label"><b class="ftx04">*</b>密码：</span>
           
                        <div class="fl item-ifo">
                         <table>
                    <tr>
                        <div class="o-intelligent-regName">
                            <input type="password" id="pwd" name="user.password" maxlength="20" class="text" datatype="*6-15" nullmsg="请输入密码！" errormsg="密码范围在6~15位之间！" />
                           </div>
                            <td><div id="accountValidate" class="Validform_checktip"></div></td>
                        </tr> </table>  
                        </div>
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
                 <br>
                 <div class="btn-group" role="group" style="padding-left: 188px">
    <button type="submit" class="btn btn-default">登录</button>
  </div>
            </div>
           
        </form>
        
    </div>
</div>



</body>
</html>