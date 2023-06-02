package com.libraryonline.LibraryOnline.repository;

import com.libraryonline.LibraryOnline.model.entity.Favorite;
import com.libraryonline.LibraryOnline.response.FavoriteResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepo extends JpaRepository<Favorite, Integer> {
    @Query("SELECT new com.libraryonline.LibraryOnline.response.FavoriteResponse(f.id, f.book.id, f.user.id) from Favorite f inner join User u ON :userId = f.user.id inner join Book on :bookId = f.book.id")
    List<FavoriteResponse> findAllBy(Integer userId, Integer bookId);
}
