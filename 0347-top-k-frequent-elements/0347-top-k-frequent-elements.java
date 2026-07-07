import java.util.*;
class MaxHeap {
    private ArrayList<ArrayList<Integer>> heap;
    public MaxHeap(ArrayList<ArrayList<Integer>> list) {
        this.heap = list;
        buildHeap();
    }

    // O(n)
    private void buildHeap() {
        int n = heap.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // O(log n)
    private void heapifyDown(int i) {
        int n = heap.size();

        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && heap.get(left).get(1) > heap.get(largest).get(1))
                largest = left;

            if (right < n && heap.get(right).get(1) > heap.get(largest).get(1))
                largest = right;

            if (largest == i)
                break;

            Collections.swap(heap, i, largest);
            i = largest;
        }
    }

    // O(log n)
    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(parent).get(1) >= heap.get(i).get(1))
                break;

            Collections.swap(heap, parent, i);
            i = parent;
        }
    }

    // O(1)
    public ArrayList<Integer> peek() {
        if (heap.isEmpty())
            return null;
        return heap.get(0);
    }

    // O(log n)
    public ArrayList<Integer> poll() {

        if (heap.isEmpty())
            return null;

        ArrayList<Integer> ans = heap.get(0);

        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);

        if (!heap.isEmpty())
            heapifyDown(0);

        return ans;
    }

    // O(log n)
    public void add(ArrayList<Integer> element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    // O(1)
    public int size() {
        return heap.size();
    }

    // O(1)
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void printHeap() {
        System.out.println(heap);
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i=0;i<nums.length;i++){
        if(map.containsKey(nums[i])){
            map.put(nums[i],map.get(nums[i])+1);
        }
        else{
             map.put(nums[i],1);
        }
      }  
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        ArrayList<Integer> pair = new ArrayList<>();
        pair.add(entry.getKey());
        pair.add(entry.getValue());
        list.add(pair);
     }
     MaxHeap heap = new MaxHeap(list);
     int[] ans=new int[k];
     for(int i=0;i<k;i++){
        ans[i]=(int)heap.poll().get(0);
     }
    return ans;

    }
}