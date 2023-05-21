package com.libraryonline.LibraryOnline.response;

public class BookResponse {
    private String title;
    private String description;
    private String author;
    private String image;

    public BookResponse(String title, String description, String author, String image) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getAuthor() {
        return author;
    }
    public String getImage() {
        return image;
    }

    public BookResponse() {

    }
}
