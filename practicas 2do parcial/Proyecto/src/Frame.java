
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Frame extends JFrame {
    private Graphicss MyGraphicsInstance;
    private Boolean checkExistance = Boolean.FALSE;

    private BufferedImage buffer;
    public JPanel myJPanel;

    public Frame(){
        super("Relleno de figuras con algoritmo Scan-Line");
        setSize(800,800);
		setResizable(false);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyGraphicsInstance = new Graphicss(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        
    }

    public void paint(Graphics g){
        if( checkExistance == Boolean.FALSE) {
            buffer = new BufferedImage (1,1,BufferedImage.TYPE_INT_RGB);

            buffer.setRGB(0, 0, Color.blue.getRGB());
            this.getGraphics().drawImage(buffer, getWidth()/2, getHeight()/2, this);

            checkExistance = Boolean.TRUE;
            super.paint(g);
        }
        super.paint(g);
        this.update(g);
    }

    public void update(Graphics g){
    
        MyGraphicsInstance.Cuadrado(300, 300, 400, 400, Color.darkGray);
        MyGraphicsInstance.ScanLine(301,350, Color.red);

    }
}
