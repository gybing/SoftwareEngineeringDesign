<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.silence.com" prefix="m" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title><m:i18n name="teacher_title"/></title>
  </head>
  <body style="text-align: center;">
            您好，${user.teaname }老师！<br>
           您的班级：
    <table width="80%" frame="border" style="text-align: center;" border="1">
    	<tr>
    		<td>学院</td>
    		<td>班级</td>
    	</tr>
   	 	<c:forEach items="${groups }" var="group">
   	 		<tr>
    			<td>${group.college }</td>
    			<td><a href="${pageContext.request.contextPath }/GroupServlet?groupid=${group.groupid}">${group.groupname }</a></td>
    		</tr>
    	</c:forEach>
    </table>
    <a href="${pageContext.request.contextPath }/ListQuestionServlet">题库管理</a>
    &nbsp;
    <a href="${pageContext.request.contextPath }/AddPaperUIServlet">添加试卷</a>
    
  </body>
</html>
