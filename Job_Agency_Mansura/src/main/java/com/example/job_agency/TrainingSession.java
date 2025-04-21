package com.example.job_agency;

import java.io.Serializable;

public class TrainingSession implements Serializable {
    private String trainingId;
    private String title;
    private String trainer;
    private String date;
    private String duration;
    private String participants;

    public TrainingSession(String trainingId, String title, String trainer, String date, String duration, String participants) {
        this.trainingId = trainingId;
        this.title = title;
        this.trainer = trainer;
        this.date = date;
        this.duration = duration;
        this.participants = participants;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public String getTitle() {
        return title;
    }

    public String getTrainer() {
        return trainer;
    }

    public String getDate() {
        return date;
    }

    public String getDuration() {
        return duration;
    }

    public String getParticipants() {
        return participants;
    }
}
