package com.iplus.studentManagement.Controller;

import com.iplus.studentManagement.Entity.User;
import com.iplus.studentManagement.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // --- Page 1: SIGN UP (GET) ---
    // Access: http://localhost:8080/signup
    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup"; // Renders the signup.html template
    }

    // --- Page 1: SIGN UP SUBMISSION (POST) ---
    @PostMapping("/signup")
    public String registerUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            RedirectAttributes redirectAttributes) {

        try {
            // Calls the Service method to save the new user with an encoded password
            userService.saveNewUser(username, password, role); 
            
            // Successful sign-up redirects to the login page with a flash message
            redirectAttributes.addFlashAttribute("message", "Registration successful! Please log in.");
            return "redirect:/login";
        } catch (RuntimeException e) {
            // Failure: username exists (runtime exception thrown from service)
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/signup";
        }
    }

    // --- Page 2: LOGIN (GET) ---
    // Access: http://localhost:8080/login
    // This displays the login form. Spring Security handles the form submission (POST).
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Renders the login.html template
    }
    
    // --- Page 3: WELCOME/STUDENT HOME PAGE (GET) ---
    // Access: http://localhost:8080/home (after successful login)
    @GetMapping("/home")
    public ModelAndView studentHome() {
        ModelAndView mav = new ModelAndView("home"); 
        mav.addObject("message", "Welcome to Student Home!");
        return mav;
    }
}