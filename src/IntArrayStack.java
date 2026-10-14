public class IntArrayStack implements IntStack{
    // uses IntArray as back-end

    public IntArrayStack(){
        // creates empty stack
    }

    @Override
    public void push(int value) {
        // pushes value on top of stack
    }

    @Override
    public int pop() {
        // pops a value from top of stack
        return 0;
    }

    @Override
    public int peek() {
        // returns the value from top of stack without removing it
        return 0;
    }

    @Override
    public int size() {
        // returns the size of the stack
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // returns whether the stack is empty
        return false;
    }

    @Override
    public String toString() {
        // returns String representation of the stack
        // "[]" for empty stack
        // "[7, 8, 6]" for non-empty one (bottom-element-first)
        return super.toString();
    }
}
