package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.CommonBean;
import model.Employee;
import model.Login;
import model.Training;
import model.TrainingEmployeeDet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.EmployeeService;
import service.FeedBackFormService;
import service.LoginService;
import service.TrainingEmployeeService;
import service.TrainingService;
import validators.FeedBackFormValidator;


@Controller
@Transactional
public class HomeController extends ManagementControllerSupport {
	@Autowired
	private LoginService loginService;
	@Autowired
	private TrainingEmployeeService trempservice;
	@Autowired
	private FeedBackFormValidator feedBackValidator;
	@Autowired
	private FeedBackFormService feedBackFormService;
	@Autowired
	private EmployeeService empService;
	@Autowired
	private TrainingService trservice;

	@RequestMapping("/DashBoard/dashBoard.htm")
	public String home(HttpServletRequest request, @ModelAttribute("commonBean") CommonBean commonBean,
			Map<String, Object> model) throws Exception {
		setCommonSearchBean(model);
			
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
		String loginUser = (String) session.getAttribute("user");
		Login login = loginService.getLoggedInUser(loginUser);
		model.put("loginUser", loginUser);
		model.put("employee", login);
		return "home";
	}
	@SuppressWarnings("deprecation")
	@RequestMapping("/Trainee/home.htm")
	public String showTrainee(HttpSession session, Map<String, Object> model){
		if(session.getAttribute("user")==null)
		{
			return "redirect:/login.htm";
		}
		loadCommonData(session, model);
		
		TrainingEmployeeDet tr=trempservice.getData(session.getAttribute("userid"));
		if(tr==null){
			return "corefiles/notraining";
		}
		if(tr.getFlag()==1){
			return "corefiles/completed";
		}
		Date endDate=tr.getEndDate();
		Date today=new Date();
		if(today.getDate()<=endDate.getDate() && today.getMonth()<=endDate.getMonth() && today.getYear()<=endDate.getYear()){
			return "corefiles/notcompletion";
		}
		if(tr.getFlag()==1){
			return "corefiles/completed";
		}
		loadCommonData(session, model);
		session.setAttribute("today", today);
		Training tra=tr.getTraining();
		tra=trservice.getTrainingDet(tra.getTrainingId());
		Employee emp=tra.getTrainerId();
		emp=empService.getEmployeeID(emp.getEmployeeId());
		tra=trservice.getTrainingDet(tra.getTrainingId());
		session.setAttribute("emp", emp);
		session.setAttribute("tra", tra);
		return "corefiles/traineeFeedBackForm";
	}
	
	@RequestMapping(value="/Trainee/save.htm", method=RequestMethod.POST)
	public String submitValue(@RequestParam("dateofFeedback") String dateofFeedback,
			@RequestParam("facultyName")String facultyname,
			@RequestParam("feedbackTitle")String feedbackTitle, HttpSession session, @ModelAttribute("commonBean") CommonBean commonBean, BindingResult errors, Map<String, Object> model){
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
		loadCommonData(session, model);
		feedBackValidator.validate(errors);
			if(errors.hasErrors()){
				return "corefiles/traineeFeedBackForm";
			}
		System.out.println(dateofFeedback+""+facultyname+""+feedbackTitle);
			TrainingEmployeeDet tr=trempservice.getData(session.getAttribute("userid"));
			trempservice.saveorUpdate(tr);
	        feedBackFormService.saveOrUpdate(commonBean,dateofFeedback, facultyname, feedbackTitle);
	        
	        model.put("val1","Thank You For Your Valueable FeedBack ");
	        return "/corefiles/success1";
		
	}
	@InitBinder
    public void bindConverters(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

	}
