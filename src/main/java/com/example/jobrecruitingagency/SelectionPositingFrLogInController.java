package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SelectionPositingFrLogInController {
    @FXML
    private RadioButton recruiterRadioButton;
    @FXML
    private RadioButton candidateRadioButton;
    private ToggleGroup toggleGroup;
    @FXML
    private Label outputlabelSelectPostingFrLogIn;

    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        recruiterRadioButton.setToggleGroup(toggleGroup);
        candidateRadioButton.setToggleGroup(toggleGroup);
    }

    @FXML
    public void continueSelectionpostingButtonOA(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) recruiterRadioButton.getScene().getWindow();
        Parent root = null;
        if (recruiterRadioButton.isSelected()) {
    root = FXMLLoader.load(Objects.requireNonNull(AgencyApplication.class.getResource("CreateAccountRecruiter.fxml")));
} else if (candidateRadioButton.isSelected()) {
    root = FXMLLoader.load(Objects.requireNonNull(AgencyApplication.class.getResource("CreateAccountCandidate.fxml")));
} else {
    outputlabelSelectPostingFrLogIn.setText("Please select a user type");
}

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
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