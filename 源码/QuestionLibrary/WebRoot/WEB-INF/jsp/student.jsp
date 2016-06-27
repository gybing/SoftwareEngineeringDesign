<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.silence.com" prefix="m"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
body {
	background-image: url(images/background.jpg);
	margin-top: 40px;
	margin-left: 200px;
	color: #000000;
	font-size: 15px;
	text-align: center;
}
</style>
<head>
<base href="<%=basePath%>">
<title><m:i18n name="student_title" />
</title>
</head>
<body style="text-align:  center;">
	你好，${user.stuname }！
	<br>
	你的试卷：<br/>
	<table width="90%" frame="border" border="1"style="text-align:  center;">
		<tr>
		    <td><font color="#0000FF">试卷名称</font></td>
		    <td><font color="#0000FF">发布时间</font></td>
		    <td><font color="#0000FF">发布人</font></td>
		</tr>
		<c:forEach items="${papers }" var="paper">
        <tr>
			<td><a href="${pageContext.request.contextPath }/PaperServlet?paperid=${paper.paperid}">${paper.papername }</a></td>
			<td>${paper.paperTime }</td>
			<td>${paper.ownername }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
