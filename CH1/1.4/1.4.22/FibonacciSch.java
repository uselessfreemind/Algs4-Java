import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class FibonacciSch {
    public int F[];//fibonacci sequence F(k)
    int source[];
    private int k;
    private int sum = 2;

    public FibonacciSch(int a[]) {
        source = a;
        FlenghtFix(0, 1);
        F[0] = 0;
        F[1] = 1;
        k = 2;//fibonacci sequence index
        sqGenerator(0, 1);
    }

    private void FlenghtFix(int a, int b) {
        int c = a + b;
        ++sum;
        if (c >= source.length)
            F = new int[sum];
        else
            FlenghtFix(b, c);
    }

    public void sqGenerator(int a, int b) {
        int c = a + b;
        F[k++] = c;
        if (k > F.length - 1)
            return;
        sqGenerator(b, c);
    }

    public int fibSearch(int key) {

        int offset = 0, index = 0;
        int dk = sum;
        while (dk > 1) {
            index = Integer.min(offset + F[dk - 2], source.length - 1);
            if (key < source[index])
                dk = dk - 2;//F(k-2) is roughly half of F(k)
            else if (key > source[index]) {
                offset = index;
                dk = dk - 1;
            } else
                return index;
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = new int[20];
        for (int j = 0; j < a.length; j++)
            a[j] = StdRandom.uniformInt(1, 50);
        Arrays.sort(a);
        FibonacciSch c = new FibonacciSch(a);
        int idx = c.fibSearch(10);
        if (idx == -1)
            throw new NoSuchElementException("\nThe key isn't in the array");
        else StdOut.printf("\nThe key's index if %d", idx);
    }
}
