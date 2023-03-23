package Biblioteca;

public enum EnumDVD {
    policiaca("policiaca",5),
    musical("Musical",0),
intriga("Intriga",12),
    terror("Terror",18),
    comedia("Comedia",3),
    drama("Drama",10);
    String tipo;
    int edad;

   private EnumDVD(String policiaca, int i) {

    }
    public void mostrarDatos(){
        System.out.println("Tipo y calificacion: "+tipo+" "+edad);
    }

    public String getTipo() {
        return tipo;
    }

    public int getEdad() {
        return edad;
    }
}
