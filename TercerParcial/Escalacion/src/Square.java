import java.util.ArrayList;
import java.util.List;

class Square {

    public List points;
    public int[] xs = new int[8];
    public int[] ys = new int[8];

    public Square(int p1x, int p1y, int p1z,
                int p2x, int p2y, int p2z,
                int p3x, int p3y, int p3z,
                int p4x, int p4y, int p4z,
                int p5x, int p5y, int p5z,
                int p6x, int p6y, int p6z,
                int p7x, int p7y, int p7z,
                int p8x, int p8y, int p8z) {
        points = new ArrayList<point>();
        point temp = new point();
        temp.x = p1x;
        temp.y = p1y;
        temp.z = p1z;
        points.add(temp);

        temp = new point();
        temp.x = p2x;
        temp.y = p2y;
        temp.z = p2z;
        points.add(temp);

        temp = new point();
        temp.x = p3x;
        temp.y = p3y;
        temp.z = p3z;
        points.add(temp);

        temp = new point();
        temp.x = p4x;
        temp.y = p4y;
        temp.z = p4z;
        points.add(temp);

        temp = new point();
        temp.x = p5x;
        temp.y = p5y;
        temp.z = p5z;
        points.add(temp);

        temp = new point();
        temp.x = p6x;
        temp.y = p6y;
        temp.z = p6z;
        points.add(temp);

        temp = new point();
        temp.x = p7x;
        temp.y = p7y;
        temp.z = p7z;
        points.add(temp);

        temp = new point();
        temp.x = p8x;
        temp.y = p8y;
        temp.z = p8z;
        points.add(temp);
    }
}
