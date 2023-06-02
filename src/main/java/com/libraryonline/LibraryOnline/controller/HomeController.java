package com.libraryonline.LibraryOnline.controller;

import com.libraryonline.LibraryOnline.model.entity.Category;
import com.libraryonline.LibraryOnline.model.entity.User;
import com.libraryonline.LibraryOnline.response.BookResponse;
import com.libraryonline.LibraryOnline.service.BookService;
import com.libraryonline.LibraryOnline.service.CategoryService;
import com.libraryonline.LibraryOnline.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final BookService bookService;
    private final CategoryService categoryService;
    private final UserService userService;

    public HomeController(BookService bookService, CategoryService categoryService, UserService userService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String homePage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        return "pages/home";
    }

    @GetMapping("/admin/dashboard")
    public String dashboardPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<BookResponse> books = this.bookService.getAllBooks();
        List<Category> categories = this.categoryService.getAllCategories();
        List<User> users = this.userService.getAllUsers();
        if (user != null) {
        model.addAttribute("user", user);
        model.addAttribute("books", books);
        model.addAttribute("categories", categories);
        model.addAttribute("users", users);
            model.addAttribute("user", user);
            return "pages/dashboard/landing_page";
        } else {
            return "redirect:/login";
        }
    }
    @GetMapping("/admin/books")
    public String booksPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<BookResponse> books = bookService.getAllBooks();
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("books", books);
            return "/pages/dashboard/books/index";
        } else {
            return "redirect:/login";
        }
    }
    @GetMapping("/admin/categories")
    public String categoriesPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Category> categories = categoryService.getAllCategories();
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("categories", categories);
            return "/pages/dashboard/categories/index";
        } else {
            return "redirect:/login";
        }
    }
}
