package com.libraryonline.LibraryOnline.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BookController {
    @GetMapping("/books")
    public String booksPage(){
        return "books";
    }
}
