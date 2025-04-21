package com.example.jobrecruitingagency;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class JobApplicationRecruiterDashboardController {


    @javafx.fxml.FXML
    private TableColumn<Application, String> experienceTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn<Application, String> hscTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private ComboBox<String> jobTypeCBJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn<Application, String> candidateNameTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private CheckBox activeCheckBoxJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn<Application, String> sscTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn<Application, String> graduateTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn<Application, String> statusTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn<Application, String> undergraduateTCJobApplicationRecruiter;
    @javafx.fxml.FXML
    private TableColumn<Application, String> skillTCJobApplicationRecruiter;
    @FXML
    private TableView<Application> tableViewCandidateSearch;

    @javafx.fxml.FXML
    public void initialize() {
        jobTypeCBJobApplicationRecruiter.getItems().addAll("Full Time","Part Time","Internship");
        experienceTCJobApplicationRecruiter.setCellValueFactory(new PropertyValueFactory<>("experience"));
        hscTCJobApplicationRecruiter.setCellValueFactory(new PropertyValueFactory<>("hsc"));
        candidateNameTCJobApplicationRecruiter.setCellValueFactory(new PropertyValueFactory<>("candidateName"));
        sscTCJobApplicationRecruiter.setCellValueFactory(new PropertyValueFactory<>("ssc"));
        graduateTCJobApplicationRecruiter.setCellValueFactory(new PropertyValueFactory<>("graduate"));
        statusTCJobApplicationRecruiter.setCellValueFactory(new PropertyValueFactory<>("status"));
        undergraduateTCJobApplicationRecruiter.setCellValueFactory(new PropertyValueFactory<>("undergraduate"));
        skillTCJobApplicationRecruiter.setCellValueFactory(new PropertyValueFactory<>("skill"));

        ArrayList<Application> applications = FileHelper.loadFromFile("applications.bin");
        ObservableList<Application> applicationList = FXCollections.observableArrayList(applications);
        tableViewCandidateSearch.setItems(applicationList);
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

    @FXML
    public void rejectButtonOA(ActionEvent actionEvent) {
    }

    @FXML
    public void approveButtonOA(ActionEvent actionEvent) {
    }
}
