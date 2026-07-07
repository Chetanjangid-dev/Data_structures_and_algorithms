class Solution {
    public String reorganizeString(String s) {
        if (s.length() == 0) return "";

        HashMap<Character, Integer> hashmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char k=s.charAt(i);
            if(hashmap.containsKey(k)){
                hashmap.put(k,hashmap.get(k)+1);
            }
            else{  hashmap.put(k,1);}
        }

        ArrayList<ArrayList<Integer>> arr2d = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : hashmap.entrySet()) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add((int) entry.getKey());   // task
            temp.add(entry.getValue());       // frequency
            arr2d.add(temp);
        }

        MaxHeap h = new MaxHeap(arr2d);
        StringBuilder sb = new StringBuilder();
        while(!( h.isEmpty()) ){
            ArrayList<ArrayList<Integer>> leftchars= new ArrayList<>();
            ArrayList<Integer> value = h.poll();
           char c1 = (char)(int)value.get(0);
            int countofc1 = value.get(1);
            if (sb.length() > 0 && c1 == sb.charAt(sb.length() - 1)) {
    return "";
}
            sb.append(c1);
            countofc1--;
         if (countofc1 > 0) {
    ArrayList<Integer> temp = new ArrayList<>();
    temp.add((int)c1);      // Explicit conversion (recommended)
    temp.add(countofc1);
    leftchars.add(temp);
}
            if(h.isEmpty()==false){
             ArrayList<Integer> value2 = h.poll();
             char c2 = (char)(int)value2.get(0);
             if (sb.length() > 0 && c2 == sb.charAt(sb.length() - 1)) {
    return "";
}
             int countofc2 = value2.get(1);
             sb.append(c2);
             countofc2--;
            if (countofc2 > 0) {
             ArrayList<Integer> temp2 = new ArrayList<>();
    temp2.add((int)c2);
    temp2.add(countofc2);
    leftchars.add(temp2);
}
            }
            for (ArrayList<Integer> node : leftchars) {
                h.insert(node);
            } 
        }
      return sb.toString();
    }
}

class MaxHeap {
    private ArrayList<ArrayList<Integer>> heap;

    public MaxHeap(ArrayList<ArrayList<Integer>> arr) {
        heap = arr;
        if (!arr.isEmpty()) buildHeap();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        ArrayList<Integer> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(ArrayList<Integer> node) {
        heap.add(node);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int p = parent(i);

            if (heap.get(p).get(1) >= heap.get(i).get(1))
                break;

            swap(p, i);
            i = p;
        }
    }

    public ArrayList<Integer> poll() {
        if (heap.isEmpty()) return null;

        ArrayList<Integer> max = heap.get(0);

        if (heap.size() == 1) {
            heap.remove(0);
            return max;
        }

        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);

        return max;
    }

    private void heapifyDown(int i) {
        while (true) {
            int largest = i;
            int l = left(i);
            int r = right(i);

            if (l < heap.size() && heap.get(l).get(1) > heap.get(largest).get(1))
                largest = l;

            if (r < heap.size() && heap.get(r).get(1) > heap.get(largest).get(1))
                largest = r;

            if (largest == i) break;

            swap(i, largest);
            i = largest;
        }
    }

    private void buildHeap() {
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public ArrayList<Integer> peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }
}
