module com.example.oc_lab_benchmark {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.oc_lab_benchmark to javafx.fxml;
    exports com.example.oc_lab_benchmark;
}