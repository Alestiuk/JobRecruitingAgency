package com.example.jobrecruitingagency;

import java.io.Serializable;

public class Application implements Serializable {
    private JobList job;
    private Candidate candidate;

    public Application(JobList job, Candidate candidate) {
        this.job = job;
        this.candidate = candidate;
    }

    public JobList getJob() {
        return job;
    }

    public void setJob(JobList job) {
        this.job = job;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Application{" +
                "job=" + job +
                ", candidate=" + candidate +
                '}';
    }
}
