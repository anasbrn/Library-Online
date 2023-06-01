package com.libraryonline.LibraryOnline.repository;

import com.libraryonline.LibraryOnline.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("SELECT new com.libraryonline.LibraryOnline.model.entity.User(u.id, u.name, u.username, u.email, u.password, u.role) from User u where u.username = :username and u.password = :password")
    User findUser(String username, String password);
}
