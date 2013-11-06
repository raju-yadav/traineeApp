
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
	
	<spring:form modelAttribute="commonBean" action="saveEmployee.htm" onreset="this.reset();">
	
				<div class="content" align="center">
				<div class="box" style="width: 600px;" >
					<h2>
						<label>Employee Creation</label></h2>
						<label>(<span style="font-style: italic;color: red;">*</span> Mandatory Fields)</label>
						<label style="font-style: italic;color: red;">${empsuccess}</label>
					<hr>
				<table >
					<tr>
						<th align='left'><label><span style="font-style: italic;color: red;">*</span>Employee Id: </label>
						</th>
						<td colspan='5'><spring:input path="employeeId" ></spring:input>
						<span style="font-style: italic;color: red;"><spring:errors path="employeeId"></spring:errors></span>
						</td>
					</tr>
					<tr>
						<th align='left'><label><span style="font-style: italic;color: red;">*</span>Employee Name: </label>
						</th>
						<td colspan='5'><spring:input path="employeeName"></spring:input>
						
						<span style="font-style: italic;color: red;"><spring:errors path="employeeName"></spring:errors></span>
						</td>
					</tr>
					
					<tr>
						<th align='left'><label><span style="font-style: italic;color: red;">*</span>Password: </label>
						</th>
						<td colspan='5'><spring:password path="password"></spring:password>
						<span style="font-style: italic;color: red;"><spring:errors path="password"></spring:errors></span>
						</td>
					</tr>
					<tr>

						<th align='left'><label><span style="font-style: italic;color: red;">*</span>Depart Name: </label>
						</th>

					<td><spring:select path="deptId" ><spring:option value="0">--Select--</spring:option>
					<spring:options items="${departments}" itemLabel="deptName" itemValue="deptId"/> </spring:select>
					<span style="font-style: italic;color: red;"><spring:errors path="deptId"></spring:errors></span>
					</td>
					</tr>
					<tr>
						<th align='left'><label><span style="font-style: italic;color: red;">*</span>Designation: </label>
						</th>
						
						<td><spring:select path="designationId" ><spring:option value="">--Select--</spring:option>
						<spring:option value="manager">Manager</spring:option>
						<spring:option value="employee">Employee</spring:option>
						</spring:select><span style="font-style: italic;color: red;"><spring:errors path="designationId"></spring:errors></span>
					    </td>
					</tr>
					<tr>
				
						<th align='left'><label><span style="font-style: italic;color: red;">*</span>User Type: </label>
						</th>
						<td><spring:select path="userTypeId" ><spring:option value="0">--Select--</spring:option>
						<spring:options items="${roles}" itemLabel="typeName" itemValue="id"/></spring:select>
						<span style="font-style: italic;color: red;"><spring:errors path="userTypeId"></spring:errors></span>
						</td>
					</tr>
					
					<tr>
						<th align='left'><label><span style="font-style: italic;color: red;">*</span>EmailId: </label>
						</th>
						<td colspan='5'><spring:input path="emailid"></spring:input>
						<span style="font-style: italic;color: red;"><spring:errors path="emailid"></spring:errors></span>
						</td>
					</tr>
					<tr>
						<th align='left'><label><span style="font-style: italic;color: red;">*</span>ReportingManager: </label>
						</th>
						<td colspan='5'><spring:input path="reportmanager"></spring:input>
						<span style="font-style: italic;color: red;"><spring:errors path="reportmanager"></spring:errors></span>
						</td>
					</tr>
					<tr><td></td><td><span style="font-style: italic;color: Blue;padding: 0 .7em;">${val1}</span></td></tr>
				</table>
				<br>
			<table align="center">
				<tr>
					<td align="center"><input type="submit" class="btnLogin" value="Submit"/>
					
					</td>
				</tr>
			</table>
			<br>

</div>
</div>
</spring:form>


