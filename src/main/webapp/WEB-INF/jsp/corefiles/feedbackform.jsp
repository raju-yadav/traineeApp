<jsp:include page="../header.jsp">
    <jsp:param value="FeedBack" name="pageTitle"/>
</jsp:include>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:form modelAttribute="commonBean" >
<div class="box"  >
<br>
<h2 align="center">Training Feedback Form</h2>
<br>
		<table >
			<tr><td></td></tr>
			<tr>
				<th><spring:label path="">Date</spring:label></th>
				<td style="position: absolute;"><spring:input path=""></spring:input><spring:errors path="dateOfFeedback" ></spring:errors></td>
				<td><pre>                    </pre></td>
				<th><spring:label path="">Faculty</spring:label></th>
				<td><spring:input path="facultyName"></spring:input><spring:errors path="facultyName" ></spring:errors></td>
			</tr>
			<tr>
				<th align='left'><spring:label path="">Title</spring:label></th>
				<td ><spring:select path="feedbackTitle"><spring:option value="">--Select--</spring:option>
				<spring:options items="${training}" itemLabel="trainingName" itemValue="trainingId"></spring:options></spring:select><spring:errors path="feedbackTitle" ></spring:errors></td>
			</tr>

		</table>
			
	<table border="1" style="position:relative; left:10px; top:30px;" class="box">
						<tr bgcolor='grey'>
							<th align="right"><spring:label path="">Legend</spring:label></th>
							<th><spring:label path="">5=EX</spring:label></th>
							<th><spring:label path="">4=VG</spring:label></th>
							<th><spring:label path="">3=G</spring:label></th>
							<th><spring:label path="">2=AVG</spring:label></th>
							<th><spring:label path="">1=Poor</spring:label></th>
						</tr>
						<tr bgcolor='grey'>
							<th align='left'><spring:label path="">About the Objectives</spring:label></th>
							<th>5</th>
							<th>4</th>
							<th>3</th>
							<th>2</th>
							<th>1</th>
						</tr>
						<tr>
							<td><spring:label path="">Were the objectives of the training clear?</spring:label><spring:errors path="trObjClearRadio" ></spring:errors></td>
							 <td align="center"><spring:radiobutton path="trObjClearRadio" value="5" /></td>
							<td align="center"><spring:radiobutton path="trObjClearRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjClearRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjClearRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjClearRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">Were the objectives of the training achieved?</spring:label><spring:errors path="trObjAchievedRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjAchievedRadio" value="5" /></td>
							<td align="center"><spring:radiobutton path="trObjAchievedRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjAchievedRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjAchievedRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjAchievedRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">How was the Presentation of the Content?</spring:label><spring:errors path="trObjContentRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjContentRadio" value="5" /></td>
							<td align="center"><spring:radiobutton path="trObjContentRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjContentRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjContentRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjContentRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">How would you rate your Understanding of the training 
							session?</spring:label><spring:errors path="trObjRateRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjRateRadio" value="5" /></td>
							<td align="center"><spring:radiobutton path="trObjRateRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjRateRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjRateRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjRateRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">How would you rate your Understanding of the reading
								materials?</spring:label><spring:errors path="trObjReadingRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjReadingRadio" value="5" /></td>
							<td align="center"><spring:radiobutton path="trObjReadingRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjReadingRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjReadingRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjReadingRadio" value="1" /></td>
						</tr>
						<tr bgcolor='grey'>
							<th align='left'><spring:label path="">About the Training topics?</spring:label></th>
							<th>5</th>
							<th>4</th>
							<th>3</th>
							<th>2</th>
							<th>1</th>
						</tr>
						<tr>
							<td><spring:label path="">How would you rate the training topics?</spring:label><spring:errors path="trObjTopiceRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjTopiceRadio" value="5" /></td>
							<td align="center"><spring:radiobutton path="trObjTopiceRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjTopiceRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjTopiceRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjTopiceRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">How relevent was it to your job profile?</spring:label></td>
							<td align="center"><spring:radiobutton path="trObjJobRadio" value="5" /><spring:errors path="trObjJobRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjJobRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjJobRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjJobRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjJobRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">Did you understand all that was presented?</spring:label></td>
							<td align="center"><spring:radiobutton path="trObjPresentedRadio" value="5" /><spring:errors path="trObjPresentedRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjPresentedRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjPresentedRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjPresentedRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjPresentedRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">How interesting was it?</spring:label></td>
							<td align="center"><spring:radiobutton path="trObjInterestRadio" value="5" /><spring:errors path="trObjInterestRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjInterestRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjInterestRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjInterestRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjInterestRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">Would this training improve your performance level in
								future?</spring:label></td>
							<td align="center"><spring:radiobutton path="trObjLevelRadio" value="5" /><spring:errors path="trObjLevelRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjLevelRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjLevelRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjLevelRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjLevelRadio" value="1" /></td>
						</tr>
						<tr bgcolor='grey'>
							<th align='left'><spring:label path="">About the Trainer</spring:label></th>
							<th>5</th>
							<th>4</th>
							<th>3</th>
							<th>2</th>
							<th>1</th>
						</tr>
						<tr>
							<td><spring:label path="">How would you rate the trainer?</spring:label><spring:errors path="trObjTrainerRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjTrainerRadio" value="5" /></td>
							<td align="center"><spring:radiobutton path="trObjTrainerRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjTrainerRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjTrainerRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjTrainerRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">How approachable was the trainer?</spring:label><spring:errors path="trObjTrainrRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjTrainrRadio" value="5" /></td>
							<td align="center"><spring:radiobutton path="trObjTrainrRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjTrainrRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjTrainrRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjTrainrRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">Did you undersand all that was said by the trainer?</spring:label><spring:errors path="trObjUrsantRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjUrsantRadio" value="5" /></td>
							<td align="center"><spring:radiobutton path="trObjUrsantRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjUrsantRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjUrsantRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjUrsantRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">How interesting were the sessions?</spring:label><spring:errors path="trObjSessionRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjSessionRadio" value="5" /></td>
							<td align="center"><spring:radiobutton path="trObjSessionRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjSessionRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjSessionRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjSessionRadio" value="1" /></td>
						</tr>
						<tr>
							<td><spring:label path="">How were your questioned related to training answered?</spring:label><spring:errors path="trObjAnsRadio" ></spring:errors></td>
							<td align="center"><spring:radiobutton path="trObjAnsRadio" value="5" /></td>
							<td align="center"><spring:radiobutton path="trObjAnsRadio" value="4" /></td>
							<td align="center"><spring:radiobutton path="trObjAnsRadio" value="3" /></td>
							<td align="center"><spring:radiobutton path="trObjAnsRadio" value="2" /></td>
							<td align="center"><spring:radiobutton path="trObjAnsRadio" value="1" /></td>
						</tr>
						<tr>
							<td colspan="6"><b><spring:label path="">General:How frequently do you think
								that this training program needs to be organized?</spring:label></b></td>
						</tr>
						
						<tr>
							<td><spring:textarea path="feedbackPerspective" rows="10" cols="120"/><spring:errors path="feedbackPerspective" ></spring:errors></td>
						</tr>
						<tr>
							<td colspan='6'><b><spring:label path="">Any special comments or suggestion for
								imprrovement. Please write in the place povided below.</spring:label></b></td>
						</tr>
						<tr>
							<td ><spring:textarea path="feedbackSuggestion" rows="10" cols="100%"/><spring:errors path="feedbackSuggestion" ></spring:errors></td>
						</tr>
					</table>
	
	
					
						
	</div>
				
</spring:form>
<%@include file="../footer.jsp" %>