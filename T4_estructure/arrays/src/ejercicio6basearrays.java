public class ejercicio6basearrays {
    public static void main(String[] args) {
        int[] listanumeros= new int[20];
        for (int i = 0; i<20;i++){
            int aleatorio1 = (int)(Math.random()*31);
            listanumeros[i] = aleatorio1;
            if (listanumeros[i] ==6){
                listanumeros[i] =8;
            }
            else if  (listanumeros[i]==7) {
                listanumeros[i] = 15;
            }else if (listanumeros[i]==20){
                listanumeros[i]=10;
            }
        }
        for (int i = 0; i < listanumeros.length; i++) {

        }
    }
}
