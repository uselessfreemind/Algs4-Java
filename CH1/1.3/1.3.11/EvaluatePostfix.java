import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {

    private static boolean isNumber(String in) {
        return in.equals("1") || in.equals("2")
                || in.equals("3") || in.equals("4")
                || in.equals("5") || in.equals("6")
                || in.equals("7") || in.equals("8")
                || in.equals("9") || in.equals("0");
    }

    public static void EvaluatePostfix() {
        StackWithPeek<Integer> v = new StackWithPeek("");
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (isNumber(s))
                v.push(Integer.parseInt(s));
            else if (s.equals("+")) {
                if (v.Size() < 2) throw new RuntimeException("stack elements inadequate\n");
                v.push(v.pop() + v.pop());
            } else if (s.equals("-")) {
                if (v.Size() < 2) throw new RuntimeException("stack elements inadequate\n");
                v.push(~(v.pop() - v.pop()));
            } else if (s.equals("*")) {
                if (v.Size() < 2) throw new RuntimeException("stack elements inadequate\n");
                v.push(v.pop() * v.pop());
            } else if (s.equals("/")) {
                if (v.Size() < 2) throw new RuntimeException("stack elements inadequate\n");
                v.push(1 / (v.pop() / v.pop()));
            } else if (s.equals("sqrt")) {
                v.push((int) Math.sqrt(v.pop()));
            } else throw new IllegalArgumentException("invalid expression\n");
        }
        StdOut.println(v.pop());
    }

    public static void main(String[] args) {
        EvaluatePostfix();
    }
}
