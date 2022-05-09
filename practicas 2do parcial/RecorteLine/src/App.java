import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class App extends JFrame
{
    private Image  imgPixel;
    private Graphics graPixel;   
	private int x1b, x2b, y1b, y2b;

	private int x0r = 50;
	private int x1r = 450;
	private int y0r = 50;
	private int y1r = 450;
	
    BufferedImage miBuffer = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);    
    
    public App(){
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imgPixel = createImage(1, 1);
        graPixel = imgPixel.getGraphics();
        
		dibujarFiguras();
        getGraphics().drawImage(miBuffer, 1, 1, this);
    } 
    
    public void paint(Graphics g){
    }
    
    public void putPixel(int x, int y,String colorPixel) {
        switch (colorPixel) {
            case "rojo":
                graPixel.setColor(Color.RED);
                break;        
            case "azul":
                graPixel.setColor(Color.BLUE);
                break;
        }
              
        miBuffer.setRGB(x, y, graPixel.getColor().getRGB());
    }
	
    public void DDA(int x0, int y0, int x1, int y1, String Color) {
        int x, y, dx, dy, p, incE, incNE, Xstep, Ystep;
        dx = (x1 - x0);
        dy = (y1 - y0);

        if (dy < 0) {
            dy = -dy; 
            Ystep = -1;
        } else { 
            Ystep = 1;
        }

        if (dx < 0) {  
            dx = -dx;
            Xstep = -1;
        } else {
            Xstep = 1;
        }

        x = x0;
        y = y0;
  
        putPixel(x0, y0, Color);
        
        if(dx>dy) {
            p = 2*dy - dx;
            incE = 2*dy;
            incNE = 2*(dy-dx);

            while (x != x1) {
                x = x + Xstep;
            
                if (p < 0){
                    p = p + incE;
                } else {
                    y = y + Ystep; 
                    p = p + incNE;
                }

                putPixel(x,y, Color);
            }
        } else {
            p = 2*dx - dy;
            incE = 2*dx;
            incNE = 2*(dx-dy);
        
            while (y != y1) {
                y = y + Ystep;
                
                if (p < 0){
                    p = p + incE;
                } else {
                    x = x + Xstep;p = p + incNE;
                }

            putPixel(x,y, Color);
            }
        }
    }

    public void DDAL(int x0, int y0, int x1, int y1) {
        int x, y, dx, dy, p, incE, incNE, Xstep, Ystep;
        dx = (x1 - x0);
        dy = (y1 - y0);
        
        if (dy < 0) {
            dy = -dy; 
            Ystep = -1;
        } else {
            Ystep = 1;
        }

        if (dx < 0) {
            dx = -dx;
            Xstep = -1;
        }  else {
            Xstep = 1;
        }

        x = x0;
        y = y0;

        if(dx>dy) {
            p = 2*dy - dx;
            incE = 2*dy;
            incNE = 2*(dy-dx);

            while (x != x1) {
                x = x + Xstep;
                if (p < 0) {
                    p = p + incE;
                } else {
                    y = y + Ystep; 
                    p = p + incNE;
                }

                if((x > x0r && y > y0r) && (x < x1r && y < y1r)){
                    putPixel(x,y, "azul");
                }
            }
        } else {
            p = 2*dx - dy;
            incE = 2*dx;
            incNE = 2*(dx-dy);
        
            while (y != y1) {
                y = y + Ystep;
                if (p < 0){
                    p = p + incE;
                } else {
                    x = x + Xstep;p = p + incNE;
                }
                if((x > x0r && y > y0r) && (x < x1r && y < y1r)){
                    putPixel(x,y, "azul");
                }
            }
        }
    }

    public void dibujarFiguras() {
    	Rectangulo(x0r, x1r, y0r, y1r);
        DDAL(100, 100, 500, 500);
        DDAL(150, 350, 500, 500);
        DDAL(90, 50, 500, 500);
        DDAL(500, 340, 0, 0);
        DDAL(100, 100, 300, 350);
    }
	
	public void Rectangulo(int x0, int x1, int y0, int y1) {
		DDA(x0, y0, x1, y0,"rojo");
		DDA(x0, y0, x0, y1,"rojo");
		DDA(x1, y0, x1, y1,"rojo");
		DDA(x0, y1, x1, y1,"rojo");
	}
	
    public static void main(String[] args) {
        new App();
    }
}