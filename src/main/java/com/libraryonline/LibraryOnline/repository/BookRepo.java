package com.libraryonline.LibraryOnline.repository;

import com.libraryonline.LibraryOnline.model.entity.Book;
import com.libraryonline.LibraryOnline.response.BookResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {
    @Query("SELECT new com.libraryonline.LibraryOnline.response.BookResponse(b.id, b.title, b.description, b.author, b.image, b.category.name, b.file) FROM Book b")
    List<BookResponse> findAllBooksWithCategoryName();
    @Query("SELECT new com.libraryonline.LibraryOnline.response.BookResponse(b.id, b.title, b.description, b.author, b.image, b.category.name, b.file) FROM Book b INNER JOIN Favorite f ON b.id = f.book.id INNER JOIN User u ON u.id = f.user.id WHERE u.id = :userId")
    List<BookResponse> getFavoriteBooks(Integer userId);
}
