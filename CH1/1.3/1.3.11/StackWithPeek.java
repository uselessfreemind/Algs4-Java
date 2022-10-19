import java.util.Iterator;

public class StackWithPeek<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node top;
    private int level;

    public StackWithPeek(Object sth) {
        level = 0;
    }

    public boolean IsEmpty() {
        return level == 0;
    }

    public int Size() {
        return level;
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
        top = top.next;
        level--;
        return temp.item;
    }

    public Item peek() {
        return top.item;
    }

    public Iterator<Item> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Item> {
        private Node current = top;

        public boolean hasNext() {
            return top.next != null;
        }

        public Item next() {
            Item temp = current.item;
            current = current.next;
            return temp;
        }
    }
}
