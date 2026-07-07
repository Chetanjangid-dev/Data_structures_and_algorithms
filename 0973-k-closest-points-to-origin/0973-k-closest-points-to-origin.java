import java.util.*;

class MinHeap {

    private List<List<Integer>> heap;

    public MinHeap(List<List<Integer>> list) {
        this.heap = list;
        buildHeap();
    }

    // O(n)
    private void buildHeap() {
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // O(log n)
    private void heapifyDown(int index) {

        int n = heap.size();

        while (true) {

            int smallest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < n && smaller(left, smallest)) {
                smallest = left;
            }

            if (right < n && smaller(right, smallest)) {
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    // O(log n)
    private void heapifyUp(int index) {

        while (index > 0) {

            int parent = (index - 1) / 2;

            if (smaller(index, parent)) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    // Compare using only index 1
    private boolean smaller(int i, int j) {
        return heap.get(i).get(1) < heap.get(j).get(1);
    }

    private void swap(int i, int j) {
        List<Integer> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // O(1)
    public List<Integer> peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    // O(log n)
    public List<Integer> poll() {

        if (heap.isEmpty()) return null;

        List<Integer> ans = heap.get(0);

        int last = heap.size() - 1;

        swap(0, last);

        heap.remove(last);

        if (!heap.isEmpty()) {
            heapifyDown(0);
        }

        return ans;
    }

    // O(log n)
    public void offer(List<Integer> element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public List<List<Integer>> getHeap() {
        return heap;
    }
}class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] ans = new int[k][2];
        for(int i=0;i<points.length;i++){
            int dist= (points[i][1]*points[i][1])+ (points[i][0]*points[i][0]);
                        list.add(Arrays.asList(i,dist));
        }
        MinHeap heap=new MinHeap(list);
        for(int i=0;i<k;i++){
             int index=heap.poll().get(0);
             ans[i][0]=points[index][0];
             ans[i][1]=points[index][1];
        }
        return ans;

    }
}