import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Point2d {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double x = 1.0, y = 1.5;
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setXscale(-10.0, 10.0);
        StdDraw.setYscale(-10.0, 10.0);
        StdDraw.square(x, y, 4.0);
        Point2D pg[] = new Point2D[N];
        for (int i = 0; i < N; i++) {
            double temp_x = StdRandom.uniform(x - 4.0, x + 4.0);
            double temp_y = StdRandom.uniform(y - 4.0, y + 4.0);
            pg[i] = new Point2D(temp_x, temp_y);
            pg[i].draw();
        }
        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++) {
                StdOut.printf("Distance from point %d to point %d is %f \n", i, j, pg[i].distanceTo(pg[j]));
                
            }
    }
}


