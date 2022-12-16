package com.example.clubsportif.offers;

public class Offre {
    private Integer image;
    private String title;
    private String subtitle;
    private  String subtitle2;

    public String getSubtitle2() {
        return subtitle2;
    }

    public void setSubtitle2(String subtitle2) {
        this.subtitle2 = subtitle2;
    }

    public Offre(Integer image, String title, String subtitle,String subtitle2) {
        this.image = image;
        this.title = title;
        this.subtitle = subtitle;
        this.subtitle2=subtitle2;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
