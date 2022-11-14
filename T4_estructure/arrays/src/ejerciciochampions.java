public class ejerciciochampions {
    public static void main(String[] args) {
        String[]bombo1={"madrid","oporto","b.munich","tothenham","chealsea","napoles","m.city","benfica"};
        String[]bombo2={"livepool","brujas","inter","eintracht.f","ac.milan","leipzig","b.dormund","PSG"};
        int aleatorio1;
        int aleatorio2;
        String[] cruces= new String[8];
        int []numerosBombo1 = {-1,-1,-1,-1,-1,-1,-1,-1};
        int []numerosBombo2 ={-1,-1,-1,-1,-1,-1,-1,-1};
        for (int i =0;i<bombo1.length;i++){
            aleatorio1 = (int)(Math.random()*8);
            while (estanumero(aleatorio1,numerosBombo1)){
                aleatorio1 = (int)(Math.random()*8);
            };
            numerosBombo1[i]= aleatorio1;
            aleatorio2=(int) (Math.random()*8);
           while(estanumero(aleatorio2,numerosBombo2)){
               aleatorio2=(int) (Math.random()*8);
           };
           numerosBombo2[i]=aleatorio2;
            cruces[i]=bombo1[aleatorio1]+"vs"+bombo2[aleatorio2];

        }
    }
    private static boolean estanumero(int numero, int [] numeros){
        for (int item:numeros) {
            if (numero == item){
                return true;
            }
        }
        return false;
    };
}
