import java.awt.*;
import javax.swing.WindowConstants;
import javax.swing.JFrame;

public class Spiral extends JFrame {

    public Spiral() {
        setTitle("Espiral");
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        int y = 0;
        int x = 0;
        int y1 = 0;
        int x1 = 0;

        super.paint(g);
        for (int i = 1; i < 50000; i++) {
            x = 300 - (int)(Math.cos((Math.PI * i) / 2000) * i/200);
            y = 300 - (int)(Math.sin((Math.PI * i) / 2000) * i/200);
            g.drawLine(x, y, x, y);
            x1 = 300 + (int)(Math.cos((Math.PI * i) / 2000) * i/200);
            y1 = 300 + (int)(Math.sin((Math.PI * i) / 2000) * i/200);
            g.drawLine(x1, y1, x1, y1);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args){
        new Spiral();
    }
}
