import edu.princeton.cs.algs4.StdOut;

public class CRReverse {
    public static int[][] Reverse(int src[][]) {
        int m = src.length, n = src[0].length;
        int result[][] = new int[n][m];
        for (int i = 0; i <= n - 1; i++)
            for (int j = 0; j <= m - 1; j++)
                result[i][j] = src[j][i];
        return result;
    }


    public static void main(String[] args) {
        int raw[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8,},
                {9, 10, 11, 12}
        };
        int result[][] = Reverse(raw);
        for (int i = 0; i <= result.length - 1; i++)
            for (int j = 0; j <= result[0].length - 1; j++) {
                StdOut.print(result[i][j]);
                if (j == result[0].length - 1)
                    StdOut.println();
            }

    }
}
