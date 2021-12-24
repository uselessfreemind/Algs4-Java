import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class logarithm {
    public static long Factorial(int n) {
        long result = n;
        if (n > 0)
            result *= Factorial(n - 1);
        else result = 1;
        return result;
    }

    public static void main(String[] args) {
        int fact;
        double Nalog;
        StdOut.println("Input the number");
        while (!StdIn.isEmpty()) {
            fact = StdIn.readInt();
            Nalog = Math.log(Factorial(fact));

            StdOut.printf("The natural logarithm of input's factorial %d is %f\n", Factorial(fact), Nalog);
            StdOut.println("Input the number");
        }
    }

}
