import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix {
    private static boolean OpPrt(String a, String b) {
        if (a.equals(b))
            return true;//true means a>=b, pop a until a<b or stack is void
        else if (a.equals("+") || a.equals("-"))
            return false;

        else if ((a.equals("*") || a.equals("/"))
                && b.equals("sqrt"))
            return false;
        else if (a.equals("("))
            return false;
        else return true;
    }

    public static void InfixToPostfix() {
        StackWithPeek<String> infix = new StackWithPeek(" ");
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt"))
                if (infix.IsEmpty())
                    infix.push(s);
                else if (!OpPrt(infix.peek(), s))
                    infix.push(s);
                else {
                    while (!infix.IsEmpty() && OpPrt(infix.peek(), s))
                        StdOut.print(infix.pop() + " ");
                    infix.push(s);

                }
            else if (s.equals("("))
                infix.push(s);
            else if (s.equals(")")) {
                while (!infix.peek().equals("("))
                    StdOut.print(infix.pop() + " ");
                infix.pop();
            } else
                StdOut.print(s + " ");
        }
        while (!infix.IsEmpty())
            StdOut.print(infix.pop() + " ");

    }

    public static void main(String[] args) {
        InfixToPostfix();
    }
}
