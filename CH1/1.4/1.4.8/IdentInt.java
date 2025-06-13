import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class IdentInt {
    public double Identintcount(int[] a) {
        Stopwatch timer = new Stopwatch();
        int cnt = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (BinarySearch.indexOf(a, a[i]) == i + 1)
                cnt++;
        }
        StdOut.printf("%d pares\n", cnt);
        double time = timer.elapsedTime();
        return time;
       /* int cnt = 0;
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] == a[j])
                    cnt++;
        StdOut.printf("%d pares\n", cnt);
        double time = timer.elapsedTime();
        return time;*/
    }

    public static void main(String[] args) {
        IdentInt s = new IdentInt();
        int size = Integer.parseInt(args[0]);
        int source[] = new int[size];
        for (int i = 0; i < size; i++)
            source[i] = StdRandom.uniformInt(-size / 2, size / 2);
        StdOut.printf("Time cost for counting two identical integer in %d " + "integers is %1.7f", size, s.Identintcount(source));
    }
}
