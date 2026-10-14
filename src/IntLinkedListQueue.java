public class IntLinkedListQueue implements IntQueue {
    private IntLinkedList list;

    public IntLinkedListQueue() {
        // creates an empty queue
        list = new IntLinkedList();
    }

    @Override
    public void enqueue(int value) {
        // adds a value to queue
        list.add(value); 
    }

    @Override
    public int dequeue() {
        // removes, and returns a value from queue
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.remove(0); 
    }

    @Override
    public int peek() {
        // returns a value from queue
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0); 
    }

    @Override
    public int size() {
        // return size of queue
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        // returns whether queue is empty
        return list.isEmpty();
    }

    @Override
    public String toString() {
        // "[]" for empty queue
        // "[7, 8, 6]" for queue containing elements: 7, 8, 6. (head-first)
        return list.toString();
    }
}