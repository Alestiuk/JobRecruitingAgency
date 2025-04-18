package com.example.jobrecruitingagency;

import java.io.IOException;
import java.io.Serializable;

public class Recruiter  implements Serializable {
    String userName, password,companyName,companyAddress,industryType,website,contactPersonName,contactPersonPhoneNumber,
            contactPersonEmail,contactPersonDesignation,userType,tradeLicenseNumber,yearOfEstablishment,
            numberOfEmployees;

    public Recruiter(String userName, String password, String companyName, String companyAddress, String industryType, String website, String contactPersonName, String contactPersonPhoneNumber, String contactPersonEmail, String contactPersonDesignation, String userType, String tradeLicenseNumber, String yearOfEstablishment, String numberOfEmployees) {
        this.userName = userName;
        this.password = password;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.industryType = industryType;
        this.website = website;
        this.contactPersonName = contactPersonName;
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
        this.contactPersonEmail = contactPersonEmail;
        this.contactPersonDesignation = contactPersonDesignation;
        this.userType = userType;
        this.tradeLicenseNumber = tradeLicenseNumber;
        this.yearOfEstablishment = yearOfEstablishment;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonPhoneNumber() {
        return contactPersonPhoneNumber;
    }

    public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getContactPersonDesignation() {
        return contactPersonDesignation;
    }

    public void setContactPersonDesignation(String contactPersonDesignation) {
        this.contactPersonDesignation = contactPersonDesignation;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getTradeLicenseNumber() {
        return tradeLicenseNumber;
    }

    public void setTradeLicenseNumber(String tradeLicenseNumber) {
        this.tradeLicenseNumber = tradeLicenseNumber;
    }

    public String getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(String yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", industryType='" + industryType + '\'' +
                ", website='" + website + '\'' +
                ", contactPersonName='" + contactPersonName + '\'' +
                ", contactPersonPhoneNumber='" + contactPersonPhoneNumber + '\'' +
                ", contactPersonEmail='" + contactPersonEmail + '\'' +
                ", contactPersonDesignation='" + contactPersonDesignation + '\'' +
                ", userType='" + userType + '\'' +
                ", tradeLicenseNumber='" + tradeLicenseNumber + '\'' +
                ", yearOfEstablishment='" + yearOfEstablishment + '\'' +
                ", numberOfEmployees='" + numberOfEmployees + '\'' +
                '}';
    }

    public void createRecruiter() {
        try {
            FileHelper.saveToFile("recruiters.dat", this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
