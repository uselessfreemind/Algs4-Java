import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Bsearch_cnt {
    private static int rank(int src[], int key, int lo, int hi, Counter t) {
        if (lo > hi)
            return -1;
        t.increment();
        if (key > src[(hi + lo) / 2]) {
            lo = lo + (hi - lo) / 2 + 1;
            return rank(src, key, lo, hi, t);
        } else if (key < src[(hi + lo) / 2]) {
            hi = hi - (hi - lo) / 2 - 1;
            return rank(src, key, lo, hi, t);
        } else return key;
    }


    public static void main(String[] args) {
        int src[] = {1, 4, 6, 2, 12, 7, 10};
        Arrays.sort(src);
        Counter t = new Counter("find");
        StdOut.printf("%d \n", rank(src, 7, 0, src.length - 1, t));
        StdOut.printf("%d times attempting", t.tally());
    }
}
