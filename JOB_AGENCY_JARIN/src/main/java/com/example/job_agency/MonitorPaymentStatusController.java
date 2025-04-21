package com.example.job_agency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;

public class MonitorPaymentStatusController {

    @FXML
    private ComboBox<String> paymentTypeComboBox;
    @FXML
    private TextField paymentAmountField;
    @FXML
    private ComboBox<String> paymentStatusComboBox;
    @FXML
    private DatePicker datepicker;

    @FXML
    private TableView<PaymentStatus> paymentStatusTable;
    @FXML
    private TableColumn<PaymentStatus, String> paymentTypeColumn;
    @FXML
    private TableColumn<PaymentStatus, Double> paymentAmountColumn;
    @FXML
    private TableColumn<PaymentStatus, String> paymentStatusColumn;
    @FXML
    private TableColumn<PaymentStatus, String> paymentDateColumn;

    private ObservableList<PaymentStatus> paymentStatusList = FXCollections.observableArrayList();
    @FXML
    private Button updatePaymentButton;

    @FXML
    public void initialize() {
        paymentTypeComboBox.getItems().addAll("Credit", "Debit", "Refund");
        paymentStatusComboBox.getItems().addAll("Pending", "Completed", "Failed");

        paymentTypeColumn.setCellValueFactory(new PropertyValueFactory<PaymentStatus, String>("paymentType"));
        paymentAmountColumn.setCellValueFactory(new PropertyValueFactory<PaymentStatus, Double>("paymentAmount"));
        paymentStatusColumn.setCellValueFactory(new PropertyValueFactory<PaymentStatus, String>("paymentStatus"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<PaymentStatus, String>("paymentDate"));
    }

    @FXML
    public void updatePaymentButtonOA(ActionEvent event) {
        String paymentType = paymentTypeComboBox.getValue();
        double paymentAmount = Double.parseDouble(paymentAmountField.getText());
        String paymentStatus = paymentStatusComboBox.getValue();
        LocalDate paymentDate = datepicker.getValue();

        PaymentStatus newPaymentStatus = new PaymentStatus(paymentType, paymentAmount, paymentStatus, paymentDate);
        paymentStatusList.add(newPaymentStatus);

        writeDataToBinaryFile();
    }

    private void writeDataToBinaryFile() {
        File file = new File("paymentObject.bin");
        try (ObjectOutputStream oos = (file.exists()) ? new ObjectOutputStream(new FileOutputStream(file, true)) : new ObjectOutputStream(new FileOutputStream(file))) {
            for (PaymentStatus paymentStatus : paymentStatusList) {
                oos.writeObject(paymentStatus);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void viewRecordOA(ActionEvent event) {
        readDataFromBinaryFile();
    }

    private void readDataFromBinaryFile() {
        File file = new File("paymentObject.bin");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            paymentStatusTable.getItems().clear();
            while (true) {
                PaymentStatus paymentStatus = (PaymentStatus) ois.readObject();
                paymentStatusTable.getItems().add(paymentStatus);
            }
        } catch (EOFException e) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
