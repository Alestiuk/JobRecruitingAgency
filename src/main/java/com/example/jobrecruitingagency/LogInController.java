package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController
{
    @javafx.fxml.FXML
    private PasswordField passwordTF;
    @javafx.fxml.FXML
    private TextField phoneNumberTF;
    @javafx.fxml.FXML
    private ComboBox<String> accountTypeCBLogIn;

    @javafx.fxml.FXML
    public void initialize() {
        accountTypeCBLogIn.getItems().addAll("Recruiter","Candidate","Training Manager","Recruitment Consultant","IT " +
                "Support Manager","HR Manager","Accountant","Agency Manager");
    }



    @javafx.fxml.FXML
    public void logInOA(ActionEvent actionEvent) {
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