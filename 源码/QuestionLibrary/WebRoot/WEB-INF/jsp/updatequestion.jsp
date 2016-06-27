<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	margin-top: 40px;
	margin-left:200px;
	color: #000000;
	font-size: 15px;
	text-align: center;
}
</style>
  <head>
    <base href="<%=basePath%>">
    <title>修改题目</title>
  </head>
  <body>
  	<form action="${pageContext.request.contextPath }/UpdateQuestionServlet" method="post">
  	<input type="hidden" name="formId" value="${formId }">
  	<input type="hidden" name="quesid" value="${question.quesid }">
  	<table width="80%" frame="border" border="1">
  		<tr>
  			<td>题目名称</td>
  			<td><input type="text" name="quesname" value="${question.quesname }"><span>${errors.quesname }</span></td>
  		</tr>
  		<tr>
  			<td>题目类型</td>
  			<td>
  				<input type="radio" name="questype" value="xuanze">选择题
  				<input type="radio" name="questype" value="tiankong">填空题
  				<input type="radio" name="questype" value="jeishi">名词解释题
  				<input type="radio" name="questype" value="jianda">简答题
  				<input type="radio" name="questype" value="yingyong">应用题
  			</td>
  		</tr>
  		<tr>
  			<td>题目内容</td>
  			<td><textarea rows="4" cols="70" name="quescontent" >${question.quescontent }</textarea><span>${errors.quescontent }</span></td>
  		</tr>
  		<tr>
  			<td>题目答案</td>
  			<td><textarea rows="4" cols="70" name="quesanswer">${question.quesanswer }</textarea><span>${errors.quesanswer }</span></td>
  		</tr>
  		<tr>
  			<td>题目备注1</td>
  			<td><input type="text" name="other1" value="${question.other1 }"><span>${errors.other1 }</span></td>
  		</tr>
  		<tr>
  			<td>题目备注2</td>
  			<td><input type="text" name="other2" value="${question.other2 }"><span>${errors.other2 }</span></td>
  		</tr>
  		<tr>
  			<td>题目备注3</td>
  			<td><input type="text" name="other3" value="${question.other3 }"><span>${errors.other3 }</span></td>
  		</tr>
  		<tr>
  			<td>题目备注4</td>
  			<td><input type="text" name="other4" value="${question.other4 }"><span>${errors.other4 }</span></td>
  		</tr>
  		<tr>
  			<td>操作</td>
  			<td>
  				<input type="reset" value="清空">
  				<input type="submit" name="submit" value="提交">
  			</td>
  		</tr>
  	</table>
  	</form>
  </body>
</html>
