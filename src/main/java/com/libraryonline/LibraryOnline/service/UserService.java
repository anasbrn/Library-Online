package com.libraryonline.LibraryOnline.service;

import com.libraryonline.LibraryOnline.model.entity.User;
import com.libraryonline.LibraryOnline.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User findUser(String username, String password){
        return userRepo.findUser(username, password);
    }

}
