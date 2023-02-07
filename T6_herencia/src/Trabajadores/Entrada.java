package Trabajadores;

public class Entrada {
    public static void main(String[] args) {
        Jefe jefe =new Jefe("Luis","Garcia","ADASDA2",16,6000);
        Asalariados asalariados=new Asalariados("Carlos","Gutierrez","asdad1",2300,true,6);
        Autonomo autonomo=new Autonomo("Chema","Muñoz","ADSQ2",2000,true,3000);
        //Autonomo -Asalariado
        //calcularNetoMes -->asalariado(sueldo - ((0.21)/numPagas) autono,o -->(sueldp -0.21)-(cuostas/12)
        //calcularNetoAnual lo mismo sin el numero de pagas
        //Asalariado
        // aumentoSueldo(int) -> aleatorio 0-1 (1 aumenta) (o no aumenta)

    }
}
