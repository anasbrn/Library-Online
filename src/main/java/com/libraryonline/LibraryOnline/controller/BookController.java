package com.libraryonline.LibraryOnline.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.libraryonline.LibraryOnline.model.entity.Book;
import com.libraryonline.LibraryOnline.model.entity.Category;
import com.libraryonline.LibraryOnline.response.BookResponse;
import com.libraryonline.LibraryOnline.service.BookService;
import com.libraryonline.LibraryOnline.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class BookController {
    private final BookService bookService;
    private final CategoryService categoryService;

    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }
    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<BookResponse> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "pages/books";
    }

    @GetMapping("/admin/books/create")
    public String createBookPage(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "/pages/dashboard/books/create";
    }

    @PostMapping("/admin/book/store")
    public String save(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return  "redirect:/admin/books";
    }


}
