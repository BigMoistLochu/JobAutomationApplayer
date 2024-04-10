package org.example.models;


import java.time.LocalDateTime;
import java.util.Objects;

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


    @Override
    public boolean equals(Object obj) {

        if(obj == null) return false;

        if(this == obj) return true;

        JobOffertDto o = (JobOffertDto) obj;
        return this.getTitle().equals(o.getTitle()) && this.getLink().equals(o.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(),getLink());
    }
}
