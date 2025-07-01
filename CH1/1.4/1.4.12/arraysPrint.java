import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class arraysPrint {


    public static void main(String[] args) {

        int a[] = new int[100];
        for (int i = 0; i < 100; i++)
            a[i] = StdRandom.uniformInt(0, 50);
        Arrays.sort(a);
        if (a[0] == a[a.length - 1])
            StdOut.println(a[0]);
        int cnt = 0;

        for (int i = 0, j = i; j < a.length - 1; ) {
            if (a[i] == a[++j])
                cnt++;
            else {
                i = j;
                if (cnt != 0) {
                    StdOut.print(a[i - 1] + ",");
                    cnt = 0;
                }

            }
        }
    }
}
