package com.example.job_agency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.Optional;

public class PrepareSalariesController {

    @FXML private TextField staffIdField;
    @FXML private TextField staffNameField;
    @FXML private TextField designationField;
    @FXML private TextField basicSalaryField;
    @FXML private TextField bonusField;
    @FXML private TextField deductionsField;
    @FXML private DatePicker salaryDatePicker;
    @FXML private Button generateSalaryButton;
    @FXML private TableView<StaffSalary> salaryTableView;
    @FXML private TableColumn<StaffSalary, String> staffIdColumn;
    @FXML private TableColumn<StaffSalary, Integer> basicSalaryColumn;
    @FXML private TableColumn<StaffSalary, Integer> bonusColumn;
    @FXML private TableColumn<StaffSalary, Integer> totalSalaryColumn;
    @FXML private TableColumn<StaffSalary, String> designationColumn;
    @FXML private Label errorMessage;

    private ObservableList<StaffSalary> staffSalaries = FXCollections.observableArrayList();

    @FXML
    public void generateSalaryButtonClick(ActionEvent event) {
        if (validateFields()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Do you want to proceed with generating salary?");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                StaffSalary newSalary = new StaffSalary(
                        staffIdField.getText(),
                        staffNameField.getText(),
                        designationField.getText(),
                        Integer.parseInt(basicSalaryField.getText()),
                        Integer.parseInt(bonusField.getText()),
                        Integer.parseInt(deductionsField.getText()),
                        salaryDatePicker.getValue()
                );

                for (StaffSalary salary : staffSalaries) {
                    if (salary.getStaffId().equals(newSalary.getStaffId())) {
                        errorMessage.setText("Staff ID must be unique.");
                        errorMessage.setVisible(true);
                        return;
                    }
                }

                staffSalaries.add(newSalary);
                saveToBinaryFile();

                salaryTableView.setItems(staffSalaries);
                errorMessage.setVisible(false);
                clearInputFields();
            }
        }
    }

    private boolean validateFields() {
        if (staffIdField.getText().isEmpty() || staffNameField.getText().isEmpty() ||
                designationField.getText().isEmpty() || basicSalaryField.getText().isEmpty() ||
                bonusField.getText().isEmpty() || deductionsField.getText().isEmpty() ||
                salaryDatePicker.getValue() == null) {
            errorMessage.setText("All fields must be filled.");
            errorMessage.setVisible(true);
            return false;
        }

        try {
            Integer.parseInt(basicSalaryField.getText());
        } catch (NumberFormatException e) {
            errorMessage.setText("Basic salary must be an integer.");
            errorMessage.setVisible(true);
            return false;
        }

        if (salaryDatePicker.getValue().isBefore(LocalDate.now())) {
            errorMessage.setText("Salary date cannot be in the past.");
            errorMessage.setVisible(true);
            return false;
        }

        errorMessage.setVisible(false);
        return true;
    }

    private void clearInputFields() {
        staffIdField.clear();
        staffNameField.clear();
        designationField.clear();
        basicSalaryField.clear();
        bonusField.clear();
        deductionsField.clear();
        salaryDatePicker.setValue(null);
    }

    private void saveToBinaryFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("staffSalaries.bin"))) {
            oos.writeObject(staffSalaries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromBinaryFile() {
        File file = new File("staffSalaries.bin");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                staffSalaries = (ObservableList<StaffSalary>) ois.readObject();
                salaryTableView.setItems(staffSalaries);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            staffSalaries = FXCollections.observableArrayList();
        }
    }

    @FXML
    public void initialize() {
        staffIdColumn.setCellValueFactory(new PropertyValueFactory<StaffSalary, String>("staffId"));
        basicSalaryColumn.setCellValueFactory(new PropertyValueFactory<StaffSalary, Integer>("basicSalary"));
        bonusColumn.setCellValueFactory(new PropertyValueFactory<StaffSalary, Integer>("bonus"));
        totalSalaryColumn.setCellValueFactory(new PropertyValueFactory<StaffSalary, Integer>("totalSalary"));
        designationColumn.setCellValueFactory(new PropertyValueFactory<StaffSalary, String>("designation"));

        loadFromBinaryFile();
    }
}
