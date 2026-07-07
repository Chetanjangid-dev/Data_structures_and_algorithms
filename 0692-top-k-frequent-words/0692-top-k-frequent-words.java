import java.util.*;

class MaxHeap {

    private List<List<Object>> heap;

    public MaxHeap(List<List<Object>> list) {
        heap = list;
        buildHeap();
    }

    // Build Heap : O(n)
    private void buildHeap() {
        int n = heap.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // Heapify Down : O(log n)
    private void heapifyDown(int index) {

        int n = heap.size();

        while (true) {

            int largest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < n && greater(left, largest)) {
                largest = left;
            }

            if (right < n && greater(right, largest)) {
                largest = right;
            }

            if (largest == index) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    // Heapify Up : O(log n)
    private void heapifyUp(int index) {

        while (index > 0) {

            int parent = (index - 1) / 2;

            if (greater(index, parent)) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    // Returns true if heap[i] has higher priority than heap[j]
  private boolean greater(int i, int j) {

    String s1 = (String) heap.get(i).get(0);
    int v1 = (Integer) heap.get(i).get(1);

    String s2 = (String) heap.get(j).get(0);
    int v2 = (Integer) heap.get(j).get(1);

    if (v1 != v2) {
        return v1 > v2;
    }

    return s1.compareTo(s2) < 0;
}
    private void swap(int i, int j) {

        List<Object> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Returns maximum element
    public List<Object> peek() {

        if (heap.isEmpty()) {
            return null;
        }

        return heap.get(0);
    }

    // Removes and returns maximum element
    public List<Object> poll() {

        if (heap.isEmpty()) {
            return null;
        }

        List<Object> ans = heap.get(0);

        int last = heap.size() - 1;

        swap(0, last);

        heap.remove(last);

        if (!heap.isEmpty()) {
            heapifyDown(0);
        }

        return ans;
    }

    // Inserts a new element
    public void offer(List<Object> element) {

        heap.add(element);

        heapifyUp(heap.size() - 1);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public List<List<Object>> getHeap() {
        return heap;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
         List<List<Object>> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }
            else{
                map.put(words[i],1);
            }
        }
       for (Map.Entry<String, Integer> entry : map.entrySet()) {
         List<Object> pair = new ArrayList<>();
         pair.add(entry.getKey());
         pair.add(entry.getValue());
         list.add(pair);
       }
       MaxHeap heap=new MaxHeap(list);
       List<String> ans=new ArrayList<>();
       for(int i=0;i<k;i++){
        ans.add((String)heap.poll().get(0));
       }
       return ans;
    }
}
//if two words have same freq return the word first wuth lower lexiographical order
