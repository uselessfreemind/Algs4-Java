import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ReversePolish {
    public static void RPN(simpleQueue<String> raw) {

        simpleQueue<String> postfix = new simpleQueue<>();
        simpleStack<String> op = new simpleStack<>();
        String temp;
        Boolean clear_opStack = false;
        while (!raw.empty()) {
            temp = raw.Dequeue();
            if (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")) {
                op.push(temp);//push operators into their stack
                if (temp.equals("*") || temp.equals("/"))
                    if (raw.check_head().equals("(")) ;
                    else {

                        clear_opStack = true;//if next element of raw queue isn't '(', pop every operator to result Quque
                    }
            } else if (temp.equals(")"))
                while (!op.empty())
                    postfix.Enqueue(op.pop());//if ')',pop every element in op stack and enter the queue
            else if (temp.equals("(")) ;//if '(', do nothing
            else
                postfix.Enqueue(temp);// rest elements are only number that are to enter the queue
        }
        while (!postfix.empty())
            StdOut.printf("%s", postfix.Dequeue());
    }

    public static void main(String[] args) {
        simpleQueue<String> infix = new simpleQueue<>();
        while (!StdIn.isEmpty())
            infix.Enqueue(StdIn.readString());
        RPN(infix);
    }
}
