import java.awt.Window;


public class Proyecto2parcialpar2 extends Thread
{
    
     private proyectosegundopar frame;
     
    public Proyecto2parcialpar2() {
        
        this.frame = new proyectosegundopar() ;
        start();
    }

    public void run() {
        while (true) {
            try {
                frame.dibujar();
                Thread.sleep(900);
            } catch (InterruptedException e){
                e.getStackTrace();
                break;
            }
        }
    }
    
    
    
    public static void main (String[] args)
    {
          new  Proyecto2parcialpar2();  
    
    }
    
    