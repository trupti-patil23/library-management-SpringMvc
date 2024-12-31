package com.library.library_management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.library.library_management.service.LoginService;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/")
	public String homePage(HttpServletResponse response) throws IOException{
		return "Login";
	}
	
	@PostMapping("/login")
	public String login( @RequestParam("userType") String userType,
            			 @RequestParam("email") String email,
            			 @RequestParam("password") String password,
            			 HttpSession session,
            			 Model model) {	
		
		//Verify if user is Authenticated or not
		boolean isAuthenticated = loginService.authenticateUser(userType, email, password);
		
		session.setAttribute("userType", userType);
		session.setAttribute("userEmail", email);
		
		if(isAuthenticated) {
			if("Student".equals(userType)) {
				return "redirect:/student/dashboard";
			} else if ("Librarian".equals(userType)) {
				return "redirect:/librarian/dashboard";
			}
		}
		
		model.addAttribute("errorMessage", "Invalid email or password. Please try again.");
		
		return "Login";		
	}
}
