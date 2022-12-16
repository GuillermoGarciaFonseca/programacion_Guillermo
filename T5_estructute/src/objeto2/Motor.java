package objeto2;

public class Motor {
    private int litrosaceite,cv;
    /*(esto es un constructor)*/public Motor ( int cv){
       this.cv=cv;
    }
    public Motor(){
        litrosaceite=0;
    }

    public int getCv() {
        return this.cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getLitrosaceite() {
        return litrosaceite;
    }

    public void setLitrosaceite(int litrosaceite) {
        this.litrosaceite = litrosaceite;
    }
}
