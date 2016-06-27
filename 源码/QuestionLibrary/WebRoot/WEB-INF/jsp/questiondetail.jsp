<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	margin-left:0px;
	color: #000000;
	font-size: 20px;
	text-align: center;
}
</style>
<head>
<base href="<%=basePath%>">
<title>题目内容</title>
</head>
<body style="text-align: center;">
	题目名称<br/>
	${question.quesname }
	<br/>
	 题目类型 
	 <br/>
	 ${question.questype }
	 <br/>
	 题目内容 <br/>
	 ${question.quescontent }
	 <br/>
	 题目答案 <br/>
	 ${question.quesanswer }
	 <br/>
	 题目备注1 <br/>
	 ${question.other1 }
	 <br/>
	 题目备注2<br/>
	${question.other2 }
	<br/>
	题目备注3 <br/>
	${question.other3 }
	<br/>
	题目备注4<br/>
	${question.other4 }
	<br/>
	 添加时间<br/>
	 ${question.insertTime }
	 <br/>
	  添加人<br/>
	 ${question.ownername }
	 <br/>
</body>
</html>
