import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class fast3sum {
    public static int linear2sum(int i[], int id) {
        return i[id] + i[++id];
    }

    public static int quadra3sum(int i[]) {
        int cnt = 0;
        for (int j = 0; j < i.length - 1; j++)
            if (i[j] == -linear2sum(i, j))
                cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        int a[] = new int[30];
        for (int i = 0; i < a.length; i++)
            a[i] = StdRandom.uniformInt(-15, 15);
        for (int i : a)
            StdOut.printf("%d,", i);
        StdOut.printf("\nthere are %d contiguous three integers whose sum is 0", quadra3sum(a));
    }
}
