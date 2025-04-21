package com.example.job_agency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CoordinateInterviews {

    @FXML private TextField candidateIdField;
    @FXML private DatePicker interviewDatePicker;
    @FXML private TextField interviewTimeField;
    @FXML private ComboBox<String> interviewTypeComboBox;
    @FXML private ComboBox<String> interviewPanelComboBox;
    @FXML private TableView<InterviewSchedule> interviewTableView;
    @FXML private TableColumn<InterviewSchedule, String> candidateIdColumn;
    @FXML private TableColumn<InterviewSchedule, LocalDate> interviewDateColumn;
    @FXML private TableColumn<InterviewSchedule, String> interviewTimeColumn;
    @FXML private TableColumn<InterviewSchedule, String> interviewTypeColumn;
    @FXML private TableColumn<InterviewSchedule, String> interviewPanelColumn;
    @FXML private Label errorMessage;
    @FXML private Label confirmationMessage;

    private final ObservableList<InterviewSchedule> interviewList = FXCollections.observableArrayList();
    private final File file = new File("interviews.bin");
    @FXML
    private Button scheduleInterviewButton;

    @FXML
    public void initialize() {
        interviewTypeComboBox.setItems(FXCollections.observableArrayList("In-Person", "Virtual", "Phone"));
        interviewPanelComboBox.setItems(FXCollections.observableArrayList("Panel A", "Panel B", "Panel C"));

        candidateIdColumn.setCellValueFactory(new PropertyValueFactory<>("candidateId"));
        interviewDateColumn.setCellValueFactory(new PropertyValueFactory<>("interviewDate"));
        interviewTimeColumn.setCellValueFactory(new PropertyValueFactory<>("interviewTime"));
        interviewTypeColumn.setCellValueFactory(new PropertyValueFactory<>("interviewType"));
        interviewPanelColumn.setCellValueFactory(new PropertyValueFactory<>("interviewPanel"));
    }

    @FXML
    public void scheduleInterviewButtonOA(ActionEvent event) {
        errorMessage.setVisible(false);
        confirmationMessage.setVisible(false);

        String candidateId = candidateIdField.getText().trim();
        LocalDate interviewDate = interviewDatePicker.getValue();
        String interviewTime = interviewTimeField.getText().trim();
        String interviewType = interviewTypeComboBox.getValue();
        String interviewPanel = interviewPanelComboBox.getValue();

        if (candidateId.isEmpty() || interviewDate == null || interviewTime.isEmpty()
                || interviewType == null || interviewPanel == null) {
            errorMessage.setText("All fields must be filled.");
            errorMessage.setVisible(true);
            return;
        }

        if (interviewDate.isBefore(LocalDate.now())) {
            errorMessage.setText("Interview date cannot be in the past.");
            errorMessage.setVisible(true);
            return;
        }

        if (interviewList.stream().anyMatch(i -> i.getCandidateId().equals(candidateId))) {
            errorMessage.setText("Candidate ID must be unique.");
            errorMessage.setVisible(true);
            return;
        }

        InterviewSchedule interview = new InterviewSchedule(candidateId, interviewDate, interviewTime, interviewType, interviewPanel);
        interviewList.add(interview);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(new ArrayList<>(interviewList));
            confirmationMessage.setText("Interview scheduled and saved successfully.");
            confirmationMessage.setVisible(true);
        } catch (IOException e) {
            errorMessage.setText("Error saving file: " + e.getMessage());
            errorMessage.setVisible(true);
        }

        candidateIdField.clear();
        interviewDatePicker.setValue(null);
        interviewTimeField.clear();
        interviewTypeComboBox.setValue(null);
        interviewPanelComboBox.setValue(null);
    }

    @FXML
    public void viewSavedDataOA(ActionEvent event) {
        errorMessage.setVisible(false);
        confirmationMessage.setVisible(false);
        interviewList.clear();

        if (!file.exists()) {
            errorMessage.setText("No saved data found.");
            errorMessage.setVisible(true);
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof java.util.List<?>) {
                for (Object item : (java.util.List<?>) obj) {
                    if (item instanceof InterviewSchedule) {
                        interviewList.add((InterviewSchedule) item);
                    }
                }
                interviewTableView.setItems(interviewList);
                confirmationMessage.setText("Data loaded successfully.");
                confirmationMessage.setVisible(true);
            }
        } catch (IOException | ClassNotFoundException e) {
            errorMessage.setText("Error reading file: " + e.getMessage());
            errorMessage.setVisible(true);
        }
    }
}
