package com.books.library.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long ISBN;
    private String title;
    private String author;
    private String publisher;
    private int release_year;
    private int copies;
    private int copies_borrowed;
    private int copies_remaining;
    private boolean is_active = true;

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

}