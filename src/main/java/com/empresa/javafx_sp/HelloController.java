package com.empresa.javafx_sp;

import java.sql.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Class.forName;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_ciudad;
    @FXML
    private TextField txt_facturacion;

    @FXML
    protected void onHelloButtonClick() throws ClassNotFoundException {
        //welcomeText.setText("Welcome to JavaFX Application!");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/test";
            Connection conn=DriverManager.getConnection(url, "root","");
            String sp="{CALL `sp_add_clientes`(?, ?, ?)}";
            CallableStatement cs=conn.prepareCall(sp);
            cs.setString(1, txt_nombre.getText());
            cs.setString(2, txt_ciudad.getText());
            cs.setString(3, txt_facturacion.getText());

            cs.executeUpdate();
            welcomeText.setText("Cliente guardado");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}