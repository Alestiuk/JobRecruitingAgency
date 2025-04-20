package com.example.jobrecruitingagency;

import java.io.Serializable;

public class JobList implements Serializable {
    private String jobTitle;
    private String department;
    private String qualification;
    private String description;
    private String responsibilities;
    private String salary;
    private String deadline;
    private String type;

    public JobList(String department, String jobTitle, String qualification, String description, String responsibilities, String salary, String deadline, String type) {
        this.department = department;
        this.jobTitle = jobTitle;
        this.qualification = qualification;
        this.description = description;
        this.responsibilities = responsibilities;
        this.salary = salary;
        this.deadline = deadline;
        this.type = type;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "JobList{" +
                "jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                ", qualification='" + qualification + '\'' +
                ", description='" + description + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                ", salary='" + salary + '\'' +
                ", deadline='" + deadline + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
