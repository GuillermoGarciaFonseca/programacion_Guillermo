package com.example.practicajson;


import com.example.practicajson.model.Pokemon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoPersoController implements Initializable {

    @FXML
    private TextField textFieldNombre, textFieldPass;

    @FXML
    private CheckBox checkRecordar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Parte grafica cargada");
    }
    public boolean isPelicula(){
        if (textFieldNombre.getText().isEmpty() || textFieldPass.getText().isEmpty()){
            return false;
        }
        return true;
    }
    public Pokemon getPelicula(){
        return new Pokemon(textFieldNombre.getText(),"ejemplo",
                Integer.parseInt(textFieldPass.getText()));
    }


}