public class IntArray {
    private int[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public IntArray() {
        // creates an empty array
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(int value) {
        // adds value at the end
        ensureCapacity(size + 1);
        data[size++] = value;
    }

    public void add(int index, int value) {
        // adds value at index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    public int get(int index) {
        // returns value at index
        checkIndex(index);
        return data[index];
    }

    public void set(int index, int value) {
        // updates value at index
        checkIndex(index);
        data[index] = value;
    }

    public int remove(int index) {
        // removes and returns value at index
        checkIndex(index);
        int removedValue = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removedValue;
    }

    public int size() {
        // returns the current size of array
        return size;
    }

    public boolean isEmpty() {
        // returns whether array is empty
        return size == 0;
    }

    public void add(int[] values) {
        // adds entire array values
        if (values == null) return;
        ensureCapacity(size + values.length);
        for (int v : values) {
            data[size++] = v;
        }
    }

    @Override
    public String toString() {
        // return String representation of array
        // "[]" empty array
        // "[7, 8, 6]" non-empty array
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            int[] newData = new int[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}