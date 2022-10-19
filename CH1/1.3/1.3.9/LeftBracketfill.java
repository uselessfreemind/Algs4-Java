import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LeftBracketfill {
    public static void fill() {

        StackWithPeek<String> refer = new StackWithPeek("");
        QueueWithPeak<String> show = new QueueWithPeak<>();

        while (!StdIn.isEmpty()) {
            String in = StdIn.readString();
            refer.push(in);
            show.enqueue(in);
        }
        while (!refer.IsEmpty()) {
            if (refer.pop().equals(refer.pop())) {

                StdOut.print("((");

            } else if (refer.pop().equals("(") ||
                    !refer.pop().equals("("))
                StdOut.print("(" + show.dequeue());
        }
    }

    public static void main(String[] args) {
        fill();
    }
}
