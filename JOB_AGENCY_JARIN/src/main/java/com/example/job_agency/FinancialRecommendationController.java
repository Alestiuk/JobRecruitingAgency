package com.example.job_agency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.io.*;
import java.time.LocalDate;

public class FinancialRecommendationController {

    @FXML private TextField recommendationTitleField;
    @FXML private TextArea recommendationDescriptionField;
    @FXML private RadioButton projectFundingRadioButton;
    @FXML private RadioButton operationalExpenseRadioButton;
    @FXML private RadioButton investmentRadioButton;
    @FXML private ToggleGroup recommendationType;
    @FXML private TextField amountField;
    @FXML private ComboBox<String> approvalStatusComboBox;
    @FXML private DatePicker recommendationDatePicker;
    @FXML private TextArea savedRecommendationDataArea;

    private final ObservableList<FinancialRecommendation> recommendationList = FXCollections.observableArrayList();
    @FXML
    private Button sendRecommendationButton;

    @FXML
    public void initialize() {
        approvalStatusComboBox.getItems().addAll("Pending", "Approved", "Rejected");
        projectFundingRadioButton.setToggleGroup(recommendationType);
        operationalExpenseRadioButton.setToggleGroup(recommendationType);
        investmentRadioButton.setToggleGroup(recommendationType);
    }

    @FXML
    public void sendRecommendationButtonOA() {
        String title = recommendationTitleField.getText();
        String description = recommendationDescriptionField.getText();
        String type = ((RadioButton) recommendationType.getSelectedToggle()).getText();
        String approvalStatus = approvalStatusComboBox.getValue();
        String amountText = amountField.getText();
        LocalDate date = recommendationDatePicker.getValue();

        if (title.isEmpty() || description.isEmpty() || approvalStatus == null || amountText.isEmpty() || date == null || recommendationType.getSelectedToggle() == null) {
            showAlert(AlertType.ERROR, "All fields must be filled.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Amount must be a valid number.");
            return;
        }

        Alert confirm = new Alert(AlertType.CONFIRMATION, "Are you sure to proceed?", ButtonType.YES, ButtonType.NO);
        confirm.showAndWait();

        if (confirm.getResult() == ButtonType.YES) {
            FinancialRecommendation recommendation = new FinancialRecommendation(title, description, type, amount, approvalStatus, date);
            recommendationList.add(recommendation);
            showAlert(AlertType.INFORMATION, "Sent successfully.");
        }
    }

    @FXML
    public void saveToFileOA() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("financial_recommendations.bin"))) {
            for (FinancialRecommendation rec : recommendationList) {
                oos.writeObject(rec);
            }
            oos.flush();
        } catch (IOException e) {
            showAlert(AlertType.ERROR, "Error saving to file.");
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("financial_recommendations.bin"))) {
            savedRecommendationDataArea.clear();
            while (true) {
                FinancialRecommendation rec = (FinancialRecommendation) ois.readObject();
                savedRecommendationDataArea.appendText(rec.toString() + "\n");
            }
        } catch (EOFException e) {
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Error loading saved data.");
        }
    }

    private void showAlert(AlertType type, String msg) {
        Alert a = new Alert(type);
        a.setContentText(msg);
        a.showAndWait();
    }
}
