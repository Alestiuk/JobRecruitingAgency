package com.example.job_agency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class U8DashboardController
{
    @javafx.fxml.FXML
    private BorderPane dashboardBP;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void profitlossOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U8_Goal4.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }

    @javafx.fxml.FXML
    public void prepareSalariesOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U8_GOAL1.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }

    @javafx.fxml.FXML
    public void payementStatusOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U8_Goal07.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }

    @javafx.fxml.FXML
    public void signOutOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewRevenueOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U8_GOAL2.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }

    @javafx.fxml.FXML
    public void financialRecomndetionOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U8_Goal3.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }

    @javafx.fxml.FXML
    public void costStatmentOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U8_Goal6.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }

    @javafx.fxml.FXML
    public void OverviewOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void recordOA(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("U8_Goal5.fxml"));
        Node node = fxmlLoader.load() ;
        dashboardBP.setCenter(node);

    }
}