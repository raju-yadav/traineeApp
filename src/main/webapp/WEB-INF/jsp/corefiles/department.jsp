
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
	
	<spring:form modelAttribute="commonBean" action="saveDept.htm">
	<div class="content" align="center">
				<div class="box"><br>
					<h2>
						<spring:label path="">Department Creation</spring:label>
						<label style="font-style: italic;color: red;">${deptsuccess}</label>
					</h2><br><hr>
					<table>
					
					<tr>
						<th align='left'><spring:label path="">Department Name: </spring:label>
						</th>
						<td colspan='5'><spring:input path="departmentName"></spring:input>
						<span style="font-style: italic;color: red;"><spring:errors path="departmentName"></spring:errors></span>
						</td>
						
					</tr>
					<tr><td></td><td><span style="font-style: italic;color: Blue;padding: 0 .7em;">${val1}</span></td></tr>
					</table><br><table>
					<tr><td><input type="submit" value="Submit" class="btnLogin" style="float:none; align:center;"/></td>
						<td>
						<br></td>
					</tr>
					
					</table>
					<br>
					</div></div></spring:form>
					                                                                                                                                                     