package com.example.job_agency;

import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ViewMonthlyProfitLossController
{
    @javafx.fxml.FXML
    private TextField netProfitLossField;
    @javafx.fxml.FXML
    private TextField totalExpensesField;
    @javafx.fxml.FXML
    private DatePicker monthPicker;
    @javafx.fxml.FXML
    private Button showPieChartButton;
    @javafx.fxml.FXML
    private Button calculateButton;
    @javafx.fxml.FXML
    private PieChart profitLossPieChart;
    @javafx.fxml.FXML
    private TextField totalRevenueField;
    @javafx.fxml.FXML
    private TextArea profitLossDataArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleShowPieChart(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCalculateProfitLoss(ActionEvent actionEvent) {
    }
}