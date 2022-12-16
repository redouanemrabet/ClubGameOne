package com.example.clubsportif.sports;

public class Sport {
    private  Integer image;
    private  String title;

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Sport(Integer image, String title) {
        this.image = image;
        this.title = title;
    }
}
