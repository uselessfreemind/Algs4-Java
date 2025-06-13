import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class BinSearchV2 {
    private int bs(int ar[], int key, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        while (lo <= hi) {
            if (ar[mid] > key)
                hi = mid - 1;
            else if (ar[mid] < key)
                lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int bisch(int[] ar, int key, int lo, int hi) {
        int idx = 0;
        for (int j = 0; j < 19; j++)
            StdOut.printf("%d, ", ar[j]);
        idx = bs(ar, key, lo, hi);
        while (idx != -1)
            idx = bs(ar, key, lo, idx);
        return;

    }

    public static void main(String[] args) {
        int source[] = new int[20];
        for (int i = 0; i < 19; i++)
            source[i] = StdRandom.uniformInt(0, 19);
        BinSearchV2 a = new BinSearchV2();
        Arrays.sort(source);
        StdOut.printf("\nThe min index of the key %d is %d", 12, a.bisch(source, 12));
        ;

    }
}
