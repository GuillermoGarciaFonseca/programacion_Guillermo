import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class automatizacion {
    public static void main(String[] args) {
        System.out.println("(" + MouseInfo.getPointerInfo().getLocation().x +  ", " + MouseInfo.getPointerInfo().getLocation().y + ")");
    }
}
