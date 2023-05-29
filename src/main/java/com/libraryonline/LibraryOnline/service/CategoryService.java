package com.libraryonline.LibraryOnline.service;
import com.libraryonline.LibraryOnline.model.entity.Category;
import com.libraryonline.LibraryOnline.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> getAllCategories() {
        return this.categoryRepo.findAll();
    }

    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    public void deleteCategory(Integer id) {
        this.categoryRepo.deleteById(id);
    }

    public Optional<Category> findById(Integer id) {
        return this.categoryRepo.findById(id);
    }

    public Category update(Category category) {
        return this.categoryRepo.save(category);
    }
}
