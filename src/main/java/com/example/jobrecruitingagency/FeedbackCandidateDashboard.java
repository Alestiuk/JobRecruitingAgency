package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FeedbackCandidateDashboard
{
    @javafx.fxml.FXML
    private ComboBox<String> feedbackTypeCBCandidateDashboard;
    @javafx.fxml.FXML
    private TextField nameTFFeedbackCandidateDashboard;
    @javafx.fxml.FXML
    private TextArea descriptionFeedbackTFCandidateDashboard;
    @javafx.fxml.FXML
    private TextField phoneTFFeedbackCandidateDashboard;
    @javafx.fxml.FXML
    private TextField emailTFFeedbackCandidateDashboard;

    @javafx.fxml.FXML
    public void initialize() {
        feedbackTypeCBCandidateDashboard.getItems().addAll("Suggestion", "Complaint","Comment");
    }

    @javafx.fxml.FXML
    public void submitFeedbackButtonOACandidateDashboard(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("CandidateDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Candidate Dashboard");
        stage.show();
    }
}