package com.example.practicajson;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DetalleController implements Initializable {

        @FXML
        public Label titulo;
        @FXML
        public ImageView imagen;
        @FXML
        public TextArea descripcion;
        @FXML
        public Label votos;
        @FXML
        public Label media;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }
        public void setPokemonData(JSONPokemon pokemonJSON){

        }
    }

