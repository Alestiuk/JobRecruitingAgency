package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class JobPosting
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
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void postTheJobOA(ActionEvent actionEvent) {
    }
}