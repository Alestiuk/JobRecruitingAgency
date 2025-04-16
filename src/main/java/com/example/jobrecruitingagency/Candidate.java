package com.example.jobrecruitingagency;

public class Candidate {
    String fullName, gender,skill, email,  password;
    Integer phoneNumber;

    public Candidate(String fullName, String gender, String skill, String email, String password, Integer phoneNumber) {
        this.fullName = fullName;
        this.gender = gender;
        this.skill = skill;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Candidate(String fullName, String gender, String skill, String email, Integer phoneNumber, String password) {
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", skill='" + skill + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public void createCandidate() {
    }
}
