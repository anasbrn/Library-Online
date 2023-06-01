package com.libraryonline.LibraryOnline.service;

import com.libraryonline.LibraryOnline.model.entity.Favorite;
import com.libraryonline.LibraryOnline.repository.FavoriteRepo;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
    private FavoriteRepo favoriteRepo;

    public FavoriteService(FavoriteRepo favoriteRepo) {
        this.favoriteRepo = favoriteRepo;
    }

    public Favorite addToFavorite(Favorite favorite){
        return this.favoriteRepo.save(favorite);
    }

    public void unfavorite(Integer id){
        this.favoriteRepo.deleteById(id);
    }
}
