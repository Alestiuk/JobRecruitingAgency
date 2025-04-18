package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class RecruiterDashboardController
{
    @javafx.fxml.FXML
    private Label outputLabelOfRecruiterDashboard;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void feedbackImprovementButtonOARecruiterDash(ActionEvent actionEvent) throws IOException {


    }

    @javafx.fxml.FXML
    public void jobApplicationButtonOARecruiterDash(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("jobApplicationRecruiterDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Job Application");
        stage.show();
    }

    @javafx.fxml.FXML
    public void logOutButtonOARecruiterDashboard(ActionEvent actionEvent) throws IOException {// Clear the logged-in recruiter
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("MainDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Main Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void messageButtonOARecruiterDash(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("MessageRecruiterDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Message");
        stage.show();
    }

    @javafx.fxml.FXML
    public void reportsButtonOARecruiterDash(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("ReportsRecruiterDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Reports");
        stage.show();
    }

    @javafx.fxml.FXML
    public void manageJobsButtonOARecruiterDash(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void scheduleInterviewsButtonOARecruiterDash(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void postJobButtonOARecruiterDash(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("JobPosting" +
                ".fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Post Job");
        stage.show();


    }

    @javafx.fxml.FXML
    public void selectFinalCandidateButtonOARecruiterDash(ActionEvent actionEvent) {
    }
}