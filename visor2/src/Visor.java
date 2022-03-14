import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.DimensionUIResource;

public class Visor extends JFrame {

    public Visor() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JScrollPane scroll = new JScrollPane(panel);

        JLabel img = new JLabel(new ImageIcon("C:\\Users\\X30\\Pictures\\Saved Pictures\\aphelios.jpg"));
        scroll.setViewportView(img);

        panel.setLayout(null);
        // panel.setPreferredSize(new DimensionUIResource(410, 410));
        panel.setVisible(true);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll);
    }

    public static void main(String[] args) {
        Visor visor = new Visor();
        visor.setSize(500, 500);
        visor.setLocationRelativeTo(null);
        // visor.setBounds(50, 50, 400, 400);
        visor.setVisible(true);
        visor.setResizable(true);
    }
}
