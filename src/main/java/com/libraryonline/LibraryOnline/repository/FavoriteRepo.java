package com.libraryonline.LibraryOnline.repository;

import com.libraryonline.LibraryOnline.model.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepo extends JpaRepository<Favorite, Integer> {

}
