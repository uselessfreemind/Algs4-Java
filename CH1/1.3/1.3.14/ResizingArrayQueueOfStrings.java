public class ResizingArrayQueueOfStrings<Item> {
    private int size;
    private Item store[];

    public ResizingArrayQueueOfStrings(int n) {
        store = (Item[]) new Object[n];

    }

    public void enqueue(Item in) {
        if (size < store.length)
            store[size++] = in;
        else resize(2 * store.length);

    }

    public Item dequeue() {
        Item temp = store[0];
        store =

    }

    private void resize(int re) {
        Item temp[] = (Item[]) new Object[re];
        int i = 0;
        while (i < store.length - 1)
            temp[i] = store[i];
        store = temp;
    }
}
