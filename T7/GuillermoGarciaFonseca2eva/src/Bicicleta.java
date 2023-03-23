public class Bicicleta {
    private EnumbiciM enumbici;
    private int velocidad,pulgadas;
    private EnumbiciT enumbiciT;
    private boolean estado;

    public Bicicleta() {
    }

    public Bicicleta(EnumbiciM enumbici, int velocidad, int pulgadas, EnumbiciT enumbiciT, boolean estado) {
        this.enumbici = enumbici;
        this.velocidad = velocidad;
        this.pulgadas = pulgadas;
        this.enumbiciT = enumbiciT;
        this.estado = estado;
    }


    public void mostrarDatos(){
        System.out.println("Velocidad: "+velocidad);
        System.out.println("pulgadas: "+pulgadas);
        System.out.println("Modelo bici: "+enumbici);
        System.out.println("Tamaño bici: "+enumbiciT);
        System.out.println("Estado: "+estado);
    }
    public void reparar(){
        if (estado != false){
            System.out.println("Su bicicleta tiene que ser reparada");
        }else {
            System.out.println("Su bicicleta no tiene que ser reparada");
        }
    }

    public EnumbiciM getEnumbici() {
        return enumbici;
    }

    public void setEnumbici(EnumbiciM enumbici) {
        this.enumbici = enumbici;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public EnumbiciT getEnumbiciT() {
        return enumbiciT;
    }

    public void setEnumbiciT(EnumbiciT enumbiciT) {
        this.enumbiciT = enumbiciT;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
