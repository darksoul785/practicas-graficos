import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;

public class parcial3 extends JFrame implements ActionListener,KeyListener,Runnable
{
    private BufferedImage buffer;
    private Graphics bufferFill;
    private Thread thr;
    private Dimension offDimension;
    private Graphics offGraphics;
    private BufferedImage offImage;
    private int[][][] cord = new int[36][100][3];
    private int[][][] cord2 = new int[36][100][3];
    private double t, angle;
    private int x, y, z, ytemp, xtemp, rotateTemp;
    private String axis = "y-";
    private double angulox, anguloy, anguloz;
    private boolean exit = true;
    private double ang = 0;
    private double ang2 = 0;
    private int cont = 0;
    private float xp = 5;
    private float yp = 1;
    private float zp = 10;

    public static void main(String[] args) throws InterruptedException
    {
        parcial3 v = new parcial3();
        v.setVisible(true);
    }

    public parcial3() throws InterruptedException
    {

        this.setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(this);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
        thr = new Thread(this);
        thr.start();
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        bufferFill = (Graphics2D) buffer.createGraphics();
        cylinder();
        medusa();
        auto();
    }

    public void run()
    {

    }

    public void paint(Graphics g)
    {
        update(g);
        //update2(g);
    }



    public void update(Graphics g)
    {
        Dimension d = this.getSize();
        offDimension = d;
        offImage = new BufferedImage(offDimension.width, offDimension.height, BufferedImage.TYPE_INT_RGB);
        offGraphics = (Graphics2D) offImage.getGraphics();
        curvas();
        medusa();
        ramo();
        cylinder();
        g.drawImage(offImage, 0, 0, this);
        
    }

    public void putPixel(int x, int y, Color c)
    {
        buffer.setRGB(0, 0, c.getRGB());
        offGraphics.drawImage(buffer, x, y, null);
    }
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                handleEvent("up");
                break;
            case KeyEvent.VK_DOWN:
                handleEvent("down");
                break;
            case KeyEvent.VK_LEFT:
                handleEvent("left");
                break;
            case KeyEvent.VK_RIGHT:
                handleEvent("right");
                break;
            case KeyEvent.VK_1:
                handleEvent("1");
                break;
            case KeyEvent.VK_2:
                handleEvent("2");
                break;
            default:
                break;
        }
    }

    public void curvas()
    {

        y = 170;
        x = 500;

        for (int j = 0; j < 36; j++) {
            for (int i = 1; i < 62; i++)
            {
                linea3d(cord[j][i][0] + x, cord[j][i][1] + y, cord[j][i][2],
                        cord[j][i + 1][0] + x, cord[j][i + 1][1] + y, cord[j][i + 1][2], 2,
                        new Color((j * 2) + 170, i + j + 3, i + 150));
                if (i < 61 && j < 35)
                {
                    linea3d(cord[j][i][0] + x, cord[j][i][1] + y, cord[j][i][2],
                            cord[j + 1][i + 1][0] + x, cord[j + 1][i + 1][1] + y,
                            cord[j + 1][i + 1][2], 2, new Color(i * 2 + 0, i + j + 9, j + 150));

                    linea3d(cord[j][i][0] + x, cord[j][i][1] + y, cord[j][i][2],
                            cord[j + 1][i][0] + x, cord[j + 1][i][1] + y, cord[j + 1][i][2],
                            2, new Color(i + 133, j + 40, i + j * 2 + 13));
                }
                else if (i == 61 && j < 35)
                {
                    linea3d(cord[j][i][0] + x, cord[j][i][1] + y, cord[j][i][2],
                            cord[j + 1][i][0] + x, cord[j + 1][i][1] + y, cord[j + 1][i][2],
                            1, new Color(i * 2 + 31, j * 2 + 31, i + j + 31));

                    linea3d(cord[j][i + 1][0] + x, cord[j][i + 1][1] + y,
                            cord[j][i + 1][2], cord[j + 1][i][0] + x, cord[j + 1][i][1] + y,
                            cord[j + 1][i][2], 1, new Color(i * 2 + 31, j + 31, i + j * 2 + 31));

                    linea3d(cord[j][i + 1][0] + x, cord[j][i + 1][1] + y,
                            cord[j][i + 1][2], cord[j + 1][i + 1][0] + x,
                            cord[j + 1][i + 1][1] + y, cord[j + 1][i + 1][2], 1,
                            new Color(i + 31, j * 2 + 31, i + j * 2 + 31));
                }
            }
        }
    }


    public void ramo()
    {
        y = 200;
        x = 500;

        for (int j = 0; j < 36; j++) {
            for (int i = 1; i < 62; i++)
            {
                linea3d(cord2[j][i][0] + x, cord2[j][i][1] + y, cord2[j][i][2],
                        cord2[j][i + 1][0] + x, cord2[j][i + 1][1] + y, cord2[j][i + 1][2], 1,
                        new Color((j * 2) + 10, i + j + 150, i + 150));
                if (i < 61 && j < 35)
                {
                    linea3d(cord2[j][i][0] + x, cord2[j][i][1] + y, cord2[j][i][2],
                            cord2[j + 1][i + 1][0] + x, cord2[j + 1][i + 1][1] + y,
                            cord2[j + 1][i + 1][2], 1, new Color(i * 2 + 0, i + j + 150, j + 15));

                    linea3d(cord2[j][i][0] + x, cord2[j][i][1] + y, cord2[j][i][2],
                            cord2[j + 1][i][0] + x, cord2[j + 1][i][1] + y, cord2[j + 1][i][2],
                            1, new Color(i + 133, j + 40, i + j * 2 + 13));
                }
                else if (i == 61 && j < 35)
                {
                    linea3d(cord2[j][i][0] + x, cord2[j][i][1] + y, cord2[j][i][2],
                            cord2[j + 1][i][0] + x, cord2[j + 1][i][1] + y, cord2[j + 1][i][2],
                            1, new Color(i * 2 + 31, j * 2 + 131, i + j + 31));

                    linea3d(cord2[j][i + 1][0] + x, cord2[j][i + 1][1] + y,
                            cord2[j][i + 1][2], cord2[j + 1][i][0] + x, cord2[j + 1][i][1] + y,
                            cord2[j + 1][i][2], 1, new Color(i * 2 + 31, j + 31, i + j * 2 + 31));

                    linea3d(cord2[j][i + 1][0] + x, cord2[j][i + 1][1] + y,
                            cord2[j][i + 1][2], cord2[j + 1][i + 1][0] + x,
                            cord2[j + 1][i + 1][1] + y, cord2[j + 1][i + 1][2], 1,
                            new Color(i + 31, j * 2 + 31, i + j * 2 + 31));
                }
            }
        }
    }




    public void linea3d(float x1, float y1, float z1, float x2, float y2, float z2, float thickness, Color color)
    {
        x1 = x1 - xp * (z1 / zp);
        y1 = y1 - yp * (z1 / zp);
        x2 = x2 - xp * (z2 / zp);
        y2 = y2 - yp * (z2 / zp);
        float dx = x2 - x1;
        float dy = y2 - y1;
        float ybegin = y1;
        float yend = y2;
        float steps;
        float thick = thickness / 2;

        if (Math.abs(dx) > Math.abs(dy))
        {
            steps = Math.abs(dx);

        }
        else
        {
            steps = Math.abs(dy);
        }

        float xinc = dx / steps;
        float yinc = dy / steps;

        if (thickness == 1)
        {
            putPixel(Math.round(x1), Math.round(y1), color);
            for (int i = 0; i <= steps; i++)
            {
                x1 = x1 + xinc;
                y1 = y1 + yinc;
                putPixel(Math.round(x1), Math.round(y1), color);
            }
        }
        else if ((int) thick == thick)
        {
            for (int i = 0; i <= steps; i++)
            {
                x1 = x1 + xinc;
                y1 = y1 + yinc;
                if (ybegin == yend)
                {
                    for (int j = 1; j <= thick; j++)
                    {
                        putPixel(Math.round(x1), Math.round(y1 + j - 1), color);
                        putPixel(Math.round(x1), Math.round(y1 - j), color);
                    }
                }
                else
                {
                    for (int j = 1; j <= thick; j++)
                    {
                        putPixel(Math.round(x1 + j - 1), Math.round(y1), color);
                        putPixel(Math.round(x1 - j), Math.round(y1), color);
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i <= steps; i++)
            {
                x1 = x1 + xinc;
                y1 = y1 + yinc;
                putPixel(Math.round(x1), Math.round(y1), color);
                if (ybegin == yend)
                {
                    for (int j = 1; j <= (int) thick; j++)
                    {
                        putPixel(Math.round(x1), Math.round(y1 + j), color);
                        putPixel(Math.round(x1), Math.round(y1 - j), color);
                    }
                } else
                {
                    for (int j = 1; j <= (int) thick; j++)
                    {
                        putPixel(Math.round(x1 + j), Math.round(y1), color);
                        putPixel(Math.round(x1 - j), Math.round(y1), color);
                    }
                }
            }
        }
    }

    
    public void linea3d2(float x1, float y1, float z1, float x2, float y2, float z2, float thickness, Color color)
    {
        x1 = x1 - xp * (z1 / zp);
        y1 = y1 - yp * (z1 / zp);
        x2 = x2 - xp * (z2 / zp);
        y2 = y2 - yp * (z2 / zp);
        float dx = x2 - x1;
        float dy = y2 - y1;
        float ybegin = y1;
        float yend = y2;
        float steps;
        float thick = thickness / 2;

        if (Math.abs(dx) > Math.abs(dy))
        {
            steps = Math.abs(dx);

        }
        else
        {
            steps = Math.abs(dy);
        }

        float xinc = dx / steps;
        float yinc = dy / steps;

        if (thickness == 1)
        {
            putPixel(Math.round(x1), Math.round(y1), color);
            for (int i = 0; i <= steps; i++)
            {
                x1 = x1 + xinc;
                y1 = y1 + yinc;
                putPixel(Math.round(x1), Math.round(y1), color);
            }
        }
        else if ((int) thick == thick)
        {
            for (int i = 0; i <= steps; i++)
            {
                x1 = x1 + xinc;
                y1 = y1 + yinc;
                if (ybegin == yend)
                {
                    for (int j = 1; j <= thick; j++)
                    {
                        putPixel(Math.round(x1), Math.round(y1 + j - 1), color);
                        putPixel(Math.round(x1), Math.round(y1 - j), color);
                    }
                }
                else
                {
                    for (int j = 1; j <= thick; j++)
                    {
                        putPixel(Math.round(x1 + j - 1), Math.round(y1), color);
                        putPixel(Math.round(x1 - j), Math.round(y1), color);
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i <= steps; i++)
            {
                x1 = x1 + xinc;
                y1 = y1 + yinc;
                putPixel(Math.round(x1), Math.round(y1), color);
                if (ybegin == yend)
                {
                    for (int j = 1; j <= (int) thick; j++)
                    {
                        putPixel(Math.round(x1), Math.round(y1 + j), color);
                        putPixel(Math.round(x1), Math.round(y1 - j), color);
                    }
                } else
                {
                    for (int j = 1; j <= (int) thick; j++)
                    {
                        putPixel(Math.round(x1 + j), Math.round(y1), color);
                        putPixel(Math.round(x1 - j), Math.round(y1), color);
                    }
                }
            }
        }
    }

    public void rotacion()
    {
        if (axis.equals("x+"))
        {
            if (angulox >= 360)
            {
                angulox = 0;

            } else
            {
                angulox++;
            }
        }
        if (axis.equals("x-"))
        {
            if (angulox <= 0)
            {
                angulox = 360;

            }
            else
            {
                angulox--;
            }
        }
        if (axis.equals("y+"))
        {
            if (anguloy >= 360)
            {
                anguloy = 0;
            }
            else
            {
                anguloy++;
            }
        }
        if (axis.equals("y-"))
        {
            if (anguloy <= 0)
            {
                anguloy = 360;
            }
            else
            {
                anguloy--;
            }
        }

        if (axis.equals("z+"))
        {
            if (anguloz >= 360)
            {
                anguloz = 0;
            }
            else
            {
                anguloz++;
            }
        }

        if (axis.equals("z-"))
        {
            if (anguloz <= 0)
            {
                anguloz = 360;
            }
            else
            {
                anguloz--;
            }
        }

        int ang;
        for (int j = 0; j < 36; j++)
        {
            for (int i = 0; i < 100; i++)
            {
                ang = cord[j][i][0];
                cord[j][i][0] = (int) Math.round((cord[j][i][0] * Math.cos(Math.toRadians(angulox)))- 
                (cord[j][i][1] * Math.sin(Math.toRadians(angulox))));

                cord[j][i][1] = (int) Math.round((ang * Math.sin(Math.toRadians(angulox)))+ (cord[j][i][1] *
                 Math.cos(Math.toRadians(angulox))));
            }
        }

        for (int j = 0; j < 36; j++)
        {
            for (int i = 0; i < 100; i++)
            {
                ang = cord[j][i][0];
                cord[j][i][0] = (int) Math.round((cord[j][i][0] * Math.cos(Math.toRadians(anguloy))) - 
                (cord[j][i][2] * Math.sin(Math.toRadians(anguloy))));

                cord[j][i][2] = (int) Math.round((ang * Math.sin(Math.toRadians(anguloy))) +
                 (cord[j][i][2] * Math.cos(Math.toRadians(anguloy))));
            }
        }

        for (int j = 0; j < 36; j++)
        {
            for (int i = 0; i < 100; i++)
            {
                ang = cord[j][i][1];
                cord[j][i][1] = (int) Math.round((cord[j][i][1] * Math.cos(Math.toRadians(anguloz))) - 
                (cord[j][i][2] * Math.sin(Math.toRadians(anguloz))));

                cord[j][i][2] = (int) Math.round((ang * Math.sin(Math.toRadians(anguloz))) +
                 (cord[j][i][2] * Math.cos(Math.toRadians(anguloz))));
            }
        }
        paint(this.getGraphics());
    }

    public void rotacion2()
    {
        if (axis.equals("x+"))
        {
            if (angulox >= 360)
            {
                angulox = 0;

            } else
            {
                angulox++;
            }
        }
        if (axis.equals("x-"))
        {
            if (angulox <= 0)
            {
                angulox = 360;

            }
            else
            {
                angulox--;
            }
        }
        if (axis.equals("y+"))
        {
            if (anguloy >= 360)
            {
                anguloy = 0;
            }
            else
            {
                anguloy++;
            }
        }
        if (axis.equals("y-"))
        {
            if (anguloy <= 0)
            {
                anguloy = 360;
            }
            else
            {
                anguloy--;
            }
        }

        if (axis.equals("z+"))
        {
            if (anguloz >= 360)
            {
                anguloz = 0;
            }
            else
            {
                anguloz++;
            }
        }

        if (axis.equals("z-"))
        {
            if (anguloz <= 0)
            {
                anguloz = 360;
            }
            else
            {
                anguloz--;
            }
        }

        int ang2;
        for (int j = 0; j < 36; j++)
        {
            for (int i = 0; i < 100; i++)
            {
                ang2 = cord2[j][i][0];
                cord2[j][i][0] = (int) Math.round((cord2[j][i][0] * Math.cos(Math.toRadians(angulox)))- 
                (cord2[j][i][1] * Math.sin(Math.toRadians(angulox))));

                cord2[j][i][1] = (int) Math.round((ang2 * Math.sin(Math.toRadians(angulox)))+ (cord2[j][i][1] *
                 Math.cos(Math.toRadians(angulox))));
            }
        }

        for (int j = 0; j < 36; j++)
        {
            for (int i = 0; i < 100; i++)
            {
                ang2 = cord[j][i][0];
                cord2[j][i][0] = (int) Math.round((cord2[j][i][0] * Math.cos(Math.toRadians(anguloy))) - 
                (cord2[j][i][2] * Math.sin(Math.toRadians(anguloy))));

                cord2[j][i][2] = (int) Math.round((ang2 * Math.sin(Math.toRadians(anguloy))) +
                 (cord2[j][i][2] * Math.cos(Math.toRadians(anguloy))));
            }
        }

        for (int j = 0; j < 36; j++)
        {
            for (int i = 0; i < 100; i++)
            {
                ang = cord[j][i][1];
                cord[j][i][1] = (int) Math.round((cord[j][i][1] * Math.cos(Math.toRadians(anguloz))) - 
                (cord[j][i][2] * Math.sin(Math.toRadians(anguloz))));

                cord[j][i][2] = (int) Math.round((ang * Math.sin(Math.toRadians(anguloz))) +
                 (cord[j][i][2] * Math.cos(Math.toRadians(anguloz))));
            }
        }
        paint(this.getGraphics());
    }

    public void cylinder()
    {
        rotateTemp = 1;
        int ang2;
        this.ang2 = this.ang2 + .1;
        for (int j = 0; j <36; j++) //j < 36
        {
            t = 0;
            angle = this.ang2;
            xtemp = 1;
            ytemp = 1;
            if (j % 2 == 0)
            {
                ytemp = 11;
            }

            for (int i = 0; i < 63; i++)
            {
                cord2[j][i][0] = (int) ((((2 + Math.cos(t)) * Math.cos(angle)) * 50) + xtemp);
                cord2[j][i][1] = (int) ((((2 + Math.cos(t)) * Math.sin(angle)) * 50) + ytemp);
                cord2[j][i][2] = (int) t;
                if (rotateTemp != 1)
                {
                    ang2 = cord2[j][i][0];
                    cord2[j][i][0] = (int) ((cord2[j][i][0] * Math.cos(Math.toRadians(rotateTemp)))
                            - (cord2[j][i][2] * Math.sin(Math.toRadians(rotateTemp))));
                    cord2[j][i][2] = (int) ((ang2 * Math.sin(Math.toRadians(rotateTemp)))
                            + (cord2[j][i][2] * Math.cos(Math.toRadians(rotateTemp))));
                }

                if (j % 2 == 0 && i == 62)
                {
                    cord2[j][i + 1][0] = (int) ((((2 + Math.cos(t)) * Math.cos(angle)) * 50) + xtemp);
                    cord2[j][i + 1][1] = (int) ((((2 + Math.cos(t)) * Math.sin(angle)) * 50) + ytemp + 11);
                    cord2[j][i + 1][2] = (int) t;
                    if (rotateTemp != 1)
                    {
                        ang2 = cord2[j][i + 1][0];
                        cord2[j][i
                                + 1][0] = (int) ((cord2[j][i + 1][0] * Math.cos(Math.toRadians(rotateTemp)))
                                - (cord2[j][i + 1][2] * Math.sin(Math.toRadians(rotateTemp))));
                        cord2[j][i + 1][2] = (int) ((ang2 * Math.sin(Math.toRadians(rotateTemp)))
                                + (cord2[j][i + 1][2] * Math.cos(Math.toRadians(rotateTemp))));
                    }
                }

                //para cilindro mover la t += 0.1 y angle tambien
                if (t <= Math.PI * 2 && !exit)
                {
                    t += .2;
                    angle += .2;
                    if (t >= Math.PI * 2)
                    {
                        exit = true;
                    }
                }
                else if (exit)
                {
                    t -= .2;
                    angle -= .2;
                    if (t <= 0)
                    {
                        exit = false;
                    }
                }
                if (i < 33 && i > 20)
                {
                    xtemp -= 1;
                }
                else if (i < 45 && i > 32)
                {
                    xtemp += 1;
                }
                ytemp += 15;
            }
            rotateTemp += 11;
        }
    }


    public void medusa()
    {
        rotateTemp = 1;
        int ang;
        this.ang = this.ang + .1;
        for (int j = 0; j <36; j++) //j < 36
        {
            t = 0;
            angle = this.ang;
            xtemp = 50;
            ytemp = 1;
            if (j % 2 == 0)
            {
                ytemp = 11;
            }

            for (int i = 0; i < 63; i++)
            {
                cord[j][i][0] = (int) ((((2 + Math.cos(t)) * Math.cos(angle)) * 50) + xtemp);
                cord[j][i][1] = (int) ((((2 + Math.cos(t)) * Math.sin(angle)) * 50) + ytemp);
                cord[j][i][2] = (int) t;
                if (rotateTemp != 1)
                {
                    ang = cord[j][i][0];
                    cord[j][i][0] = (int) ((cord[j][i][0] * Math.cos(Math.toRadians(rotateTemp)))
                            - (cord[j][i][2] * Math.sin(Math.toRadians(rotateTemp))));
                    cord[j][i][2] = (int) ((ang * Math.sin(Math.toRadians(rotateTemp)))
                            + (cord[j][i][2] * Math.cos(Math.toRadians(rotateTemp))));
                }

                if (j % 2 == 0 && i == 62)
                {
                    cord[j][i + 1][0] = (int) ((((2 + Math.cos(t)) * Math.cos(angle)) * 50) + xtemp);
                    cord[j][i + 1][1] = (int) ((((2 + Math.cos(t)) * Math.sin(angle)) * 50) + ytemp + 11);
                    cord[j][i + 1][2] = (int) t;
                    if (rotateTemp != 1)
                    {
                        ang = cord[j][i + 1][0];
                        cord[j][i
                                + 1][0] = (int) ((cord[j][i + 1][0] * Math.cos(Math.toRadians(rotateTemp)))
                                - (cord[j][i + 1][2] * Math.sin(Math.toRadians(rotateTemp))));
                        cord[j][i + 1][2] = (int) ((ang * Math.sin(Math.toRadians(rotateTemp)))
                                + (cord[j][i + 1][2] * Math.cos(Math.toRadians(rotateTemp))));
                    }
                }

                //para cilindro mover la t += 0.1 y angle tambien
                if (t <= Math.PI * 2 && !exit)
                {
                    t += .1;
                    angle += .1;
                    if (t >= Math.PI * 2)
                    {
                        exit = true;
                    }
                }
                else if (exit)
                {
                    t -= .1;
                    angle -= .1;
                    if (t <= 0)
                    {
                        exit = false;
                    }
                }
                if (i < 33 && i > 20)
                {
                    xtemp -= 1;
                }
                else if (i < 45 && i > 33)
                {
                    xtemp += 1;
                }
                ytemp += 5;
            }
            rotateTemp += 11;
        }
    }

    

    public void auto() throws InterruptedException {
        while(true){

            Thread.sleep(10);
            axis = "y-";
            rotacion();

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleEvent(e.getActionCommand());
    }

    public void handleEvent(String s)
    {
        switch (s)
        {
            case "up":
                axis = "z+";
                rotacion();
                //rotacion2();
                break;
            case "down":
                axis = "z-";
                rotacion();
                //rotacion2();
                break;
            case "left":
                axis = "y+";
                rotacion();
                //rotacion2();
                break;
            case "right":
                axis = "y-";
                rotacion();
                //rotacion2();
                break;
            case "1":
                axis = "x+";
                rotacion();
                //rotacion2();
                break;
            case "2":
                axis = "x-";
                rotacion();
                //rotacion2();
                break;
        }
    }

    public void keyTyped(KeyEvent e) { }

    public void keyReleased(KeyEvent e)
    {

    }

}
