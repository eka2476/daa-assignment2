public class IntQueueStack implements IntStack {
    private IntQueue q1;
    private IntQueue q2;

    public IntQueueStack() {
        q1 = new IntLinkedListQueue();
        q2 = new IntLinkedListQueue();
    }

    @Override
    public void push(int value) {
        q2.enqueue(value);
        while (!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }
        IntQueue temp = q1;
        q1 = q2;
        q2 = temp;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.dequeue();
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.peek();
    }

    @Override
    public int size() {
        return q1.size();
    }

    @Override
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    @Override
    public String toString() {
        // returns String representation of the stack
        // "[]" for empty stack
        // "[7, 8, 6]" for non-empty one (bottom-element-first)
        if (isEmpty()) {
            return "[]";
        }
        int n = q1.size();
        int[] tempArr = new int[n];
        for (int i = 0; i < n; i++) {
            tempArr[i] = q1.dequeue();
            q1.enqueue(tempArr[i]); 
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = n - 1; i >= 0; i--) {
            sb.append(tempArr[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}