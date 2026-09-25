class MedianFinder {

    Queue<Integer> maxpq;
    Queue<Integer> minpq;

    public MedianFinder() {
        maxpq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minpq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }
    
    public void addNum(int num) {
        if (size() == 0) {
            maxpq.offer(num);
        } else if (size() % 2 == 0) {
            if (minpq.peek() < num) {
                maxpq.offer(minpq.poll());
                minpq.offer(num);
            } else {
                maxpq.offer(num);
            }
        } else if (maxpq.peek() < num) {
            minpq.offer(num);
        } else {
            minpq.offer(maxpq.poll());
            maxpq.offer(num);
        }

    }
    
    public double findMedian() {
        if (size() == 0) return 0;
        if (size() % 2 == 0) return (maxpq.peek() + minpq.peek()) / 2D;
        return maxpq.peek();
    }

    int size() {
        return minpq.size() + maxpq.size();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */