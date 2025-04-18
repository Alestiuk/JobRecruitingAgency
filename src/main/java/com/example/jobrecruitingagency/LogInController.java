package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LogInController {
    @javafx.fxml.FXML
    private PasswordField passwordTF;
    @javafx.fxml.FXML
    private TextField phoneNumberTF;
    @javafx.fxml.FXML
    private ComboBox<String> accountTypeCBLogIn;
    @javafx.fxml.FXML
    private Label outputLabelLogIn;

    @javafx.fxml.FXML
    public void initialize() {
        accountTypeCBLogIn.getItems().addAll("Recruiter","Candidate","Training Manager","Recruitment Consultant","IT " +
                "Support Manager","HR Manager","Accountant","Agency Manager");
    }



    @javafx.fxml.FXML
    public void logInOA(ActionEvent actionEvent) {
        String phoneNumber = phoneNumberTF.getText();
        String password = passwordTF.getText();
        String accountType = accountTypeCBLogIn.getValue();
        String type =accountTypeCBLogIn.getValue();
        //validation check
        if (!phoneNumber.matches("01\\d{9}")) {
            outputLabelLogIn.setText("Enter a valid Phone Number");
            return;
        }if (password.isEmpty() ) {
            outputLabelLogIn.setText("Please enter password");
            return;
        }if (accountType == null) {
            outputLabelLogIn.setText("Please select a account type");
            return;
        } else {
            outputLabelLogIn.setText("Login successful");
        }
        boolean matched = false;

        if (accountType.equals("Candidate")) {
            ArrayList<Candidate> candidates = FileHelper.loadFromFile("candidates.dat");
            for (Candidate c : candidates) {
                if (c.getPhoneNumber().equals(phoneNumber) && c.getPassword().equals(password)) {
                    matched = true;
                    break;
                }
            }
        } else if (accountType.equals("Recruiter")) {
            ArrayList<Recruiter> recruiters = FileHelper.loadFromFile("recruiters.dat");
            for (Recruiter r : recruiters) {
                if (r.getContactPersonPhoneNumber().equals(phoneNumber) && r.getPassword().equals(password)) {
                    matched = true;
                    break;
                }
            }
        }

        if (matched) {
            outputLabelLogIn.setText("Login successful!");
        //if validation pass
        try {
            Parent root = null ;
            String fxml = type + "Dashboard" + ".fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource(fxml));
            root = fxmlLoader.load();
            Scene scene = new Scene(root) ;
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle( type + " Dashboard");
            stage.show();
        } catch (Exception e) {
            outputLabelLogIn.setText("Scene for " +type + "' not found.");
        }
    }


}

    @javafx.fxml.FXML
    public void backButtonOALogIn(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("MainDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Main Dashboard");
        stage.show();
    }
    }