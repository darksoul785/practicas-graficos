import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class App extends JFrame implements KeyListener {
    public Cubo c1;
    private BufferedImage pixel;
    private int x1b, y1b, x0r = 100, y0r = 50, x1r = 350, y1r = 300, unidad, y2, x2;
    double x, y, z = 300.0;

    public static void main(String[] args) {
        new App();
    }

    private App() {
        super("Traslacion");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.addKeyListener(this);
        pixel = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

        x2 = 200;
        y2 = 200;
        unidad = 20;
    }

    private void putPixel(int x, int y, Color c) {
        pixel.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(pixel, x, y, this);
    }

    public void cuboPerspectiva(int x1, int y1, int z1, int large, Color c) {
        ArrayList<Integer> valuesX1 = new ArrayList<>();
        ArrayList<Integer> valuesY1 = new ArrayList<>();
        ArrayList<Integer> valuesX2 = new ArrayList<>();
        ArrayList<Integer> valuesY2 = new ArrayList<>();
        int[] arrX = { 0, 1, 1, 0, 0 };
        int[] arrY = { 0, 0, 1, 1, 0 };

        double xc = 100;
        double yc = 100;
        double zc = -200.0;
        for (int cont = 0; cont < arrX.length; cont++) {
            double tempX, tempY;
            tempX = x1 + (arrX[cont] * large);
            tempY = y1 + (arrY[cont] * large);
            x = tempX + (xc * ((z - z1) / zc));
            y = y2 - (tempY + (yc * ((z - z1) / zc)));
            valuesX1.add((int) x);
            valuesY1.add((int) y);
        }
        for (int cont = 0; cont < arrX.length; cont++) {
            double tempX, tempY;
            double tempZ = z1 + large;
            tempX = x1 + (arrX[cont] * large);
            tempY = y1 + (arrY[cont] * large);
            x = tempX + (xc * ((z - tempZ) / zc));
            y = y2 - (tempY + (yc * ((z - tempZ) / zc)));
            valuesX2.add((int) x);
            valuesY2.add((int) y);
        }
        for (int cont = 1; cont < valuesX1.size(); cont++) {
            dibujarLineas(valuesX1.get(cont - 1), valuesY1.get(cont - 1), valuesX1.get(cont), valuesY1.get(cont), c);
            dibujarLineas(valuesX2.get(cont - 1), valuesY2.get(cont - 1), valuesX2.get(cont), valuesY2.get(cont), c);
            dibujarLineas(valuesX1.get(cont - 1), valuesY1.get(cont - 1), valuesX2.get(cont - 1),
                    valuesY2.get(cont - 1), c);
        }
    }

    public void dibujarLineas(int x1, int y1, int x2, int y2, Color c) {

        double m, b;
        double dx = x2 - x1;
        double dy = y2 - y1;
        m = dy / dx;
        b = y1 - (m * x1);
        double y = 0;
        if (Double.isInfinite(m)) {
            if (y1 > y2) {
                int xAux;
                xAux = x1;
                x1 = x2;
                x2 = xAux;

                int yAux;
                yAux = y1;
                y1 = y2;
                y2 = yAux;

                for (int yi = y1; yi < y2; yi++) {
                    putPixel(x1, (int) round(yi), c);
                }
            } else {

                for (int yi = y1; yi < y2; yi++) {
                    putPixel(x1, (int) round(yi), c);
                }
            }
        }

        else {

            if (x1 > x2) { // Horizontal
                int xaux;
                xaux = x1;
                x1 = x2;
                x2 = xaux;

                int yaux;
                yaux = y1;
                y1 = y2;
                y2 = yaux;

                for (int x = x1; x < x2; x++) {
                    y = (m * x) + b;
                    putPixel(x, (int) round(y), c);
                }
            } else {
                for (int x = x1; x < x2; x++) {
                    y = (m * x) + b;
                    putPixel(x, (int) round(y), c);
                }
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        cuboPerspectiva(x2, 100, 100, unidad, Color.blue); // Cubo
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 37)// Flecha izquierda
        {
            x2 -= 5;
        } else if (e.getKeyCode() == 38)// Flecha arriba
        {
            y2 -= 5;
        } else if (e.getKeyCode() == 39)// Flecha derecha
        {
            x2 += 5;
        } else if (e.getKeyCode() == 40)// Flecha abajo
        {
            y2 += 5;
        } else if (e.getKeyCode() == 49)// 1 Suma en Z
        {
            z += 5;
        } else if (e.getKeyCode() == 50)// 2 Resta en Z
        {
            z -= 5;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

class Cubo {

    public List punt;
    public int[] xses = new int[8];
    public int[] yses = new int[8];

    public Cubo(int p1x, int p1y, int p1z,
            int p2x, int p2y, int p2z,
            int p3x, int p3y, int p3z,
            int p4x, int p4y, int p4z,
            int p5x, int p5y, int p5z,
            int p6x, int p6y, int p6z,
            int p7x, int p7y, int p7z,
            int p8x, int p8y, int p8z) // 8 aristas
    {
        punt = new ArrayList<Punto>();
        Punto temp = new Punto();
        temp.x = p1x;
        temp.y = p1y;
        temp.z = p1z;
        punt.add(temp);

        temp = new Punto();
        temp.x = p2x;
        temp.y = p2y;
        temp.z = p2z;
        punt.add(temp);

        temp = new Punto();
        temp.x = p3x;
        temp.y = p3y;
        temp.z = p3z;
        punt.add(temp);

        temp = new Punto();
        temp.x = p4x;
        temp.y = p4y;
        temp.z = p4z;
        punt.add(temp);

        temp = new Punto();
        temp.x = p5x;
        temp.y = p5y;
        temp.z = p5z;
        punt.add(temp);

        temp = new Punto();
        temp.x = p6x;
        temp.y = p6y;
        temp.z = p6z;
        punt.add(temp);
    }
}

class Punto {
    public int x, y, z;
}
