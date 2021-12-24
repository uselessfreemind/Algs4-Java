import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinSchRec {
    public static int rank(int src[], int key, int hi, int lo, int lv) {
        for (int i = 0; i < lv; i++)
            StdOut.printf(" ");
        StdOut.printf("%d %d at level %d\n", lo, hi, lv);
        if (lo > hi)
            return -1;//boundary error
        int mid = (hi + lo) / 2;
        if (key < src[mid])
            return rank(src, key, mid - 1, lo, ++lv);
        else if (key > src[mid])
            return rank(src, key, hi, mid + 1, ++lv);
        else
            return mid;
    }

    public static void main(String[] args) {
        int whitelist[] = {12, 43, 55, 14, 94, 61, 77, 4, 23};
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(whitelist, key, whitelist.length - 1, 0, 0) == -1)
                StdOut.println(key);
        }
    }
}

