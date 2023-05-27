package com.libraryonline.LibraryOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String homePage() {
        return "pages/home";
    }

    @GetMapping("/admin/dashboard")
    public String dashboardPage() {
        return "pages/landing_page";
    }
}
