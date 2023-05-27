package com.libraryonline.LibraryOnline.controller;

import com.libraryonline.LibraryOnline.response.BookResponse;
import com.libraryonline.LibraryOnline.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/home")
    public String homePage() {
        return "pages/home";
    }

    @GetMapping("/admin/dashboard")
    public String dashboardPage() {
        return "pages/dashboard/landing_page";
    }
    @GetMapping("/admin/books")
    public String booksPage(Model model) {
        List<BookResponse> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "pages/dashboard/books";
    }
}
