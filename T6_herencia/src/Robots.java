import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Robots {
    public static void main(String[] args) throws Exception {
        Robot r = new Robot();
        r.mouseMove(113, 215);
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.mouseRelease(InputEvent.BUTTON1_MASK);

        int[] executeNotepad = {KeyEvent.VK_N, KeyEvent.VK_O, KeyEvent.VK_T, KeyEvent.VK_E, KeyEvent.VK_P};
        for (int i = 0; i < executeNotepad.length; i++) {
            r.delay(500);
            r.keyPress(executeNotepad[i]);
            r.keyRelease(executeNotepad[i]);
        }

        r.mouseMove(157, 258);
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}