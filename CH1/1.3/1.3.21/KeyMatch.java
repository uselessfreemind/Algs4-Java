import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KeyMatch<Item> {
    private class node {
        Item item;
        node next;
        node last;
    }

    private int size;
    private node first;
    private node temp, last;


    public void KeyMatch() {
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

    private node traverse(node f, String k) {
        node p = f;
        while (!p.item.equals(k)) {
            p = p.next;
            if (p == null)
                break;
        }
        return p;
    }

    public boolean find(node f, String key) {
        return (traverse(f, key) != null);
    }

   /* public void deletelast() {
        last = traverse(first);
        last = last.last;
        last.next = null;
        size--;
    }*/

    public static void main(String[] args) {
        KeyMatch<String> source = new KeyMatch<>();
        String temp;
        while (!StdIn.isEmpty()) {
            temp = StdIn.readString();
            source.push(temp);
        }
        if (source.find(source.first, args[0]))
            StdOut.println("Key is successfully found");
        else
            StdOut.println("Unable to find key");
        while (!source.empty())
            StdOut.println(source.pop());
    }
}
