package com.example.t2_estructura.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button botonPulsar;
    @FXML
    private Label textoSalida;
    @FXML
    private TextField textoNombre;

   private ArrayList<String>usuarios;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    instacias();
        // se ejecuta - loader.load()
        botonPulsar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (textoNombre.getText().length()>0){
                    //textoSalida.setText(String.format("Perfecto %s has completado tu primera app de javaFX",textoNombre.getText().length()>0));
                usuarios.add(textoNombre.getText());
                textoNombre.clear();
                }else {
                    textoSalida.setText("Por favor faltan datos" );
                }
                //System.out.println("evento pulsado correctamente");
            }
        });

    }
public void instacias(){

}
    }

