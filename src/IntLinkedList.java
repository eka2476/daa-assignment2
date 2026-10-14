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

    public IntLinkedList(){
        // creates an empty list
    }

    public void add(int value){
        // adds a value at the end
    }

    public void add(int index, int value){
        // adds a value at index
    }

    public int get(int index){
        // returns a value at index
        return 0;
    }

    public void set(int index, int value){
        // updates a value at index
    }

    public int remove(int index){
        // removes and returns value at index
        return 0;
    }

    public int size(){
        // returns size of list
        return 0;
    }

    public boolean isEmpty(){
        // returns whether list is empty
        return false;
    }

    @Override
    public String toString() {
        // returns String representation of list
        // "[]" for empty list
        // "[7, 8, 6]" for non-empty list
        return super.toString();
    }
}