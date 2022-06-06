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
        new Hilos();
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        rot.Graphics(g);
        rot.Rot(x, y, z, -50, orientacion, angulo, Color.white);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                orientacion = 1;
                angulo -= 0.1;
                break;
            case KeyEvent.VK_RIGHT:
                orientacion = 1;
                angulo += 0.1;
                break;
            case KeyEvent.VK_UP:
                orientacion = 2;
                angulo += 0.1;
                break;
            case KeyEvent.VK_DOWN:
                orientacion = 2;
                angulo -= 0.1;
                break;
            case KeyEvent.VK_D:
                orientacion = 3;
                angulo -= 0.1;
                break;
            case KeyEvent.VK_A:
                orientacion = 3;
                angulo += 0.1;
                break;
            default:
                break;
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

    @Override

    public void run() {
        int j = 1;
        while (true) {
            switch (j) {
                case 1:
                    ventana.orientacion = 1;
                    break;
                case 2:
                    ventana.orientacion = 2;
                    break;
                case 3:
                    ventana.orientacion = 3;
                    break;
            }
            for (int i = 0; i <= 50; i++) {
                ventana.angulo -= 0.05;
                ventana.repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ventana.angulo = 0;
            j++;
            if (j > 3) {
                j = 1;
            }

        }
    }
}