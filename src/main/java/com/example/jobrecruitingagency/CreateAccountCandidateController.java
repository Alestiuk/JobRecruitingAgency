package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CreateAccountCandidateController
{

    @javafx.fxml.FXML
    private TextField emailTFCreateAccountCandidate;
    @javafx.fxml.FXML
    private TextField retypePasswordTFCreateAccountCandidate;
    @javafx.fxml.FXML
    private TextField passwordTFCreateAccountCandidate;
    @javafx.fxml.FXML
    private TextField fullNameTFCreateAccountCandidate;
    @javafx.fxml.FXML
    private ComboBox<String> selectSkillCBcreateAccountForCandidate;
    @javafx.fxml.FXML
    private TextField mobileTFCreateAccountCandidate;
    @javafx.fxml.FXML
    private ComboBox<String> genderCBCandidate;
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
        selectSkillCBcreateAccountForCandidate.getItems().addAll("Accounting", "Admin Support", "Customer Service", "Finance", "Human Resources", "Information Technology", "Legal", "Marketing", "Sales", "Support");
        genderCBCandidate.getItems().addAll("Male", "Female");

    }



    @javafx.fxml.FXML
    public void createAccountForCandidateOA(ActionEvent actionEvent) throws IOException {
        String fullName = fullNameTFCreateAccountCandidate.getText();
        String gender = genderCBCandidate.getValue();
        String skill = selectSkillCBcreateAccountForCandidate.getValue();
        String email = emailTFCreateAccountCandidate.getText();
        String phoneNumberint = mobileTFCreateAccountCandidate.getText();
        String password = passwordTFCreateAccountCandidate.getText();
        String retypePassword = retypePasswordTFCreateAccountCandidate.getText();

        //Validation Checker
        if (fullName.isEmpty()) {
            outputLabel.setText("Please enter your full name");
            return;
        }if (gender == null || gender.isEmpty()) {
            outputLabel.setText("Please select your gender");
            return;
        }if (skill == null || skill.isEmpty()) {
            outputLabel.setText("Please select your skill");
            return;
        }if (email.isEmpty()) {
            outputLabel.setText("Please enter your email");
            return;
        }
        if (!email.matches(".*@.*\\.com$")) {
            outputLabel.setText("Enter a Valid Email");
            return;
        }if (phoneNumberint.isEmpty()) {
             outputLabel.setText("Please enter your phone number");
             return;
        }if (!phoneNumberint.matches("01\\d{9}")) {
             outputLabel.setText("Enter a valid Phone Number");
             return;
        }if (password.isEmpty()) {
            outputLabel.setText("Please enter your password");
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
         }
        outputLabel.setText("Account created successfully!");

        // If all validation passed, create account
        Integer phoneNumber = Integer.parseInt(mobileTFCreateAccountCandidate.getText());
        Candidate candidate = new Candidate(fullName,gender,skill,email,password,phoneNumber);
        candidate.createCandidate();


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("CandidateDashboard.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Candidate Dashboard");
            stage.show();

        } catch (Exception e) {
            outputLabel.setText("Scene for CandidateDashboard not found.");
        }

    }
}