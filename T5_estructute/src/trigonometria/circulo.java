package trigonometria;

public class circulo {
    private double radio,diametro,area;
    public circulo(double radio){
        this.radio=radio;

    }
    public circulo(){}
    public double Diametro() {
        diametro = 2 * this.radio;
        return diametro;
    }
public double Area(){
        this.area = Math.PI*Math.pow(this.radio,2);
        return area;
        }
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
