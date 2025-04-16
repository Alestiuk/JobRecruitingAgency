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

public class JobOfferCandidateDashboard
{
    @javafx.fxml.FXML
    private TableColumn salaryTCJobOFfferCandidate;
    @javafx.fxml.FXML
    private TableColumn companyNameTCJobOFfferCandidate;
    @javafx.fxml.FXML
    private TableColumn jobTypeTCJobOFfferCandidate;
    @javafx.fxml.FXML
    private TableColumn jobTitleTCJobOFfferCandidate;
    @javafx.fxml.FXML
    private Label outputLableJobOffer;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void rejectButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void accecptButtonOA(ActionEvent actionEvent) {
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