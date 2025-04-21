package com.example.job_agency;

import com.example.job_agency.UpcomingTraining;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class InputTrainings {

    @FXML private TextField trainingIdField;
    @FXML private TextField trainingTitleField;
    @FXML private TextField trainerNameField;
    @FXML private DatePicker trainingDatePicker;
    @FXML private TextField durationField;
    @FXML private TextField participantsField;
    @FXML private Label errorMessage;

    private final ObservableList<UpcomingTraining> trainings = FXCollections.observableArrayList();
    private final String FILE_PATH = "upcomingTrainings.bin";
    @FXML
    private Button saveTrainingButton;

    @FXML
    public void initialize() {
        errorMessage.setText("");
    }

    @FXML
    private void saveTrainingButtonOA() {
        errorMessage.setText("");

        // Validation
        if (trainingIdField.getText().isEmpty() ||
                trainingTitleField.getText().isEmpty() ||
                trainerNameField.getText().isEmpty() ||
                trainingDatePicker.getValue() == null ||
                durationField.getText().isEmpty() ||
                participantsField.getText().isEmpty()) {

            errorMessage.setText("All fields must be filled!");
            return;
        }

        // Confirmation
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Save");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("Do you want to save this training?");
        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                String trainingId = trainingIdField.getText();
                String title = trainingTitleField.getText();
                String trainer = trainerNameField.getText();
                String date = trainingDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String duration = durationField.getText();
                String participants = participantsField.getText();

                UpcomingTraining training = new UpcomingTraining(trainingId, title, trainer, date, duration, participants);
                trainings.add(training);
                saveToBinaryFile();
                clearFields();
                errorMessage.setText("Training saved successfully!");
            }
        });
    }

    private void clearFields() {
        trainingIdField.clear();
        trainingTitleField.clear();
        trainerNameField.clear();
        trainingDatePicker.setValue(null);
        durationField.clear();
        participantsField.clear();
    }

    private void saveToBinaryFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(new ArrayList<>(trainings));
        } catch (IOException e) {
            errorMessage.setText("Error saving training: " + e.getMessage());
        }
    }
}
