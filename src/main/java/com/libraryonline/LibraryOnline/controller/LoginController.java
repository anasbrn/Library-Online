package com.libraryonline.LibraryOnline.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "pages/auth/login";
    }
    @GetMapping("/register")
    public String registerPage() {
        return "pages/auth/register";
    }
}
