package trigonometria;

public class Circulo {
    private double radio,area,diametro;

    public Circulo(double area) {
        this.area = area;
    }
    public double calcularAreacirculo(){
        area=(Math.pow(this.radio,2))*Math.PI;
        return area;
    }
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }
}
