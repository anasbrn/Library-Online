package com.libraryonline.LibraryOnline.controller;

import com.libraryonline.LibraryOnline.model.entity.User;
import com.libraryonline.LibraryOnline.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerFrom(){
        return "pages/auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user){
        this.userService.addUser(user);
        return "redirect:/home";
    }
}
