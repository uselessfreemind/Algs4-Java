import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class histo {
    public static int ArrMax(int tar[]) {
        Arrays.sort(tar);
        return tar[tar.length - 1];
    }


    public static int[] histogram(int a[], int m) {
        int result[] = new int[m - 1];
        for (int j = 0; j <= ArrMax(a); j++)
            for (int i = 0; i <= a.length - 1; i++) {
                if (a[i] == j)
                    result[j]++;
            }
        return result;
    }

    public static void main(String[] args) {
        int m = 14;
        int result[] = new int[m - 1];
        int src[] = {4, 4, 0, 3, 1, 3, 12, 7};
        result = histogram(src, m);
        for (int i = 0; i < result.length; i++)
            StdOut.printf("%d,", result[i]);
    }
}
