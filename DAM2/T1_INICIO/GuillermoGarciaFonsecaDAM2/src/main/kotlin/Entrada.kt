import model.Fantasy
import model.Jugador
import model.Participantes
import java.util.Objects
import kotlin.collections.ArrayList
import kotlin.collections.ArrayList as ArrayList1

fun main(arg:Array<String>): Unit {
    val participante1 = Participantes("Manuel", 20, 1000000, 1, ArrayList())
    val participante2 = Participantes("Raul", 0, 1000000, 2, ArrayList())
    val participante3 = Participantes("Pepe", 100, 1000000, 3, ArrayList())
    val participante4 = Participantes("Carlos", 50, 1000000, 3, ArrayList())

    val fantasy = Fantasy<Participantes>(ArrayList<Jugador>())

    val jugadores = listOf(
        Jugador(1, "Marc-André ter Stegen", 3000000, "Portero"),
        Jugador(2, "Ronald Araújo", 4000000, "Defensa"),
        Jugador(3, "Eric García", 1000000, "Defensa"),
        Jugador(4, "Pedri", 5000000, "Mediocentro"),
        Jugador(5, "Robert Lewandowski", 8000000, "Delantero"),
        Jugador(6, "Courtois", 3000000, "Portero"),
        Jugador(7, "David Alaba", 4000000, "Defensa"),
        Jugador(8, "Jesús Vallejo", 500000, "Defensa"),
        Jugador(9, "Luka Modric", 5000000, "Mediocentro"),
        Jugador(10, "Karim Benzema", 8000000, "Delantero"),
        Jugador(11, "Ledesma", 500000, "Portero"),
        Jugador(12, "Juan Cala", 300000, "Defensa"),
        Jugador(13, "Zaldua", 400000, "Defensa"),
        Jugador(14, "Alez Fernández", 700000, "Mediocentro"),
        Jugador(15, "Choco Lozano", 800000, "Delantero"),
        Jugador(16, "Rajković", 300000, "Portero"),
        Jugador(17, "Raíllo", 200000, "Defensa"),
        Jugador(18, "Maffeo", 300000, "Defensa"),
        Jugador(19, "Ruiz de Galarreta", 400000, "Mediocentro"),
        Jugador(25, "Ángel", 300000, "Delantero"),
        Jugador(20, "Remiro", 1000000, "Portero"),
        Jugador(21, "Elustondo", 900000, "Defensa"),
        Jugador(22, "Zubeldia", 800000, "Defensa"),
        Jugador(23, "Zubimendi", 1000000, "Mediocentro"),
        Jugador(24, "Take Kubo", 800000, "Delantero")
    )

participante1.plantilla.addAll(jugadores.subList(0,8))
    participante2.plantilla.addAll(jugadores.subList(0, 6))
    participante3.plantilla.addAll(jugadores.subList(6, 12))
    participante4.plantilla.addAll(jugadores.subList(12, 17))

    fantasy.agregarParticipante(participante1)
    fantasy.agregarParticipante(participante2)
    fantasy.agregarParticipante(participante3)
    fantasy.agregarParticipante(participante4)




}

private fun <Participante> Fantasy<Participante>.agregarParticipante(participante: Participante) {
    TODO("Not yet implemented")
}
