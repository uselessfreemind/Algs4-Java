import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Copy {

    public static StackWithPeek<String> replicate() {
        StackWithPeek<String> res = new StackWithPeek("");
        StackWithPeek<String> src = new StackWithPeek("");
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            src.push(s);
        }
        for (String s : src)
            res.push(s);
        return res;
    }

    public static void main(String[] args) {
        StackWithPeek<String> temp = replicate();
        while (!temp.IsEmpty())
            StdOut.println(temp.pop());
    }
}
