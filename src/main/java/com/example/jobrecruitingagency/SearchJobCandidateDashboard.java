package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
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

public class SearchJobCandidateDashboard
{
    @javafx.fxml.FXML
    private TableColumn statusTCCandidateSearch;
    @javafx.fxml.FXML
    private TableColumn jobTitleTCCandidateSearch;
    @javafx.fxml.FXML
    private TableColumn salaryTCCandidateSearch;
    @javafx.fxml.FXML
    private CheckBox statusCheckBoxCandidateSearch;
    @javafx.fxml.FXML
    private TableColumn deadlineTCCandidateSearch;
    @javafx.fxml.FXML
    private ComboBox<String> jobTypeCBSearchCandidateDashboard;
    @javafx.fxml.FXML
    private TableView<String> tableViewCandidateSearch;

    @javafx.fxml.FXML
    public void initialize() {
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
}