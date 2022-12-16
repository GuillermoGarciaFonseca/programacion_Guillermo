package objeto;

public class Persona {
    private String nombre, apellido, dni;
    private int edad, altura;
    private double peso;
    public Persona(String nombre, String apellido, String dni, int edad, int altura, double peso){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;

    }
    public Persona(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }
    public Persona(String nombre, String apellido, int edad, double peso, int altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        dni = "111111111X";
    }
    public Persona() {
        nombre = "por defecto";
        apellido = "por defecto";
        dni = "111111111X";
    }

    public void mostraDatos(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellido: "+apellido);
        System.out.println("DNI: "+dni);
        System.out.println("Edad: "+edad);
        System.out.println("Altura: "+altura);
        System.out.println("Peso: "+peso);
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public  void aumentarEdad(int numero){
        this.edad +=numero;
    }
    public double calcularIMC(){
        // IMC = peso / (altura * altura)
        double imc = this.peso / Math.pow((double) this.altura/100,2);
        return imc;


    }

}
