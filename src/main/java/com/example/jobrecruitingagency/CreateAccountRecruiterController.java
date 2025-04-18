package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.StringReader;

public class CreateAccountRecruiterController
{
    @javafx.fxml.FXML
    private TextField userNameTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField contactPersonDesignationTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField contactPersonMobileTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private ComboBox<String> industryTypeCB;
    @javafx.fxml.FXML
    private TextField tradeLicenseNoTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField contactPersonEmailTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField companyNameTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField contactPersonNameTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextArea companyAddressTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField websiteLinkTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField passwordTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField retypePasswordTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField yearOfEstablishTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private ComboBox<String> numberOfEmployeesCB;
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
        numberOfEmployeesCB.getItems().addAll("1-50","51-100","101-500","501-1000","1001-5000","5000+");
        industryTypeCB.getItems().addAll("Advertising and Marketing","Aeospace","Agriculture","Animal Husbandry",
                "Architecture","Astronomy","Computer and Technology","Design","Education","Energy","Entertainment",
                "Finance","Health","Hospitality","Human Resources","Information Technology","Legal","Logistics","Media","Mining","Oil and Gas","Real Estate","Science","Telecommunications","Transportation","Utilities","Other");
    }

    @javafx.fxml.FXML
    public void createAccountOARecruiter(@NotNull ActionEvent actionEvent) throws IOException {



        String userName = userNameTFCreateRecruiterAccount.getText();
        String  password = passwordTFCreateRecruiterAccount.getText();
        String companyName = companyNameTFCreateRecruiterAccount.getText();
        String numberOfEmployees= numberOfEmployeesCB.getValue();
        String companyAddress = companyAddressTFCreateRecruiterAccount.getText();
        String industryType = industryTypeCB.getValue();
        String website = websiteLinkTFCreateRecruiterAccount.getText();
        String contactPersonName = contactPersonNameTFCreateRecruiterAccount.getText();
        String contactPersonEmail = contactPersonEmailTFCreateRecruiterAccount.getText();
        String contactPersonDesignation = contactPersonDesignationTFCreateRecruiterAccount.getText();
        String contactPersonPhoneNumber = contactPersonMobileTFCreateRecruiterAccount.getText();
        String tradeLicenseNumber = tradeLicenseNoTFCreateRecruiterAccount.getText();
        String yearOfEstablishment = yearOfEstablishTFCreateRecruiterAccount.getText();
        String retypePassword = retypePasswordTFCreateRecruiterAccount.getText();
        String userType = "Recruiter";

        //Validation Checker
        if (userName.isEmpty()) {
            outputLabel.setText("Please enter username");
            return;
        }if (password.isEmpty()) {
            outputLabel.setText("Please enter password");
            return;
        }if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$")) {
            outputLabel.setText("Password must be at least 8 characters and include uppercase, lowercase, digit, and special character");
            return;
        }if (retypePassword.isEmpty()) {
            outputLabel.setText("Please Retype password");
            return;
        }if (!password.equals(retypePassword)) {
            outputLabel.setText("Passwords do not match");
            return;
        }if (companyName.isEmpty()) {
            outputLabel.setText("Please enter company name");
            return;
        }if (yearOfEstablishment == null) {
            outputLabel.setText("Please enter year of establishment");
            return;
        }if (!yearOfEstablishment.matches("\\d{4}")) {
            outputLabel.setText("Enter a valid 4-digit year");
            return;
        }if (numberOfEmployees == null || numberOfEmployees.isEmpty()) {
            outputLabel.setText("Please select number of employees");
            return;
        }if (companyAddress.isEmpty()) {
            outputLabel.setText("Please enter company address");
            return;
        }if (industryType == null || industryType.isEmpty()) {
            outputLabel.setText("Please select industry type");
            return;
        }if (tradeLicenseNumber.isEmpty()) {
            outputLabel.setText("Please enter trade license number");
            return;
        }if (!tradeLicenseNumber.matches("\\d+")) {
            outputLabel.setText("Trade license number must be numeric");
            return;
        }if (website.isEmpty()) {
            outputLabel.setText("Please enter website link");
            return;
        }if (!website.matches("^(http|https)://.*\\.(com|org|net|bd|info)(/.*)?$")) {
            outputLabel.setText("Please enter a valid website Link (eg: https://example.com)");
            return;
        }if (contactPersonName.isEmpty()) {
            outputLabel.setText("Please enter contact person name");
            return;
        }if (contactPersonEmail.isEmpty()) {
            outputLabel.setText("Please enter contact person email");
            return;
        }if (!contactPersonEmail.matches(".*@.*\\.com$")) {
            outputLabel.setText("Enter a Valid Email");
            return;
        }if (contactPersonDesignation.isEmpty()) {
            outputLabel.setText("Please enter contact person designation");
            return;
        }if (contactPersonPhoneNumber.isEmpty()) {
            outputLabel.setText("Please enter contact person phone number");
            return;
        }if (!contactPersonPhoneNumber.matches("01\\d{9}")) {
            outputLabel.setText("Enter a valid Phone Number");
            return;
        }
        outputLabel.setText("Account created successfully!");

        Recruiter recruiter = new Recruiter(userName,password,companyName,companyAddress,industryType,website
                ,contactPersonName,contactPersonPhoneNumber,contactPersonEmail,contactPersonDesignation,userType,tradeLicenseNumber,yearOfEstablishment,numberOfEmployees);
         recruiter.createRecruiter();
         //if all pass, create account
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("RecruiterDashboard.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Recruiter Dashboard");
            stage.show();
        } catch (Exception e) {
            outputLabel.setText("Error");
        }
    }
}