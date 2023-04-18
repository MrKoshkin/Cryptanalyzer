module com.example.module1_filnalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.module1_filnalproject to javafx.fxml;
    exports com.example.module1_filnalproject;
}