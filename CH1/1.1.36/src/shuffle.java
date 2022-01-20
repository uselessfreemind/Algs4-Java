import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class shuffle {

    public static int[][] ShuffleTest(int m, int n) {
        int test[] = new int[m];
        int res[][] = new int[m][m];
        StdRandom.setSeed(5824);
        for (int i = 0; i < m; i++)
            test[i] = StdRandom.uniform(m);
        for (int i = 0; i < n; i++)//shuffle 0~n times
        {
            test[i] = i;
            StdRandom.shuffle(test);
            for (int j = 0; j < m; j++)// number m occurring times
                for (int k = 0; k < m; k++)//if [j][k]==k
                    if (test[j] == k)
                        res[j][k]++;
        }
        return res;
    }

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]), n = Integer.parseInt(args[1]);
        int res[][] = ShuffleTest(m, n);
        for (int i = 0; i < res.length; i++)
            for (int j = 0; j < res[0].length; j++) {
                StdOut.printf("%d, ", res[i][j]);
                if (j == res[0].length - 1)
                    StdOut.println();
            }
    }
}

