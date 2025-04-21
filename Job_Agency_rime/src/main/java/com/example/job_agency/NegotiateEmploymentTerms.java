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

public class NegotiateEmploymentTerms {

    @FXML private TextField candidateIdField, salaryOfferedField, jobRoleField, contractDurationField;
    @FXML private DatePicker startDatePicker;
    @FXML private TableView<EmploymentTerm> employmentTermsTableView;
    @FXML private TableColumn<EmploymentTerm, String> candidateIdColumn, salaryOfferedColumn, jobRoleColumn, contractDurationColumn;
    @FXML private TableColumn<EmploymentTerm, LocalDate> startDateColumn;
    @FXML private Label errorMessage, confirmationMessage;

    private final ObservableList<EmploymentTerm> employmentTermsList = FXCollections.observableArrayList();
    private final String fileName = "employment_terms.bin";
    @FXML
    private Button saveEmploymentTermsButton1;
    @FXML
    private Button saveEmploymentTermsButton;

    @FXML
    public void initialize() {
        candidateIdColumn.setCellValueFactory(new PropertyValueFactory<>("candidateId"));
        salaryOfferedColumn.setCellValueFactory(new PropertyValueFactory<>("salaryOffered"));
        jobRoleColumn.setCellValueFactory(new PropertyValueFactory<>("jobRole"));
        contractDurationColumn.setCellValueFactory(new PropertyValueFactory<>("contractDuration"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
    }

    @FXML
    private void saveEmploymentTermsButton1(ActionEvent event) {
        errorMessage.setVisible(false);
        confirmationMessage.setVisible(false);

        String candidateId = candidateIdField.getText().trim();
        String salary = salaryOfferedField.getText().trim();
        String jobRole = jobRoleField.getText().trim();
        String duration = contractDurationField.getText().trim();
        LocalDate startDate = startDatePicker.getValue();

        if (candidateId.isEmpty() || salary.isEmpty() || jobRole.isEmpty() || duration.isEmpty() || startDate == null) {
            errorMessage.setText("All fields are required.");
            errorMessage.setVisible(true);
            return;
        }

        if (startDate.isBefore(LocalDate.now())) {
            errorMessage.setText("Start date cannot be in the past.");
            errorMessage.setVisible(true);
            return;
        }

        for (EmploymentTerm term : employmentTermsList) {
            if (term.getCandidateId().equals(candidateId)) {
                errorMessage.setText("Candidate ID must be unique.");
                errorMessage.setVisible(true);
                return;
            }
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to save this record?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirm Save");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            EmploymentTerm newTerm = new EmploymentTerm(candidateId, salary, jobRole, duration, startDate);
            employmentTermsList.add(newTerm);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(new ArrayList<>(employmentTermsList));
            } catch (IOException e) {
                errorMessage.setText("Error saving data.");
                errorMessage.setVisible(true);
                return;
            }

            confirmationMessage.setText("Employment terms saved successfully.");
            confirmationMessage.setVisible(true);

            candidateIdField.clear();
            salaryOfferedField.clear();
            jobRoleField.clear();
            contractDurationField.clear();
            startDatePicker.setValue(null);
        }
    }

    @FXML
    private void viewEmploymentTermsButton1(ActionEvent event) {
        errorMessage.setVisible(false);
        confirmationMessage.setVisible(false);

        File file = new File(fileName);
        if (!file.exists()) {
            errorMessage.setText("No saved data found.");
            errorMessage.setVisible(true);
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object readObject = ois.readObject();
            if (readObject instanceof ArrayList<?>) {
                employmentTermsList.clear();
                for (Object obj : (ArrayList<?>) readObject) {
                    if (obj instanceof EmploymentTerm) {
                        employmentTermsList.add((EmploymentTerm) obj);
                    }
                }
                employmentTermsTableView.setItems(employmentTermsList);
                confirmationMessage.setText("Data loaded successfully.");
                confirmationMessage.setVisible(true);
            }
        } catch (IOException | ClassNotFoundException e) {
            errorMessage.setText("Error loading data.");
            errorMessage.setVisible(true);
        }
    }
}
