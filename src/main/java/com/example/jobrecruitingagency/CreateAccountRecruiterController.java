package com.example.jobrecruitingagency;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class CreateAccountRecruiterController
{
    @javafx.fxml.FXML
    private TextField userNameTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField contactPersonDesignationTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField contactPersonMobileTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private ComboBox<String> industryTypeCB;
    @javafx.fxml.FXML
    private TextField tradeLicenseNoTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField contactPersonEmailTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField companyNameTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField contactPersonNameTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextArea companyAddressTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField websiteLinkTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField passwordTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField retypePasswordTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private TextField yearOfEstablishTFCreateRecruiterAccount;
    @javafx.fxml.FXML
    private ComboBox<String> numberOfEmployeesCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createAccountOARecruiter(@NotNull ActionEvent actionEvent) throws IOException {
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