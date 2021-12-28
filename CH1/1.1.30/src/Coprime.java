import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Coprime {
    public static boolean[][] mutual(int n) {
        boolean a[][] = new boolean[n][n];
        for (int i = 1; i <= n - 1; i++)
            for (int j = 1; j <= n - 1; j++) {
                if (Euclid.GCD(i, j) == 1)
                    a[i][j] = true;
            }
        return a;
    }

    public static void main(String[] args) {
        StdOut.println("Enter the size");
        while (!StdIn.isEmpty()) {
            int size = StdIn.readInt();
            boolean n[][] = mutual(size);
            for (int i = 0; i <= n.length - 1; i++)
                for (int j = 0; j <= n[0].length - 1; j++) {
                    StdOut.printf("%b ", n[i][j]);
                    if (j == n[0].length - 1)
                        StdOut.println();
                }
        }
    }
}
