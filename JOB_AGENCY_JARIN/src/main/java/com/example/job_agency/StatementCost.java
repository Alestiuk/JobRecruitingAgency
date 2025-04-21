package com.example.job_agency;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StatementCost {

    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private TextField yearField;
    @FXML
    private TextField costCategoryField;
    @FXML
    private TextField costAmountField;
    @FXML
    private TableView<CostStatement> costTableView;
    @FXML
    private TableColumn<CostStatement, String> monthColumn;
    @FXML
    private TableColumn<CostStatement, String> yearColumn;
    @FXML
    private TableColumn<CostStatement, Integer> amountColumn;
    @FXML
    private TableColumn<CostStatement, String> categoryColumn;
    @FXML
    private Label confirmationMessage;
    @FXML
    private Label errorMessage;

    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private BarChart<String, Number> costBarChart;

    private ArrayList<CostStatement> costStatementsList;
    @FXML
    private Button addCostButton;

    // Constructor to initialize the list
    public StatementCost() {
        costStatementsList = new ArrayList<>();
    }

    // Initialize ComboBox with months and Table columns
    @FXML
    public void initialize() {
        // Initialize ComboBox with months
        monthComboBox.getItems().addAll("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");

        // Initialize Table columns with PropertyValueFactory
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    }

    // Handle Add Cost Statement button click (ActionEvent)
    @FXML
    public void handleAddCostStatement(ActionEvent event) {
        // Get user input
        String month = monthComboBox.getValue();
        String year = yearField.getText();
        String category = costCategoryField.getText();
        String amountText = costAmountField.getText();

        // Validate input
        if (month == null || year.isEmpty() || category.isEmpty() || amountText.isEmpty()) {
            errorMessage.setText("All fields must be filled.");
            errorMessage.setVisible(true);
            return;
        }

        // Validate if amount is a number
        int amount;
        try {
            amount = Integer.parseInt(amountText);
        } catch (NumberFormatException e) {
            errorMessage.setText("Cost Amount must be an integer.");
            errorMessage.setVisible(true);
            return;
        }


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Add Cost Statement");
        alert.setHeaderText("Are you sure you want to add this cost statement?");
        alert.setContentText("Month: " + month + "\nYear: " + year + "\nCategory: " + category + "\nAmount: " + amount);

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {

                CostStatement statement = new CostStatement(month, year, category, amount);
                costStatementsList.add(statement);


                writeToFile();


                yearField.clear();
                costCategoryField.clear();
                costAmountField.clear();
                confirmationMessage.setText("Cost Statement Added Successfully.");
                confirmationMessage.setVisible(true);
            }
        });
    }

    // View saved data when View button is clicked
    @FXML
    public void viewOA(ActionEvent event) {
        // Read data from the file and display in the table
        readFromFile();
    }

    private void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("CostStatements.txt", true))) {
            for (CostStatement statement : costStatementsList) {
                writer.write(statement.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        try (Scanner scanner = new Scanner(new File("CostStatements.txt"))) {
            costTableView.getItems().clear();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                CostStatement statement = new CostStatement(
                        tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                costTableView.getItems().add(statement);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void barChartOA(ActionEvent actionEvent) {
    }
}

