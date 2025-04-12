module com.example.jobrecruitingagency {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;


    opens com.example.jobrecruitingagency to javafx.fxml;
    exports com.example.jobrecruitingagency;

}