package validators;

import model.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import service.LoginService;

@Component
public class LoginValidator {
	
	@Autowired
	private LoginService loginService;

	public long validate(Login login, Errors errors) {
		if (login.getUserName().equals("")) {
			errors.rejectValue("userName", "userName");
		} else if (login.getPassword().equals("")) {
			errors.rejectValue("password", "password");
		}
		if (errors.getErrorCount() == 0){
			long id=dbValidation(login, errors);
			return id;
		}
		return 0;	
	}

	private long dbValidation(Login login, Errors errors) {
		Login user = loginService.userCheck(login);
		if (user == null) {
			errors.rejectValue("userName", "loginName.notValid");
		}
		if(user != null){
			long id=loginService.getRole(login);
			return id;
		}
		return 0;
	}
}
