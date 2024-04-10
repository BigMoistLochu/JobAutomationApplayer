package org.example.models;


import java.time.LocalDateTime;

public class JobOffertDto {

    private String title;
    private String link;

    private LocalDateTime date;

    public JobOffertDto(String title, String link, LocalDateTime date) {
        this.title = title;
        this.link = link;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
