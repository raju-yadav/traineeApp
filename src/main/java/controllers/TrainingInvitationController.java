package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.CommonBean;
import model.Employee;
import model.Training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.EmployeeService;
import service.MailManagerService;
import service.TrainingService;
import validators.TrainingInvitationValidator;

@Controller
@SessionAttributes("commonBean")
@Transactional
public class TrainingInvitationController extends ManagementControllerSupport {
	@Autowired
	private TrainingInvitationValidator trainingvalidator;

	@Autowired
	private EmployeeService employeeService;
	@Autowired 
	private MailManagerService mailManagerService;
	@Autowired
	private TrainingService triainingService;
	@RequestMapping("/TrainingInvitation/traininginvitation.htm")
	public String show(@RequestParam(value="trainingName", required=false)String trainingName, HttpSession session, Map<String, Object> model) {
		loadCommonData(session, model);
		if(session.getAttribute("success")!=null)
			session.removeAttribute("success");
		List<Employee> employees = new ArrayList<Employee>();
		model.put("employees", employees);
		List<Training> training = new ArrayList<Training>();
		training=triainingService.getTrainingName();
		model.put("trainingName", trainingName);
		session.setAttribute("training", training);
	
		return "/corefiles/traininginvitation";
	}
	@RequestMapping("/TrainingInvitation/traininginvitation1.htm")
	public String success(@RequestParam(value="trainingName", required=false)String trainingName, HttpSession session, Map<String, Object> model) {
		loadCommonData(session, model);
		List<Employee> employees = new ArrayList<Employee>();
		model.put("employees", employees);
		List<Training> training = new ArrayList<Training>();
		training=triainingService.getTrainingName();
		model.put("trainingName", trainingName);
		session.setAttribute("training", training);
	
		return "/corefiles/traininginvitation";
	}
	
	@RequestMapping(value = "/corefiles/invitation/trainingType.htm")
	public void loadtrainingtype(@RequestParam(value="trainingName", required=false)String trainingName, Map<String, Object> model){
		Training det=triainingService.getName(trainingName);
		model.put("trainingDet", det);
	}
	@RequestMapping(value = "/corefiles/invitation/fromDate.htm")
	public void loadTrainingdate(@RequestParam(value="trainingName", required=false)String trainingName, Map<String, Object> model){
		Training det=triainingService.getName(trainingName);
		model.put("trainingDet", det);
	}
	@RequestMapping(value = "/corefiles/invitation/toDate.htm")
	public void loadTrainingtoDate(@RequestParam(value="trainingName", required=false)String trainingName, Map<String, Object> model){
		Training det=triainingService.getName(trainingName);
		model.put("trainingDet", det);
	}
	@RequestMapping(value = "/corefiles/invitation/traName.htm")
	public void loadtraName1(@RequestParam(value="trainingName", required=false)String trainingName, Map<String, Object> model){
		Training det=triainingService.getName(trainingName);
		Employee emp=det.getTrainerId();
		String empString=emp.getEmployeeId();
		System.out.println(empString);
		emp=employeeService.getEmployeeID(empString);
		model.put("employee", emp);
	}
	
	@RequestMapping(value = "/TrainingInvitation/submit.htm", method = RequestMethod.POST)
	public String search(@RequestParam(value="trainingName", required=false)String trainingName,HttpSession session, @ModelAttribute("commonBean") CommonBean commonBean, BindingResult errors, Map<String, Object> model) {
		loadCommonData(session, model);
		if(trainingName==""){
			errors.rejectValue("trainingName", "trainingName.required");
			return "/corefiles/traininginvitation";
		}
		List<Employee> employees = new ArrayList<Employee>();
		String employeeId = commonBean.getEmployeeId(); 
		String empName = commonBean.getEmployeeName(); 
	    employees = employeeService.getEmployees(employeeId,empName);
		model.put("employees", employees);
		loadTrainingdate(trainingName, model);
		loadTrainingtoDate(trainingName, model);
		loadtrainingtype(trainingName, model);
		loadtraName1(trainingName, model);
		return "/corefiles/traininginvitation";
	}
	@RequestMapping(value = "/TrainingInvitation/submit.htm", method = RequestMethod.POST, params="sendMail")
	public String sendMail(@RequestParam(value="trainingName", required=false)String trainingName,@RequestParam(value="venu", required=false)String venuName,@RequestParam(value="timeSlot", required=false)String timeSlot,HttpSession session, @ModelAttribute("commonBean") CommonBean commonBean, BindingResult errors, Map<String, Object> model) {
		loadCommonData(session, model);
		trainingvalidator.validate(errors, commonBean, trainingName, venuName, timeSlot);
		if(errors.hasErrors()){
			if(trainingName!=""){
				loadtraName1(trainingName, model);
				loadTrainingdate(trainingName, model);
			}
			return "/corefiles/traininginvitation";
		}
		List<String> aray=new ArrayList<String>(); 
		Training training=triainingService.getName(trainingName);
		List<Date> dateDet=new ArrayList<Date>();
		dateDet.add(training.getFromDate());
		dateDet.add(training.getToDate());
		Employee emp=training.getTrainerId();
		String empString=emp.getEmployeeId();
		emp=employeeService.getEmployeeID(empString);
		
		aray.add(trainingName);aray.add(venuName);aray.add(training.getTrainingtype());aray.add(timeSlot);aray.add(emp.getEmployeeName()); 
		mailManagerService.sendMail(commonBean, aray, dateDet);
		session.setAttribute("success", "Invitation Has Been Sent");
		return "redirect:/TrainingInvitation/traininginvitation1.htm";
	}
}
