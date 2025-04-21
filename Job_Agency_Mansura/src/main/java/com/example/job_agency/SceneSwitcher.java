package com.example.job_agency;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {
    public static <T> T switchScene(String fxmlFileName, Event event, String stageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.setTitle(stageName);

        T controller = fxmlLoader.getController();
        return controller;
    }

    public static <T> T switchScene(String fxmlFileName, Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.setScene(scene);

        T controller = fxmlLoader.getController();
        return controller;
    }

    public static void switchSceneNewStage(String fxmlFileName,String stageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(stageName);
        stage.show();
    }

    public static<T> T switchSceneNewStage(String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        T controller = fxmlLoader.getController();
        return controller;
    }
}
