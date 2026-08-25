class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         HashMap<Integer,Integer> freq = new HashMap<>();
         for(int i = 0 ; i < nums.length;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
         } 
         List<int[]> arr = new ArrayList<>();
         for(Integer key:freq.keySet()){
              arr.add(new int[]{(int)key,(int)freq.get(key)});
         }          
         two_d_maxheap h =  new two_d_maxheap(arr);
         int[] ans = new int[k];
         for(int i =0;i<k;i++){
                ans[i]=h.extractMax()[0];
         }
       return ans;


    }
}
public class  two_d_maxheap {
  
    List<int[]> heap;

    public two_d_maxheap() {
        heap = new ArrayList<>();
    }

    public two_d_maxheap(List<int[]> heap) {
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
        int[] temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    void heapifyUp() {

        int i = heap.size() - 1;

        while (i > 0) {

            int parent = getParent(i);

            // Comparison index 1 ke basis par
            if (heap.get(parent)[1] >= heap.get(i)[1])
                break;

            swap(parent, i);

            i = parent;
        }
    }

    void heapifyDown() {

        int i = 0;
        int limit = heap.size();

        while (true) {

            int largest = i;

            int left = getLeft(i);
            int right = getRight(i);

            // Index 1 ke basis par comparison
            if (left < limit &&
                heap.get(left)[1] > heap.get(largest)[1]) {

                largest = left;
            }

            if (right < limit &&
                heap.get(right)[1] > heap.get(largest)[1]) {

                largest = right;
            }

            if (largest == i)
                break;

            swap(i, largest);

            i = largest;
        }
    }

    void heapifyDown(int i, int limit) {

        while (true) {

            int largest = i;

            int left = getLeft(i);
            int right = getRight(i);

            if (left < limit &&
                heap.get(left)[1] > heap.get(largest)[1]) {

                largest = left;
            }

            if (right < limit &&
                heap.get(right)[1] > heap.get(largest)[1]) {

                largest = right;
            }

            if (largest == i)
                break;

            swap(i, largest);

            i = largest;
        }
    }

    public void insert(int[] val) {

        heap.add(val);

        heapifyUp();
    }

    public int[] extractMax() {

        if (heap.size() == 0)
            return null;

        if (heap.size() == 1)
            return heap.remove(heap.size() - 1);

        int[] max = heap.get(0);

        int[] last = heap.remove(heap.size() - 1);

        heap.set(0, last);

        heapifyDown();

        return max;
    }

    void buildHeap() {

        for (int i = heap.size() / 2 - 1; i >= 0; i--) {

            heapifyDown(i, heap.size());
        }
    }

    int[] peek() {
        return heap.get(0);
    }

    int size() {
        return heap.size();
    }
}