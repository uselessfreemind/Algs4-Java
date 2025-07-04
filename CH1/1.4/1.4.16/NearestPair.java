import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class NearestPair {
    public static double nearest(double[] ar) {
        Arrays.sort(ar);
        double diff_old = ar[1] - ar[0], diff;
        for (int i = 0; i < ar.length - 1; ) {
            if (ar[i] != ar[++i]) {
                diff = Math.abs(ar[i] - ar[i - 1]);
                if (diff < diff_old)
                    diff_old = diff;
            }
        }
        return diff_old;
    }

    public static void main(String[] args) {
        double[] raw = new double[10];
        for (int i = 0; i < raw.length; i++)
            raw[i] = StdRandom.uniformDouble(0e0, 10e0);
        StdOut.printf("\nthe nearest pair of array is %f", nearest(raw));
    }
}
