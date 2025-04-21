package com.example.job_agency;

import java.io.Serializable;

public class UpcomingTraining implements Serializable {
    private String trainingId;
    private String trainingTitle;
    private String trainerName;
    private String trainingDate;
    private String duration;
    private String participants;

    public UpcomingTraining(String trainingId, String trainingTitle, String trainerName,
                            String trainingDate, String duration, String participants) {
        this.trainingId = trainingId;
        this.trainingTitle = trainingTitle;
        this.trainerName = trainerName;
        this.trainingDate = trainingDate;
        this.duration = duration;
        this.participants = participants;
    }

    public String getTrainingId() { return trainingId; }
    public void setTrainingId(String trainingId) { this.trainingId = trainingId; }

    public String getTrainingTitle() { return trainingTitle; }
    public void setTrainingTitle(String trainingTitle) { this.trainingTitle = trainingTitle; }

    public String getTrainerName() { return trainerName; }
    public void setTrainerName(String trainerName) { this.trainerName = trainerName; }

    public String getTrainingDate() { return trainingDate; }
    public void setTrainingDate(String trainingDate) { this.trainingDate = trainingDate; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getParticipants() { return participants; }
    public void setParticipants(String participants) { this.participants = participants; }
}
