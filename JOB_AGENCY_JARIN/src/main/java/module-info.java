module com.example.job_agency {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.job_agency to javafx.fxml;
    exports com.example.job_agency;
}