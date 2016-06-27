<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.silence.com" prefix="m"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
body {
	background-image: url(images/background.jpg);
	margin-top: 60px;
	color: #000000;
	font-size: 40px;
	
}

#content {
	margin-top: 150px;
	color: #000000;
	font-size: 40px;
	text-align: center;
}
</style>
<base href="<%=basePath%>">
<title><m:i18n name="index_title" />
</title>
</head>

<body>
	<img src="images/title.jpg" />
	<div id="content">
		<a href="${pageContext.request.contextPath }/LoginUIServlet"><m:i18n
				name="student_login" /> </a> <a
			href="${pageContext.request.contextPath }/LoginUIServlet?admin=admin"><m:i18n
				name="teacher_login" /> </a> <a
			href="${pageContext.request.contextPath }/RegisterUIServlet"><m:i18n
				name="student_register" /> </a> <a
			href="${pageContext.request.contextPath }/RegisterUIServlet?admin=admin"><m:i18n
				name="teacher_register" /> </a> <br>
	</div>
</body>
</html>
