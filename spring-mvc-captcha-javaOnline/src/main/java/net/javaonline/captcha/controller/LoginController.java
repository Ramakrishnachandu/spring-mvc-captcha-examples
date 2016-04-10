package net.javaonline.captcha.controller;
import javax.servlet.http.HttpSession;

import net.javaonline.login.form.Login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	private static final String CAPTCHA2 = "CAPTCHA";

	@Value("${app.login.username}")
	private String username;
	
	
	@Value("${app.login.password}")
	private String password;
	
	@RequestMapping(value="/loadLoginPg")
	public String homepage(Model model){
		Login login= new Login();
		model.addAttribute("login", login);
		return "login";
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") Login login,BindingResult result,Model model,HttpSession session) {
		LOGGER.debug("--- In Login method ----");
		if (login.getUserId() == null || login.getUserId().equals("")){
			login.setCaptcha("");
			model.addAttribute("message", "User Id is required");
			return "login";
		}


		if (login.getPassword() == null || login.getPassword().equals("")){
			login.setCaptcha("");
			model.addAttribute("message", "Password is required");
			return "login";
		}	

		String captcha = (String) session.getAttribute(CAPTCHA2);
		if(captcha == null || (captcha != null && !captcha.equals(login.getCaptcha()))){
			login.setCaptcha("");
			model.addAttribute("message", "Captcha does not match");
			return "login";
		}

		if(login.getUserId().equals(username) && login.getPassword().equals(password)){
			System.out.println("user id and password matches");
			model.addAttribute("loginId", login.getUserId());
			return "home";
		}
		else{
			login.setCaptcha("");
			model.addAttribute("message","User ID or Password Incorrect");
			return "login";	
		}
	}
}
