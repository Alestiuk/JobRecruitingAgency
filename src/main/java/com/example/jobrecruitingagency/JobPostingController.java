package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
        jobTypeCBPostJob.getItems().addAll("Full Time","Part Time","Internship");
    }

    @javafx.fxml.FXML
    public void postTheJobOA(ActionEvent actionEvent) throws IOException {
        String jobTitle = jobTitleTF.getText();
        String department = departmentTF.getText();
        String qualification = qualificationTF.getText();
        String description = jobDescriptionTF.getText();
        String responsibilities = keyResponsibilitiesTF.getText();
        String salaryText = salaryTF.getText();
        String deadline = (deadlineDatepicker.getValue() != null) ? deadlineDatepicker.getValue().toString() : "";
        String type = jobTypeCBPostJob.getValue();
        if (jobTitle.isEmpty()) {
            outputLabel.setText("Please enter job title");
            return;
        }if (department.isEmpty()) {
            outputLabel.setText("Please enter department");
            return;
        }if (qualification.isEmpty()) {
            outputLabel.setText("Please enter qualification");
            return;
        }if (description.isEmpty()) {
            outputLabel.setText("Please enter description");
            return;
        }if (responsibilities.isEmpty()) {
            outputLabel.setText("Please enter responsibilities");
            return;
        }if (salaryText.isEmpty()) {
            outputLabel.setText("Please enter salary");
            return;
        }if (deadline.isEmpty()) {
            outputLabel.setText("Please enter deadline");
            return;
        }if (type == null || type.isEmpty()) {
            outputLabel.setText("Please select job type");
            return;
        }

        JobList job = new JobList(department, jobTitle, qualification, description, responsibilities, salaryText, deadline, type);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("jobs.bin", true))) {
            out.writeObject(job);
        } catch (IOException e) {
            e.printStackTrace();
            outputLabel.setText("Failed to save job.");
            return;
        }

        outputLabel.setText("Job posted successfully!");


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