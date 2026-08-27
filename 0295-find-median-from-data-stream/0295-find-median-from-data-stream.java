import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //size balanced 
        if(left.size()>right.size()){
            right.add(num);
        }
        else{
            left.add(num);
        }
        //propety balanced
        if(!right.isEmpty() && left.peek()>right.peek()){
             int l = left.poll();
             int r = right.poll();
             left.add(r);
             right.add(l);
        }
        
    }
    public double findMedian() {
        if (left.size() + right.size() == 0)
            return 0.0;

        if ((left.size() + right.size()) % 2 == 0) {
           return ((double) left.peek() + (double) right.peek()) / 2;
        }

        return (double) left.peek();
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */