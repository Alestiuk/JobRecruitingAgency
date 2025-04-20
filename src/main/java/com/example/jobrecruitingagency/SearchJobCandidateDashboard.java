package com.example.jobrecruitingagency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SearchJobCandidateDashboard
{
    @javafx.fxml.FXML
    private TableView<JobList> tableViewCandidateSearch;
    @javafx.fxml.FXML
    private TableColumn<JobList, String> statusTCCandidateSearch;
    @javafx.fxml.FXML
    private TableColumn<JobList, String> jobTitleTCCandidateSearch;
    @javafx.fxml.FXML
    private TableColumn<JobList, String> salaryTCCandidateSearch;
    @javafx.fxml.FXML
    private CheckBox statusCheckBoxCandidateSearch;
    @javafx.fxml.FXML
    private TableColumn<JobList, String> deadlineTCCandidateSearch;
    @javafx.fxml.FXML
    private ComboBox<String> jobTypeCBSearchCandidateDashboard;


    @javafx.fxml.FXML
    public void initialize() {
        jobTypeCBSearchCandidateDashboard.getItems().addAll("Full Time", "Part Time", "Internship");
        ObservableList<JobList> jobData = FXCollections.observableArrayList(loadJobsFromFile());
        tableViewCandidateSearch.setItems(jobData);

        jobTitleTCCandidateSearch.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        salaryTCCandidateSearch.setCellValueFactory(new PropertyValueFactory<>("salary"));
        deadlineTCCandidateSearch.setCellValueFactory(new PropertyValueFactory<>("deadline"));

    }

    @javafx.fxml.FXML
    public void homeButtonCandidateDashboardOA(ActionEvent actionEvent) throws IOException {
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
    public void searchButtonCandidateDashboardOA(ActionEvent actionEvent) {
    }


    @Deprecated
    public void clearButtonCandidateDashboardOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void clearButtonSearchJobCandidateDashboardOA(ActionEvent actionEvent) {
    }
    public List<JobList> loadJobsFromFile() {
        List<JobList> jobLists = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("jobs.dat"))) {
            while (true) {
                JobList job = (JobList) in.readObject();
                jobLists.add(job);
            }
        } catch (EOFException eof) {
            // End of file reached – normal behavior
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobLists;
    }
}