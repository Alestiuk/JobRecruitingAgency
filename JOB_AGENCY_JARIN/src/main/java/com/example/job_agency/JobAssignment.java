package com.example.job_agency;

import java.io.Serializable;

public class JobAssignment implements Serializable {
    private String job;
    private String recruiter;
    private String title;
    private String description;
    private String status;

    public JobAssignment(String job, String recruiter, String title, String description, String status) {
        this.job = job;
        this.recruiter = recruiter;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getJob() {
        return job;
    }

    public String getRecruiter() {
        return recruiter;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Job: " + job + ", Recruiter: " + recruiter + ", Title: " + title + ", Description: " + description + ", Status: " + status;
    }
}
