package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import service.LoginService;
import controllers.LoginController;

@Transactional
public class SecurityInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private LoginService loginService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (!(handler instanceof LoginController)) {
			if (!userAuthorized(request)) {
				String loginPage = request.getContextPath() + "/login.htm";
				response.sendRedirect(loginPage);
				return false;
			}
		} else if (request.getRequestURI().endsWith("/login.htm")) {
			if (userAuthorized(request)) {
				String homePage = request.getContextPath() + "/home.htm";
				response.sendRedirect(homePage);
				return false;
			}
		}

		return true;
	}

	private boolean userAuthorized(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session != null) {
			String loggedInUser = (String) session.getAttribute("user");
			return loggedInUser != null && loginService.getLoggedInUser(loggedInUser) != null;
		}
		
		return false;
	}
}
