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

    public void removeAfter(node mid) {
        node p;
        mid = mid.next;
        while (mid != null) {
            p = mid;
            mid = mid.next;
            p = null;
            size--;
        }
    }
    /*public void deletelast() {
        last = traverse(first);
        last = last.last;
        last.next = null;
        size--;
    }*/

    public static void main(String[] args) {
        BidrctSimpleStack<String> source = new BidrctSimpleStack<>();
        String temp;
        while (!StdIn.isEmpty()) {
            temp = StdIn.readString();
            source.push(temp);
        }
        source.removeAfter(source.first.next.next.next);
        while (!source.empty())
            StdOut.println(source.pop());
    }
}
