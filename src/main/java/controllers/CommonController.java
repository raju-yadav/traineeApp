package controllers;

import java.util.Map;
import javax.servlet.http.HttpSession;

import model.CommonBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



import service.DepartmentService;
import service.GroupService;
import service.TemplateService;
import validators.CustCategoryValidator;
import validators.DepartmentValidator;
import validators.FeedBackCategoryValidator;
import validators.GroupValidator;

@Controller
@SessionAttributes("commonBean")
@Transactional
public class CommonController extends ManagementControllerSupport {
	@Autowired
	private TemplateService templateService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private GroupValidator grvalidator;
	@Autowired
	private DepartmentValidator depvalidator;
	@Autowired
	private CustCategoryValidator custCategory;
	@Autowired
	private FeedBackCategoryValidator feedCategory;
	
	@RequestMapping("/Customized/customizedproperties.htm")
	public String index(HttpSession session, Map<String, Object> model, 
		@RequestParam(value = "tab", required = false) Integer tabIndex) {
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
			loadCommonData(session, model);
				selectEmployeesTab(session);
				if(session.getAttribute("empsuccess")!=null)
					session.removeAttribute("empsuccess");
				if(session.getAttribute("deptsuccess")!=null)
					session.removeAttribute("deptsuccess");
				if(session.getAttribute("grpsuccess")!=null)
					session.removeAttribute("grpsuccess");
				if(session.getAttribute("objsuccess")!=null)
					session.removeAttribute("objsuccess");
				if(session.getAttribute("quesuccess")!=null)
					session.removeAttribute("quesuccess");
		return "/corefiles/index";
	}
	@RequestMapping("/Customized/customizedpropertiestab.htm")
	public String afterindex(HttpSession session, Map<String, Object> model, 
		@RequestParam(value = "tab", required = false) Integer tabIndex) {
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
			loadCommonData(session, model);
		

			if (session.getAttribute("currentTab") == null)
				selectEmployeesTab(session);
			
				
		
		return "/corefiles/index";
	}
	@RequestMapping(value = "/Customized/saveGroup.htm", method = RequestMethod.POST)
	public String saveGroup(HttpSession session, @ModelAttribute("commonBean") CommonBean commonBean, BindingResult errors, Map<String, Object> model) {
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
		selectGroupTab(session);
		loadCommonData(session, model);
		grvalidator.validate(errors,commonBean);
		if (errors.hasErrors()) {
            return "/corefiles/index";
        }
		
		groupService.saveOrUpdate(commonBean);
		/*EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		long rows = employeeDaoImpl.insertLoginInfo(commonBean);
		if(rows <= 0) {
		}*/
		if(session.getAttribute("empsuccess")!=null)
			session.removeAttribute("empsuccess");
		if(session.getAttribute("deptsuccess")!=null)
			session.removeAttribute("deptsuccess");
		if(session.getAttribute("objsuccess")!=null)
			session.removeAttribute("objsuccess");
		if(session.getAttribute("quesuccess")!=null)
			session.removeAttribute("quesuccess");
		session.setAttribute("grpsuccess", "(Group Inserted Successfully)");
		return "redirect:/Customized/customizedpropertiestab.htm";
	}
	@RequestMapping(value = "/Customized/saveDept.htm", method = RequestMethod.POST)
	public String saveDepartment(HttpSession session, @ModelAttribute("commonBean") CommonBean commonBean, BindingResult errors, SessionStatus status,Map<String, Object> model) {
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
		loadCommonData(session, model);
		selectDeptTab(session);
		depvalidator.validate(errors,commonBean);
		if (errors.hasErrors()) {
			
            return "corefiles/index";
        }
		
		departmentService.saveOrUpdate(commonBean);
		if(session.getAttribute("empsuccess")!=null)
			session.removeAttribute("empsuccess");
		if(session.getAttribute("grpsuccess")!=null)
			session.removeAttribute("grpsuccess");
		if(session.getAttribute("objsuccess")!=null)
			session.removeAttribute("objsuccess");
		if(session.getAttribute("quesuccess")!=null)
			session.removeAttribute("quesuccess");
		session.setAttribute("deptsuccess", "(Department Inserted Successfully)");
		status.setComplete();
		return "redirect:/Customized/customizedpropertiestab.htm";
	}
	
	@RequestMapping(value = "/Customized/saveObjective.htm", method = RequestMethod.POST)
	public String saveObjectives(HttpSession session, @ModelAttribute("commonBean") CommonBean commonBean, BindingResult errors, Map<String, Object> model) {
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}selectFeeTempTab(session);
		loadCommonData(session, model);
		custCategory.validate(errors,commonBean);
		if (errors.hasErrors()) {
            return "/corefiles/index";
        }
		templateService.saveOrUpdate(commonBean);
		if(session.getAttribute("empsuccess")!=null)
			session.removeAttribute("empsuccess");
		if(session.getAttribute("grpsuccess")!=null)
			session.removeAttribute("grpsuccess");
		if(session.getAttribute("deptsuccess")!=null)
			session.removeAttribute("deptsuccess");
		if(session.getAttribute("quesuccess")!=null)
			session.removeAttribute("quesuccess");
		session.setAttribute("objsuccess", "(Objective Inserted Successfully)");
		return "redirect:/Customized/customizedpropertiestab.htm";
	}
	@RequestMapping(value = "/Customized/saveQue.htm", method = RequestMethod.POST)
	public String saveQuestions(HttpSession session, @ModelAttribute("commonBean") CommonBean commonBean, BindingResult errors, Map<String, Object> model) {
		if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}selectFeeTempTab(session);
		loadCommonData(session, model);
		feedCategory.validate(errors,commonBean);
		if (errors.hasErrors()) {
            return "/corefiles/index";
        }
		templateService.saveOrUpdate1(commonBean);
		loadCommonData(session, model);
		if(session.getAttribute("empsuccess")!=null)
			session.removeAttribute("empsuccess");
		if(session.getAttribute("grpsuccess")!=null)
			session.removeAttribute("grpsuccess");
		if(session.getAttribute("deptsuccess")!=null)
			session.removeAttribute("deptsuccess");
		if(session.getAttribute("objsuccess")!=null)
			session.removeAttribute("objsuccess");
		session.setAttribute("quesuccess", "(SubCategory Inserted Successfully)");
		
		return "/corefiles/index";
	}
	
}
