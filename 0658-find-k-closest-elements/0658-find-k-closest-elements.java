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

    // Compare priority
    private boolean smaller(int i, int j) {

        int firstDist = heap.get(i).get(1);
        int secondDist = heap.get(j).get(1);

        // Smaller distance has higher priority
        if (firstDist != secondDist) {
            return firstDist < secondDist;
        }

        // If distances are equal, smaller index has higher priority
        return heap.get(i).get(0) < heap.get(j).get(0);
    }

    private void swap(int i, int j) {

        List<Integer> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public List<Integer> peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    // O(log n)
    public List<Integer> poll() {

        if (heap.isEmpty()) {
            return null;
        }

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
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       List< List<Integer>> list=new ArrayList<>();
       for (int i=0;i<arr.length;i++){
         list.add(Arrays.asList(arr[i],Math.abs(arr[i]-x)));
       }
       MinHeap heap=new MinHeap(list);
       List<Integer> ans=new ArrayList<>();
       for(int i=0;i<k;i++){
        ans.add((Integer)heap.poll().get(0));
       }
    Collections.sort(ans);
     return ans;
    }
}