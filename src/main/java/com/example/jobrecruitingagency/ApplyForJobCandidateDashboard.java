package com.example.jobrecruitingagency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ApplyForJobCandidateDashboard
{
    @javafx.fxml.FXML
    private TableColumn<JobList, String> qualificationTC;
    @javafx.fxml.FXML
    private TableColumn<JobList, String> deadlineTC;
    @javafx.fxml.FXML
    private TableColumn<JobList, String> salaryTC;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<JobList, String> typeTC;
    @javafx.fxml.FXML
    private TextField phoneNumberTF;
    @javafx.fxml.FXML
    private TableColumn<JobList, String> departmentTC;
    @javafx.fxml.FXML
    private TableColumn<JobList, String> responsibilitiesTC;
    @javafx.fxml.FXML
    private TableColumn<JobList, String> jobTitleTC;
    @javafx.fxml.FXML
    private TableColumn<JobList, String> descriptionTC;
    @javafx.fxml.FXML
    private TableView<JobList> jobTableView;

    @javafx.fxml.FXML
    public void initialize() {
        ObservableList<JobList> jobData = FXCollections.observableArrayList(loadJobsFromFile());
        jobTableView.setItems(jobData);

        jobTitleTC.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        departmentTC.setCellValueFactory(new PropertyValueFactory<>("department"));
        qualificationTC.setCellValueFactory(new PropertyValueFactory<>("qualification"));
        descriptionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
        responsibilitiesTC.setCellValueFactory(new PropertyValueFactory<>("responsibilities"));
        salaryTC.setCellValueFactory(new PropertyValueFactory<>("salary"));
        deadlineTC.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
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

    @javafx.fxml.FXML
    public void applyButtonOA(ActionEvent actionEvent) {
        String phoneNumber = phoneNumberTF.getText();

        // Validate phone number
        if (!phoneNumber.matches("01\\d{9}")) {
            outputLabel.setText("Enter a valid 11-digit phone number starting with 01");
            return;
        }

        // Find selected job
        JobList selectedJob = jobTableView.getSelectionModel().getSelectedItem();
        if (selectedJob == null) {
            outputLabel.setText("Please select a job to apply for.");
            return;
        }

        // Load candidates
        ArrayList<Candidate> candidates = FileHelper.loadFromFile("candidates.bin");
        Candidate matchingCandidate = null;
        for (Candidate c : candidates) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                matchingCandidate = c;
                break;
            }
        }

        // If candidate not found
        if (matchingCandidate == null) {
            outputLabel.setText("No user found via this contact");
            return;
        }

        // Save Application
        Application application = new Application(selectedJob, matchingCandidate);
        try {
            FileHelper.saveToFile("applications.bin", application);
            outputLabel.setText("Application submitted successfully!");
        } catch (IOException e) {
            outputLabel.setText("Error saving application.");
            e.printStackTrace();
        }
    }
    public List<JobList> loadJobsFromFile() {
        List<JobList> jobLists = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("jobs.bin"))) {
            while (true) {
                JobList job = (JobList) in.readObject();
                jobLists.add(job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobLists;

    }

}