import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BidrctSimpleStack<Item> {
    private class node {
        Item item;
        node next;
        node last;
    }

    private int size;
    private node first;
    private node temp, last;


    public void BidrctSimpleStack() {
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
        last = traverse(first);
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

    public void insertAfter(node before, node after) {
        node t;
        if (before != null && after != null) {
            t = before.next;
            before.next = after;
            after.last = before;
            t.last = after;
            after.next = t;
            size++;
        }
    }

    public void deletelast() {
        last = traverse(first);
        last = last.last;
        last.next = null;
        size--;
    }

    public static void main(String[] args) {
        BidrctSimpleStack<String> source = new BidrctSimpleStack<>();
        String temp;
        while (!StdIn.isEmpty()) {
            temp = StdIn.readString();
            source.push(temp);
        }

        source.insertAfter(source.first.next, source.last);
        while (!source.empty())
            StdOut.println(source.pop());
    }
}
