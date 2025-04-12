package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccountCandidateController
{

    @javafx.fxml.FXML
    private TextField emailTFCreateAccountCandidate;
    @javafx.fxml.FXML
    private TextField retypePasswordTFCreateAccountCandidate;
    @javafx.fxml.FXML
    private TextField passwordTFCreateAccountCandidate;
    @javafx.fxml.FXML
    private TextField fullNameTFCreateAccountCandidate;
    @javafx.fxml.FXML
    private ComboBox<String> selectSkillCBcreateAccountForCandidate;
    @javafx.fxml.FXML
    private TextField mobileTFCreateAccountCandidate;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void createAccountOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createAccountForCandidateOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("CandidateDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Candidate Dashboard");
        stage.show();
    }
}