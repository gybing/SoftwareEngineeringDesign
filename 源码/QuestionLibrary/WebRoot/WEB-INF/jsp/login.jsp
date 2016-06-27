<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title><m:i18n name="login_title" /></title>
</head>
<body>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<center>
		<font color="red"> <s:actionerror /> <s:fielderror /> </font>
		<form action="${pageContext.request.contextPath }/LoginServlet"
			method="post" theme="simple">
			<input type="hidden" name="formId" value="${formId }"> <input
				type="hidden" name="admin" value="${admin }">
			<c:choose>
				<c:when test="${empty(admin) }">
					<table background="images/student.jpg" width="344" height="300">
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><m:i18n name="login_stuid" />
							</td>
							<td><input name="stuid" type="text" value="${param.stuid }"
								style="margin-bottom: 5px"><span>${errors.stuid }</span>
							</td>
						</tr>
						<tr>
							<td><m:i18n name="login_password" />
							</td>
							<td><input name="password" type="password"
								value="${param.password }" style="margin-bottom: 5px"><span>${errors.password
									}</span></td>
						</tr>
						<tr>
							<td><m:i18n name="login_checkCode" />
							</td>
							<td><input type="text" name="checkCode"
								style="margin-bottom: 5px"><img src="${result.path}"
								height="25px" onclick="location.reload()" /><span>${checkCodeError
									}</span>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input name="submit" type="submit"
								value="<m:i18n name="login_submit"/>" style="margin-bottom: 5px">
							</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<table background="images/teacher.jpg" width="344" height="300">
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><m:i18n name="login_teaid" />
							</td>
							<td><input name="teaid" type="text" value="${param.teaid }"
								style="margin-bottom: 5px"> <span>${errors.teaid
									}</span></td>
						</tr>
						<tr>
							<td><m:i18n name="login_password" />
							</td>
							<td><input name="password" type="password"
								value="${param.password }" style="margin-bottom: 5px"> <span>${errors.password
									}</span></td>
						</tr>
						<tr>
							<td><m:i18n name="login_checkCode" />
							</td>
							<td><input type="text" name="checkCode"
								style="margin-bottom: 5px"><img src="${result.path}"
								height="25px" onclick="location.reload()" /><span>${checkCodeError
									}</span></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input name="submit" type="submit"
								value="<m:i18n name="login_submit"/>" style="margin-bottom: 5px">
							</td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
		</form>
	</center>
</body>
</html>
