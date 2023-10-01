import model.Usuario


fun main() {
    //var arrayvacio: Array<String> = emptyArray()
    var arrayvacio: Array<String?> = arrayOfNulls<String>(10)
    var arrayElementos: Array<Any?> = arrayOf(1,2,3,4,5,"sasdasd")
    var arrayNumeros= intArrayOf(1,2,3,4,5,6,7)

    //obtener dato
    println(arrayElementos[0])
    var contador =0
    arrayElementos[3]="cambios"
    arrayElementos.forEach { it: Any? ->
    if (it==3){
        contador++
    }
    }

    var lista :List<Any?> =arrayElementos.filter { it == 3 }
    println("El numero de 3 es ${arrayElementos.filter { it == 3 }.size}")
    var listaElementos =ArrayList<String>()
    listaElementos.add("1233445")
    listaElementos[1] ="2345678"
    listaElementos.get(0)
    listaElementos[0]
    listaElementos.remove("asdadsa")
    listaElementos.removeAt(0)
    listaElementos.removeIf{it.equals("weq",)}

    var Usuario:Usuario=Usuario("aaaaa","asdda")



}