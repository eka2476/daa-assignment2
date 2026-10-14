public class IntStackQueue implements IntQueue{
    // use two stacks as back-end

    public IntStackQueue() {
        // creates an empty stack
    }

    @Override
    public void enqueue(int value) {

    }

    @Override
    public int dequeue() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        // "[]" for empty queue
        // "[7, 8, 6]" for queue containing elements: 7, 8, 6. (head-first)
        return super.toString();
    }
}
