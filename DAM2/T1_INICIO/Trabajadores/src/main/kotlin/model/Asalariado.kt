package model

import java.util.Scanner

class Asalariado(nombre: String, apellido: String, dni: String, sueldo: Int = 10000,var  numeroPagas:Int,
var contratado:Boolean =false) :
    Trabajador(nombre, apellido, dni, sueldo) {
    override fun calcularSueldoNetoMes() {
    var salario = (sueldo-(sueldo *0.21))/numeroPagas
    }
    override fun mostrarDatos(){
        super.mostrarDatos()
        println("Nº pagas $numeroPagas")
        println("Contratado $contratado")
    }
}