package com.example.job_agency;

import java.io.Serializable;

public class Meeting implements Serializable {
    private String title;
    private String participants;
    private String date;
    private String time;
    private String description;

    public Meeting(String title, String participants, String date, String time, String description) {
        this.title = title;
        this.participants = participants;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getParticipants() {
        return participants;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title + "," + participants + "," + date + "," + time + "," + description;
    }
}
