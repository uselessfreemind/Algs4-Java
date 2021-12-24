import edu.princeton.cs.algs4.StdOut;

public class Fibonaci {
    public static long FRecur(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return FRecur(n - 1) + FRecur(n - 2);
    }

    public static long Floop(int n) {
        if (n < 2) return 1;
        long result[] = new long[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++)
            result[i] = result[i - 1] + result[i - 2];
        return result[n];
    }

    public static void main(String[] args) {
        for (int n = 0; n < 100; n++)
            StdOut.println(n + " " + Floop(n));
    }
}
