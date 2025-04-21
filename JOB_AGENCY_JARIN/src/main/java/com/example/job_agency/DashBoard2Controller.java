package com.example.job_agency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class DashBoard2Controller
{
    @javafx.fxml.FXML
    private BorderPane dashboardBP;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void signOutOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void arrangeMeetingOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U7_Goal5.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }

    @javafx.fxml.FXML
    public void viewCandidateDetailsOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U7_Goal1.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }

    @javafx.fxml.FXML
    public void viewRevenueAndExpensesOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U7_Goal6.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }
    @javafx.fxml.FXML
    public void handlePaymentsAndTransactionsOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U7_Goal4.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }

    @javafx.fxml.FXML
    public void acceptFinancialRecommendationsOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U7_Goal7.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }

    @javafx.fxml.FXML
    public void manageAgencyBudgetOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U7_Goal3.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }

    @javafx.fxml.FXML
    public void OverviewOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void AssignRecruitersOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U7_Goal2.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }
}