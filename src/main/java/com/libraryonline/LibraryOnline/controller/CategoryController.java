package com.libraryonline.LibraryOnline.controller;
import com.libraryonline.LibraryOnline.model.entity.Category;
import com.libraryonline.LibraryOnline.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/categories")
    public String categoriesPage(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "/pages/categories";
    }

    @GetMapping("/admin/categories/create")
    public String createCategoryPage() {
        return "/pages/dashboard/categories/create";
    }

    @PostMapping("/admin/category/store")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

}
