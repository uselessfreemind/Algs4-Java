import java.util.Iterator;

public class myStack<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node top;
    private int level;
    private Item in;

    public myStack(Item item) {
        in = item;
    }

    public boolean IsEmpty() {
        return (level == 0);
    }

    public void push(Item item) {
        Node temp = top;
        top = new Node();
        top.item = item;
        top.next = temp;
        level++;
    }

    public Item pop() {
        Node temp = top;
        top = temp.next;
        level--;
        return temp.item;
    }

    public int size() {
        return level;
    }

    public Iterator<Item> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Item> {
        private Node current = top;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item res = current.item;
            current = current.next;
            return res;
        }

        public void Remove() {
        }

    }

}
