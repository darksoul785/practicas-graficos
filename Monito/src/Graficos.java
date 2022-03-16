import javax.swing.*;
import java.awt.*;

public class Graficos extends JFrame {

    public Graficos() {
        setTitle("Monito chido");
        setSize(200, 300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        g.drawString("Demo de graficos",10,5);

        // dibujar cara
        g.drawArc(50, 60, 50, 50, 0, 360);
        g.drawArc(60, 70, 30, 30, 180, 180);
        g.fillOval(65, 75, 5, 5);
        g.fillOval(80, 75, 5, 5);

        // dibujar cuerpo
        g.drawLine(75, 110, 75, 200);

        // brazos
        g.drawLine(75, 120, 45, 160);
        g.drawLine(75, 120, 105, 160);

        // piernas
        g.drawLine(75, 200, 45, 240);
        g.drawLine(75, 200, 105, 240);
    }

    public static void main(String[] args){
        new Graficos();
    }
}
