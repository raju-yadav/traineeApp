<jsp:include page="../header.jsp">
	<jsp:param value="Employee Creation" name="pageTitle" />
</jsp:include>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
	<div class="content" align="center">
				<div class="box">
				<br><br><br>
	
				<h1><span>${val}</span> Inserted Successfully</h1>
				<br><br><br>
				<input type="button" value="Back"  class="btnLogin" style="float:none;align:center;" onclick="window.location.href='${val1}'"/>
				<br><br>
				</div>
				</div>