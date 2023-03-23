package model;
public class Usuario {
    private int telefono,edad;
    private String nombre,apellidos,dni;
    public void mostrarDatos(){
        System.out.println("El nombre del Usuario"+nombre);
        System.out.println("EL apellido del Usuario"+apellidos);
        System.out.println("El dni del Usuario"+dni);
        System.out.println("El telefono del Usuario"+telefono);
        System.out.println("El dni del Usuario"+dni);
    }

    public Usuario(String nombre, String apellido, String dni, int edad, int telefono) {
    }

    public Usuario(int telefono, int edad, String nombre, String apellidos, String dni) {
        this.telefono = telefono;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "telefono=" + telefono +
                "edad= " + edad +'\n'+
                "nombre= " + nombre + '\n' +
                "apellidos= " + apellidos + '\n' +
                "dni= " + dni + '\n' ;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
