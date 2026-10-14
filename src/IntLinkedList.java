public class IntLinkedList {
    Node head;
    Node tail;
    int size;

    // internal class that represents a list node.
    static class Node {
        int value;
        Node next;
        Node prev;
        Node() {
            value = 0;
            next = null;
            prev = null;
        }

        Node(int value) {
            this.value = value;
            next = null;
            prev = null;
        }

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public IntLinkedList() {
        // creates an empty list
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int value) {
        // adds a value at the end
        Node newNode = new Node(value, tail, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void add(int index, int value) {
        // adds a value at index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == size) {
            add(value);
            return;
        }
        if (index == 0) {
            Node newNode = new Node(value, null, head);
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            size++;
            return;
        }

        Node curr = getNode(index);
        Node newNode = new Node(value, curr.prev, curr);
        curr.prev.next = newNode;
        curr.prev = newNode;
        size++;
    }

    public int get(int index) {
        // returns a value at index
        checkIndex(index);
        return getNode(index).value;
    }

    public void set(int index, int value) {
        // updates a value at index
        checkIndex(index);
        Node curr = getNode(index);
        curr.value = value;
    }

    public int remove(int index) {
        // removes and returns value at index
        checkIndex(index);
        Node curr = getNode(index);
        
        if (curr.prev != null) {
            curr.prev.next = curr.next;
        } else {
            head = curr.next;
        }

        if (curr.next != null) {
            curr.next.prev = curr.prev;
        } else {
            tail = curr.prev;
        }

        size--;
        return curr.value;
    }

    public int size() {
        // returns size of list
        return size;
    }

    public boolean isEmpty() {
        // returns whether list is empty
        return size == 0;
    }

    @Override
    public String toString() {
        // returns String representation of list
        // "[]" for empty list
        // "[7, 8, 6]" for non-empty list
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.value);
            if (curr.next != null) {
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private Node getNode(int index) {
        Node curr;
        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}