package com.libraryonline.LibraryOnline.controller;

import com.libraryonline.LibraryOnline.model.entity.User;
import com.libraryonline.LibraryOnline.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "pages/auth/login";
    }
    @GetMapping("/register")
    public String registerPage() {
        return "pages/auth/register";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        User user = this.userService.findUser(username, password);
        if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
        {
            session.setAttribute("user", user);
            if (user.getRole().equals("USER"))
            {
                return "redirect:/home";
            }
            else if (user.getRole().equals("ADMIN"))
            {
                return "redirect:/admin/dashboard";
            }
        }
        else
        {
            return "redirect:/login?error";
        }
        return username;
    }
}
