package com.libraryonline.LibraryOnline.repository;

import com.libraryonline.LibraryOnline.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
