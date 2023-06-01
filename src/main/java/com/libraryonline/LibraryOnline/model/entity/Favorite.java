package com.libraryonline.LibraryOnline.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "favorites")
@Entity
@Data
@NoArgsConstructor
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public void setBookId(Integer bookId) {
        this.book = new Book();
        this.book.setId(bookId);
    }


    public void setUserId(Integer userId) {
        this.user = new User(1, "krforfk", "okrofkr", "doekf", "rofkr", "orkfro");
        this.user.setId(userId);
    }
}
