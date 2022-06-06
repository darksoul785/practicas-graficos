import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class auto extends JFrame implements KeyListener {
    private App rot;
    private int x, y, z;
    float angulo;
    int orientacion;

    public auto() {
        x = 200;
        y = 250;
        z = 20;

        angulo = 0;
        orientacion = 1;
        rot = new App(500, 500);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new auto();
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        rot.Graphics(g);
        rot.Rot(x, y, z, -50, orientacion, angulo, Color.white);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 37)// Flecha izquierda
        {
            orientacion = 1;
            angulo -= 0.1;
        } else if (e.getKeyCode() == 39)// Flecha derecha
        {
            orientacion = 1;
            angulo += 0.1;
        } else if (e.getKeyCode() == 38)// Flecha arriba
        {
            orientacion = 2;
            angulo += 0.1;
        } else if (e.getKeyCode() == 40)// Flecha abajo
        {
            orientacion = 2;
            angulo -= 0.1;
        } else if (e.getKeyCode() == 49)// 1 Angulo Z
        {
            orientacion = 3;
            angulo -= 0.1;
        } else if (e.getKeyCode() == 50)// 2 Angulo Z
        {
            orientacion = 3;
            angulo += 0.1;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
class Hilos extends Thread {
    auto ventana = new auto();

    public Hilos() {
        start();
    }
}