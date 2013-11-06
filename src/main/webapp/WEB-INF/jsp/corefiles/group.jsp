
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
	
	<spring:form modelAttribute="commonBean" action="saveGroup.htm">
	<div class="content" align="center">
				<div class="box"><br>
					<h2>
						<spring:label path="">Group Creation</spring:label>
					</h2><br>
					<label style="font-style: italic;color: red;">${grpsuccess}</label>
					<hr>
					<table>
				
					<tr>
						<th align='left'><spring:label path="">Group Name: </spring:label>
						</th>
						<td colspan='5'><spring:input path="groupName"></spring:input>
						<span style="font-style: italic;color: red;"><spring:errors path="groupName"></spring:errors></span>
						</td>
						
					</tr>
					<tr><td></td><td><span style="font-style: italic;color: Blue;padding: 0 .7em;">${val1}</span></td></tr>
					</table><br><table>
					<tr><td><input type="submit" value="Submit" class="btnLogin" style="float:none; align:center;"/></td>
						<td><%-- <input type="button" value="Reset" class="btnLogin" style="float:none; align:center;" onclick="window.location.href='${val}'"/> --%><br></td>
					</tr>
					
					</table>
					<br>
					</div>
					</div>
					</spring:form>