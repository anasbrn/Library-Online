package com.libraryonline.LibraryOnline.service;
import com.libraryonline.LibraryOnline.model.entity.Book;
import com.libraryonline.LibraryOnline.repository.BookRepo;
import com.libraryonline.LibraryOnline.response.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<BookResponse> findById(Integer id) {
        Optional<Book> bookOptional = this.bookRepo.findById(id);
        return bookOptional.map(this::convertToBookResponse);
    }

    public List<BookResponse> getFavoriteBooks(Integer userId) {
        return this.bookRepo.getFavoriteBooks(userId);
    }

    private BookResponse convertToBookResponse(Book book) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setTitle(book.getTitle());
        bookResponse.setAuthor(book.getAuthor());
        bookResponse.setDescription(book.getDescription());
        bookResponse.setImage(book.getImage());
        bookResponse.setCategoryName(book.getCategory().getName());

        return bookResponse;
    }


    public Book update(Book book) {
        return this.bookRepo.save(book);
    }
}

