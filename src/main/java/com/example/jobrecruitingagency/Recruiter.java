package com.example.jobrecruitingagency;

public class Recruiter {
    String userName, password,companyName,companyAddress,industryType,website,contactPersonName,
            contactPersonEmail,contactPersonDesignation;
    Integer contactPersonPhoneNumber,tradeLicenseNumber,yearOfEstablishment,numberOfEmployees;

    public Recruiter(String userName, String password, String companyName, String companyAddress, String industryType,
                     String website, String contactPersonName, String contactPersonEmail,
                     String contactPersonDesignation, Integer contactPersonPhoneNumber, Integer tradeLicenseNumber,
                     Integer yearOfEstablishment, Integer numberOfEmployees) {
        this.userName = userName;
        this.password = password;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.industryType = industryType;
        this.website = website;
        this.contactPersonName = contactPersonName;
        this.contactPersonEmail = contactPersonEmail;
        this.contactPersonDesignation = contactPersonDesignation;
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
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

    public Integer getContactPersonPhoneNumber() {
        return contactPersonPhoneNumber;
    }

    public void setContactPersonPhoneNumber(Integer contactPersonPhoneNumber) {
        this.contactPersonPhoneNumber = contactPersonPhoneNumber;
    }

    public Integer getTradeLicenseNumber() {
        return tradeLicenseNumber;
    }

    public void setTradeLicenseNumber(Integer tradeLicenseNumber) {
        this.tradeLicenseNumber = tradeLicenseNumber;
    }

    public Integer getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(Integer yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
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
                ", contactPersonEmail='" + contactPersonEmail + '\'' +
                ", contactPersonDesignation='" + contactPersonDesignation + '\'' +
                ", contactPersonPhoneNumber=" + contactPersonPhoneNumber +
                ", tradeLicenseNumber=" + tradeLicenseNumber +
                ", yearOfEstablishment=" + yearOfEstablishment +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }

    public void createRecruiter() {
    }
}
