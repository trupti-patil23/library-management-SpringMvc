package com.library.library_management.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CommonController {	

    /**
     * Handles the logout functionality for both Student and Librarian.
     * @param session The current HTTP session.
     * @return Redirects to the login page after invalidating the session.
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    
        // Invalidate the session
        session.invalidate();
        
        // Redirect to login page
        return "redirect:/";
    }

}
