package com.libraryonline.LibraryOnline.repository;

import com.libraryonline.LibraryOnline.model.entity.Book;
import com.libraryonline.LibraryOnline.response.BookResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {
    @Query("SELECT new com.libraryonline.LibraryOnline.response.BookResponse(b.id, b.title, b.author, b.description, b.image, b.category.name) FROM Book b")
    List<BookResponse> findAllBooksWithCategoryName();
}
