module com.example.tempreature {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.temperature to javafx.fxml;
    exports com.example.temperature;
}