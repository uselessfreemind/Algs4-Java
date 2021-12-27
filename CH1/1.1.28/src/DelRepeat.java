import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class DelRepeat {
    public static int rank(int key, int a[]) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
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
        int i = 0, j = 0, k = 0, idx = 0;
        while (++j <= src.length - 1) {
            if (src[i] == src[j])//if neighbour elements are identical
                src[j] = 0;//set repeating elements to zero
            else {
                idx++;//index for result array
                i = j;//next element
            }
        }
        int res[] = new int[idx];
        for (int m = 0; m < idx; m++) {
            while (src[k++] == 0)
                ;
            res[m] = src[k - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        int wl[] = In.readInts(args[0]);
        Arrays.sort(wl);
        int wl_filtrate[] = DelRep(wl);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            for (int i = 0; i <= wl_filtrate.length - 1; i++)
                StdOut.printf("%d ,", wl_filtrate[i]);
            StdOut.println();
            if (rank(key, wl) < 0)
                StdOut.println(key);
        }
    }
}

