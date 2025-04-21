package com.example.job_agency;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;

public class ManageAgencyBudget
{
    @javafx.fxml.FXML
    private ComboBox budgetCategoryComboBox;
    @javafx.fxml.FXML
    private TableColumn jobPostingsColumn;
    @javafx.fxml.FXML
    private TableColumn recruiterFeesColumn;
    @javafx.fxml.FXML
    private TableColumn currentBudgetColumn;
    @javafx.fxml.FXML
    private TableColumn categoryColumn;
    @javafx.fxml.FXML
    private TableColumn advertisingColumn;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableView budgetTable;
    @javafx.fxml.FXML
    private TextField newBudgetAmountField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveChanges(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void validateNumericInput(Event event) {
    }

    @javafx.fxml.FXML
    public void loadData(ActionEvent actionEvent) {
    }
}