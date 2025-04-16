package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MessageRecruiterDashboard
{
    @javafx.fxml.FXML
    private TextArea messageTextAreaRecruiterMessage;
    @javafx.fxml.FXML
    private Label outputLableMessageRecruiter;
    @javafx.fxml.FXML
    private TextField phoneNumberTFMessageRecruiter;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendButtonOARecruiterMessage(ActionEvent actionEvent) {
        String message;
        message = messageTextAreaRecruiterMessage.getText();
        if (message.isEmpty()) {
            outputLableMessageRecruiter.setText("Empty Message");
        } else {
            outputLableMessageRecruiter.setText("Message Sent");

        }

    }

    @javafx.fxml.FXML
    public void homeButtonOA(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(AgencyApplication.class.getResource("RecruiterDashboard.fxml"));
        root = fxmlLoader.load();
        Scene scene = new Scene(root) ;
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Recruiter Dashboard");
        stage.show();
    }
}