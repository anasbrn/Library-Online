package com.libraryonline.LibraryOnline.controller;

import com.libraryonline.LibraryOnline.model.entity.Favorite;
import com.libraryonline.LibraryOnline.model.entity.User;
import com.libraryonline.LibraryOnline.service.FavoriteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin(origins = "*")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("favorites")
    public String favoritesPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            return "pages/favorites";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/favorite/store")
    public String addToFavorite(@RequestParam("book_id") Integer bookId, @RequestParam("user_id") Integer userId) {
        System.out.println("bbbbbbbbokId" + bookId);
        System.out.println("useeeeeeeeerId" + userId);
        Favorite favorite = new Favorite();
        favorite.setBookId(bookId);
        favorite.setUserId(userId);

        this.favoriteService.addToFavorite(favorite);

        return "redirect:/favorites";
    }
}
