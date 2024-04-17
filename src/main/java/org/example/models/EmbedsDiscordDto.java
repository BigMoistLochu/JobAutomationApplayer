package org.example.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmbedsDiscordDto {

    private String username;

    private final List<JobOffertDto> embeds;

    public EmbedsDiscordDto(String username, List<JobOffertDto> embeds)
    {
        this.username = username;
        this.embeds = embeds;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<JobOffertDto> getEmbeds() {
        return embeds;
    }

}
