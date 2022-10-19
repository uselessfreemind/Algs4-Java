public class QueueWithPeak<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node top;
    private Node end;
    private int level;

    public QueueWithPeak() {
        level = 0;
    }

    public boolean IsEmpty() {
        return level == 0;
    }

    public int size() {
        return level;
    }

    public void enqueue(Item i) {
        Node temp = end;
        end = new Node();
        end.item = i;
        end.next = null;
        if (level++ == 0) {
            top = end;
            return;
        }
        temp.next = end;

    }

    public Item dequeue() {
        Node temp = top;
        top = top.next;
        level--;
        return temp.item;
    }

    public Item peek(boolean te) {
        return te ? top.item : end.item;
    }
}
