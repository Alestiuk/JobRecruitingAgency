package com.example.job_agency;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewCandidateDetails
{
    @javafx.fxml.FXML
    private TableView candidateTable;
    @javafx.fxml.FXML
    private TableColumn experienceColumn;
    @javafx.fxml.FXML
    private TableColumn skillsColumn;
    @javafx.fxml.FXML
    private TableColumn jobTitleColumn;
    @javafx.fxml.FXML
    private TableColumn qualificationsColumn;
    @javafx.fxml.FXML
    private TableColumn candidateNameColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadCandidateDetails(ActionEvent actionEvent) {
    }
}