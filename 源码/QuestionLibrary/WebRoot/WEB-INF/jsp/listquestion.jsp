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
	margin-left: 200px;
	margin-top:40px;
	color: #000000;
	font-size: 15px;
	text-align: center;
}
</style>
<head>
<base href="<%=basePath%>">
<title>题库</title>
</head>

<body style="text-align: center;">
	<a href="${pageContext.request.contextPath }/AddQuestionUIServlet">添加题目</a>
	<br/>
	选择题：<br/>
	<table frame="border" border="1" width="80%">
		<tr>
			<td>题目名称</td>
			<td>添加时间</td>
			<td>添加人</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${xuanze }" var="xz">
		<tr>
			<td><a href="${pageContext.request.contextPath }/QuestionDetailServlet?quesid=${xz.quesid}">${xz.quesname }</a></td>
			<td>${xz.insertTime }</td>
			<td>${xz.ownername }</td>
			<td>
				<a href="${pageContext.request.contextPath }/UpdateQuestionUIServlet?quesid=${xz.quesid}">修改</a>
				&nbsp;
				<a href="${pageContext.request.contextPath }/DeleteQuestionServlet?quesid=${xz.quesid}">删除</a>
			</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	填空题：<br/>
	<table frame="border" border="1" width="80%">
		<tr>
			<td>题目名称</td>
			<td>添加时间</td>
			<td>添加人</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${tiankong }" var="tk">
			<tr>
			<td><a href="${pageContext.request.contextPath }/QuestionDetailServlet?quesid=${tk.quesid}">${tk.quesname }</a></td>
			<td>${tk.insertTime }</td>
			<td>${tk.ownername }</td>
			<td>
			<a href="${pageContext.request.contextPath }/UpdateQuestionUIServlet?quesid=${tk.quesid}">修改</a>
			&nbsp;
			<a href="${pageContext.request.contextPath }/DeleteQuestionServlet?quesid=${tk.quesid}">删除</a>
			</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	名词解释题：<br/>
	<table frame="border" border="1" width="80%">
		<tr>
			<td>题目名称</td>
			<td>添加时间</td>
			<td>添加人</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${jeishi }" var="js">
			<tr>
			<td><a href="${pageContext.request.contextPath }/QuestionDetailServlet?quesid=${js.quesid}">${js.quesname }</a></td>
			<td>${js.insertTime }</td>
			<td>${js.ownername }</td>
			<td>
			<a href="${pageContext.request.contextPath }/UpdateQuestionUIServlet?quesid=${js.quesid}">修改</a>
			&nbsp;
			<a href="${pageContext.request.contextPath }/DeleteQuestionServlet?quesid=${js.quesid}">删除</a>
			</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	简答题：<br/>
	<table frame="border" border="1" width="80%">
		<tr>
			<td>题目名称</td>
			<td>添加时间</td>
			<td>添加人</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${jianda }" var="jd">
			<tr>
			<td><a href="${pageContext.request.contextPath }/QuestionDetailServlet?quesid=${jd.quesid}">${jd.quesname }</a></td>
			<td>${jd.insertTime }</td>
			<td>${jd.ownername }</td>
			<td>
			<a href="${pageContext.request.contextPath }/UpdateQuestionUIServlet?quesid=${jd.quesid}">修改</a>
			&nbsp;
			<a href="${pageContext.request.contextPath }/DeleteQuestionServlet?quesid=${jd.quesid}">删除</a>
			</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	应用题：<br/>
	<table frame="border" border="1" width="80%">
		<tr>
			<td>题目名称</td>
			<td>添加时间</td>
			<td>添加人</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${yingyong }" var="yy">
			<tr>
			<td><a href="${pageContext.request.contextPath }/QuestionDetailServlet?quesid=${yy.quesid}">${yy.quesname }</a></td>
			<td>${yy.insertTime }</td>
			<td>${yy.ownername }</td>
			<td>
			<a href="${pageContext.request.contextPath }/UpdateQuestionUIServlet?quesid=${yy.quesid}">修改</a>
			&nbsp;
			<a href="${pageContext.request.contextPath }/DeleteQuestionServlet?quesid=${yy.quesid}">删除</a>
			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
