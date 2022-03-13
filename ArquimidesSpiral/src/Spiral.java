import java.awt.*;
import javax.swing.WindowConstants;
import javax.swing.JFrame;

public class Spiral extends JFrame {

    public Spiral() {
        setTitle("Espiral");
        setSize(620, 620);
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
            x = 310 - (int)(Math.cos((Math.PI * i) / 3000) * i/150);
            y = 310 - (int)(Math.sin((Math.PI * i) / 3000) * i/150);
            g.drawLine(x, y, x, y);
            x1 = 310 + (int)(Math.cos((Math.PI * i) / 3000) * i/150);
            y1 = 310 + (int)(Math.sin((Math.PI * i) / 3000) * i/150);
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
