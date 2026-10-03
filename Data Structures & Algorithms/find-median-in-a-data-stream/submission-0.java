class MedianFinder{

    PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> high = new PriorityQueue<>();
    


    public MedianFinder(){}

    public void addNum(int num) {
        low.offer(num);              // 1. always into low
        high.offer(low.poll());      // 2. move low's max to high
        if (high.size() > low.size()) {
                low.offer(high.poll());  // 3. rebalance: low may be 1 bigger, never smaller
        }
    }

    public double findMedian() {
        if (low.size() > high.size()) return low.peek();
        return (low.peek() + high.peek()) / 2.0;
    }
}