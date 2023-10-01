package model

class Usuario (var nombre:String, var apellido:String) {
    /*var nombre :String? =null
    lateinit var apellido: String
    var edad:Int=0

*/
    lateinit var dni:String
   constructor(nombre:String,apellido:String,dni:String) : this(nombre,apellido){

   }
}
