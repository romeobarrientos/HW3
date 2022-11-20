module com.cse.hw3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.cse.hw3 to javafx.fxml;
    exports com.cse.hw3;
}