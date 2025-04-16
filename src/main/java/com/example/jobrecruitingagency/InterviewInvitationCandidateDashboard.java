package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class InterviewInvitationCandidateDashboard
{
    @javafx.fxml.FXML
    private TableColumn jobTitleTCIntervieweInvitationCandidate;
    @javafx.fxml.FXML
    private TableColumn interviewInvitationTCIntervieweInvitationCandidate1;
    @javafx.fxml.FXML
    private TableColumn interviewIDateTCIntervieweInvitationCandidate;
    @javafx.fxml.FXML
    private TableColumn interviewInvitationTCIntervieweInvitationCandidate11;
    @javafx.fxml.FXML
    private TableColumn companyNameTCIntervieweInvitationCandidate;
    @javafx.fxml.FXML
    private TableColumn jobTypeTCIntervieweInvitationCandidate;
    @javafx.fxml.FXML
    private TableColumn salaryTCIntervieweInvitationCandidate;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void homeButtonOA(ActionEvent actionEvent) throws IOException {
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