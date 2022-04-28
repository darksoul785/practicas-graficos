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
        circuloPolares(110, 210, 100, buffer);
        g.drawImage(buffer, 10, 10, this);
    }

    public void circuloPolares(int xc, int yc, int r, BufferedImage bu) {

        for (int i = (xc - r); i <= xc + r; i++) {
            float y = yc + (float) Math.sqrt(r * r - Math.pow((i - xc), 2));
            float yar = yc - (float) Math.sqrt(r * r - Math.pow((i - xc), 2));
            bu.setRGB(i, (int) y, Color.BLACK.getRGB());
            bu.setRGB(i, (int) yar, Color.BLACK.getRGB());
        }
    }
    public static void main(String[] args) {
        App a = new App();
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}