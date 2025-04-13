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

public class JobPostingController
{
    @javafx.fxml.FXML
    private TextArea jobDescriptionTF;
    @javafx.fxml.FXML
    private TextArea keyResponsibilitiesTF;
    @javafx.fxml.FXML
    private TextField salaryTF;
    @javafx.fxml.FXML
    private TextField jobTitleTF;
    @javafx.fxml.FXML
    private DatePicker deadlineDatepicker;
    @javafx.fxml.FXML
    private TextField departmentTF;
    @javafx.fxml.FXML
    private TextArea qualificationTF;
    @javafx.fxml.FXML
    private ComboBox<String> jobTypeCBPostJob;

    @javafx.fxml.FXML
    public void initialize() {
        jobTypeCBPostJob.getItems().addAll("Full Time","Part Time","Internship");
    }

    @javafx.fxml.FXML
    public void postTheJobOA(ActionEvent actionEvent) throws IOException {
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