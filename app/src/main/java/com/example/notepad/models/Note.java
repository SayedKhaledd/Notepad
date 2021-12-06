package com.example.notepad.models;

import java.io.Serializable;

public class Note implements Serializable {

    private String title, description, imageURL, date;
    private boolean isFav;

    public Note(String title, String description, String imageURL, String date, boolean isFav) {
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
        this.date = date;
        this.isFav = isFav;
    }

    public Note(String title, String date) {
        this.title = title;
        this.date = date;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }
}
