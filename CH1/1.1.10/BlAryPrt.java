import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BlAryPrt {
    public static char[][] BRT(int s[][]) {
        int m = s.length, n = s[0].length;
        char result[][] = new char[m][n];
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (s[i][j] == 0)
                    result[i][j] = ' ';
                else
                    result[i][j] = '*';
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int raw[][] = {
                {1, 1, 1, 1},
                {0, 1, 0, 1},
                {1, 1, 0, 0}};
        String res[] = new String[raw.length];
        char show[][] = BRT(raw);
        for (int i = 0; i <= raw.length - 1; i++) {
            res[i] = Arrays.toString(show[i]);
            StdOut.printf("%s\n", res[i]);
        }
    }
}
