package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.CommonBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.EmployeeService;
import validators.EmployeeValidator;
import dao.impl.EmployeeDaoImpl;

@SuppressWarnings("unused")
@Controller
@SessionAttributes("commonBean")
@Transactional
public class EmployeeController extends ManagementControllerSupport {
	@Autowired 
	private EmployeeValidator empvalidator;
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/Employee/AddEmployee.htm")
	public String showForm(HttpSession session, Map<String, Object> model) {
		loadCommonData(session, model);
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
		List<String> departments = employeeService.getDepartment();
		List<String> roles = employeeService.getRoles();
		model.put("departments", departments);
		model.put("roles", roles);
		model.put("val1", "Employee Record Inserted Successfully");
		return "/corefiles/employee";
	}

	@RequestMapping(value = "/Customized/saveEmployee", method = RequestMethod.POST)
	public String next(HttpSession session, @ModelAttribute("commonBean") CommonBean commonBean, BindingResult errors, Map<String, Object> model) {
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
		loadCommonData(session, model);
		selectEmployeesTab(session);
		empvalidator.validate(errors,commonBean);
		if (errors.hasErrors()) {
            return "corefiles/index";
        }
		
		employeeService.saveOrUpdate(commonBean);
		if(session.getAttribute("deptsuccess")!=null)
			session.removeAttribute("deptsuccess");
		if(session.getAttribute("grpsuccess")!=null)
			session.removeAttribute("grpsuccess");
		if(session.getAttribute("objsuccess")!=null)
			session.removeAttribute("objsuccess");
		if(session.getAttribute("quesuccess")!=null)
			session.removeAttribute("quesuccess");
		session.setAttribute("empsuccess", "(Employee Inserted Successfully)");
		return "redirect:/Customized/customizedpropertiestab.htm";
	}

	@InitBinder
	public void bindConverters(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
}