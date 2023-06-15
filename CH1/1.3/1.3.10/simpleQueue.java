import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class simpleQueue<Item> implements Iterable<Item> {
    private class node {
        Item item;
        node next;
    }

    private node head;
    private int members_q;
    private node end;

    public void simpleQueue() {
        members_q = 0;
        end = null;
        head = null;
    }

    public boolean empty() {
        return members_q == 0;
    }

    public void Enqueue(Item item_in) {
        node in = new node();
        node temp;
        if (members_q++ == 0) {
            head = in;
            end = head;
            head.item = item_in;
            head.next = null;
        } else {
            temp = end;
            end = in;
            temp.next = end;
            end.next = null;
            in.item = item_in;
        }
    }

    public Item Dequeue() {
        node temp;
        if (members_q == 0)
            throw new RuntimeException("Empty queue,nothing is to leave");
        else {
            temp = head;
            if (members_q-- == 1)
                head = null;
            else
                head = head.next;
            return temp.item;
        }

    }

    public Iterator iterator() {
        return new itr();
    }

    public Item check_head() {
        if (head != null)
            return head.item;
        else
            throw new NoSuchElementException("empty queue");
    }

    private class itr implements Iterator<Item> {
        private node current = head;
        node temp;

        public boolean hasNext() {
            return members_q != 0;
        }

        public Item next() {
            temp = current;
            current = current.next;
            return temp.item;
        }
    }

    public static void main(String[] args) {
        simpleQueue<String> source = new simpleQueue<>();
        String temp;
        while (!StdIn.isEmpty()) {
            temp = StdIn.readString();
            source.Enqueue(temp);
        }
        while (!source.empty()) {
            StdOut.printf("%s ", source.Dequeue());
        }
    }
}
