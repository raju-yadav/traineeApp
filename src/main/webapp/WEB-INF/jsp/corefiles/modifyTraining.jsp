<jsp:include page="../header.jsp">
	<jsp:param value="Training Creation" name="pageTitle" />
</jsp:include>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib prefix="springs" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:form modelAttribute="commonBean" action="submit.htm">
	
				<div class="content" align="center">
				<div class="box">
					<br>
					<h2>
						<label>Training Creation</label></h2>
						<label>(<span style="font-style: italic;color: red;">*</span> Mandatory Fields)</label>
					
						<label style="font-style: italic; color: red">If you want to Create the Training <a href="${pageContext.request.contextPath}/CreateTraining/training.htm"><u>Click Here</u></a></label>
					<hr>
				
						<table>
					
						<tr><td>
					
						<label><span style="font-style: italic;color: red;">*</span>Training Name: </label>
						</td><td>
						<spring:select path="trainingId" id="trName">
						<spring:option value="0">--Select--</spring:option>
						<spring:options items="${training}" itemLabel="trainingName"  itemValue="trainingId"/>
						</spring:select>
						<span style="font-style: italic;color: red;"><spring:errors path="trainingName"></spring:errors></span>
						</td></tr>
					
						<tr><td>
						<label><span style="font-style: italic;color: red;">*</span>Training Type: </label>
						</td>
						<td>

						 <spring:select path="trainingtype">
							<spring:option value="">--Select--</spring:option>
							<spring:option value="internal">Internal</spring:option>
							<spring:option value="External">External</spring:option>
						</spring:select> 
						<span style="font-style: italic;color: red;"><spring:errors path="trainingtype"></spring:errors></span>

					</td></tr>
					<tr><td>
						<label><span style="font-style: italic;color: red;">*</span>Department Name: </label>
						</td>
						<td>
						<spring:select path="deptId" ><spring:option value="0">--Select--</spring:option>
						<spring:options items="${dep}" itemLabel="deptName" itemValue="deptId"/> </spring:select>
					<span style="font-style: italic;color: red;"><spring:errors path="departmentName"></spring:errors></span>
					</td></tr>
					<tr><td>
						<label>Trainer Name: </label>
						</td>
						<td>
						<spring:select path="trainerName" ><spring:option value="">--Select--</spring:option>
						<spring:options items="${emp}" itemLabel="employeeName" itemValue="employeeId"></spring:options>
					
						</spring:select>
						<span style="font-style: italic;color: red;"><spring:errors path="trainerName"></spring:errors></span>
					</td></tr>
					<tr><td>
						<label>Group Name: </label>
						</td>
						<td>
						<spring:select path="group" ><spring:option value="0">--Select--</spring:option>
						<spring:options items="${gr}" itemLabel="groupName" itemValue="groupId"/> </spring:select>
						<span style="font-style: italic;color: red;"><spring:errors path="group"></spring:errors></span>
					</td></tr>
					<tr><td>
						<label><span style="font-style: italic;color: red;">*</span>Starting Date: </label>
						</td><td>
						<spring:input path="trFrom"></spring:input>
						<span style="font-style: italic;color: red;"><spring:errors path="trFrom"></spring:errors></span>
						</td></tr>
					<tr><td>
						<label><span style="font-style: italic;color: red;">*</span>Ending Date: </label>
						</td><td>
						<spring:input path="trEnd"></spring:input>
						<span style="font-style: italic;color: red;"><spring:errors path="trEnd"></spring:errors></span>
						</td></tr>
						<tr><td>
					</table>
				<br>
			
			<input type="submit" value="Submit" class="btnLogin" style="align:center; float:none;"/>
			<input type="button" value="Reset" class="btnLogin" style="align:center; float:none;" onclick="window.location.href='${val}'"/>
			<br><br>	
			</div>
	</div>
</spring:form>
<%@include file="../footer.jsp"%>