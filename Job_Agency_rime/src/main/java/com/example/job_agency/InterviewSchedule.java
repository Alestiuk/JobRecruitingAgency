package com.example.job_agency;

import java.io.Serializable;
import java.time.LocalDate;

public class InterviewSchedule implements Serializable {
    private String candidateId;
    private LocalDate interviewDate;
    private String interviewTime;
    private String interviewType;
    private String interviewPanel;

    public InterviewSchedule(String candidateId, LocalDate interviewDate, String interviewTime, String interviewType, String interviewPanel) {
        this.candidateId = candidateId;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewType = interviewType;
        this.interviewPanel = interviewPanel;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String getInterviewPanel() {
        return interviewPanel;
    }

    public void setInterviewPanel(String interviewPanel) {
        this.interviewPanel = interviewPanel;
    }

    @Override
    public String toString() {
        return "InterviewSchedule{" +
                "candidateId='" + candidateId + '\'' +
                ", interviewDate=" + interviewDate +
                ", interviewTime='" + interviewTime + '\'' +
                ", interviewType='" + interviewType + '\'' +
                ", interviewPanel='" + interviewPanel + '\'' +
                '}';
    }
}

