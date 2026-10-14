public class IntArrayDeque implements IntDeque {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public IntArrayDeque() {
        // creates an empty deque
        data = new int[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public void addFirst(int value) {
        ensureCapacity();
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + data.length) % data.length;
        }
        data[front] = value;
        size++;
    }

    @Override
    public void addLast(int value) {
        ensureCapacity();
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % data.length;
        }
        data[rear] = value;
        size++;
    }

    @Override
    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        int value = data[front];
        if (size == 1) {
            front = 0;
            rear = 0;
        } else {
            front = (front + 1) % data.length;
        }
        size--;
        return value;
    }

    @Override
    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        int value = data[rear];
        if (size == 1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear - 1 + data.length) % data.length;
        }
        size--;
        return value;
    }

    @Override
    public int peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return data[front];
    }

    @Override
    public int peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return data[rear];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        // "[]" for empty deque
        // "[7, 8, 6]" for deque containing elements: 7, 8, 6. (front-first)
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int curr = front;
        for (int i = 0; i < size; i++) {
            sb.append(data[curr]);
            if (i < size - 1) {
                sb.append(", ");
            }
            curr = (curr + 1) % data.length;
        }
        sb.append("]");
        return sb.toString();
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int newCapacity = data.length * 2;
            int[] newData = new int[newCapacity];
            int curr = front;
            for (int i = 0; i < size; i++) {
                newData[i] = data[curr];
                curr = (curr + 1) % data.length;
            }
            data = newData;
            front = 0;
            rear = size - 1;
        }
    }
}