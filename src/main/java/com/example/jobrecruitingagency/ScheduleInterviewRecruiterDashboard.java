package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ScheduleInterviewRecruiterDashboard
{
    @javafx.fxml.FXML
    private TableColumn hscTCScheduleInterviewRecruiter;
    @javafx.fxml.FXML
    private TableColumn undergraduateTCScheduleInterviewRecruiter;
    @javafx.fxml.FXML
    private TableColumn candidateNameTCScheduleInterviewRecruiter;
    @javafx.fxml.FXML
    private TableView tableViewScheduleInterview;
    @javafx.fxml.FXML
    private DatePicker interviewDatePicker;
    @javafx.fxml.FXML
    private TableColumn graduateTCScheduleInterviewRecruiter;
    @javafx.fxml.FXML
    private TextField interviewTimeTF;
    @javafx.fxml.FXML
    private TableColumn experienceTCScheduleInterviewRecruiter;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn sscTCScheduleInterviewRecruiter;
    @javafx.fxml.FXML
    private TableColumn statusTCScheduleInterviewRecruiter;
    @javafx.fxml.FXML
    private TextField InterviewLocatonTF;
    @javafx.fxml.FXML
    private TableColumn skillTCScheduleInterviewRecruiter;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("RecruiterDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Recruiter Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void sendButtonOA(ActionEvent actionEvent) {
    }
}