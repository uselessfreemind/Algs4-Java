import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MaxInt {
    public static int lg(int n, int pow) {
        int idx = 1;
        if ((pow *= 2) < n) {
            idx += lg(n, pow);
        }
        return idx;
    }

    public static void main(String[] args) {
        int N, power = 1;
        StdOut.println("Enter the x");
        //while (!StdIn.isEmpty()) {
        N = StdIn.readInt();
        StdOut.printf("The max integer which is the greatest value less than" +
                " Log2N is %d", lg(N, power) - 1);
        //}
    }
}
