import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisualCounter {
    private int max_try;
    private double max_abs;
    private int t;
    private double res;
    private double mean;

    public VisualCounter(int n, double max) {
        max_try = n;
        max_abs = Math.abs(max);
        t = 0;
        res = 0.0;
        mean = 0.0;
    }

    public void inc(double n) {
        t++;
        res += n;
        t = Math.min(t, max_try);
        res = Math.min(res, max_abs);
    }

    public void dec(double n) {
        t--;
        res -= n;
    }

    public void mean() {
        mean = res / t;
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.setPenRadius(0.008);
        StdDraw.setXscale(0, max_try);
        StdDraw.setYscale(-max_abs, max_abs);
        StdDraw.point(t, res);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.point(t, mean);
    }

    public static void main(String[] args) {
        int times_max = Integer.parseInt(args[0]);
        double accu = Double.parseDouble(args[1]);
        VisualCounter trial = new VisualCounter(times_max, accu);

        for (int i = 0; i < 30; i++) {
            if (StdRandom.uniform(2) == 1) {
                trial.inc(StdRandom.uniform(0, accu));
                trial.draw();
            } else {
                trial.dec(StdRandom.uniform(0, accu));
                trial.draw();
            }
        }
        // trial.mean();
        // trial.draw();
    }
}
