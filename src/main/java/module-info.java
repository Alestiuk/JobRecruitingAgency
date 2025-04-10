module com.example.jobrecruitingagency {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jobrecruitingagency to javafx.fxml;
    exports com.example.jobrecruitingagency;
    exports com.example.jobrecruitingagency.Abir_2331415;
    opens com.example.jobrecruitingagency.Abir_2331415 to javafx.fxml;
}