import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class BidrctSimpleStack<Item> {
    private class node {
        Item item;
        node next;
        node last;
    }

    private int size;
    private node first;
    private node temp, last;


    public BidrctSimpleStack() {
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
        if (size == 0) {
            first = in;
            first.next = null;
            first.last = null;
            last = first;
        } else {
            temp = first;
            first = in;
            first.next = temp;
            first.last = null;
            temp.last = first;
        }
        size++;
        first.item = item;
    }

    public boolean empty() {
        return (size == 0);
    }

    private node traverse(node f) {
        node p = f;
        while (p.next != null) {
            StdOut.println(p.item);
            p = p.next;
        }
        StdOut.println(p.item);
        return p;
    }

    /*public void remove(node f, Item i) {
        node t = f;
        if (f.item.equals(i)) {
            if (f == first)
                pop();
            else if (f == last)
                deletelast();
            else {
                t.last.next = t.next;
                t.next.last = t.last;
                size--;
            }
        }
        f = f.next;
        if (f != null)
            remove(f, i);
    }*/

    public void deletelast() {
        //last = traverse(first);
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.last;
            last.next = null;
        }
        size--;
    }

    public Item max(node f) {
        if (size == 0)
            throw new NoSuchElementException("0");
        else if (size == 2)
            if ((int) f.item < (int) f.next.item)
                return f.next.item;
            else
                return f.item;
        else
            while (f != last) {
                if ((int) f.item >= (int) f.next.item)
                    nodeswap(f);
                else
                    f = f.next;
            }
        return last.item;
    }

    private void nodeswap(node f) {
        node after = f.next;
        node temp1 = f.last;
        node temp2 = after.next;
        if (f == first) {
            f.next = after.next;
            f.last = after;
            after.last = null;
            after.next = f;
            first = after;
        } else if (after == last) {
            f.last.next = after;
            after.last = f.last;
            after.next = f;
            f.last = after;
            last = f;
        } else {
            f.next = after.next;
            f.last = after;
            after.next = f;
            after.last = temp1.last;
            temp1.next = after;
            temp2.last = f;
        }
    }

    public static void main(String[] args) {
        BidrctSimpleStack<Integer> source = new BidrctSimpleStack<>();
        int temp;
        while (!StdIn.isEmpty()) {
            temp = StdIn.readInt();
            source.push(temp);
        }


        StdOut.println(source.max(source.first));
        //while (!source.empty())
        //StdOut.println(source.pop());
    }
}
