package com.libraryonline.LibraryOnline.controller;

import com.libraryonline.LibraryOnline.model.entity.Category;
import com.libraryonline.LibraryOnline.response.BookResponse;
import com.libraryonline.LibraryOnline.service.BookService;
import com.libraryonline.LibraryOnline.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final BookService bookService;
    private final CategoryService categoryService;

    public HomeController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
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
        return "/pages/dashboard/books/index";
    }
    @GetMapping("/admin/categories")
    public String categoriesPage(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "/pages/dashboard/categories/index";
    }
}
