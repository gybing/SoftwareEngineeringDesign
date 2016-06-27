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
<style type="text/css">
body {
	background-image: url(images/background.jpg);
	margin-left: 500px;
	margin-top:150px;
	color: #000000;
	font-size: 15px;
	text-align: center;
}
</style>
<head>
<base href="<%=basePath%>">
<title><m:i18n name="register_title" /></title>
</head>
<body>

	<form action="${pageContext.request.contextPath }/RegisterServlet"
		method="post">
		<input type="hidden" name="formId" value="${formId }"> <input
			type="hidden" name="admin" value="${admin }">
		<table>
		<c:choose>
			<c:when test="${empty(admin) }">
				<tr>
					<td>学生注册</td>
				</tr>
				<tr>
					<td><m:i18n name="login_stuid" /></td>
					<td>
						<input name="stuid" type="text" value="${param.stuid }"
							style="margin-bottom: 5px"><span>${errors.stuid }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="register_stuname" /></td>
					<td>
						<input name="stuname" type="text" value="${param.stuname }"
							style="margin-bottom: 5px"><span>${errors.stuname }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="register_college" /></td>
					<td>
						<input name="college" type="text" value="${param.college }"
							style="margin-bottom: 5px"><span>${errors.college }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="register_phone" /></td>
					<td>
						<input name="phone" type="text" value="${param.phone }"
							style="margin-bottom: 5px"><span>${errors.phone }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="register_email" /></td>
					<td>
						<input name="email" type="text" value="${param.email }"
							style="margin-bottom: 5px"><span>${errors.email }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="register_groupid" /></td>
					<td>
						<input name="groupid" type="text" value="${param.groupid }"
							style="margin-bottom: 5px"><span>${errors.groupid }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="login_password" /></td>
					<td>
						<input name="password" type="password" value="${param.password }"
							style="margin-bottom: 5px"><span>${errors.password }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="register_password2" /></td>
					<td>
						<input name="password2" type="password" value="${param.password2 }"
							style="margin-bottom: 5px"><span>${errors.password2 }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="login_checkCode" /></td>
					<td>
						<input type="text" name="checkCode" style="margin-bottom: 5px">
							<img src="${result.path}" height="25px" onclick="location.reload()" />
							<span>${checkCodeError }</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input name="submit" type="submit"
							value="<m:i18n name="register_submit" />"
							style="margin-bottom: 5px">
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td>教师注册</td>
				</tr>
				<tr>
					<td><m:i18n name="login_teaid" /></td>
					<td>
						<input name="teaid" type="text" value="${param.teaid }"
							style="margin-bottom: 5px"><span>${errors.teaid }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="register_teaname" /></td>
					<td>
						<input name="teaname" type="text" value="${param.teaname }"
							style="margin-bottom: 5px"><span>${errors.teaname }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="register_college" /></td>
					<td>
						<input name="college" type="text" value="${param.college }"
							style="margin-bottom: 5px"><span>${errors.college }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="register_phone" /></td>
					<td>
						<input name="phone" type="text" value="${param.phone }"
							style="margin-bottom: 5px"><span>${errors.phone }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="register_email" /></td>
					<td>
						<input name="email" type="text" value="${param.email }"
							style="margin-bottom: 5px"><span>${errors.email }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="login_password" /></td>
					<td>
						<input name="password" type="password" value="${param.password }"
							style="margin-bottom: 5px"><span>${errors.password }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="register_password2" /></td>
					<td>
						<input name="password2" type="password" value="${param.password2 }"
							style="margin-bottom: 5px"><span>${errors.password2 }</span>
					</td>
				</tr>
				<tr>
					<td><m:i18n name="login_checkCode" /></td>
					<td>
						<input type="text" name="checkCode" style="margin-bottom: 5px">
							<img src="${result.path}" height="25px" onclick="location.reload()" />
							<span>${checkCodeError }</span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input name="submit" type="submit"value="<m:i18n name="register_submit"/>" 
							style="margin-bottom: 5px">
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</table>
	</form>
</body>
</html>
