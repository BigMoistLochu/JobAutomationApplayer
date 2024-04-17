package org.example.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class JobOffertDto {


    private String title;
   
    private String description;

    @JsonIgnore
    private LocalDateTime date;

    public JobOffertDto(String title, String description, LocalDateTime date) {
        this.title = title;
        this.description = description;
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
        return this.getTitle().equals(o.getTitle()) && this.getDescription().equals(o.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription());
    }
}
