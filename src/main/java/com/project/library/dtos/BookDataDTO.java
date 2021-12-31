package com.project.library.dtos;

public class BookDataDTO {

    private String title;
    private String writer;
    private double price;
    private String date;

    //CONSTRUCTORES
    public BookDataDTO() { }

    public BookDataDTO(String title, String writer, double price, String date) {
        this.title = title;
        this.writer = writer;
        this.price = price;
        this.date = date;
    }

    //GETTER
    public String getTitle() {return title;}
    public String getWriter() {return writer;}
    public double getPrice() {return price;}
    public String getDate() {return date;}

    //SETTER
    public void setTitle(String title) {this.title = title;}
    public void setWriter(String writer) {this.writer = writer;}
    public void setPrice(double price) {this.price = price;}
    public void setDate(String date) {this.date = date;}
}
