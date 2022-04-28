import java.awt.Color;
import java.awt.Dimension;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.tools.Tool;

pixel;

    public AlgoritmodepuntomedioLíneaRecta() {
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
    	Dimension tamanioPanatalla = miPantalla.getScreenSize();
    	int altoPantalla = tamanioPanatalla.height;
    	int anchoPantalla = tamanioPanatalla.width;

    	setSize(anchoPantalla/2, altoPantalla/2);
    	setLocation(anchoPantalla/4, altoPantalla/4);
        
        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        pixelt(null);

    }

    @Override

    public void paint (Graphics g){
        super.paint(g);
        g.setColor(Color.BLUE);
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        pixel = buffer.createGraphics();

        ddaLine(100,100,100,200,buffer);
        g.drawImage(buffer, 0, 0, this);
    }

    public void ddaLine(int x0, int y0, int x1, int y1, BufferedImage b){
        Color c = Color.BLACK;
        int dX = x1 - x0;
        int dY = y1 - y0;
        int step = 0;

        float incX = 0;
        float incY = 0;
        float x = 0;
        float y = 0;

        if (Math.abs(dX) > Math.abs(dY)) {
            step = Math.abs(dX);
        } else {
            step = Math.abs(dY);
        }

        incX = (float) dX / step;
        incY = (float) dY / step;

        x = x0;
        y = y0;

        b.setRGB(Math.round(x), Math.round(y), c.getRGB());
        for (int i = 1; i <= step; i++) {
            x += incX;
            y += incY;
            b.setRGB(Math.round(x), Math.round(y), c.getRGB());
        }
    }

    public static void main(String[] args) throws Exception {
        App a = new App();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }
}
