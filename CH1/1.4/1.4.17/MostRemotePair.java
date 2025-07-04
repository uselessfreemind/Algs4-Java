import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MostRemotePair {

    public static double maxabs(double[] ar) {
        if (ar.length == 0)
            throw new RuntimeException("void array\n");
        else if (ar.length <= 2)
            throw new RuntimeException("insufficient elements\n");
        double diff;
        double min = ar[0], max = ar[0];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] < min)
                min = ar[i];
            else if (ar[i] > max)
                max = ar[i];
        }
        return max - min;
    }

    public static void main(String[] args) {
        double[] raw = new double[10];
        for (int i = 0; i < raw.length; i++)
            raw[i] = StdRandom.uniformDouble(-10, 10);
        for (double i : raw)
            StdOut.print(i + ",");
        StdOut.printf("\nthe most remote pair of the array is %f", maxabs(raw));
    }
}
