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
        Toolkit screen = Toolkit.getDefaultToolkit();
    	Dimension size = screen.getScreenSize();
    	int screenHeight = size.height;
    	int screenWidth = size.width;
    	setSize(400, 400);
    	setLocation(screenWidth/4, screenHeight/4);
        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        pixel = buffer.createGraphics();
        lineaPuntoMedio(0, 100, 50, 200, buffer);
        g.drawImage(buffer, 0, 0, this);
    }

    public void lineaPuntoMedio(int x0, int y0, int x1, int y1, BufferedImage b) {
        int x;
        int y;
        int dx;
        int dy;
        int xend;
        int p;
        int incE;
        int incNE;
        dx = x1 - x0;
        dy = y1 - y0;
        p = 2 * dy - dx;
        incE = 2 * dy;
        incNE = 2 * (dy - dx);
        
        if (x0 > x1) {
            x = x1;
            y = y1;
            xend = x0;
        } 
        else {
            x = x0;
            y = y0;
            xend = x1;
        }
        while (x <= xend) {
            b.setRGB(x, y, Color.black.getRGB());
            x = x + 1;
            if (p <= 0) {
                p = p + incE;
            } 
            else {
                y = y + 1;
                p = p + incNE;
            }
        }
    }
    public static void main(String[] args) {
        App a = new App();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }
    
}
