package com.libraryonline.LibraryOnline.service;

import com.libraryonline.LibraryOnline.model.entity.Favorite;
import com.libraryonline.LibraryOnline.repository.FavoriteRepo;
import com.libraryonline.LibraryOnline.response.FavoriteResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    private FavoriteRepo favoriteRepo;

    public FavoriteService(FavoriteRepo favoriteRepo) {
        this.favoriteRepo = favoriteRepo;
    }

    public Favorite addToFavorite(Favorite favorite){
        return this.favoriteRepo.save(favorite);
    }

    public List<FavoriteResponse> getFavoritBook(Integer userId, Integer bookId){
        return this.favoriteRepo.findAllBy(userId, bookId);
    }

    public void unfavorite(Integer id){
        this.favoriteRepo.deleteById(id);
    }
}
