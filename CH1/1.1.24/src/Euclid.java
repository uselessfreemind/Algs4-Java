import edu.princeton.cs.algs4.StdOut;

public class Euclid {
    public static int GCD(int a, int b) {
        if (a < 0 || b < 0)
            return -1;
        int r = a % b, q = a / b;
        StdOut.printf("%d,%d\n", a, b);
        if (r == 0)
            return b;
        else
            return GCD(b, r);
    }

    public static void main(String[] args) {
        StdOut.printf("The greatest common divisor of  1234567 and " +
                "1111111 is %d\n", GCD(1234567, 1111111));
    }
}
