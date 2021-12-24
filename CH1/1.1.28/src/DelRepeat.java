import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class DelRepeat {
    public static int rank(int key, int a[]) {
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            int mid = lo + (hi + lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }


    public static int[] DelRep(int src[]) {
        int i = 0, j = i + 1, k = 0, idx = 0;
        while (j++ <= src.length - 1) {
            if (src[i] == src[j])
                src[j] = 0;
            else {
                idx++;
                i = j;
            }
        }
        int res[] = new int[idx];
        for (int m = 0; m <= idx; m++) {
            while (src[k] == 0) {
                if (k <= src.length - 1)
                    k++;
            }
            res[m] = src[k];
        }
        return res;
    }

    public static void main(String[] args) {
        int wl[] = StdIn.readAllInts();
        Arrays.sort(wl);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, wl) < 0)
                StdOut.println(key);
        }
    }
}
