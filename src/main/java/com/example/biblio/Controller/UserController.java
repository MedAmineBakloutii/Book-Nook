package com.example.biblio.Controller;

import com.example.biblio.Model.User;
import com.example.biblio.Service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/login"; // Redirect to login page after successful registration
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser() {
        // Handle login logic here
        return "redirect:/dashboard"; // Redirect to the dashboard after successful login
    }

    @GetMapping("/admin/login")
    public String showAdminLoginForm() {
        return "admin-login";
    }

    @PostMapping("/admin/login")
    public String loginAdmin() {
        // Handle admin login logic here
        return "redirect:/admin/dashboard"; // Redirect to the admin dashboard after successful login
    }

    // Additional methods for user management

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user-list";
    }


}
