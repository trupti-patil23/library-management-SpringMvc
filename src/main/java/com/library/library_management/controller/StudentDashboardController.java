package com.library.library_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.library.library_management.exception.ResourceNotFoundException;
import com.library.library_management.model.Book;
import com.library.library_management.service.BorrowRequestService;
import com.library.library_management.service.StudentDashboardService;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/")
public class StudentDashboardController {
	
	@Autowired
	private StudentDashboardService studentDashboardService;
	
	@Autowired
	private BorrowRequestService borrowRequestService;

	@GetMapping("/student/dashboard")
	public String showStudentDashboard(HttpSession session, Model model) {
		String userType = (String) session.getAttribute("userType");
		
		 // Check if session is valid
        if (userType == null || !"Student".equals(userType)) {
            return "redirect:/login";
        }
        
        // Fetch available books
        List<Book> availableBooks = studentDashboardService.getAvailableBooks();
        model.addAttribute("availableBooks", availableBooks);
     //   model.addAttribute("userEmail", userEmail);        
      
		return "StudentDashboard";
	}
	
    // Handle borrow request
	@PostMapping("/student/borrow") 
	public String borrowBookRequest(@RequestParam("bookId") int bookId, HttpSession session, Model model) {

		String userEmail = (String) session.getAttribute("userEmail");
		 
      //ToDO : Before BorrowRequest Request, Add validation like checking if the student has overdue books
        
     // Handle borrow request logic
        try {
	        boolean isRequestSuccessful = borrowRequestService.createBorrowRequest(userEmail, bookId);
	        if (isRequestSuccessful) {
	            model.addAttribute("successMessage", "Book borrowed successfully!");
	        } else {
	            model.addAttribute("errorMessage", "Failed to borrow the book. Please try again.");
	        }
        }catch (ResourceNotFoundException e) {
            throw e; 
        }catch(Exception e) {
        	throw e;
        }
        
        // Reload available books
        List<Book> availableBooks = studentDashboardService.getAvailableBooks();
        model.addAttribute("availableBooks", availableBooks);
		
		return "StudentDashboard";		
	}
}
