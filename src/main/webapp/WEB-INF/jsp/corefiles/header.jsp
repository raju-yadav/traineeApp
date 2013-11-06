<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>${param['pageTitle']} - TraineeApp</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/structure.css"/>
<link href="${pageContext.request.contextPath}/css/blue-style.css" rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/css/redmond/jquery-ui-1.8.20.custom.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/demo_table.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/images/favicon.png" rel="shortcut icon" />
<script type="text/javascript">
	contextRoot = '${pageContext.request.contextPath}';
</script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui-1.8.20.custom.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/script.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dropdown.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui-timepicker-addon.js"></script>
	
<script type="text/javascript"> 
$(document).ready(function(){ 
	
	$("#nav ul.child").removeClass("child");
	
	$("#nav li").has("ul").hover(function(){
		$(this).addClass("current").children("ul").fadeIn();
	}, function() {
		$(this).removeClass("current").children("ul").hide();
	});
		
});
</script>

</head>

<body style="min-width: 900px;">

<table width="100%" height="100%" border="0" align="center"
	cellpadding="0" cellspacing="0" bgcolor="#63B8FF">
		<tr>
			<td width="40%" align="justify"><img
				src="${pageContext.request.contextPath}/images/Yell.jpg"
				style="float: left; position: relative;" alt="Yell Adworks"
				title="Yell Adworks" height="50px" /></td>
			<td width="30%" style="text-align: center;vertical-align: middle;">
				<h2>
					<font color=#ffffff >Trainning Information&nbsp;System</font>
				</h2>
			</td >
			<td width="30%" align="center" style="text-align: center;vertical-align: bottom;">Welcome,&nbsp;&nbsp;<c:out value="${loginUser}" />!&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="${pageContext.request.contextPath}/logout.htm"><span style="text-decoration: underline;">Logout</span></a>
			</td>
		</tr>
	</table>
	
<div class="content" >
<%@include file="hrnavigation.jsp" %>