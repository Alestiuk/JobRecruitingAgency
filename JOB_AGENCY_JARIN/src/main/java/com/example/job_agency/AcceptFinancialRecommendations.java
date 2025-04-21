package com.example.job_agency;

import com.example.job_agency.FinancialRecommendation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.Scanner;

public class AcceptFinancialRecommendations {

    @FXML private TableView<FinancialRecommendation> recommendationTable;
    @FXML private TableColumn<FinancialRecommendation, String> recommendationTitleColumn;
    @FXML private TableColumn<FinancialRecommendation, String> categoryColumn;
    @FXML private TableColumn<FinancialRecommendation, Double> amountColumn;
    @FXML private TableColumn<FinancialRecommendation, String> statusColumn;
    @FXML private Label errorLabel;
    @FXML private TextArea savedDataTextArea;

    private final ObservableList<FinancialRecommendation> recommendationList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        recommendationTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("approvalStatus"));
    }

    @FXML
    public void loadRecommendations() {
        recommendationList.clear();
        recommendationTable.getItems().clear();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("financial_recommendations.bin"))) {
            while (true) {
                FinancialRecommendation rec = (FinancialRecommendation) ois.readObject();
                recommendationList.add(rec);
            }
        } catch (EOFException ignored) {
        } catch (Exception e) {
            errorLabel.setText("Failed to load data.");
        }

        recommendationTable.setItems(recommendationList);
    }

    @FXML
    public void approveRecommendation() {
        FinancialRecommendation selected = recommendationTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            errorLabel.setText("No item selected.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to approve?", ButtonType.YES, ButtonType.NO);
        confirm.showAndWait();

        if (confirm.getResult() == ButtonType.YES) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("approved_recommendations.txt", true))) {
                writer.println(selected.toString());
            } catch (IOException e) {
                errorLabel.setText("Error saving approved data.");
                return;
            }

            try (Scanner sc = new Scanner(new File("approved_recommendations.txt"))) {
                savedDataTextArea.clear();
                while (sc.hasNextLine()) {
                    savedDataTextArea.appendText(sc.nextLine() + "\n");
                }
            } catch (Exception e) {
                errorLabel.setText("Error reading approved data.");
            }
        }
    }

    @FXML
    public void rejectRecommendation() {
        FinancialRecommendation selected = recommendationTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            errorLabel.setText("No item selected.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to reject?", ButtonType.YES, ButtonType.NO);
        confirm.showAndWait();

        if (confirm.getResult() == ButtonType.YES) {
            savedDataTextArea.setText("Recommendation '" + selected.getTitle() + "' has been rejected.");
        }
    }
}
