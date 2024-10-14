module org.example.pi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.pi to javafx.fxml;
    exports org.example.pi;
}