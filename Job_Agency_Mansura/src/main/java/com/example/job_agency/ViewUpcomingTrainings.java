package com.example.job_agency;

import com.example.job_agency.UpcomingTraining;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ViewUpcomingTrainings {

    @FXML private TableView<UpcomingTraining> upcomingTrainingsTableView;
    @FXML private TableColumn<UpcomingTraining, String> trainingIdColumn;
    @FXML private TableColumn<UpcomingTraining, String> trainingTitleColumn;
    @FXML private TableColumn<UpcomingTraining, String> trainerColumn;
    @FXML private TableColumn<UpcomingTraining, String> dateColumn;
    @FXML private TableColumn<UpcomingTraining, String> durationColumn;
    @FXML private TableColumn<UpcomingTraining, String> participantsColumn;
    @FXML private Label confirmationMessage;

    private final String FILE_PATH = "upcomingTrainings.bin";

    @FXML
    public void initialize() {
        trainingIdColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTrainingId()));
        trainingTitleColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTrainingTitle()));
        trainerColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTrainerName()));
        dateColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTrainingDate()));
        durationColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDuration()));
        participantsColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getParticipants()));
    }

    @FXML
    private void loadDataOA() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            List<UpcomingTraining> loadedTrainings = (List<UpcomingTraining>) ois.readObject();
            ObservableList<UpcomingTraining> observableList = FXCollections.observableArrayList(loadedTrainings);
            upcomingTrainingsTableView.setItems(observableList);
            confirmationMessage.setVisible(true);
            confirmationMessage.setText("Training data loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            confirmationMessage.setVisible(true);
            confirmationMessage.setText("Error loading data: " + e.getMessage());
        }
    }
}
