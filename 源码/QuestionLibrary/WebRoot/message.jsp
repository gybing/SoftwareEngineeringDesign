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
	margin: 0px;
	color: #000000;
	font-size: 15px;
	text-align: center;
}
</style>
<base href="<%=basePath%>">
<title><m:i18n name="message_title" />
</title>

</head>

<body>
	${message }
	<br>
</body>
</html>
