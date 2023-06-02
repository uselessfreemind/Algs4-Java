import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class parentheses {


    public static void main(String[] args) {
        simplestack<String> input = new simplestack<>();
        simplestack<String> output = new simplestack<>();
        String temp;
        int parentheses_r = 0;
        int parentheses_l = 0;
        while (!StdIn.isEmpty()) {
            temp = StdIn.readString();
            input.push(temp);
            if (temp.equals(")"))
                parentheses_r++;
        }
        while (!input.empty()) {
            if (input.check().equals("*") || input.check().equals("/")) {
                output.push("(");
                parentheses_l++;
            }
            output.push(input.pop());
            
        }
        int diff = parentheses_r - parentheses_l;
        while (diff-- > 0)
            output.push("(");
        while (!output.empty())
            StdOut.printf(output.pop());
    }
}
