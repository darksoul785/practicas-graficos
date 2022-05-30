import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame {
    private Graphic GraphicsInstance;
    private Boolean checkExistance = Boolean.FALSE;
    private BufferedImage buffer;
    public JPanel myJPanel;
    private MyKeyListener MyKeyInstance;

    public Frame() {
        super("Practica 1");
        setSize(600, 600);
        setVisible(true);
        myJPanel = new JPanel();
        add(myJPanel);
        setVisible(true);
        GraphicsInstance = new Graphic(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyKeyInstance = new MyKeyListener();
        addKeyListener(MyKeyInstance);
    }

    public void paint(Graphics g) {
        if (checkExistance == Boolean.FALSE) {
            buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

            buffer.setRGB(0, 0, Color.blue.getRGB());
            this.getGraphics().drawImage(buffer, getWidth() / 2, getHeight() / 2, this);

            checkExistance = Boolean.TRUE;
            super.paint(g);
        }
        super.paint(g);
        this.update(g);
    }

    public void update(Graphics g) {
        GraphicsInstance.ResetBuff();
        GraphicsInstance.SetCamara(MyKeyInstance.GetX(), MyKeyInstance.GetY(), MyKeyInstance.GetZ());
        GraphicsInstance.SetColor(Color.BLUE);
        GraphicsInstance.CuboParalela(150, 150, 200, 350, 350, 100);

        this.getGraphics().drawImage(GraphicsInstance.GetFondo(), 0, 0, this);

    }

    public boolean GetChange() {
        return MyKeyInstance.GetChange();
    }

    public void SetChange(boolean NewChange) {
        MyKeyInstance.SetChange(NewChange);
    }
}

class MyKeyListener implements KeyListener {

    public static int X = 10;
    public static int Y = 20;
    public static int Z = -20;

    public int GetX() {
        return X;
    }

    public int GetY() {
        return Y;
    }

    public int GetZ() {
        return Z;
    }

    private boolean Change = false;

    public boolean GetChange() {
        return Change;
    }

    public void SetChange(boolean NewChange) {
        Change = NewChange;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            Y = Y - 1;
            Change = true;
        }
        if (key == KeyEvent.VK_A) {
            X = X - 1;
            Change = true;
        }
        if (key == KeyEvent.VK_S) {
            Y = Y + 1;
            Change = true;
        }
        if (key == KeyEvent.VK_D) {
            X = X + 1;
            Change = true;
        }

        if (key == KeyEvent.VK_LEFT) {
            X = X - 1;
            Change = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            X = X + 1;
            Change = true;
        }
        if (key == KeyEvent.VK_UP) {
            Y = Y - 1;
            Change = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            Y = Y + 1;
            Change = true;
        }
        if (key == KeyEvent.VK_ADD || key == KeyEvent.SHIFT_DOWN_MASK) {
            Z = Z + 1;
            Change = true;
        }
        if (key == KeyEvent.VK_MINUS) {
            Z = Z - 1;
            Change = true;
        }

    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {

    }
}
