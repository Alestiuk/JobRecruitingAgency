package com.example.jobrecruitingagency;

import java.io.IOException;
import java.io.Serializable;

public class Candidate implements Serializable {
    String fullName, gender,skill, email,password,userType,phoneNumber;


    public Candidate(String fullName, String gender, String skill, String email, String password, String userType, String phoneNumber) {
        this.fullName = fullName;
        this.gender = gender;
        this.skill = skill;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.phoneNumber = phoneNumber;
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
        return "Candidate{" +
                "fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", skill='" + skill + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void createCandidate() {
        try {
            FileHelper.saveToFile("candidates.bin", this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        };
    }

}
