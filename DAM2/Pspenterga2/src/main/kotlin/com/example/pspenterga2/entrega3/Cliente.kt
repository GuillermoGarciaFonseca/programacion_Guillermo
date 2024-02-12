package com.example.pspenterga2.entrega3
import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import java.rmi.registry.LocateRegistry
import java.rmi.registry.Registry

class FormularioCliente : Application() {
    private lateinit var formularioService: FormularioService

    override fun start(primaryStage: Stage) {
        primaryStage.title = "Formulario"

        val nameLabel = Label("Nombre:")
        val nameField = TextField()
        val ageLabel = Label("Edad:")
        val ageField = TextField()
        val submitButton = Button("Enviar")
        val curso =Label("Curso:")
        val cursonombre=TextField()


        val gridPane = GridPane().apply {
            padding = Insets(10.0)
            hgap = 5.0
            vgap = 5.0
        }

        gridPane.add(nameLabel, 0, 0)
        gridPane.add(nameField, 1, 0)
        gridPane.add(ageLabel, 0, 1)
        gridPane.add(ageField, 1, 1)
        gridPane.add(submitButton, 1, 2)
        gridPane.add(curso, 2,1)
        gridPane.add(cursonombre,2,2)

        submitButton.setOnAction {
            val nombre = nameField.text
            val edad = ageField.text.toIntOrNull()

            if (edad != null) {
                val resultado = formularioService.enviarFormulario(nombre, edad)
                println("Respuesta del servidor: $resultado")
            } else {
                println("La edad ingresada no es válida.")
            }
        }

        val scene = Scene(gridPane, 300.0, 200.0)

        primaryStage.scene = scene
        primaryStage.show()
    }

    override fun init() {
        try {
            val registry: Registry = LocateRegistry.getRegistry("localhost", 12345)
            formularioService = registry.lookup("FormularioService") as FormularioService
        } catch (e: Exception) {
            println("Error al conectarse al servidor: ${e.message}")
            e.printStackTrace()
        }
    }
}

fun main(args: Array<String>) {
    Application.launch(FormularioCliente::class.java, *args)
}