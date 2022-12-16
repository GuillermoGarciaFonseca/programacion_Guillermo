import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejerciciosbasearraylist {
    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //listasArrays();
        //ejercicio6();

    }

    public static void ejercicio1() {
        ArrayList<String> palabras = new ArrayList<>();
        palabras.add("Cosa");
        palabras.add("Pata");
        palabras.add("Avión");
        palabras.add("Hola");
        palabras.add("Nombre");
        palabras.add("Hipopotamo");
        palabras.add("Ordenador");
        palabras.add("Móvil");
        palabras.add("Cable");
        palabras.add("Ratón");
        palabras.add("Rata");
        //for (String item:palabras) {
        //  System.out.println(item);
        //}
        for (int i = 0; i < palabras.size(); i++) {
            System.out.println(palabras.get(i));
        }
    }

    public static void ejercicio2() {
        ArrayList<Integer> numeroaleatorios = new ArrayList();
        int max = 0;
        int min = 101;
        int sumatorio = 0;
        double media = 0.0;
        for (int i = 0; i < 20; i++) {
            numeroaleatorios.add((int) (Math.random() * 101));
        }
        for (int item : numeroaleatorios) {
            sumatorio += item;
            if (item > max) {
                max = item;
            }
            if (item < min) {
                min = item;
            }
            media = sumatorio % 2;
        }

    }

    public static void ejercicio3() {
        ArrayList<String> nombrecompaneros = new ArrayList();
        nombrecompaneros.add("Carlos");
        nombrecompaneros.add("Joaquin");
        nombrecompaneros.add("Chema");
        nombrecompaneros.add("Alex");
        nombrecompaneros.add("Sergio");
        nombrecompaneros.add("Miguel");
        nombrecompaneros.add("Javi");
        nombrecompaneros.add("Hector");
        int aleatorio = (int) (Math.random() * nombrecompaneros.size());
        System.out.println(aleatorio);
    }

    public static void ejercicio4() {
        ArrayList<Integer> aleatorios1 = new ArrayList();
        ArrayList<Integer> aleatorios2 = new ArrayList();
        int buscar1, buscar2;
        for (int i = 0; i < 21; i++) {
            aleatorios1.add((int) (Math.random() * 21));
            aleatorios2.add((int) (Math.random() * 21));
        }
        int contador = 0;
        for (int i = 0; i < aleatorios2.size(); i++) {

        }
    }

    public static void ejercicio5() {
        ArrayList<String> palabras = new ArrayList();
        Scanner in = new Scanner(System.in);
        int contadorletras = 0;
        String palabraGrande = palabras.get(0), palabraPequeña = palabras.get(0);
        for (int i = 0; i < 10; i++) {
            System.out.println("Dime una palabra");
            palabras.add(in.next());
        }
        for (String item : palabras) {
            contadorletras += item.replaceAll(" ", "").length();
            if (item.replaceAll(" ", "").length() > palabraGrande.length()) {
                palabraGrande = item;
            }
            if (item.replaceAll(" ", "").length() < palabraPequeña.length()) {
                palabraPequeña = item;
            }
        }
    }

   /* public static void listaArrays() {
        ArrayList<Object[]> listaAgenda = new ArrayList<>();
        Object[] usuarionuevo = new Object[]
        listaAgenda.add(new Object[]{"Borja", "contrasenia", 21, "correo@ces", "4324286", "admin"});
        listaAgenda.add(new Object[]{"Carla", "1234", 18, "correo@ces", "26463865", "user"});
        listaAgenda.add(new Object[]{"Martin", "dgdd", 22, "correo@ces", "67365828", "admin"});
        listaAgenda.add(new Object[]{"Pepe", "4567", 24, "correo@ces", "765874593", "user"});
        listaAgenda.add(new Object[]{"Rober", "asdf", 54, "correo@ces", "6435765423", "user"});
        listaAgenda.add(new Object[]{"Marta", "prueba", 43, "correo@ces", "56371743", "user"});
        listaAgenda.add(new Object[]{"Sergio", "ejemplo", 18, "correo@ces", "65743425557", "user"});
        //usuario luis -- admin
        listaAgenda.get(0)[5] = "admin";
        System.out.println("Nombre" + listaAgenda.get(0)[0] + "perfil: " + listaAgenda.get(0)[5]);
        //como imprimo el correo?
   /* System.out.println(listaAgenda.get(0)[3]);
    for (int i = 0; i < listaAgenda.get(0).length; i++) {
        System.out.println(listaAgenda.get(0)[i]);
    }*/
        //Sacar datos de todos aquellos elementos q tengan una edad menor a 35

    /*for (int i = 0; i < listaAgenda.size(); i++) {
        if ((int)listaAgenda.get(i)[2]<35){
            for (int j = 0; j < 5; j++) {
                System.out.print(listaAgenda.get(i)[j]+" ");
            }
            System.out.println();
        }

    }*/
/*)
        //pedir al usuario por tecladoun nombre y una contraseña
        //si el usuariono esta en la lista -- no existe el usuario
        //si el usuario esta en la lista pero su pass es incorrecta --pass incorrecta
        //si el usuario esta en la lista y su pass es correcta pero es user --privilegios insuficientes
        //si el usuario esta en la lista y su pass es correcta y es admin --acceso correcto
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escribe nombre y contraseña");
        String nombre = lectura.next();
        String pass = lectura.next();
        Object[] usuario = estaUsuario(nombre, listaAgenda);
        if (usuario != null) {
            if (((String) usuario[1]).equals(pass)) {
                if (((String) usuario[5]).equals("admin")) {
                    System.out.println("acceso correcto");
                } else {
                    System.out.println("No hay privilegios");
                }
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } else {
            System.out.println("El usuario no esta en la lista");
        }

    }*/

    /*public static Object[] estaUsuario(String nombre, ArrayList<Object[]> lista) {
        Object[] usuarioEncontrado = null;

        //busqueda
        for (Object[] usuario : lista) {
            if (((String) usuario[0]).equalsIgnoreCase(nombre)) {
                usuarioEncontrado = usuario;
                break;
            }
        }
        return usuarioEncontrado;
    }
};*/
    public static ArrayList<Object[]> ejercicio6() {
        ArrayList<Object[]> listacoches = new ArrayList();
        int opcion = 0
        do {

            System.out.println("1.agregar coche");
            System.out.println("2.Lista coches");
            System.out.println("3.Buscar marca");
            System.out.println("4.agregar coche");
            System.out.println("5.Salir");
            System.out.println("Que quieres hacer");
            opcion = new Scanner(System.in).nextInt();
            switch (opcion){
                case 1 :
                    System.out.println("Introduce modelo");
                    String modelo = new Scanner(System.in).next();
                    System.out.println("Introduce marca");
                    String marca = new Scanner(System.in).next();
                    System.out.println("Introduce cv");
                    int cv = new Scanner(System.in).nextInt();
                    listacoches.add(new Object[]{marca,modelo,cv});
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
            }
        }while (opcion!=5);
        /*Object[] coche1 = new Object[]{"Citroen", "cactus", 110};
        listacoches.add(coche1);
        Object[] coche2 = new Object[]{"Ford", "fiesta", 100};
        listacoches.add(coche2);
        Object[] coche3 = new Object[]{"Citroen", "airforce", 130};
        for (Object item :
                listacoches) {
            System.out.printf("marca %s\t\t\tModelo:%s\t\t\t Cv:%d%v",coche1[0],coche2[1],coche3[2]);
        }
        private static void buscarmarca(ArrayList<Object[]>listacoches, String marca){
            for (Object[]coche:listacoches
                 ) {
                if (((String)coche[0]).equalsIgnoreCase()),
            }
        }*/
    }
    }








