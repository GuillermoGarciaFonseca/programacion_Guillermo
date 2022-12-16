import java.util.Scanner;
public class ahorcado{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int intentos=8,W=0;
        boolean verdad=true,w=true;
        int rep=0;
        System.out.println("Bienvenido al juego del ahorcado");
        System.out.println("Ingrese palabra");
        String palabra=in.nextLine();
        System.out.println("\n\n");
        String letra[]=new String[5];
        String [] letras =palabra.split("");
        String intento[] = new String[letras.length];
        String ingresadas[] = new String[letras.length];
        W=letras.length-1;
        for(int i=0;i<25;i++){System.out.println("");}
        for(int i=1;i<letras.length;i++){
            intento[i]="_ ";
        }
        while(intentos>0) {
            System.out.println("Ingrese letra");
            for(int i=1;i<letras.length;i++) {
                System.out.print(intento[i]);
            }
            System.out.println("");
            letra[0]=in.nextLine();rep=0;boolean aviso=true;
            for(int i=1;i<letras.length;i++) {
                w=true;
                if(letras[i].equals(letra[0]))
                {
                    if(!intento[i].equals(letra[0])){
                        intento[i]=letra[0];
                        verdad=false;
                        rep++; ingresadas[i]=letras[0];
                    }else{aviso=false;verdad=false;}
                }
            }
            if(aviso==false) {
                System.out.println(" Aviso: Ya ingresaste esa letra ");
            }
            aviso=true;
            if(verdad==true){
                intentos--;
            }
            else{W=W-rep;}
            System.out.println(" \nQuedan: "+intentos+" Intentos");
            impresion(intentos);
            if(intentos==0) {
                System.out.println("\nLastima Perdiste\nLa palabra es: "+palabra);
            }
            if(W<=0){
                System.out.println(palabra+"\nFelicidades ganaste, Bien echo.");intentos=0;}
            verdad=true;rep=0;
        }
    }
    static void impresion(int vd) {
        if(vd==8) {
            System.out.println("prueba otra letra ");
            System.out.println("    |   |   ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("------------");
        }if(vd==7) {
            System.out.println("Suerte a la próxima la aciertas");
            System.out.println("    |   |   ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("------------");
        }if(vd==6) {
            System.out.println("A la siguiente te cuenta");
            System.out.println("    |   |   ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("------------");
        }
        if(vd==5) {
            System.out.println("    -----   ");
            System.out.println("    |   |   ");
            System.out.println("    |   |   ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("------------");
        }
        if(vd==4) {
            System.out.println("    -----   ");
            System.out.println("    |   |   ");
            System.out.println("    |   |   ");
            System.out.println("    |   0   ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("------------");
        }
        if(vd==3) {
            System.out.println("    -----   ");
            System.out.println("    |   |   ");
            System.out.println("    |   |   ");
            System.out.println("    |   0   ");
            System.out.println("    |  /    ");
            System.out.println("    |       ");
            System.out.println("    |    \\ ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("------------");
        }
        if(vd==2) {
            System.out.println("    -----   ");
            System.out.println("    |   |   ");
            System.out.println("    |   |   ");
            System.out.println("    |   0   ");
            System.out.println("    |  /|   ");
            System.out.println("    |   |   ");
            System.out.println("    |    \\ ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("------------");
        }
        if(vd==1) {
            System.out.println("    -----   ");
            System.out.println("    |   |   ");
            System.out.println("    |   |   ");
            System.out.println("    |   0   ");
            System.out.println("    |   |\\ ");
            System.out.println("    |   |   ");
            System.out.println("    |  / \\   ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("------------");
        }
        if(vd==0)
        {
            System.out.println("    -----   ");
            System.out.println("    |   |   ");
            System.out.println("    |   |   ");
            System.out.println("    |   0   ");
            System.out.println("    |  /|\\ ");
            System.out.println("    |   |   ");
            System.out.println("    |  / \\   ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("    |       ");
            System.out.println("------------");
        }
    }
}