package com.libraryonline.LibraryOnline.response;

public class FavoriteResponse {
    private Integer id;
    private Integer userId;
    private Integer bookId;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public FavoriteResponse(Integer id, Integer bookId, Integer userId) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
    }


    public Integer getId() {
        return id;
    }
    public Integer getBookId() {
        return bookId;
    }
    public Integer getUserId() {
        return userId;
    }


}
