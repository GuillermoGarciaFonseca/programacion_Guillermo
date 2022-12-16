import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;


public class entrada {
    public static void main(String[]args){

        Hashtable<String, Object[]>listacoches = new Hashtable<>();
        System.out.println(listacoches.size());
        listacoches.put("1213A",new Object[]{"1213A","Mercedes","C200",2000});
        Object[] coche = new Object[]{"2345C","Nissan","GT",300};
        listacoches.put(coche[0].toString(),coche);
        //[(1234a,Onject[])], (2345abc,object[])]

        Object[] cocheencontrado=listacoches.get("1234a");
        System.out.println(listacoches.size());
        Object[] cocheborrado=listacoches.remove("123A");
        if (cocheborrado == null) {

            System.out.println("No existe el coche en la lista");
        }else {
            System.out.println("Coche borrado correctamente"+cocheborrado[1]);
        }
        listacoches.containsKey("1234A");
        //meter unos cuantos coches dentro de la lista
        //intentar sacar los datos de todos los coches
        listacoches.put("1213A",new Object[]{"1213A","Mercedes","C200",2000});
        listacoches.put("2345B",new Object[]{"2345B","Citroen","C5",2500});
        listacoches.put("3456C",new Object[]{"3456C","Mercedes","C250",1500});
        listacoches.put("4567D",new Object[]{"4567D","Citroen","C4",2600});
        listacoches.put("5678E",new Object[]{"5678E","Mercedes","B4",2700});
        //1-recorrer claves
        // 2- recorrer los valores
        Enumeration<String>clavesEnum=listacoches.keys();
        /*for (Iterator<String> it = clavesEnum.asIterator(); it.hasNext(); ) {
            String clave = it.next();
            listacoches.get(clave);
        }*/
        while (clavesEnum.hasMoreElements()){
            String clave = clavesEnum.nextElement();
            Object[] cochelista = listacoches.get(clave);
            for (Object item:cochelista) {
                System.out.println(item+" ");

            }
            System.out.println();
        }
        Collection<Object[]>elementos= listacoches.values();
        Iterator<Object[]>listaiterable=elementos.iterator();
        while (listaiterable.hasNext())
        {
            Object[]cochelista= listaiterable.next();
            for (Object item :cochelista
                 ) {
                System.out.println(item+" ");
            }
            System.out.println();
        }
        //clavesEnum.hasMoreElements();
        //clavesEnum.nextElement();
        //clavesEnum.asIterator();



    }
}
