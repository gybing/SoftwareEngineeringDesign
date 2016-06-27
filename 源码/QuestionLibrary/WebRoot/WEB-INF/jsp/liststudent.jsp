<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
body {
	background-image: url(images/background.jpg);
	margin-left: 200px;
	margin-top:40px;
	color: #000000;
	font-size: 15px;
	text-align: center;
}
</style>
  <head>
    <base href="<%=basePath%>">
    <title>${group.groupname }</title>
  </head>
  
  <body style="text-align: center;">
    ${group.groupname } <br>
    <table width="80%" frame="border" border="1">
    	<tr>
    		<td>学号</td>
    		<td>姓名</td>
    		<td>学院</td>
    		<td>班级</td>
    		<td>手机</td>
    		<td>邮箱</td>
    	</tr>
    	<c:forEach items="${students }" var="stu">
    		<tr>
    			<td>${stu.stuid }</td>
    			<td>${stu.stuname }</td>
    			<td>${stu.college }</td>
    			<td>${stu.groupname }</td>
    			<td>${stu.phone }</td>
    			<td>${stu.email }</td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
