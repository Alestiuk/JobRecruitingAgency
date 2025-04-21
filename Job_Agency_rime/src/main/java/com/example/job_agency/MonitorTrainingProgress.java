package com.example.job_agency;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MonitorTrainingProgress
{
    @javafx.fxml.FXML
    private TableColumn trainerFeedbackColumn;
    @javafx.fxml.FXML
    private TableColumn completionPercentageColumn;
    @javafx.fxml.FXML
    private DatePicker completionDatePicker;
    @javafx.fxml.FXML
    private TextField completionPercentageField;
    @javafx.fxml.FXML
    private Button saveProgressButton;
    @javafx.fxml.FXML
    private Label errorMessage;
    @javafx.fxml.FXML
    private TableColumn completionDateColumn;
    @javafx.fxml.FXML
    private TextField trainingIdField;
    @javafx.fxml.FXML
    private TableView progressTableView;
    @javafx.fxml.FXML
    private TableColumn trainingIdColumn;
    @javafx.fxml.FXML
    private TextArea trainerFeedbackField;
    @javafx.fxml.FXML
    private Label confirmationMessage;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveProgressButtonOA(ActionEvent actionEvent) {
    }
}