class Solution {
    public int kthSmallest(int[][] matrix, int k) {
    int m =  matrix.length;
    int n =matrix[0].length;
    List<List<Integer>> list =  new ArrayList<>();
      for(int i =0;i<m;i++){
         list.add(Arrays.asList(matrix[i][0],i,0));
      }
    MinHeap  h = new MinHeap(list);
    List<Integer> temp;
    Integer row,col,val;
    while(!h.isEmpty()){
       temp = h.remove();
       val=temp.get(0);
        row=temp.get(1);
        col=temp.get(2);
        k--;
        if(k==0){
            return (int)val;
        }
        if(col+1<n){
            h.insert(Arrays.asList(matrix[row][col+1],row,col+1));
        }        
    }
    return -1;
    }
}
//0 value 1 row 2 col
class MinHeap {

    private List<List<Integer>> heap;

    public MinHeap(List<List<Integer>> list) {
        this.heap = list;      // Same list, no copy
        buildHeap();           // In-place O(n)
    }

    private void buildHeap() {
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    private void heapifyDown(int index) {
        int n = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < n && heap.get(left).get(0) < heap.get(smallest).get(0))
                smallest = left;

            if (right < n && heap.get(right).get(0) < heap.get(smallest).get(0))
                smallest = right;

            if (smallest == index)
                break;

            Collections.swap(heap, index, smallest);
            index = smallest;
        }
    }

    public List<Integer> peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    public List<Integer> remove() {
        if (heap.isEmpty()) return null;

        List<Integer> root = heap.get(0);
        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);

        if (!heap.isEmpty())
            heapifyDown(0);

        return root;
    }

    public void insert(List<Integer> node) {
        heap.add(node);

        int i = heap.size() - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(parent).get(0) <= heap.get(i).get(0))
                break;

            Collections.swap(heap, parent, i);
            i = parent;
        }
    }
    public boolean isEmpty(){
        return heap.size()==0;
    }
    public List<List<Integer>> getHeap() {
        return heap;
    }
}