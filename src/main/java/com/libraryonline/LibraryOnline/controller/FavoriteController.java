package com.libraryonline.LibraryOnline.controller;

import com.libraryonline.LibraryOnline.service.FavoriteService;
import org.springframework.stereotype.Controller;

@Controller
public class FavoriteController {
    private FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }
}
