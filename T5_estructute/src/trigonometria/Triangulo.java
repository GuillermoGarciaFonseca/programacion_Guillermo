package trigonometria;

public class Triangulo {
    private double base,altura,area;
    public Triangulo(Double base,Double altura){
        this.altura=altura;
        this.base=base;
    }
    public void Area(){
        area = (base*altura)/2;
    }


}
