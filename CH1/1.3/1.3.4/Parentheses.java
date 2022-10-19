import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {

    public static boolean completeness() {
        myStack<String> test = new myStack("");
        boolean minute = false, mid = false, large = false;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("{") || s.equals("[")
                    || s.equals("("))
                test.push(s);
            else if (s.equals("}"))
                large = (test.pop().equals("{"));
            else if (s.equals("]"))
                mid = (test.pop().equals("["));
            else if (s.equals(")"))
                minute = (test.pop().equals("("));
        }
        return minute | mid | large;
    }

    /*public static void StackTest() {
        myStack<String> strstack = new myStack("");
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-"))
                strstack.push(s);
            else if (!strstack.IsEmpty())
                StdOut.print(strstack.pop() + " ");

        }
        for (String s : strstack)
            StdOut.println(s);
        StdOut.println(strstack.size() + " elements in the stack");
    }*/

    public static void main(String[] args) {
        if (completeness())
            StdOut.println("Parentheses are complete");
        else
            StdOut.println("Parentheses are incomplete");
    }
}
