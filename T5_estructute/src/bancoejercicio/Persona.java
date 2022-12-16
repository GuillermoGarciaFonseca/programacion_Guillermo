package bancoejercicio;

public class Persona {
    private String nombre,nif,apellido;
    private int telefono;
    public Persona(String nombre,String nif, int telefono,String apellido){
        this.nif=nif;
        this.nombre=nombre;
        this.telefono=telefono;
        this.apellido= apellido;
    }
    public void mostrarDatos(){
        System.out.println("El nif es: "+nif);
        System.out.println("El nombre es: "+nombre);
        System.out.println("El apellido es: "+apellido);
        System.out.print("El numero de telefono es: "+telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public String setNif() {
        this.nif = nif;
        return null;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
