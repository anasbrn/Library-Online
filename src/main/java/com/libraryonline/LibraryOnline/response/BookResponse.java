package com.libraryonline.LibraryOnline.response;

public class BookResponse {
    private String title;
    private String description;
    private String author;
    private String image;
    private String categoryName;

    public BookResponse(String title, String description, String author, String image, String categoryName) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.image = image;
        this.categoryName = categoryName;
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
    public String getCategoryName() {
        return categoryName;
    }
}
