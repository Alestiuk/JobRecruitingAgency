package com.example.job_agency;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;

public class HandlePaymentsAndTransactions
{
    @javafx.fxml.FXML
    private TableColumn transactionIdColumn;
    @javafx.fxml.FXML
    private TableColumn paymentAmountColumn;
    @javafx.fxml.FXML
    private TableColumn paymentStatusColumn;
    @javafx.fxml.FXML
    private TableView paymentTable;
    @javafx.fxml.FXML
    private TextArea savedDataTextArea;
    @javafx.fxml.FXML
    private ComboBox paymentMethodComboBox;
    @javafx.fxml.FXML
    private TableColumn paymentMethodColumn;
    @javafx.fxml.FXML
    private TextField paymentAmountField;
    @javafx.fxml.FXML
    private Label errorLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void validateNumericInput(Event event) {
    }

    @javafx.fxml.FXML
    public void processPayment(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadPaymentData(ActionEvent actionEvent) {
    }
}