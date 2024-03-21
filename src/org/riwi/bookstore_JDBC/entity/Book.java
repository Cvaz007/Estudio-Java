package org.riwi.bookstore_JDBC.entity;

public class Book {
    private String id;
    private String title;
    private String authorId;
    private double price;
    private String yearOfPublished;

    public Book(String id, String title, String authorId, double price, String yearOfPublished) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.price = price;
        this.yearOfPublished = yearOfPublished;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getYearOfPublished() {
        return yearOfPublished;
    }

    public void setYearOfPublished(String yearOfPublished) {
        this.yearOfPublished = yearOfPublished;
    }
}
