class MinStack {
    Node stack;
    public MinStack() {
        Node stack = null;
    }
    
    public void push(int val) {
        if (stack == null) {
            stack = new Node(val, val);
            return;
        }

        Node top = new Node(val, Math.min(val, stack.min));
        top.next = stack;
        stack = top;
    }
    
    public void pop() {
        Node tmp = stack;
        stack = stack.next;
        tmp.next = null;
    }
    
    public int top() {
        return stack.val;
    }
    
    public int getMin() {
        return stack.min;
    }
}

class Node {
    int val;
    int min;
    Node next;

    Node (int val, int min) {
        this.val = val;
        this.min = min;
    }
}
