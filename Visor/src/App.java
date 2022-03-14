import java.io.File;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class App extends JPanel{

    File file =  new File("C:\\Users\\X30\\Pictures\\Saved Pictures\\aphelios.jpg");
    Image picture = new ImageIcon((file.getAbsolutePath())).getImage();
    public void paint(Graphics g){
        update(g);
    }
    @Override
    public void update (Graphics g){
        g.drawImage(picture, 0, 0, this);
    }
    public static void main(String[] args){

        App visor = new App();
        visor.setLayout(null);
        JFrame frame = new JFrame("Visor de imagenes");
        frame.add(visor);   
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


    }
}
