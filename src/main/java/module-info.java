module com.empresa.javafx_sp {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;


    opens com.empresa.javafx_sp to javafx.fxml;
    exports com.empresa.javafx_sp;
}