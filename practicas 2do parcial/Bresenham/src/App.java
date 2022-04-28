import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class App extends JFrame {

    private BufferedImage buffer;
    private Graphics pixel;

    public App() {
        setSize(400, 400);
        setLocationRelativeTo(null);

        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        pixel = buffer.createGraphics();
        lineaBresenham(30, 100, 200, 250, buffer);
        g.drawImage(buffer, 0, 0, this);
    }

    public void lineaBresenham(int x0, int y0, int x1, int y1, BufferedImage b) {
        Color c = Color.BLACK;
        int x = 0;
        int y = 0;
        int dX;
        int dY;
        int p;
        int incE;
        int incNE;
        int stepsX;
        int stepsY;

        dX = (x1 - x0);
        dY = (y1 - y0);

        if (dY < 0) {
            dY = -dY;
            stepsY = -1;
        } else {
            stepsY = 1;
        }
        if (dX < 0) {
            dX = -dX;
            stepsX = -1;
        } else {
            stepsX = 1;
            x = x0;
            y = y0;
            b.setRGB(x, y, c.getRGB());
        }
        if (dX > dY) {
            p = 2 * dY - dX;
            incE = 2 * dY;
            incNE = 2 * (dY - dX);
            while (x != x1) {
                x = x + stepsX;
                if (p < 0) {
                    p = p + incE;
                } else {
                    y = y + stepsY;
                    p = p + incNE;
                }
                b.setRGB(x, y, c.getRGB());
            }
        } else {
            p = 2 * dX - dY;
            incE = 2 * dX;
            incNE = 2 * (dX - dY);
            while (y0 != y1) {
                y = y + stepsY;
                if (p < 0) {
                    p = p + incE;
                } else {
                    x = x + stepsX;
                    p = p + incNE;
                }
            }
            b.setRGB(x, y, c.getRGB());
        }

    }

    public static void main(String[] args) {
        App a = new App();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }
}