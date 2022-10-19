import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfString {
    private String s[];
    private int size;
    public int N;

    public FixedCapacityStackOfString(int cap) {
        size = cap;
        s = new String[size];
        N = 0;
    }

    public void push(String in) {
        s[N++] = in;
    }

    public String pop() {
        return s[--N];
    }

    public boolean IsEmpty() {
        return (N == 0);
    }

    public boolean IsFull() {
        return N >= size;
    }

    public static void main(String[] args) {
        String s;
        FixedCapacityStackOfString test = new FixedCapacityStackOfString(20);
        while (!StdIn.isEmpty()) {
            s = StdIn.readString();
            if (!s.equals("-")) {
                if (!test.IsFull())
                    test.push(s);
                else
                    throw new RuntimeException("Stack is full");
            } else {
                if (!test.IsEmpty())
                    StdOut.print(test.pop() + " ");
            }
        }
        StdOut.println(test.N + " elements in the stack");
    }
}
