package prueba1;

public class Motor {
    private int Cv,aceite;
public Motor(int Cv) {
    this.Cv = Cv;

}
    public Motor(){
    this.aceite=0;
}

    public int getCv() {
        return Cv;
    }

    public int getAceite() {
        return aceite;
    }

    public void setAceite(int aceite) {
        this.aceite = aceite;
    }
}
