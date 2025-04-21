package com.example.job_agency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.Optional;

public class ArrangeMeetingController {

    @FXML private TextField meetingTitleField;
    @FXML private ComboBox<String> participantsComboBox;
    @FXML private DatePicker meetingDatePicker;
    @FXML private TextField meetingTimeField;
    @FXML private TextArea meetingDescriptionArea;
    @FXML private TableView<Meeting> meetingTableView;
    @FXML private TableColumn<Meeting, String> titleColumn;
    @FXML private TableColumn<Meeting, String> participantsColumn;
    @FXML private TableColumn<Meeting, String> dateColumn;
    @FXML private TableColumn<Meeting, String> timeColumn;
    @FXML private TableColumn<Meeting, String> descriptionColumn;
    @FXML private Label statusLabel;

    private final ObservableList<Meeting> meetingList = FXCollections.observableArrayList();

    private final File meetingFile = new File("MeetingData.bin");

    @FXML
    public void initialize() {
        participantsComboBox.getItems().addAll("Director", "Manager", "Team Lead", "All Staff");

        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        participantsColumn.setCellValueFactory(new PropertyValueFactory<>("participants"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        loadMeetingsFromFile();
        meetingTableView.setItems(meetingList);
    }

    @FXML
    void saveMeeting() {
        String title = meetingTitleField.getText().trim();
        String participants = participantsComboBox.getValue();
        LocalDate date = meetingDatePicker.getValue();
        String time = meetingTimeField.getText().trim();
        String description = meetingDescriptionArea.getText().trim();

        if (title.isEmpty() || participants == null || date == null || time.isEmpty() || description.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "All fields must be filled.");
            return;
        }

        if (date.isBefore(LocalDate.now())) {
            showAlert(Alert.AlertType.WARNING, "Meeting date cannot be in the past.");
            return;
        }

        for (Meeting m : meetingList) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                showAlert(Alert.AlertType.ERROR, "Meeting title already exists. Please choose a different title.");
                return;
            }
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to save this meeting?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = confirm.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.YES) {
            Meeting meeting = new Meeting(title, participants, date.toString(), time, description);
            meetingList.add(meeting);
            saveMeetingsToFile();
            meetingTableView.setItems(meetingList);
            statusLabel.setText("Meeting saved successfully.");
            clearFields();
        }
    }

    private void clearFields() {
        meetingTitleField.clear();
        participantsComboBox.setValue(null);
        meetingDatePicker.setValue(null);
        meetingTimeField.clear();
        meetingDescriptionArea.clear();
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void saveMeetingsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(meetingFile))) {
            for (Meeting m : meetingList) {
                oos.writeObject(m);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMeetingsFromFile() {
        if (!meetingFile.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(meetingFile))) {
            while (true) {
                Meeting m = (Meeting) ois.readObject();
                meetingList.add(m);
            }
        } catch (EOFException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
