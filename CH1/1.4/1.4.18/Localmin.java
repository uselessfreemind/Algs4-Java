import edu.princeton.cs.algs4.StdOut;

public class Localmin {

    public static int localMinlinear(double a[]) {
        int i;
        for (i = 1; i < a.length - 2; i++)
            if (a[i] < a[i - 1] && a[i] < a[i + 1])
                break;
        return i;
    }

    public static int localMinLg(double a[]) {
        int lo = 0, hi = a.length - 1;
        int idx;
        while (lo < hi) {
            idx = lo + (hi - lo) / 2;
            if (a[idx] < a[idx - 1] && a[idx] < a[idx + 1])
                return idx;
            else if (a[idx] > a[idx - 1])
                hi = idx - 1;
            else if (a[idx] > a[idx + 1])
                lo = idx + 1;
        }

        return lo;
    }

    public static void main(String[] args) {
        double d[] = {3.1, 3.0, 3.7, 3.8, 4.0, 3.6, 3.5, 3.4};
        /*for (int i = 0; i < 10; i++)
           d[i] = StdRandom.uniformDouble(2.0, 10.0);
        for (double i : d)
            StdOut.print(i + ",");*/
        StdOut.printf("\n%d", localMinLg(d));

    }
}
