package com.project.library.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id //Para generar un identificador único
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String title;
    private String writer;
    private double price;
    private String releaseDate;

    //CONSTRUCTORES
    public Book() { }

    public Book(String title, String writer, double price, String releaseDate) {
        this.title = title;
        this.writer = writer;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    //GETTER - Métodos accesadores a datos
    public Long getId() {return id;}
    public String getTitle() {return title;}
    public String getWriter() {return writer;}
    public double getPrice() {return price;}
    public String getReleaseDate() {return releaseDate;}

    //SETTER - Métodos modificadores de datos
    public void setId(Long id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setWriter(String writer) {this.writer = writer;}
    public void setPrice(double price) {this.price = price;}
    public void setReleaseDate(String releaseDate) {this.releaseDate = releaseDate;}
}
