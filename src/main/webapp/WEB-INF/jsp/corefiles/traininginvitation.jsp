<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp">
	<jsp:param value="Group Creation" name="pageTitle" />
</jsp:include>
<%@ taglib prefix="springs" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ui.accordion.js"></script>
<script>

	</script>
<spring:form modelAttribute="commonBean" action="submit.htm" >
	
	<div class="content" align="center">
		<div class="box">
			<br>
			<h2>Training Invitation</h2>
			<br/>
			<spring:errors path="selectedMails" cssClass="ui-state-error ui-corner-all" cssStyle="padding: 0 .7em;"></spring:errors>
			
			<h2><span style="color:red;" id="suc">${success}</span></h2>
			<hr>
			<table>
				<tr>
					<th><spring:label path="">Select Trining Name:</spring:label></th>
					<td><spring:select path="trainingName"
							cssStyle="width: 170px;" id="trainingName">
							<spring:option value="">--Select--</spring:option>
							<spring:options items="${training}" itemLabel="trainingName"
								itemValue="trainingName" />
						</spring:select>
						<span style="font-style: italic; color: red;"><spring:errors
								path="trainingName" cssClass="ui-state-error ui-corner-all" cssStyle="padding: 0 .7em;"></spring:errors></span></td>
								<td>	</td>
					<th><spring:label path="">Trainer Name:</spring:label></th>
					<td><span id="traName1"><%@include file="invitation/traName.jsp" %></span></td>
				</tr>
				<tr>
					<th><spring:label path="venu">Venue:</spring:label></th>
					<td><spring:select path="venu" cssStyle="width: 170px;" id="venu">
							<spring:option value="">--Select--</spring:option>
							<spring:option value="Training Hall1">TrainingHall 1</spring:option>
							<spring:option value="Training Hall2">TrainingHall 2</spring:option>
							<spring:option value="Training Hall3">TrainingHall 3</spring:option>
						</spring:select><spring:errors path="venu" cssClass="ui-state-error ui-corner-all" cssStyle="padding: 0 .7em;"/></td>
						<td></td>
					<th><spring:label path="">Training Type:</spring:label></th>
					
					<td>
					<c:set var="employeeListId" value="leftEmployeeList" scope="request"></c:set>
					<span id="traType"><%@include file="invitation/trainingType.jsp" %></span></td>
					<td></td>
					 
				</tr>
				<tr>
					<th><spring:label path="">Starting Date:</spring:label></th>
					<td>
					<span id="fromDate"><%@include file="invitation/fromDate.jsp" %></span></td>
					<td><pre>                   </pre></td>
					<th><spring:label path="">Ending Date:</spring:label></th>
					<td>
					<span id="toDate" ><%@include file="invitation/toDate.jsp" %></span></td>
					<td></td>
					
				</tr>
				<tr>
					<th><spring:label path="">Time Slot</spring:label></th>
					<td><spring:input path="timeSlot" cssStyle="width: 150px;" id="timeSlot"></spring:input>
					<spring:errors path="timeSlot" cssClass="ui-state-error ui-corner-all" cssStyle="padding: 0 .7em;"></spring:errors> </td>
				</tr>
			</table>
			<br>

			<hr>
			<br>
			<h2>Search Employees</h2>
			<br>
			<table>

				<tr>
					<th align='left'><spring:label path="">Employee Id: </spring:label>
					</th>
					<td colspan='5'><spring:input path="employeeId" cssStyle="width:150px"></spring:input>
						<span style="font-style: italic; color: red;"><spring:errors
								path="employeeId"></spring:errors> </span></td>
				
					<th align='left'><spring:label path="">Employee Name: </spring:label>
					</th>
					<td colspan='5'><spring:input path="employeeName" cssStyle="width:150px"></spring:input>
						<span style="font-style: italic; color: red;"><spring:errors
								path="employeeName"></spring:errors> </span></td>
					<td><input type="submit" value="Search" class="btnLogin"
						value="Submit" style="float: right; align: center;" /></td>
				</tr>
			</table>


			<div id="teamDataPanel" style="max-width: 800px;">

				<table id="teamDataTable" style="max-width: 800px; " class="dataTable">
					<thead>
						<tr>
							<th>Select</th>
							<th>EmployeeId</th>
							<th>EmployeeName</th>
							<th>EmailId</th>
							<th>Reportmanager</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${employees}" var="emp" varStatus="status">
							<tr class="${(status.count % 2 == 0) ? 'even' : 'odd'}">
								<td><spring:checkbox path="selectedMails" value="${emp.employeeId}" id="selectedMails" /></td>
								<td>${emp.employeeId}</td>
								<td>${emp.employeeName}</td>
								<td>${emp.emailid}</td>
								<td>${emp.reportmanager}</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
				<input type="submit" value="Send Invitation" name="sendMail" class="btnLogin" /><br>
				<br>
			</div>
		</div>
	</div>
</spring:form>
