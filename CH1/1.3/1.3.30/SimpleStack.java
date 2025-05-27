import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SimpleStack<Item> {
    private class node {
        Item item;
        node next;
    }

    private node first;
    private int size;

    public SimpleStack() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public void push(Item item) {
        node temp = first;
        first = new node();
        first.item = item;
        first.next = temp;
        size++;
    }

    public void reverseLoop(node f) {
        node r = f.next;
        node start = f;
        while (f.next != null) {
            f.next = r.next;
            r.next = start;
            start = r;
            r = f.next;
        }
        first = start;
    }

    public void reverseRecur(node f) {
        node r = f.next;
        if (r == null)
            return;
        f.next = r.next;
        r.next = first;
        first = r;
        reverseRecur(f);
    }

    public static void main(String[] args) {
        SimpleStack<String> source = new SimpleStack<>();
        String temp;
        while (!StdIn.isEmpty()) {
            temp = StdIn.readString();
            source.push(temp);
        }
        //source.reverseLoop(source.first);
        source.reverseRecur(source.first);
        while (!source.isEmpty()) {
            StdOut.println(source.pop());
        }
    }

}
