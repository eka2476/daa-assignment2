public class IntStackQueue implements IntQueue {
    private IntStack inbox;
    private IntStack outbox;

    public IntStackQueue() {
        // creates an empty queue
        inbox = new IntArrayStack();
        outbox = new IntArrayStack();
    }

    @Override
    public void enqueue(int value) {
        inbox.push(value);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        shiftStacks();
        return outbox.pop();
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        shiftStacks();
        return outbox.peek();
    }

    @Override
    public int size() {
        return inbox.size() + outbox.size();
    }

    @Override
    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

    @Override
    public String toString() {
        // "[]" for empty queue
        // "[7, 8, 6]" for queue containing elements: 7, 8, 6. (head-first)
        if (isEmpty()) {
            return "[]";
        }

        int outSize = outbox.size();
        int inSize = inbox.size();
        int[] elements = new int[outSize + inSize];

        int[] tempOut = new int[outSize];
        for (int i = 0; i < outSize; i++) {
            tempOut[i] = outbox.pop();
        }

        for (int i = 0; i < outSize; i++) {
            elements[i] = tempOut[outSize - 1 - i]; 
            outbox.push(tempOut[i]);
        }


        int[] tempIn = new int[inSize];
        for (int i = 0; i < inSize; i++) {
            tempIn[i] = inbox.pop();
        }

        for (int i = 0; i < inSize; i++) {
            elements[outSize + i] = tempIn[inSize - 1 - i];
            inbox.push(tempIn[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i < elements.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void shiftStacks() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
    }
}