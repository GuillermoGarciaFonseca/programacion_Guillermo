import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {

    public void ejercicio3 (){
        Scanner sc = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String nombre;
        String telefono;
        String correo;

        do {
            System.out.println("Introduce un nombre: ");
            nombre = sc.nextLine();
            System.out.println("Introduce un teléfono: ");
            telefono = sc.nextLine();
            System.out.println("Introduce un correo: ");
            correo = sc.nextLine();
            usuarios.add(new Usuario(nombre, telefono, correo));

            System.out.println("¿Quieres introducir otro usuario? (s/n)");
        } while (sc.nextLine().equalsIgnoreCase("s"));

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/fichero/ejercicio3.txt"));

            for (Usuario usuario : usuarios) {
                bw.write(usuario.getNombre() + "," + usuario.getTelefono() + "," + usuario.getEmail());
                bw.newLine();
            }

            bw.close();
        } catch (Exception e) {
            System.out.println("Lo siento no se puede escribir en este fichero");
        }

    }
}
