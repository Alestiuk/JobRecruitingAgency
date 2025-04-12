package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SelectionPositingFrLogInController {
    @javafx.fxml.FXML
    private RadioButton recruiterRadioButton;
    @javafx.fxml.FXML
    private RadioButton candidateRadioButton;
    private ToggleGroup toggleGroup;

    @javafx.fxml.FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        recruiterRadioButton.setToggleGroup(toggleGroup);
        candidateRadioButton.setToggleGroup(toggleGroup);
    }

    @javafx.fxml.FXML
    public void continueSelectionpostingButtonOA(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) recruiterRadioButton.getScene().getWindow();
        Parent root;
        if (recruiterRadioButton.isSelected()) {
            root = FXMLLoader.load(Objects.requireNonNull(AgencyApplication.class.getResource("CreateAccountRecruiter.fxml")));
        } else {
            root = FXMLLoader.load(Objects.requireNonNull(AgencyApplication.class.getResource("CreateAccountCandidate.fxml")));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void loginSelectionpostingButtonOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("LogIn.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Log In");
        stage.show();
    }
}