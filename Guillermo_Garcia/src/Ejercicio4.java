public class Ejercicio4 {


    public  static void main(String[] args){
        double preciocoche2,pagoplazos,interespagado1,suma,interespagado2,interespagado3,interespagado4,
                interespagado5,interespagado6,preciocoche1,preciocoche3,preciocoche4,preciocoche5,preciocoche6;;
        double interes1,interes2,interes3,interes4,interes5,interes6;
        preciocoche1=30000;
        preciocoche2 = 25000;
        preciocoche3 = 20000;
        preciocoche4 = 15000;
        preciocoche5 = 10000;
        preciocoche6 = 5000;
        interes1=3.5;
        interes2 = 7;
        interes3=10.5;
        interes4=14;
        interes5=17.5;
        interes6=21;

        pagoplazos = 6;
        interespagado1= preciocoche1 * interes1/100;
        interespagado2= preciocoche2 * interes2/100;
        interespagado3= preciocoche3 * interes3/100;
        interespagado4= preciocoche4 * interes4/100;
        interespagado5= preciocoche5 * interes5/100;
        interespagado6= preciocoche6 * interes6/100;

        System.out.println("“El interés pagado (3,5) en el primer mes es de: "+interespagado1);
        System.out.println("“El interés pagado (7) en el segundo mes es de: "+interespagado2);
        System.out.println("“El interés pagado (10,5) en el tercer mes es de: "+interespagado3);
        System.out.println("“El interés pagado (14) en el cuarto mes es de: "+interespagado4);
        System.out.println("“El interés pagado (17,5) en el quinto mes es de: "+interespagado5);
        System.out.println("“El interés pagado (21) en el sexto mes es de: "+interespagado6);

    }
}
