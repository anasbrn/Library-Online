package com.libraryonline.LibraryOnline.controller;

import com.libraryonline.LibraryOnline.model.entity.Favorite;
import com.libraryonline.LibraryOnline.model.entity.User;
import com.libraryonline.LibraryOnline.response.BookResponse;
import com.libraryonline.LibraryOnline.service.BookService;
import com.libraryonline.LibraryOnline.service.FavoriteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class FavoriteController {
    private final FavoriteService favoriteService;
    private final BookService bookService;

    public FavoriteController(FavoriteService favoriteService, BookService bookService) {
        this.favoriteService = favoriteService;
        this.bookService = bookService;
    }

    @GetMapping("/favorites")
    public String favoritesPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
        System.out.println("useeeeeeeeeeeeeer : "+user.getId());
            List<BookResponse> books = this.bookService.getFavoriteBooks(user.getId());
            model.addAttribute("user", user);
            model.addAttribute("books", books);
            return "pages/favorites";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/favorite/store")
    public String addToFavorite(@RequestParam("book_id") Integer bookId, @RequestParam("user_id") Integer userId) {
        Favorite favorite = new Favorite();
        favorite.setBookId(bookId);
        favorite.setUserId(userId);

        this.favoriteService.addToFavorite(favorite);

        return "redirect:/favorites";
    }
}
