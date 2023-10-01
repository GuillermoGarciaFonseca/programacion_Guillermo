package model

class Participantes(var nombre: String,  var puntos:Int, var presupuesto:Int = 10000000,var id:Int,var plantilla: ArrayList<Jugador>) {


    override fun toString(): String {
        return "Participantes(nombre='$nombre', puntos=$puntos, presupuesto=$presupuesto, id=$id)"
    }

}