package com.libraryonline.LibraryOnline.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.libraryonline.LibraryOnline.model.entity.Book;
import com.libraryonline.LibraryOnline.model.entity.Category;
import com.libraryonline.LibraryOnline.model.entity.User;
import com.libraryonline.LibraryOnline.response.BookResponse;
import com.libraryonline.LibraryOnline.service.BookService;
import com.libraryonline.LibraryOnline.service.CategoryService;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

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
    public String getAllBooks(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null){
            List<BookResponse> books = bookService.getAllBooks();
            model.addAttribute("user", user);
            model.addAttribute("books", books);
            return "pages/books";
        } else {
            return "redirect:/login";
        }
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

    @PostMapping("/admin/book/delete")
    public String deleteBook(@RequestParam("id") Integer id) {
        this.bookService.deleteBook(id);
        return "redirect:/admin/books";
    }

    @GetMapping("/admin/book/{id}/edit")
    public String editBookPage(@RequestParam("id") Integer id, Model model) throws NotFoundException {
        Optional<BookResponse> bookList = bookService.findById(id);
        List<Category> categories = categoryService.getAllCategories();
        BookResponse book = bookList.get();
        model.addAttribute("book", book);
        model.addAttribute("categories", categories);

        return "/pages/dashboard/books/edit";
    }

    @PostMapping("/admin/book/update")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookService.update(book);
        return "redirect:/admin/books";
    }


}
