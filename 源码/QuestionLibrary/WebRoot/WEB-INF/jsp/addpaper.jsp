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
<title>添加试卷</title>
</head>

<body style="text-align: center;">
	<form action="${pageContext.request.contextPath }/AddPaperServlet"
		method="post">
		<input type="hidden" name="formId" value="${formId }">
		<table frame="border">
			<tr>
				<td>试卷标题</td>
				<td><input type="text" name="papername">
				</td>
			</tr>
			<tr>
				<td>${paper.paperTime }</td>
			</tr>
			<tr>
				<td>${paper.ownername }</td>
			</tr>
			<c:if test="${!empty(xuanze) }">
				<tr>
					<td>${xuhao[i] }选择题 <%
						request.setAttribute("i",
									((Integer) request.getAttribute("i")) + 1);
					%>
					</td>
				</tr>

				<c:forEach items="${xuanze }" var="xz">
					<tr>
						<td>${xz.quescontent }</td>
					</tr>
					<tr>
						<td><input type="radio" name="${xz.quesid }" value="A">${xz.other1
							}&nbsp;&nbsp; <input type="radio" name="${xz.quesid }" value="B">${xz.other2
							}&nbsp;&nbsp; <input type="radio" name="${xz.quesid }" value="C">${xz.other3
							}&nbsp;&nbsp; <input type="radio" name="${xz.quesid }" value="D">${xz.other4
							}</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${!empty(tiankong) }">
				<tr>
					<td>${xuhao[i] }填空题 <%
						request.setAttribute("i",
									((Integer) request.getAttribute("i")) + 1);
					%>
					</td>
				</tr>
				<c:forEach items="${tiankong }" var="tk">
					<tr>
						<td>${tk.quescontent }</td>
					</tr>
					<tr>
						<td><input type="text" name="${tk.quesid }"></td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${!empty(jeishi) }">
				<tr>
					<td>${xuhao[i] }名词解释题 <%
						request.setAttribute("i",
									((Integer) request.getAttribute("i")) + 1);
					%>
					</td>
				</tr>
				<c:forEach items="${jeishi }" var="js">
					<tr>
						<td>${js.quescontent }</td>
					</tr>
					<tr>
						<td><textarea rows="5" cols="50" name="${js.quesid }"></textarea>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${!empty(jianda) }">
				<tr>
					<td>${xuhao[i] }简答题 <%
						request.setAttribute("i",
									((Integer) request.getAttribute("i")) + 1);
					%>
					</td>
				</tr>
				<c:forEach items="${jianda }" var="jd">
					<tr>
						<td>${jd.quescontent }</td>
					</tr>
					<tr>
						<td><textarea rows="5" cols="50" name="${jd.quesid }"></textarea>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${!empty(yingyong) }">
				<tr>
					<td>${xuhao[i] }应用题 <%
						request.setAttribute("i",
									((Integer) request.getAttribute("i")) + 1);
					%>
					</td>
				</tr>
				<c:forEach items="${yingyong }" var="yy">
					<tr>
						<td>${yy.quescontent }</td>
					</tr>
					<tr>
						<td><textarea rows="5" cols="50" name="${yy.quesid }"></textarea>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr>
				<td><input type="submit" name="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>
