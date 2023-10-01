
fun ejercicioUno(x: ArrayList<Int>):Unit{
x
}
fun listaNumeros(x:Int){
    (1..x).forEach{ println(it)}
}
fun main() {
    val lista= ArrayList<String>()
    lista.add("Uno")
    lista.add("Dos")
    lista.add("Tres")
    lista.add("Cuatro")
    lista.add("Cinco")
    lista.forEach { println(it?.length ?:0) }
    var listaNumeros=ArrayList<Int>()
    ejercicioUno(listaNumeros)
}

