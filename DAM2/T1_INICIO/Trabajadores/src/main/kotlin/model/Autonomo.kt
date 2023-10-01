package model

class Autonomo (nombre: String, apellido: String, dni: String, sueldo: Int=10000, var contratado:Boolean=false,
                var cuotaSS:Int):
    Trabajador(nombre,apellido,dni, sueldo){
    override fun calcularSueldoNetoMes() {
    var salario = (sueldo-(cuotaSS*12))/12
    }
    override fun mostrarDatos() {
        super.mostrarDatos()
    println("Cuota Seguridad Social $cuotaSS")
        println("Contratado $contratado")
    }

}