<jsp:include page="../header.jsp">
    <jsp:param value="Create Team" name="pageTitle"/>
</jsp:include>

<div id="customizableTabs">
    <ul>
        <li><a href="#employeesTab">Create Employee</a></li>
        <li><a href="#departmentTab">Create Department</a></li>
        <li><a href="#groupTab">Create Group</a></li>
        <li><a href="#templateTab">FeedBack Template</a></li>
    </ul>
    <div id="employeesTab">
        <span id="empForm">
            <%@include file="employee.jsp" %>
        </span>
    </div>
    <div id="departmentTab">
        <span id="depForm">
            <%@include file="department.jsp" %>
        </span>
    </div>
    <div id="groupTab">
        <span id="grpForm">
            <%@include file="group.jsp" %>
        </span>
    </div>
    <div id="templateTab">
        <span id="tepForm">
            <%@include file="feedbacktemplatecreation.jsp" %>
        </span>
    </div>
    <script type="text/javascript">
    $("#customizableTabs").tabs().tabs('select', ${currentTab});
</script></div><%@include file="../footer.jsp" %>