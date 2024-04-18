package org.example.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Objects;

public class JobOffertDto {

    @JsonProperty("username")
    private String title;

    @JsonProperty("content")
    private String url;

    @JsonIgnore
    private LocalDateTime date;

    public JobOffertDto(String title, String url, LocalDateTime date) {
        this.title = title;
        this.url = url;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return this.getTitle().equals(o.getTitle()) && this.getUrl().equals(o.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getUrl());
    }
}
