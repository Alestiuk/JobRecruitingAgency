package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CandidateDashboardController
{
    @javafx.fxml.FXML
    private Label outputLabelCandidateDashboard;

    @javafx.fxml.FXML
    public void initialize() {
        outputLabelCandidateDashboard.setText("Welcome to Candidate Dashboard");
    }

    @javafx.fxml.FXML
    public void applyForAJobButtonOAcandidateDashboard(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void provideFeedbackButtonOAcandidateDashboard(ActionEvent actionEvent) throws IOException {

        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("FeedbackCandidateDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Feedback");
        stage.show();
    }

    @javafx.fxml.FXML
    public void trackApplicationsButtonOAcandidateDashboard(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("TrackApplicationCandidateDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Track Applications");
        stage.show();
    }

    @javafx.fxml.FXML
    public void interviewInvitationButtonOAcandidateDashboard(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("InterviewInvitationCandidateDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Interview Invitation");
        stage.show();
    }

    @javafx.fxml.FXML
    public void jobOfferButtonOAcandidateDashboard(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("JobOfferCandidateDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Job Offer");
        stage.show();
    }

    @javafx.fxml.FXML
    public void manageProfileButtonOAcandidateDashboard(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("manageProfileCandidateDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Manage Profile");
        stage.show();
    }

    @Deprecated
    public void interviewPreparationButtonOAcandidateDashboard(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchButtonOAcandidateDashboard(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("SearchJobCandidateDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Search Job");
        stage.show();
    }

    @javafx.fxml.FXML
    public void logOutButtonOARecruiterDashboard(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("MainDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Main Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void inboxButtonOAcandidateDashboard(ActionEvent actionEvent) {
    }
}