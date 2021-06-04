package com.uveys.rssapp;

import java.net.URL;
import java.util.Date;

public class News {
    public String title;
    public String image;
    public String link;
    public String publishedAt;

    public News(String title, String image, String link, String publishedAt) {
        this.title = title;
        this.image = image;
        this.link = link;
        this.publishedAt = publishedAt;
    }
    public News() {}

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
