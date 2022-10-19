import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class PeekTest {
    public static void peek() {
        StackWithPeek<Integer> test = new StackWithPeek(100);
        while (!StdIn.isEmpty()) {
            int in = Integer.parseInt(StdIn.readString());
            test.push(in);
        }
        StdOut.println(test.peek());
    }

    public static void main(String[] args) {
        peek();
    }
}
