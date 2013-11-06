<jsp:include page="header.jsp">
	<jsp:param value="Employee Creation" name="pageTitle" />
</jsp:include>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<div class="content" align="center">
				<div class="box">
				<br><br>
<ul>
		<li style="width: 164px; background:none; display: list-item;" class="menuli"><a href="${pageContext.request.contextPath}/Employee/AddEmployee.htm">CreateEmployee</a></li>
		
		<li style="width: 164px; background:none;" class="menuli"><a href="${pageContext.request.contextPath}/Group/group.htm">Create Group</a></li>
		
		<li style="width: 164px; background:none;" class="menuli"><a href="${pageContext.request.contextPath}/Department/department.htm">Create Department</a></li>		
		<li style="width: 164px; background:none;" class="menuli"><a href="${pageContext.request.contextPath}/Template/feedTemplate.htm">FeedBack Template Creation</a></li>		

</ul>
<br><br>
</div></div>