package com.example.job_agency;

import java.io.Serializable;
import java.time.LocalDate;

public class EmploymentTerm implements Serializable {
    private String candidateId;
    private String salaryOffered;
    private String jobRole;
    private String contractDuration;
    private LocalDate startDate;

    public EmploymentTerm(String candidateId, String salaryOffered, String jobRole, String contractDuration, LocalDate startDate) {
        this.candidateId = candidateId;
        this.salaryOffered = salaryOffered;
        this.jobRole = jobRole;
        this.contractDuration = contractDuration;
        this.startDate = startDate;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getSalaryOffered() {
        return salaryOffered;
    }

    public void setSalaryOffered(String salaryOffered) {
        this.salaryOffered = salaryOffered;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(String contractDuration) {
        this.contractDuration = contractDuration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return candidateId + " | " + jobRole + " | " + salaryOffered;
    }
}
