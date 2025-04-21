package com.example.jobrecruitingagency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class TrackApplicationCandidateDashboard
{
    @javafx.fxml.FXML
    private TableColumn<Application, String> jobTitleTCCandidateTrackApplication;
    @javafx.fxml.FXML
    private TableColumn<Application, String>salaryTCCandidateTrackApplication;
    @javafx.fxml.FXML
    private CheckBox acceptedCheckBoxCandidateTrackApplication;
    @javafx.fxml.FXML
    private TableColumn<Application, String> statusTCCandidateTrackApplication;
    @javafx.fxml.FXML
    private TableView<Application> tableViewCandidateSearch;

    @javafx.fxml.FXML
    public void initialize() {
        jobTitleTCCandidateTrackApplication.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        salaryTCCandidateTrackApplication.setCellValueFactory(new PropertyValueFactory<>("salary"));

        ArrayList<Application> applications = FileHelper.loadFromFile("applications.bin");
        ObservableList<Application> applicationList = FXCollections.observableArrayList(applications);
        tableViewCandidateSearch.setItems(applicationList);
    }

    @javafx.fxml.FXML
    public void showAllButtonCandidateTrackApplicationOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchButtonCandidateTrackApplicationOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void homeButtonCandidateTrackApplicationOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("CandidateDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Candidate Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void clearButtonTrackApplicationRecruiterDashboardOA(ActionEvent actionEvent) {
    }

    }

