package com.mycompany.circulo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.abs;
import static java.lang.Math.round;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.abs;
import static java.lang.Math.round;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;

import java.awt.Color;


public final class Circulo extends JFrame
{
    private BufferedImage buff;
    
    public static void main(String[] args)
    {
        Circulo pixel= new Circulo();
        
       
        pixel.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pixel.setSize(500, 500);
        pixel.setLayout(null);
        pixel.setResizable(false);
        pixel.setVisible(true);
        pixel.Circulo();
    }        

    public Circulo()
    {
        buff =new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        JPanel p = new JPanel();
        p.setSize(500, 500);
        this.add(p);
    }


    public void putPixel(int x, int y, Color c)
    {
            buff.setRGB(0, 0, c.getRGB());
            this.getGraphics().drawImage(buff, x, y, this); 

    }

    public void Circulo()
    {
        ///Inicializamos las variables de nuestras coordenadas en X y Y
        int yc=400;
        int xc=400;
        double R=100;
        double a,b,c;
        
        double y1,y2;
        
        int xf=xc+(int)R;
        a=Math.pow(R, 2);
        for (int x=xc-(int)R*(int)R; x<xf; x++)
        {
            b=(double)(Math.pow((x-xc), 2));
            c=a-b;
            y1=yc+Math.sqrt(c);
            y2=yc-Math.sqrt(c);
            putPixel(x, (int)round(y1), Color.BLACK); 
            putPixel(x, (int)round(y2), Color.BLACK); 
        }

    }

}