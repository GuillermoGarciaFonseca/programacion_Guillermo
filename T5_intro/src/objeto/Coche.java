package objeto;

public class Coche {

    //propiedades o atributos->variables
    //cosas que definen al objeto (Coche)
    //marca, modelo, cv, num puertas, precio (todas las variables son privadas)

    private String marca, modelo;
    private int cv, numPuertas, precio, velocidad;

    //metodos ->constructor "siempre y cuando no tengas otro" hay uno por defecto
    //por defcto tengo el constructor default Coche()
    //marca = null modelo = null cv = null numPuertas = 0 precio = 0
    //public NombreClase(parametros){}(los constructores se escriben con mayuscula)

    private int litrosGasolina, km, marcha;
    public Coche(){
        marca="por defecto";
        modelo="por defecto";
    }
    public Coche(String marca, String modelo, int numPuertas, int cv, int precio){
        this.marca = marca;
        this.modelo = modelo;
        this.numPuertas = numPuertas;
        this.cv = cv;
        this.precio = precio;
    }
    public Coche(String marca, String modelo, int numPuertas, int cv){
        this.marca = marca;
        this.modelo = modelo;
        this.numPuertas = numPuertas;
        this.cv = cv;
        this.precio=50000;
    }

    //metodos ->funcionalidades
    //acelerar -> aumenta la velocidad, consume gasolina, suben KM y se cambia la marcha (dependiendo de la velocidad)
    public void acelerar(int velocidad){


        //subira velociad
        if (this.velocidad+velocidad<=300){
            this.velocidad +=velocidad;
        }else {
            this.velocidad=300;
        }

        //gastara gasolina
        this.litrosGasolina -= (velocidad*30)/100;

        //cambiara marcha
        if (marcha<6){
            this.marcha++;
        }

        //aumenta km
        this.km+=velocidad/3;
    }
    public void mostrarDatos(){
        System.out.println("Modelo "+this.modelo);
        System.out.println("Velocidad "+this.velocidad);
        System.out.println("Marcha "+this.marcha);
        System.out.println("Gasolina "+this.litrosGasolina);
        System.out.println("KM "+this.km);
    }
    public void cargarGasolina(int litros){
        if (litros <=0) {
            System.out.println("No se puede recargar negativo");
        }else if (litrosGasolina+litros>200){
            litrosGasolina=200;
        }else {
            litrosGasolina += litros;
        }
    }
    public void frenar(int velocidad){

        if (velocidad<0)
        //disminuir velociad
        if (this.velocidad-velocidad<=0){
            this.velocidad=0;
        }else if(this.velocidad-velocidad<=0) {
            this.velocidad =0;
        }else {
            this.velocidad -=velocidad;
        }

        //gastara gasolina
        this.litrosGasolina -= (velocidad*30)/100;

        //cambiara marcha
        if (marcha<6){
            this.marcha++;
        }

        //aumenta km
        this.km+=velocidad/3;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }
    //frenar -> baja o pone a 0 la velocidad, se cambia la marcha (dependiendo de la velocidad)
    //cambiarMarcha -> cambia la marcha

    //metodos ->getter/setter

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }

    public int getVelocidad(){
        return velocidad;
    }

    public int getMarcha(){
        return marcha;
    }

    public int getLitrosGasolina(){
        return litrosGasolina;
    }

    public int getKm(){
        return km;
    }
    private void cambiarMarch(boolean movimiento){
        if (movimiento){
            if (marcha==6){
                marcha:6;
            }else {
                marcha++;
            }
        }
    }

}
