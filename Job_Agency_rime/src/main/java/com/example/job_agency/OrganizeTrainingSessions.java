package com.example.job_agency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class OrganizeTrainingSessions {

    @FXML private TextField trainingIdField, trainingTitleField, trainerNameField, durationField, participantsField;
    @FXML private DatePicker trainingDatePicker;
    @FXML private TableView<TrainingSession> sessionsTableView;
    @FXML private TableColumn<TrainingSession, String> sessionIdColumn, sessionTitleColumn, trainerColumn, dateColumn, durationColumn, participantsColumn;
    @FXML private Label errorMessage, confirmationMessage;

    private final ObservableList<TrainingSession> sessionList = FXCollections.observableArrayList();
    private final String FILE_PATH = "training_sessions.txt";

    @FXML
    public void initialize() {
        sessionIdColumn.setCellValueFactory(new PropertyValueFactory<>("trainingId"));
        sessionTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        trainerColumn.setCellValueFactory(new PropertyValueFactory<>("trainer"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        participantsColumn.setCellValueFactory(new PropertyValueFactory<>("participants"));
    }

    @FXML
    void saveSessionButtonOA(ActionEvent event) {
        errorMessage.setVisible(false);
        confirmationMessage.setVisible(false);

        String id = trainingIdField.getText().trim();
        String title = trainingTitleField.getText().trim();
        String trainer = trainerNameField.getText().trim();
        String date = trainingDatePicker.getValue() != null ? trainingDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : "";
        String duration = durationField.getText().trim();
        String participants = participantsField.getText().trim();

        if (id.isEmpty() || title.isEmpty() || trainer.isEmpty() || date.isEmpty() || duration.isEmpty() || participants.isEmpty()) {
            errorMessage.setText("All fields must be filled.");
            errorMessage.setVisible(true);
            return;
        }

        TrainingSession session = new TrainingSession(id, title, trainer, date, duration, participants);
        sessionList.add(session);
        writeToFile(session);
        confirmationMessage.setText("Training session saved successfully.");
        confirmationMessage.setVisible(true);
        clearFields();
    }

    private void writeToFile(TrainingSession session) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(session.getTrainingId() + "," + session.getTitle() + "," + session.getTrainer() + "," +
                    session.getDate() + "," + session.getDuration() + "," + session.getParticipants());
            writer.newLine();
        } catch (IOException e) {
            errorMessage.setText("Error writing to file.");
            errorMessage.setVisible(true);
        }
    }

    @FXML
    void viewsaveSessionButtonOA(ActionEvent event) {
        sessionList.clear();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            errorMessage.setText("No saved sessions found.");
            errorMessage.setVisible(true);
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 6) {
                    sessionList.add(new TrainingSession(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
            sessionsTableView.setItems(sessionList);
        } catch (IOException e) {
            errorMessage.setText("Error reading from file.");
            errorMessage.setVisible(true);
        }
    }

    private void clearFields() {
        trainingIdField.clear();
        trainingTitleField.clear();
        trainerNameField.clear();
        trainingDatePicker.setValue(null);
        durationField.clear();
        participantsField.clear();
    }
}
