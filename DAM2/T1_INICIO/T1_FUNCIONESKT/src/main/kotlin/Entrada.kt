fun funcionSuma(operadoUno: Int,operadoDos: Int): Int {
    var suma = operadoUno+operadoUno
    //println("El resultado de suma $operadoUno +$operadoDos es $suma")
    return suma
}
fun funcionOptativa(param1: String,param2:Int?){
    println("El parametro uno es $param1 y el segundo $param2")

}
fun imprimirMensaje(mensaje:String): Unit {
    var nombre =pedirNombre()
println(mensaje+"$nombre")
}
fun funcionParametroFuncion(param: ()->String, param2:String){
    var nombre =param?.invoke() ?: "defecto"
    println("$param2,$nombre")
}
fun pedirNombre(): String {
    println("Por favor introduce el nombre ")
    var nombre = readln()
    return nombre
}
var funcionSumaFlecha: ((Int, Int)->Int)={
    param1:Int,param2:Int -> param1 + param2

}
fun main() {
    println( funcionSumaFlecha(4,8))
    //funcionParametroFuncion({pedirNombre()},"Ejemplo")
    //posicional
    //println( funcionSuma(1,2))
    //nominales
    //println( funcionSuma(operadoDos = 2, operadoUno = 1))
//funcionOptativa("uno",null)
}


