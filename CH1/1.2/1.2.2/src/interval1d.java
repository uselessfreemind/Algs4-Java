import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class interval1d {
    public static void main(String[] args) {
        double itvr_x0, itvr_x1;
        int N = Integer.parseInt(args[0]);
        Interval1D ig[] = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            StdOut.printf("The %dth interval's min\n", i);
            itvr_x0 = StdIn.readDouble();
            StdOut.printf("The %dth interval's max\n", i);
            itvr_x1 = StdIn.readDouble();
            StdOut.println();
            ig[i] = new Interval1D(itvr_x0, itvr_x1);
        }
        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++)
                if (ig[i].intersects(ig[j])) {
                    StdOut.printf("[%f,%f] ,", ig[i].min(), ig[i].max());
                    StdOut.printf("[%f,%f]\n", ig[j].min(), ig[j].max());
                    StdOut.println();
                } else
                    StdOut.println("There aren't 1D intervals which intersect\n");


    }
}

