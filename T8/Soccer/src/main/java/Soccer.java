public class Soccer {
    public static void main(String[] args) {
        Lector lector= new Lector();
        lector.obtenerUltimosPartidosEquipo("1571069");
        lector.obtenerClasificacion();
        lector.obtenerLigas();
        lector.listarLigas();
        lector.mostrarEquipos();
        lector.obtenerEquipos("España");
    }
}
