package com.pskwierc.swaggerannotations.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "books")
@ApiModel(description = "All details about the book.")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Database generated book ID")
    private long id;

    @Column(name = "author", nullable = false)
    @ApiModelProperty(notes = "Author of the book")
    private String author;

    @Column(name = "title", nullable = false)
    @ApiModelProperty(notes = "Book title")
    private String title;

    @Column(name = "isbn", nullable = false)
    @ApiModelProperty(notes = "Book ISBN")
    private String isbn;

    public Book() {}

    public Book(String author, String title, String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
