class Solution {
    public int lastStoneWeight(int[] stones) {

      ArrayList<Integer> list = new ArrayList<>();
      for(int i=0;i<stones.length;i++){
        list.add(stones[i]);
      }
      MaxHeap h =  new MaxHeap(list);
      while(h.size()>=2){
         h.insert(Math.abs(h.extractMax()- h.extractMax()) );
      }
      if(h.size()==1) return h.extractMax();
      return 0;
     }
}



public class MaxHeap {

    ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public MaxHeap(ArrayList<Integer> heap) {
        this.heap = heap;
        buildHeap();
    }

    int getParent(int i) {
        return (i - 1) / 2;
    }

    int getLeft(int i) {
        return 2 * i + 1;
    }

    int getRight(int i) {
        return 2 * i + 2;
    }

    void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // New element ko upar le jao
    void heapifyUp() {

        int i = heap.size() - 1;

        while (i > 0) {

            int parent = getParent(i);

            // Parent already greater/equal hai
            if (heap.get(parent) >= heap.get(i))
                break;

            swap(parent, i);

            i = parent;
        }
    }

    // Root se heapify down
    void heapifyDown() {

        int i = 0;
        int limit = heap.size();

        while (true) {

            int largest = i;

            int left = getLeft(i);
            int right = getRight(i);

            // Left child bada hai
            if (left < limit &&
                heap.get(left) > heap.get(largest)) {

                largest = left;
            }

            // Right child aur bhi bada hai
            if (right < limit &&
                heap.get(right) > heap.get(largest)) {

                largest = right;
            }

            // Current element hi largest hai
            if (largest == i)
                break;

            swap(i, largest);

            i = largest;
        }
    }

    // Build heap ke liye
    void heapifyDown(int i, int limit) {

        while (true) {

            int largest = i;

            int left = getLeft(i);
            int right = getRight(i);

            if (left < limit &&
                heap.get(left) > heap.get(largest)) {

                largest = left;
            }

            if (right < limit &&
                heap.get(right) > heap.get(largest)) {

                largest = right;
            }

            if (largest == i)
                break;

            swap(i, largest);

            i = largest;
        }
    }

    // Element insert
    public void insert(int val) {

        heap.add(val);

        heapifyUp();
    }

    // Maximum element remove
    public int extractMax() {

        if (heap.size() == 0)
            return -1;

        if (heap.size() == 1)
            return heap.remove(heap.size() - 1);

        // Root par maximum hota hai
        int max = heap.get(0);

        // Last element ko root par lao
        int last = heap.remove(heap.size() - 1);

        heap.set(0, last);

        // Heap fix karo
        heapifyDown();

        return max;
    }

    // Existing ArrayList ko MaxHeap banao
    void buildHeap() {

        for (int i = heap.size() / 2 - 1; i >= 0; i--) {

            heapifyDown(i, heap.size());
        }
    }

    // Maximum element dekho
    int peek() {

        return heap.get(0);
    }

    int size() {

        return heap.size();
    }
}