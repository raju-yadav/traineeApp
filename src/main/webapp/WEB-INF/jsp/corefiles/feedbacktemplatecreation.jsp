
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib prefix="springs" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ui.accordion.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ui.core.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ui.widget.js"></script>
	<script>
	$(function() {
		var icons = {
				header: "ui-icon-circle-arrow-e",
				headerSelected: "ui-icon-circle-arrow-s"
			};
		$( "#accordion" ).accordion({icons: icons, autoHeight: false});
	});
	</script>
	
				<div class="box" align="center">
				<div  id="accordion" >
				
				<h3><a href="#">Create Objectives</a></h3>
				<div>
					<spring:form modelAttribute="commonBean" action="saveObjective.htm">
					<br>
					<label style="font-style: italic;color: red;">${objsuccess}</label>
					<br>
					<h2>Training Objective </h2>
					<table>
					<tr><td>
						<label>Objective Name</label>
						</td><td>
						<spring:input path="trobj"></spring:input>
						<span style="font-style: italic;color: red;"><spring:errors path="trobj" cssClass="ui-state-error ui-corner-all" cssStyle="padding: 0 .7em;"></spring:errors></span>
						</td></tr>
						<tr><td></td><td><input type="submit" value="Submit" class="btnLogin" style="float:right; align:center;"/></td></tr>
					</table>
					
			</spring:form></div>
			<h3><a href="#">Create SubCategories</a></h3>
			<div>
			<spring:form modelAttribute="commonBean" action="saveQue.htm">
			<br>
			<label style="font-style: italic;color: red;">${quesuccess}</label>
			<br>
			<h2>Question on Objectives</h2>
			<table>
					<tr><td>
						<label>Question</label>
						</td><td>
						<spring:input path="trque"></spring:input>
						<span style="font-style: italic;color: red;"><spring:errors path="trque" cssClass="ui-state-error ui-corner-all" cssStyle="padding: 0 .7em;"></spring:errors></span>
						</td></tr>
						<tr><td>
						<label>Type</label></td>
						<td><spring:select path="objid"><spring:option value="0">--Select--</spring:option>
						<spring:options items="${objectives}" itemLabel="feedObj" itemValue="objectiveid"></spring:options></spring:select>
						<span style="font-style: italic;color: red;"><spring:errors path="objid" cssClass="ui-state-error ui-corner-all" cssStyle="padding: 0 .7em;"></spring:errors></span></td></tr>
						<tr><td></td><td><input type="submit" value="Submit" class="btnLogin" style="float:right; align:center;"/></td></tr>
					</table>
					
					<br>
			</spring:form></div></div>
					</div>