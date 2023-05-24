package com.libraryonline.LibraryOnline.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class CategoryController {
    public String categoriesPage() {
        return "categories";
    }
}
