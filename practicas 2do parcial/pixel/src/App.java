package pixel.src;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.round;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class App extends JFrame
{
    private BufferedImage buff;
    
    public static void main(String[] args)
    {
        App pixel= new App();
        pixel.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pixel.setSize(300, 300);
        pixel.setLayout(null);
        pixel.setResizable(false);
        pixel.setVisible(true);
        pixel.linea();
    }        

    public App()
    {
        buff =new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        JPanel p = new JPanel();
        p.setSize(200, 200);
        this.add(p);
    }


    public void putPixel(int x, int y, Color c)
    {
            buff.setRGB(0, 0, c.getRGB());
            this.getGraphics().drawImage(buff, x, y, this); 

    }

    public void linea()
    {
        ///Inicializamos las variables de nuestras coordenadas en X y Y
        int y0=150; //punto0 en y 
        int x0=150; //punto en x

        int y1=100; //punto1 en y
        int x1=100; //punto enx1

        double b,m;
        double y=10;        

        ///Calculamos  la poendiente y b
        m=(double)(y1-y0)/(x1-x0);
        b=y0-m*x0;       
        
                                 
        for (int i =x0; i < x1; i++) //Pintamos la linea recta
        {
            y=(m)*i+b;
            putPixel(150,150 + i, Color.BLACK); 
        }
        
    }    
}
