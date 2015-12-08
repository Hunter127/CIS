<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%  
  Object username = session.getAttribute("admin");  
  if(null == username){  
        /* 管理员页面，无权访问 */
      response.sendRedirect("index.jsp");  
  }  
%>  
</head>
<body>
管理员
</body>
</html>