package com.libraryonline.LibraryOnline.repository;
import com.libraryonline.LibraryOnline.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
