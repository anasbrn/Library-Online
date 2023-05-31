package com.libraryonline.LibraryOnline.response;

public class BookResponse {
    private Integer id;
    private String title;
    private String description;
    private String author;
    private String image;
    private String categoryName;

    private String file;

    public BookResponse(Integer id, String title, String description, String author, String image, String categoryName, String file) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.image = image;
        this.categoryName = categoryName;
        this.file = file;
    }

    public BookResponse() {

    }

    public Integer getId() {
        return id;
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

    public String getFile() {
        return file;
    }

    public void setId(Integer id) {
         this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
