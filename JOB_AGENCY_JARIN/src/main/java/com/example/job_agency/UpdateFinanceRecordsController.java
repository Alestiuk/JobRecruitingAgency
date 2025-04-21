package com.example.job_agency;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateFinanceRecordsController {

    @FXML
    private TextField accountNameField;
    @FXML
    private TextField accountNumberField;
    @FXML
    private TextField amountField;
    @FXML
    private ComboBox<String> transactionTypeComboBox;
    @FXML
    private TableView<FinanceRecord> financeRecordsTable;
    @FXML
    private TableColumn<FinanceRecord, String> accountNameColumn;
    @FXML
    private TableColumn<FinanceRecord, String> accountNumberColumn;
    @FXML
    private TableColumn<FinanceRecord, Double> amountColumn;
    @FXML
    private TableColumn<FinanceRecord, String> transactionTypeColumn;

    private ArrayList<FinanceRecord> financeRecordList;
    @FXML
    private Button updateRecordButton;

    public UpdateFinanceRecordsController() {
        financeRecordList = new ArrayList<>();
    }

    @FXML
    public void initialize() {

        transactionTypeComboBox.getItems().addAll("Deposit", "Withdrawal", "Transfer");


        accountNameColumn.setCellValueFactory(new PropertyValueFactory<>("accountName"));
        accountNumberColumn.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        transactionTypeColumn.setCellValueFactory(new PropertyValueFactory<>("transactionType"));
    }

    @FXML
    public void updateRecordButtonOA(ActionEvent event) {

        String accountName = accountNameField.getText();
        String accountNumber = accountNumberField.getText();
        double amount = Double.parseDouble(amountField.getText());
        String transactionType = transactionTypeComboBox.getValue();


        FinanceRecord record = new FinanceRecord(accountName, accountNumber, amount, transactionType);
        financeRecordList.add(record);


        accountNameField.clear();
        accountNumberField.clear();
        amountField.clear();
        transactionTypeComboBox.setValue(null);


        writeRecordsToFile();
    }

    @FXML
    public void viewRecordOA(ActionEvent event) {
        readRecordsFromFile();
    }

    private void writeRecordsToFile() {
        try (FileWriter writer = new FileWriter("FinanceRecords.txt", true)) {
            for (FinanceRecord record : financeRecordList) {
                writer.write(record.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readRecordsFromFile() {
        try (Scanner scanner = new Scanner(new File("FinanceRecords.txt"))) {
            financeRecordsTable.getItems().clear();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                FinanceRecord record = new FinanceRecord(
                        tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
                financeRecordsTable.getItems().add(record);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
