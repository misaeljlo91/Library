package com.project.library.dtos;

import com.project.library.models.Book;

public class BookDTO {

    private Long id;
    private String title;
    private String writer;
    private double price;
    private String releaseDate;

    //CONSTRUCTORES
    public BookDTO() { }

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.writer = book.getWriter();
        this.price = book.getPrice();
        this.releaseDate = book.getReleaseDate();
    }

    //GETTER
    public Long getId() {return id;}
    public String getTitle() {return title;}
    public String getWriter() {return writer;}
    public double getPrice() {return price;}
    public String getReleaseDate() {return releaseDate;}

    //SETTER
    public void setId(Long id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setWriter(String writer) {this.writer = writer;}
    public void setPrice(double price) {this.price = price;}
    public void setReleaseDate(String releaseDate) {this.releaseDate = releaseDate;}
}
