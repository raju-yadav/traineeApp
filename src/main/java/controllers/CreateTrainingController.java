package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.CommonBean;
import model.Employee;
import model.Training;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import service.EmployeeService;
import service.GroupService;
import service.TrainingService;
import validators.TrainingModificationvalidator;
import validators.TrainingValidator;

@Controller
@SessionAttributes("commonBean")
@Transactional
public class CreateTrainingController extends ManagementControllerSupport {
	@Autowired
	private EmployeeService empservice;
	@Autowired
	private TrainingService trainingService;
	@Autowired
	private GroupService grservice;
	@Autowired
    private TrainingValidator trvalidator;
	@Autowired
	private TrainingModificationvalidator tmv;
	
	@RequestMapping("/CreateTraining/training.htm")
	public String showForm(HttpSession session, Map<String, Object> model) {
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
		loadCommonData(session, model);
		List<String> dep=empservice.getDepartment();
		model.put("dep", dep);
		List<Employee> emp=empservice.getEmp();
		model.put("emp", emp);
		List<String> gr=grservice.getGroup();
		model.put("gr",gr);
		model.put("val", "training.htm");
		return "/corefiles/createtraining";
	}

	@RequestMapping(value = "/CreateTraining/submit.htm", method = RequestMethod.POST)
	public String next(HttpSession session, @ModelAttribute("commonBean") CommonBean commonBean, BindingResult errors, Map<String, Object> model) {
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
		trvalidator.validate(errors,commonBean);
		  if (errors.hasErrors()) {
	            return showForm(session, model);
	        }
		  loadCommonData(session, model);
		trainingService.saveOrUpdate(commonBean);
		model.put("val", "Training");
		model.put("val1", "training.htm");
		return "/corefiles/success";
	}

	@RequestMapping("/Training/trainingModification.htm")
	public String modifyTraining(HttpSession session, Map<String, Object> model) {
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
		loadCommonData(session, model);
		List<Training> training = new ArrayList<Training>();
		training=trainingService.getTrainingName();
		session.setAttribute("training", training);
		List<String> dep=empservice.getDepartment();
		model.put("dep", dep);
		List<Employee> emp=empservice.getEmp();
		model.put("emp", emp);
		List<String> gr=grservice.getGroup();
		model.put("gr",gr);
		model.put("val", "training.htm");
		return "/corefiles/modifyTraining";
	}
//	@RequestMapping(value = "/corefiles/modification/trainingstdate.htm")
//	public void loadTrainingdate(@RequestParam(value="trainingName", required=false)String trainingName, Map<String, Object> model){
//		Training det=trainingService.getName(trainingName);
//		model.put("trainingDet", det);
//	}
	
	@RequestMapping(value = "/Training/submit.htm", method = RequestMethod.POST)
	public String modify(HttpSession session, @ModelAttribute("commonBean") CommonBean commonBean, BindingResult errors, Map<String, Object> model) {
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
		tmv.validate(errors,commonBean);
		  if (errors.hasErrors()) {
	            return modifyTraining(session, model);
	        }
		  loadCommonData(session, model);
		 Training training= trainingService.getTrainingDet(commonBean.getTrainingId());
		 String name=training.getTrainingName();
		 
		trainingService.saveOrUpdate1(commonBean,name);
		model.put("val", "Training");
		model.put("val1", "trainingModification.htm");
		return "/corefiles/success";
	}
	@InitBinder
	public void bindConverters(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
}

