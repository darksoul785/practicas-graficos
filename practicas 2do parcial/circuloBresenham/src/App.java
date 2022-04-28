import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class App extends JFrame {

     private BufferedImage buffer;
    private Graphics pixel;

    public App() {
        setSize(400,400);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        pixel = buffer.createGraphics();
        circuloBrensenham(200, 200, 130, buffer);
	    //circuloBrensenham(200, 200, 130, buffer);
        g.drawImage(buffer, 0, 0, null);
    }

    public void circuloBrensenham(int xc, int yc, int r, BufferedImage buff) {
        int x = - r;
        int y = 0;
        int error = 2 - 2 * r;

        do {
            buff.setRGB(xc - x, yc + y, Color.red.getRGB());
            buff.setRGB(xc - y, yc - x, Color.green.getRGB());
            buff.setRGB(xc + x, yc - y, Color.blue.getRGB());
            buff.setRGB(xc + y, yc + x, Color.orange.getRGB());

            r = error;
            if (r > x) {
                error += ++x * 2 + 1;
            }
            if (r <= y) {
                error += ++y * 2 + 1;
            }
        } while (x < 0);
    }
    public static void main(String[] args) {
        App a = new App();
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}