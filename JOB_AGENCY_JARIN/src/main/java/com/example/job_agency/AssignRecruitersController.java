package com.example.job_agency;

import com.example.job_agency.JobAssignment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class AssignRecruitersController {

    @FXML private ComboBox<String> jobComboBox;
    @FXML private ComboBox<String> recruiterComboBox;
    @FXML private TextField jobTitleField;
    @FXML private TextArea jobDescriptionArea;
    @FXML private TextField jobStatusField;
    @FXML private Label statusLabel;


    private final ObservableList<JobAssignment> assignmentList = FXCollections.observableArrayList();
    private final File file = new File("assignments.bin");

    @FXML
    public void initialize() {

        jobComboBox.setItems(FXCollections.observableArrayList("Job001", "Job002", "Job003"));
        recruiterComboBox.setItems(FXCollections.observableArrayList("Alice", "Bob", "Charlie"));


    }

    @FXML
    private void confirmAssignment(ActionEvent event) {
        String job = jobComboBox.getValue();
        String recruiter = recruiterComboBox.getValue();
        String title = jobTitleField.getText();
        String description = jobDescriptionArea.getText();
        String status = jobStatusField.getText();


        if (job == null || recruiter == null || title.isEmpty() || description.isEmpty() || status.isEmpty()) {
            showAlert(AlertType.ERROR, "Validation Error", "Please fill in all fields.");
            return;
        }


        Alert confirm = new Alert(AlertType.CONFIRMATION);
        confirm.setTitle("Confirmation");
        confirm.setHeaderText("Are you sure you want to assign this recruiter?");
        Optional<ButtonType> result = confirm.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            JobAssignment assignment = new JobAssignment(job, recruiter, title, description, status);
            assignmentList.add(assignment);
            saveAssignmentsToFile();
            statusLabel.setText("Assignment saved successfully.");
        }
    }

    private void saveAssignmentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            for (JobAssignment assignment : assignmentList) {
                oos.writeObject(assignment);
            }
        } catch (IOException e) {
            showAlert(AlertType.ERROR, "File Error", "Could not save assignments.");
        }
    }

    private void showAlert(AlertType type, String title, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
