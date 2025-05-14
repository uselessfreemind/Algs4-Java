import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BidrctSimpleStack<Item> {
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

    private node traverse(node f, int k) {
        node p = f;
        int ct = 0;
        while (ct++ != k) {
            p = p.next;
        }
        return p;
    }

    public String delete(int k) {
        size--;
        node toDelete;
        String result = "";
        if (k > size || k < 0)
            result = "Invalid element index, please try again";
        else {
            toDelete = traverse(first, k);
            toDelete.last.next = toDelete.next;
            toDelete = null;
            result = "The " + Integer.toString(k) + "th element is successfully deleted";
        }
        return result;
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
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            temp = StdIn.readString();
            source.push(temp);
        }
        StdOut.println(source.delete(k));
        while (!source.empty())
            StdOut.println(source.pop());
    }
}
