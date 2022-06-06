import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static java.lang.Math.cos;
import static java.lang.Math.round;
import static java.lang.Math.sin;

public class App {

        private BufferedImage buff;
        private int xP = 200, yP = 50, zP = -200;
        private int ancho, alto;
        private Graphics Pixel;

        public App(int ancho, int alto) {
                this.ancho = ancho;
                this.alto = alto;
                buff = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);

        }

        public void Graphics(Graphics g) {
                Pixel = g;
                Pixel.fillRect(0, 0, buff.getWidth(), buff.getHeight());
        }

        public void Putpixel(int x, int y, Color c) {
                buff.setRGB(x, y, c.getRGB());
        }

        public void Trazo(int x1, int x2, int y1, int y2, Color color) {
                int dx = x2 - x1;
                int dy = y2 - y1;
                int a;

                if (Math.abs(dx) > Math.abs(dy))
                        a = Math.abs(dx);
                else
                        a = Math.abs(dy);
                float xi = (float) dx / a;
                float yi = (float) dy / a;
                float x = x1;
                float y = y1;
                Putpixel(round(x), round(y), color);
                for (int i = 1; i < a; i++) {
                        x = x + xi;
                        y = y + yi;
                        Putpixel(round(x), round(y), color);
                }

        }

        public int vista(int mov1, int mov2, float angulo, boolean bandera) {
                double sin = sin(angulo);
                double cos = cos(angulo);
                int vuelta = 0;

                if (bandera) {
                        vuelta = (int) (mov1 * cos + mov2 * sin);
                }

                else {
                        vuelta = (int) (mov1 * cos - mov2 * sin);
                }
                return vuelta;
        }

        public void conv3d(int x, int y, int z, int x1, int y1, int z1) {
                int xc = 150, yc = 150, zc = -1000;

                int x2d = xc - ((zc * (x - xc)) / (z - zc));
                int x12d = xc - ((zc * (x1 - xc)) / (z1 - zc));
                int y2d = yc - ((zc * (y - yc)) / (z - zc));
                int y12d = yc - ((zc * (y1 - yc)) / (z1 - zc));

                Trazo(x2d, x12d, y2d, y12d, Color.blue);
        }

        public void Rot(int x, int y, int z, int mov, int orientacion, float angulo, Color color) {
                buff = new BufferedImage(this.ancho, this.alto, BufferedImage.TYPE_INT_ARGB);
                if (orientacion == 1)
                        CXaZ(x, y, z, mov, angulo);
                if (orientacion == 2)
                        CYaZ(x, y, z, mov, angulo);
                if (orientacion == 3)
                        CXaY(x, y, z, mov, angulo);
                Pixel.drawImage(buff, 0, 0, null);

        }

        public void CXaZ(int x, int y, int z, int mov, float angulo) {

                conv3d(x + this.vista(-mov, -mov, angulo, false), y + mov, z + this.vista(-mov, -mov, angulo, true),
                                x + this.vista(mov, -mov, angulo, false), y + mov,
                                z + this.vista(-mov, mov, angulo, true));

                conv3d(x + this.vista(-mov, -mov, angulo, false), y + mov, z + this.vista(-mov, -mov, angulo, true),
                                x + this.vista(-mov, mov, angulo, false), y + mov,
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x + this.vista(mov, -mov, angulo, false), y + mov, z + this.vista(-mov, mov, angulo, true),
                                x + this.vista(mov, mov, angulo, false), y + mov,
                                z + this.vista(mov, mov, angulo, true));

                conv3d(x + this.vista(mov, mov, angulo, false), y + mov, z + this.vista(mov, mov, angulo, true),
                                x + this.vista(-mov, mov, angulo, false), y + mov,
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x + this.vista(-mov, -mov, angulo, false), y - mov, z + this.vista(-mov, -mov, angulo, true),
                                x + this.vista(mov, -mov, angulo, false), y - mov,
                                z + this.vista(-mov, mov, angulo, true));

                conv3d(x + this.vista(-mov, -mov, angulo, false), y - mov, z + this.vista(-mov, -mov, angulo, true),
                                x + this.vista(-mov, mov, angulo, false), y - mov,
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x + this.vista(mov, -mov, angulo, false), y - mov, z + this.vista(-mov, mov, angulo, true),
                                x + this.vista(mov, mov, angulo, false), y - mov,
                                z + this.vista(mov, mov, angulo, true));

                conv3d(x + this.vista(mov, mov, angulo, false), y - mov, z + this.vista(mov, mov, angulo, true),
                                x + this.vista(-mov, mov, angulo, false), y - mov,
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x + this.vista(-mov, -mov, angulo, false), y + mov, z + this.vista(-mov, -mov, angulo, true),
                                x + this.vista(-mov, -mov, angulo, false), y - mov,
                                z + this.vista(-mov, -mov, angulo, true));

                conv3d(x + this.vista(mov, -mov, angulo, false), y + mov, z + this.vista(-mov, mov, angulo, true),
                                x + this.vista(mov, -mov, angulo, false), y - mov,
                                z + this.vista(-mov, mov, angulo, true));

                conv3d(x + this.vista(-mov, mov, angulo, false), y + mov, z + this.vista(mov, -mov, angulo, true),
                                x + this.vista(-mov, mov, angulo, false), y - mov,
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x + this.vista(mov, mov, angulo, false), y + mov, z + this.vista(mov, mov, angulo, true),
                                x + this.vista(mov, mov, angulo, false), y - mov,
                                z + this.vista(mov, mov, angulo, true));

        }

        public void CYaZ(int x, int y, int z, int mov, float angulo) {
                conv3d(x - mov, y + this.vista(mov, -mov, angulo, false), z + this.vista(-mov, mov, angulo, true),
                                x + mov, y + this.vista(mov, -mov, angulo, false),
                                z + this.vista(-mov, mov, angulo, true));

                conv3d(x - mov, y + this.vista(mov, -mov, angulo, false), z + this.vista(-mov, mov, angulo, true),
                                x - mov, y + this.vista(mov, mov, angulo, false),
                                z + this.vista(mov, mov, angulo, true));

                conv3d(x + mov, y + this.vista(mov, -mov, angulo, false), z + this.vista(-mov, mov, angulo, true),
                                x + mov, y + this.vista(mov, mov, angulo, false),
                                z + this.vista(mov, mov, angulo, true));

                conv3d(x + mov, y + this.vista(mov, mov, angulo, false), z + this.vista(mov, mov, angulo, true),
                                x - mov, y + this.vista(mov, mov, angulo, false),
                                z + this.vista(mov, mov, angulo, true));

                conv3d(x - mov, y + this.vista(-mov, -mov, angulo, false), z + this.vista(mov, -mov, angulo, true),
                                x + mov, y + this.vista(-mov, -mov, angulo, false),
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x - mov, y + this.vista(-mov, -mov, angulo, false), z + this.vista(mov, -mov, angulo, true),
                                x - mov, y + this.vista(-mov, mov, angulo, false),
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x + mov, y + this.vista(-mov, -mov, angulo, false), z + this.vista(mov, -mov, angulo, true),
                                x + mov, y + this.vista(-mov, mov, angulo, false),
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x + mov, y + this.vista(-mov, mov, angulo, false), z + this.vista(mov, -mov, angulo, true),
                                x - mov, y + this.vista(-mov, mov, angulo, false),
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x - mov, y + this.vista(mov, -mov, angulo, false), z + this.vista(-mov, mov, angulo, true),
                                x - mov, y + this.vista(-mov, -mov, angulo, false),
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x + mov, y + this.vista(mov, -mov, angulo, false), z + this.vista(-mov, mov, angulo, true),
                                x + mov, y + this.vista(-mov, -mov, angulo, false),
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x - mov, y + this.vista(mov, mov, angulo, false), z + this.vista(mov, mov, angulo, true),
                                x - mov, y + this.vista(-mov, mov, angulo, false),
                                z + this.vista(mov, -mov, angulo, true));

                conv3d(x + mov, y + this.vista(mov, mov, angulo, false), z + this.vista(mov, mov, angulo, true),
                                x + mov, y + this.vista(-mov, mov, angulo, false),
                                z + this.vista(mov, -mov, angulo, true));

        }

        public void CXaY(int x, int y, int z, int mov, float angulo) {

                conv3d(x + this.vista(-mov, mov, angulo, false), y + this.vista(mov, -mov, angulo, true), z - mov,
                                x + this.vista(mov, mov, angulo, false), y + this.vista(mov, mov, angulo, true),
                                z - mov);

                conv3d(x + this.vista(-mov, mov, angulo, false), y + this.vista(mov, -mov, angulo, true), z - mov,
                                x + this.vista(-mov, mov, angulo, false), y + this.vista(mov, -mov, angulo, true),
                                z + mov);

                conv3d(x + this.vista(mov, mov, angulo, false), y + this.vista(mov, mov, angulo, true), z - mov,
                                x + this.vista(mov, mov, angulo, false), y + this.vista(mov, mov, angulo, true),
                                z + mov);

                conv3d(x + this.vista(mov, mov, angulo, false), y + this.vista(mov, mov, angulo, true), z + mov,
                                x + this.vista(-mov, mov, angulo, false), y + this.vista(mov, -mov, angulo, true),
                                z + mov);

                conv3d(x + this.vista(-mov, -mov, angulo, false), y + this.vista(-mov, -mov, angulo, true), z - mov,
                                x + this.vista(mov, -mov, angulo, false), y + this.vista(-mov, mov, angulo, true),
                                z - mov);

                conv3d(x + this.vista(-mov, -mov, angulo, false), y + this.vista(-mov, -mov, angulo, true), z - mov,
                                x + this.vista(-mov, -mov, angulo, false), y + this.vista(-mov, -mov, angulo, true),
                                z + mov);

                conv3d(x + this.vista(mov, -mov, angulo, false), y + this.vista(-mov, mov, angulo, true), z - mov,
                                x + this.vista(mov, -mov, angulo, false), y + this.vista(-mov, mov, angulo, true),
                                z + mov);

                conv3d(x + this.vista(mov, -mov, angulo, false), y + this.vista(-mov, mov, angulo, true), z + mov,
                                x + this.vista(-mov, -mov, angulo, false), y + this.vista(-mov, -mov, angulo, true),
                                z + mov);

                conv3d(x + this.vista(-mov, mov, angulo, false), y + this.vista(mov, -mov, angulo, true), z - mov,
                                x + this.vista(-mov, -mov, angulo, false), y + this.vista(-mov, -mov, angulo, true),
                                z - mov);

                conv3d(x + this.vista(mov, mov, angulo, false), y + this.vista(mov, mov, angulo, true), z - mov,
                                x + this.vista(mov, -mov, angulo, false), y + this.vista(-mov, mov, angulo, true),
                                z - mov);

                conv3d(x + this.vista(-mov, mov, angulo, false), y + this.vista(mov, -mov, angulo, true), z + mov,
                                x + this.vista(-mov, -mov, angulo, false), y + this.vista(-mov, -mov, angulo, true),
                                z + mov);

                conv3d(x + this.vista(mov, mov, angulo, false), y + this.vista(mov, mov, angulo, true), z + mov,
                                x + this.vista(mov, -mov, angulo, false), y + this.vista(-mov, mov, angulo, true),
                                z + mov);

        }
}