module com.example.rso_seminarska {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.rso_seminarska to javafx.fxml;
    exports com.example.rso_seminarska;
}