import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class simplestack<Item> implements Iterable<Item> {
    private int node_num;

    private class node {
        Item item;
        node next;
    }

    private node first = new node();

    public void simplestack() {
        first.next = null;
        node_num = 0;
    }

    public boolean empty() {
        return node_num == 0;
    }

    public Item check() {
        if (first != null)
            return first.item;
        else
            throw new RuntimeException("empty stack");
    }

    public Item pop() {
        node temp;
        if (node_num == 0)
            throw new RuntimeException("Empty stack");
        else {
            temp = first;
            if (--node_num == 0)
                first = null;
            else
                first = first.next;

            return temp.item;
        }
    }

    public void push(Item item) {
        node income = new node();
        if (node_num++ == 0) {
            first = new node();
            first.item = item;
            first.next = null;
        } else {
            node temp = first;
            first = income;
            first.item = item;
            first.next = temp;
        }
    }

    public Iterator<Item> iterator() {
        return new itr();
    }

    private class itr implements Iterator<Item> {
        node temp = first;

        public boolean hasNext() {
            return temp != null;
        }

        public Item next() {
            Item item = temp.item;
            temp = temp.next;
            return item;
        }
    }

    public static void main(String[] args) {
        simplestack<String> source = new simplestack<String>();
        String temp;
        while (!StdIn.isEmpty()) {
            temp = StdIn.readString();
            source.push(temp);
        }
        while (!source.empty())
            StdOut.println(source.pop());
    }
}
