import java.util.List;
class Solution {
    public int lastStoneWeight(int[] stones) {
         List<Integer> list = new ArrayList<>(Arrays.stream(stones).boxed().toList());
        MaxHeap heap=new MaxHeap(list);
        int smash,stone1,stone2;
        while(heap.size()>2){
               stone1=heap.remove();
               stone2=heap.remove();
               smash=Math.abs(stone1-stone2);
               if(smash>0){
                heap.insert(smash);
               }
        }
       if(heap.size()==2){
        return Math.abs(heap.remove()-heap.remove());
       }
       return (int)heap.remove();
    }
}

























class MaxHeap {

    private final List<Integer> heap;

    // Builds a max heap in-place
    public MaxHeap(List<Integer> list) {
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
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    // O(log n)
    public int remove() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return max;
    }

    // O(1)
    public int peek() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(parent) >= heap.get(index)) {
                break;
            }

            swap(parent, index);
            index = parent;
        }
    }

    private void heapifyDown(int index) {
        int n = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < n && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < n && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest == index) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printHeap() {
        System.out.println(heap);
    }

    // Optional: Returns the underlying heap
    public List<Integer> getHeap() {
        return heap;
    }
}