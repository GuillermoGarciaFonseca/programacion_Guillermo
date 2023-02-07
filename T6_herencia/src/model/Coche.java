package model;

public abstract class Coche {

    //molde de lo que será un objeto tipo object
    //

    private String marca,modelo;

    private boolean encendido;

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        //this.encendido=false;
    }

    protected Coche() {
    }

   /* public void mostrarDatos(){
        System.out.println(this.marca);
        System.out.println(this.modelo);
        System.out.println(this.encendido);
    }*/

    //Mostrar datos-->si
    //genero getter y setter de los nuevos de los antiguos no
    // De marca y modelo no se escribirian porque estarian duplicados
    //pregunta si quiero encender en el modoCampo
    // y __> se enciende "Encendido mod campo"
    //public abstract void mostrarDatos();

    //Mostrar datos-->si
    //genero getter y setter de los nuevos de los antiguos no
    // De marca y modelo no se escribirian porque estarian duplicados
    //pregunta si quiero encender en el modoCampo
    // y __> se enciende "Encendido mod campo"


    //Mostrar datos-->si
    //genero getter y setter de los nuevos de los antiguos no
    // De marca y modelo no se escribirian porque estarian duplicados
    //pregunta si quiero encender en el modoCampo
    // y __> se enciende "Encendido mod campo"


    public void encender(){
        if (encendido){
            System.out.println("EL coche esta apagado");
        }else {
            System.out.println("El coche ya esta encendido");
            this.encendido=true;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public  void mostrarDatos(){
        System.out.println(this.marca);
        System.out.println(this.modelo);
        System.out.println(this.encendido);
    };

}
