package trigonometria;

public class Cuadrado {
    private int base,altura;
    private double area,perimetro;

    public Cuadrado(int base, int altura) {
        this.base = base;
        this.altura = altura;
        calcularArea();
        calcularPerimetro();
    }

    public double calcularArea(){
        area=(double) (base*altura);
        return area;
    }
    public double calcularPerimetro(){

        perimetro=(2*altura)+(2*base);

        return perimetro;
    }
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
}
