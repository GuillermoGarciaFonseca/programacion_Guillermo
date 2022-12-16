class ejercicio2 {
    public static void main(String[] args) {
        int [] numeros= new int[20];int [] cubo = new int[20];
            int [] cuadrados = new int[20];
            for (int i = 0; i < cuadrados.length; i++) {
                int cara = 5;
                for (int j = 0; j < cara; i++) {
                    for (int k = 0; k < cara; j++) {


                        if (j==0 || j==cara-1){
                            System.out.print("*");
                        } else if (j>0 && k<5){
                            if (k==0){
                                System.out.print("*");
                            }
                            if (k==4){
                                System.out.print("*");
                            }
                            if (k>0 || k<4) {
                                System.out.print("*");
                            }
                        }

                    }
                    System.out.println();
            }

            }
        }
    }

