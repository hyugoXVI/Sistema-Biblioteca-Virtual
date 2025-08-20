package com.example.Sistema_Biblioteca_Digital.model;


public class MediaItem {
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
}
