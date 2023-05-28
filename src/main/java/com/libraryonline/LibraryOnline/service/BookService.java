package com.libraryonline.LibraryOnline.service;
import com.libraryonline.LibraryOnline.model.entity.Book;
import com.libraryonline.LibraryOnline.model.entity.Category;
import com.libraryonline.LibraryOnline.repository.BookRepo;
import com.libraryonline.LibraryOnline.response.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<BookResponse> getAllBooks() {
        return this.bookRepo.findAllBooksWithCategoryName();
    }

    public Book addBook(Book book) {
        Book bookAdded = this.bookRepo.save(book);
        return bookAdded;
    }

    public void deleteBook(Integer id) {
        this.bookRepo.deleteById(id);
    }
}

