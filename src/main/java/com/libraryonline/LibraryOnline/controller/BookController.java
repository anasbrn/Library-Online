package com.libraryonline.LibraryOnline.controller;
import com.libraryonline.LibraryOnline.model.entity.Book;
import com.libraryonline.LibraryOnline.model.entity.Category;
import com.libraryonline.LibraryOnline.response.BookResponse;
import com.libraryonline.LibraryOnline.service.BookService;
import com.libraryonline.LibraryOnline.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<BookResponse> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }
}
