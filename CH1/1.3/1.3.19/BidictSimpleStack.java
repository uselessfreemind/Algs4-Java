import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BidictSimpleStack<Item> {
    private class node {
        Item item;
        node next;
        node last;
    }

    private int size;
    private node first = new node();
    private node temp, last;


    public void SimpleStack() {
        size = 0;
    }

    public int Size() {
        return size;
    }

    public Item pop() {
        temp = first;
        if (--size == 0) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.last = null;
        }
        return temp.item;
    }

    public void push(Item item) {
        node in = new node();
        if (size++ == 0) {
            first = in;
            first.next = null;
            first.last = null;
        } else {
            temp = first;
            first = in;
            first.next = temp;
            first.last = null;
            temp.last = first;
        }
        first.item = item;
    }

    public boolean empty() {
        return (size == 0);
    }

    private node traverse(node f) {
        node p = f;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public void deletelast() {
        last = traverse(first);
        last = last.last;
        last.next = null;
        size--;
    }

    public static void main(String[] args) {
        BidictSimpleStack<String> source = new BidictSimpleStack<>();
        String temp;
        while (!StdIn.isEmpty()) {
            temp = StdIn.readString();
            source.push(temp);
        }
        source.deletelast();
        while (!source.empty())
            StdOut.println(source.pop());
    }
}
