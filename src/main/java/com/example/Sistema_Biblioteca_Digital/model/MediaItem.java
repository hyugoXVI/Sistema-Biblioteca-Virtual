package com.example.Sistema_Biblioteca_Digital.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class MediaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String authorOrPublisher;
    private  String title;
    private  int year;


    public MediaItem(){}

    public MediaItem(String authorOrPublisher, String title, int year) {
        this.authorOrPublisher = authorOrPublisher;
        this.title = title;
        this.year = year;
    }

    public String getAuthorOrPublisher() {
        return authorOrPublisher;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public long getId() {
        return id;
    }
}
