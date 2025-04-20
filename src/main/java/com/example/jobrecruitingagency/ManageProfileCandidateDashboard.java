package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageProfileCandidateDashboard
{
    @javafx.fxml.FXML
    private TextField fullNameTFManegProfileCandidate;
    @javafx.fxml.FXML
    private TextField phoneTFManegProfileCandidate;
    @javafx.fxml.FXML
    private ComboBox<String> hscCBManegProfileCandidate;
    @javafx.fxml.FXML
    private TextField nationalityTFManegProfileCandidate;
    @javafx.fxml.FXML
    private ComboBox<String> sscCBManegProfileCandidate;
    @javafx.fxml.FXML
    private TextArea skillTFManegProfileCandidate;
    @javafx.fxml.FXML
    private ComboBox<String> undergraduateCBManegProfileCandidate;
    @javafx.fxml.FXML
    private TextArea workExperienceTFManegProfileCandidate;
    @javafx.fxml.FXML
    private TextField emailTFManegProfileCandidate;
    @javafx.fxml.FXML
    private TextField addressTFManegProfileCandidate;
    @javafx.fxml.FXML
    private DatePicker dateOfBirthManegProfileCandidate;
    @javafx.fxml.FXML
    private ComboBox<String> graduateCBManegProfileCandidate;

    @javafx.fxml.FXML
    public void initialize() {
        sscCBManegProfileCandidate.getItems().addAll("1.00 - 2.00","2.00 - 3.00","3.00 - 4.00","4.00 - 5.00","5.00");
        hscCBManegProfileCandidate.getItems().addAll("1.00 - 2.00","2.00 - 3.00","3.00 - 4.00","4.00 - 5.00","5.00");
        undergraduateCBManegProfileCandidate.getItems().addAll("1.00 - 2.00","2.00 - 3.00","3.00 - 4.00","4.00");
        graduateCBManegProfileCandidate.getItems().addAll("1.00 - 2.00","2.00 - 3.00","3.00 - 4.00","4.00");
    }

    @javafx.fxml.FXML
    public void confirmButtonOAManegProfileCandidate(ActionEvent actionEvent) throws IOException {
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