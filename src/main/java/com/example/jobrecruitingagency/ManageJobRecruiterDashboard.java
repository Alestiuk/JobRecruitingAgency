package com.example.jobrecruitingagency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ManageJobRecruiterDashboard
{
    @javafx.fxml.FXML
    private TableColumn<JobList,String> deadlineTC;
    @javafx.fxml.FXML
    private TableColumn<JobList,String> salaryTC;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<JobList,String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<JobList,String> departmentTC;
    @javafx.fxml.FXML
    private TableColumn typeTC;
    @javafx.fxml.FXML
    private TableColumn jobTitleTC;
    @javafx.fxml.FXML
    private TableView<JobList> jobTableView;

    @javafx.fxml.FXML
    public void initialize() {
        ObservableList<JobList> jobData = FXCollections.observableArrayList(loadJobsFromFile());
        jobTableView.setItems(jobData);

        jobTitleTC.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        departmentTC.setCellValueFactory(new PropertyValueFactory<>("department"));
        salaryTC.setCellValueFactory(new PropertyValueFactory<>("salary"));
        deadlineTC.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
    }

    @javafx.fxml.FXML
    public void editButtonOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void deleteButtonOA(ActionEvent actionEvent) {
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
    public List<JobList> loadJobsFromFile() {
        List<JobList> jobLists = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("jobs.dat"))) {
            while (true) {
                JobList job = (JobList) in.readObject();
                jobLists.add(job);
            }
        } catch (EOFException eof) {
            // End of file reached – normal behavior
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobLists;
    }
}