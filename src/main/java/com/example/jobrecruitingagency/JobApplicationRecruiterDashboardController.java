package com.example.jobrecruitingagency;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class JobApplicationRecruiterDashboardController {


    @javafx.fxml.FXML
    private TableColumn experienceTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn hscTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private ComboBox<String> jobTypeCBJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn candidateNameTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private CheckBox activeCheckBoxJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn sscTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn graduateTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn statusTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn undergraduateTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn skillTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableView tableViewCandidateSearchJobApplicationRecruiter;
    @javafx.fxml.FXML
    public void initialize() {
        jobTypeCBJobApplicationRecruiter.getItems().addAll("Full Time","Part Time","Internship");
    }

    @javafx.fxml.FXML
    public void homeButtonOAJobApplicationRecruiter(ActionEvent actionEvent) throws IOException {
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
    public void searchButtonOAJobApplicationRecruiter(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearButtonJobApplicationRecruiterDashboardOA(ActionEvent actionEvent) {
    }
}
