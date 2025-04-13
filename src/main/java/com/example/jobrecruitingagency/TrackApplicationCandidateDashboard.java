package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackApplicationCandidateDashboard
{
    @javafx.fxml.FXML
    private TableColumn jobTitleTCCandidateTrackApplication;
    @javafx.fxml.FXML
    private TableColumn salaryTCCandidateTrackApplication;
    @javafx.fxml.FXML
    private CheckBox acceptedCheckBoxCandidateTrackApplication;
    @javafx.fxml.FXML
    private TableColumn statusTCCandidateTrackApplication;
    @javafx.fxml.FXML
    private TableView tableViewCandidateSearch;

    @javafx.fxml.FXML
    public void initialize() {
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