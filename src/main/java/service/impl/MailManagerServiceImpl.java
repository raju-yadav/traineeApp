package service.impl;



import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import model.CommonBean;
import model.Employee;
import model.Training;
import service.EmployeeService;
import service.LoginService;
import service.MailManagerService;
import service.TrainingEmployeeService;
import service.TrainingService;
@Service
public class MailManagerServiceImpl implements MailManagerService {
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private EmployeeService empService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private TrainingService trainingService;
	@Autowired
	private TrainingEmployeeService trService;
	@Override
	public void sendMail(CommonBean commonBean,List<String> aray, List<Date> dateDet){
		String [] employeeid=commonBean.getSelectedMails();
		for (int i = 0; i < employeeid.length; i++) {
			Employee emp=empService.getEmployeeID(employeeid[i]);
			Training tr=trainingService.getName(aray.get(0));
			trService.saveorUpdate(emp,tr,dateDet.get(1));
			String pwd=loginService.getPassword(emp.getEmployeeId());
			try{
				MimeMessage mimeMessage = sender.createMimeMessage();
				MimeMsgSenderImpl msgsender=new MimeMsgSenderImpl(emp,aray,dateDet,pwd);
					msgsender.prepare(mimeMessage);	
					sender.send(msgsender);
				}catch(Exception e){e.printStackTrace();}
		}
		
	
	}
	
	
}
