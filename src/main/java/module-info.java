module com.example.module1_filnalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.apache.poi.ooxml;

    opens com.example.JavaRush_Module1_FilnalProject to javafx.fxml;
    exports com.example.JavaRush_Module1_FilnalProject;
}