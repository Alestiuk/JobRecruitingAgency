module com.example.jobrecruitingagency {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jobrecruitingagency to javafx.fxml;
    exports com.example.jobrecruitingagency;
}