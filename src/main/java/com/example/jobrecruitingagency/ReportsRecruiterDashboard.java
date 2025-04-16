package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportsRecruiterDashboard
{
    @javafx.fxml.FXML
    private TableColumn callForInterviewTCReportsRecruiter;
    @javafx.fxml.FXML
    private TableColumn postedJobTCReportsRecruiter;
    @javafx.fxml.FXML
    private Label outputLabelCandidatePhone;
    @javafx.fxml.FXML
    private TableColumn appliedCandidateTCReportsRecruiter;
    @javafx.fxml.FXML
    private TableColumn rejectedTCReportsRecruiter;
    @javafx.fxml.FXML
    private Label outputlabel;
    @javafx.fxml.FXML
    private TableColumn approvedTCReportsRecruiter;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void downloadReportsOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void showInformationOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("RecruiterDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Recruiter Dashboard");
        stage.show();
    }
}