import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val proceso=ProcessBuilder("java","-cp","C:\\Users\\Guillermo\\Desktop\\jdk-18.0.2.1\\bin\\java.exe \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.2.2\\lib\\idea_rt.jar=51882:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.2.2\\bin\" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\\Users\\Guillermo\\OneDrive\\Documentos\\programacion_Guillermo\\DAM2\\T1_INICIO\\PSp\\out\\production\\PSp;C:\\Users\\Guillermo\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-jdk8\\1.7.10\\kotlin-stdlib-jdk8-1.7.10.jar;C:\\Users\\Guillermo\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\1.7.10\\kotlin-stdlib-1.7.10.jar;C:\\Users\\Guillermo\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-common\\1.7.10\\kotlin-stdlib-common-1.7.10.jar;C:\\Users\\Guillermo\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar;C:\\Users\\Guillermo\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-jdk7\\1.7.10\\kotlin-stdlib-jdk7-1.7.10.jar Ejemplo.kt","Ejemplo.kt")
    val hijo=proceso.start()
    val  input=hijo.inputStream
    val lectura=BufferedReader(InputStreamReader(input))
    val resultado=lectura.readLine()
    println(resultado)
    hijo.waitFor()
    println("El hijo acabo ")
}