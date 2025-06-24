import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinSearchV2 {


    public int bisch(int[] ar, int key) {
        int lo = 0, hi = ar.length - 1;
        int mid, mid_next = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (ar[mid] > key)
                hi = mid - 1;
            else if (ar[mid] < key)
                lo = mid + 1;
            else {
                mid_next = mid;
                hi = mid - 1;
            }
        }
        return mid_next;
    }

    public static void main(String[] args) {
        int source[] = {1, 2, 3, 3, 4, 7, 7, 7, 10};
        // for (int i = 0; i < 19; i++)
        //  source[i] = StdRandom.uniformInt(0, 19);
        BinSearchV2 a = new BinSearchV2();
        Arrays.sort(source);
        StdOut.printf("\nThe min index of the key %d is %d", 12, a.bisch(source, 17));
        ;

    }
}
