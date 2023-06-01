package com.libraryonline.LibraryOnline.service;

import com.libraryonline.LibraryOnline.repository.FavoriteRepo;

public class FavoriteService {
    private FavoriteRepo favoriteRepo;

    public FavoriteService(FavoriteRepo favoriteRepo) {
        this.favoriteRepo = favoriteRepo;
    }
}
