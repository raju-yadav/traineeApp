package service.impl;


import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;

import model.Employee;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MimeMsgSenderImpl implements MimeMessagePreparator {
	

	private Employee emp;
	private List<String> aray;
	private List<Date> dateDet;
	private String pwd;
	public MimeMsgSenderImpl(){
		
	}
	public MimeMsgSenderImpl(Employee emp,List<String> aray, List<Date> date, String pwd) {
		this.emp=emp;
		this.aray=aray;
		this.dateDet=date;
		this.pwd=pwd;
	}
	
	@Override
	public void prepare(MimeMessage mimeMessage) throws Exception {
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		
			mimeMessageHelper.setTo(emp.getEmailid());
			mimeMessageHelper.setSubject("Invitation For Training");
			
			String empName=emp.getEmployeeName();
			 StringBuffer txt = new StringBuffer();
			 txt.append("<h1>Invitation for The Training</h1>");
			 	txt.append("Dear Sir/Madam <u>" + empName + "</u><hr>");
			    txt.append("<u>"+aray.get(0)+"</u>Training Has Been Sceduled, You are Requested to Attend the Training programme on venu :<u>"+aray.get(1));
			    txt.append("<br/></u>Assigned Trainer is : <u>"+aray.get(4));
			    txt.append("<br/></u>The Type of the Training is :<u>"+aray.get(2));
			    txt.append("<br/></u>Starting Date For the Training is: <u>"+dateDet.get(0)+"<br/></u>Till :<u>"+dateDet.get(1));
			    txt.append("</u><br>Timings:-<u>"+aray.get(3));
			    txt.append("<br/><br/><span style=\" font-style: italic; color: red;\">Note:-</span></u> You are requested to give the Feedback on the following link After Your Training Session.");
			    txt.append("<br/><br/> http://localhost:8888/traineeApp");
			    txt.append("<br/>Your Login Details are :-");
			    txt.append("<br/>User Name :<u>"+emp.getEmployeeId());
			    txt.append("<br/></u> Password :<u>"+pwd);
			      
			    txt.append("<br/>Regards</u><br/>Yell Adworks");
			   
			mimeMessageHelper.setText(txt.toString(), true);
			
		
		
		
	}

	

}
