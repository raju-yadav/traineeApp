package controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import model.Login;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import service.LoginService;
import validators.LoginValidator;

@Controller
@Transactional
public class LoginController {
	
	private Log log = LogFactory.getLog(LoginController.class);
	@Autowired
	private LoginValidator loginValidator;
	@Autowired
	private LoginService loginService;

	@RequestMapping("/login.htm")
	public void showLogin(Map<String, Object> model) {
		model.put("login", new Login());
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String login(HttpSession session,
	        @ModelAttribute("login") Login login,
	        BindingResult errors) throws Exception {
		
		long id=loginValidator.validate(login, errors);
		

		if (errors.hasErrors()) {
			log.info("Error");
			return "login";
		}
		
		String name=loginService.getName(login.getUserName());
		String userid=login.getUserName();
		if(name==null){
			name=login.getUserName();
		}
		session.setAttribute("user", name);
		if(id==3)
		{
			session.setAttribute("userid", userid);
		return "redirect:/Trainee/home.htm";
		}
		session.setAttribute("user", name);
		return "redirect:/DashBoard/dashBoard.htm";
	}
	@RequestMapping("/logout.htm")
	public String logout(HttpSession session,SessionStatus status) {
		session.removeAttribute("arrivalsList");
		session.invalidate();
		status.setComplete();
		return "redirect:login.htm";
	}
	
	
}