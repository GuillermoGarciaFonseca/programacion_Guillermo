package model

class Fantasy<Participante>(var listaJugadores:ArrayList<Jugador>) {
    val jugadoresLiga = ArrayList<Participantes>()
    val participantes = ArrayList<Participante>()
    fun realizarFichaje(participante: Participantes, jugador: Jugador) {
        if (participante.presupuesto - jugador.valor < 0) {

        }


        fun realizarFichaje(participante: Participantes, jugador: Jugador): Boolean {
            if (participante.presupuesto - jugador.valor < 0) {
                return false
            }

            val posicionCount = participante.plantilla.count { it.posicion == jugador.posicion }
            if (jugador.posicion == "Portero" && posicionCount >= 1) return false
            if (jugador.posicion == "Defensa" && posicionCount >= 2) return false
            if (jugador.posicion == "Medio" && posicionCount >= 2) return false
            if (jugador.posicion == "Delantero" && posicionCount >= 1) return false

            participante.plantilla.add(jugador)
            participante.presupuesto -= jugador.valor
            return true

        }
        fun agregarParticipante(participante: Participante) {
            participantes.add(participante)
        }

    }
}




