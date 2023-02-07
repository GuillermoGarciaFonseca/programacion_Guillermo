package trigonometria;

public class Triangulo {
    private double base, altura;

    public Triangulo(Double base, Double altura) {
        this.altura = altura;
        this.base = base;
    }

    public double Area() {
        double area = (base * altura) / 2;
        return area;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
}


