package com.libraryonline.LibraryOnline.controller;
import com.libraryonline.LibraryOnline.model.entity.Category;
import com.libraryonline.LibraryOnline.service.CategoryService;
import org.hibernate.boot.jaxb.Origin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
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
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/admin/categories";
    }

    @PostMapping("/admin/category/delete")
    public String deleteBook(@RequestParam("id") Integer id) {
        this.categoryService.deleteCategory(id);
        return "redirect:/admin/categories";
    }

}
