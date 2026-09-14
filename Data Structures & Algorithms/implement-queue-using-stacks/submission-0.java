class MyQueue {
    
    private Deque<Integer> queuer;
    private Deque<Integer> dequeuer;

    public MyQueue() {
        queuer = new ArrayDeque<>();
        dequeuer = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queuer.push(x);
    }
    
    public int pop() {
        if (empty())
            return Integer.MIN_VALUE;
        populateDequeuer();
        return dequeuer.pop();
    }
    
    public int peek() {
        if (empty())
            return Integer.MIN_VALUE;
        populateDequeuer();
        return dequeuer.peekFirst();
    }
    
    private void populateDequeuer() {
        if (!dequeuer.isEmpty())
            return;
        
        while (!queuer.isEmpty()) {
            dequeuer.push(queuer.pop());
        }
    }
    
    public boolean empty() {
        return queuer.isEmpty() && dequeuer.isEmpty();
    }
}