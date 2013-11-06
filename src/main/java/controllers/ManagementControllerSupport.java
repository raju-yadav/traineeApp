package controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import service.EmployeeService;
import service.TemplateService;

import model.CommonBean;


public abstract class ManagementControllerSupport {
	@Autowired
	private EmployeeService	employeeService;
	@Autowired
	private TemplateService templateService;
	
	protected void loadCommonData(HttpSession session, Map<String, Object> model) {
		loadCurrentUser(session, model);
		setCommonBean(model);
		setCommonSearchBean(model);
		loadDepartment(model);
		loadRoles(model);
		loadObjectives(model);
	}

	private void loadObjectives(Map<String, Object> model) {
		List<String> objectives = templateService.getData();
		model.put("objectives", objectives);
			
	}

	private void loadRoles(Map<String, Object> model) {
		List<String> roles = employeeService.getRoles();
		model.put("roles", roles);
	}

	private void loadDepartment(Map<String, Object> model) {
		List<String> departments = employeeService.getDepartment();
		model.put("departments", departments);
	}

	protected void loadCurrentUser(HttpSession session, Map<String, Object> model) {
		String loginUser = (String) session.getAttribute("user");
		model.put("loginUser", loginUser);
	}
	private void setCommonBean(Map<String, Object> model) {
		if (!model.containsKey("commonBean"))
			model.put("commonBean", new CommonBean());
	}
	protected void setCommonSearchBean(Map<String, Object> model) {
		if (!model.containsKey("searchBean"))
			model.put("searchBean", new CommonBean());
	}
	protected void selectEmployeesTab(HttpSession session) {
		session.setAttribute("currentTab", 0);
	}

	protected void selectDeptTab(HttpSession session) {
		session.setAttribute("currentTab", 1);
	}

	protected void selectGroupTab(HttpSession session) {
		session.setAttribute("currentTab", 2);
	}
	protected void selectFeeTempTab(HttpSession session) {
		session.setAttribute("currentTab", 3);
	}
}
