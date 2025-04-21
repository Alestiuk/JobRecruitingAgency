package com.example.jobrecruitingagency;

import java.io.Serializable;

public class Application implements Serializable {

    private String jobTitle;
    private String department;
    private String qualification;
    private String description;
    private String responsibilities;
    private String salary;
    private String deadline;
    private String type;
    String fullName, gender,skill, email,password,userType,phoneNumber;


    public Application(String jobTitle, String department, String qualification, String description, String responsibilities, String salary, String deadline, String type, String fullName, String gender, String skill, String email, String password, String userType, String phoneNumber) {
        this.jobTitle = jobTitle;
        this.department = department;
        this.qualification = qualification;
        this.description = description;
        this.responsibilities = responsibilities;
        this.salary = salary;
        this.deadline = deadline;
        this.type = type;
        this.fullName = fullName;
        this.gender = gender;
        this.skill = skill;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Application{" +
                "jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                ", qualification='" + qualification + '\'' +
                ", description='" + description + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                ", salary='" + salary + '\'' +
                ", deadline='" + deadline + '\'' +
                ", type='" + type + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", skill='" + skill + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
