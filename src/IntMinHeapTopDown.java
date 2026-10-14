public class IntMinHeapTopDown implements IntQueue {
    private IntArray array;

    public IntMinHeapTopDown() {
        // creates an empty MinHeap
        array = new IntArray();
    }

    public IntMinHeapTopDown(int[] values) {
        // builds a MinHeap using top-down approach from an array of values
        array = new IntArray();
        if (values != null) {
            for (int v : values) {
                enqueue(v); 
            }
        }
    }

    @Override
    public void enqueue(int value) {
        // insert into heap
        array.add(value);
        siftUp(array.size() - 1);
    }

    @Override
    public int dequeue() {
        // remove and return the minimum from the heap
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = array.get(0);
        int last = array.remove(array.size() - 1);
        if (!array.isEmpty()) {
            array.set(0, last);
            siftDown(0);
        }
        return min;
    }

    @Override
    public int peek() {
        // return the minimum
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return array.get(0);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        // returns String representation of the internal IntArray
        return array.toString();
    }


    private void siftDown(int index) {
        int size = array.size();
        while (2 * index + 1 < size) {
            int left = 2 * index + 1;
            int right = left + 1;
            int smallest = index;

            if (array.get(left) < array.get(smallest)) {
                smallest = left;
            }
            if (right < size && array.get(right) < array.get(smallest)) {
                smallest = right;
            }

            if (smallest != index) {
                int temp = array.get(index);
                array.set(index, array.get(smallest));
                array.set(smallest, temp);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array.get(index) < array.get(parent)) {
                int temp = array.get(index);
                array.set(index, array.get(parent));
                array.set(parent, temp);
                index = parent;
            } else {
                break;
            }
        }
    }
}