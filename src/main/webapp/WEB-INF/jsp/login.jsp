<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Login - TraineeApp</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/structure.css"/>
<link href="${pageContext.request.contextPath}/images/favicon.png" rel="shortcut icon" />
<link
	href="${pageContext.request.contextPath}/css/ui-lightness/jquery-ui-1.7.2.custom.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
</head>
<body bgcolor="#ffffff">

<table width="100%" height="100%" border="0" align="center"
	cellpadding="0" cellspacing="0" bgcolor="#63B8FF">
	<tr >
		<td width="60%" align="justify"><img
							src="${pageContext.request.contextPath}/images/Yell.jpg"
							style="float: left; position: relative;" alt="Yell Adworks"
							title="Yell Adworks" height="50px" /></td>
		<td width="40%" align="center">
		<h2><font color=#ffffff>Trainning Information&nbsp;System</font></h2>
		</td>
	</tr>
</table>
<form name="loginForm" method="post" class="box login">
<div class="boxBody">
<label style="text-align:center;">Member's Login</label>
<spring:bind path="login.userName">
		
			<label style="text-align: left;">Username</label>
			<input type="text" value="<c:out value="${status.value}"/>"
				name="<c:out value="${status.expression}"/>"></input> <c:if
				test="${status.error}">
				<c:forEach items="${status.errorMessages}" var="error">
					<c:out value="${error}" />
				</c:forEach>
			</c:if>
	</spring:bind>
<spring:bind path="login.password">
			<label style="text-align: left;">Password</label>
			<input type="password"
				value="<c:out value="${status.value}"/>"
				name="<c:out value="${status.expression}"/>"></input> <c:if
				test="${status.error}">
				<c:forEach items="${status.errorMessages}" var="error">
					<c:out value="${error}" />
				</c:forEach>
			</c:if>
	</spring:bind>
	<input	type="submit" tabindex="3" name="login" value="Login" class="btnLogin" style="float:right;" />
	<input	type="reset" tabindex="4" name="reset" value="Reset" class="btnLogin" style="float:right;" />
</div>
</form>



</body>
</html>