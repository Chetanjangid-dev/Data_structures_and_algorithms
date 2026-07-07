import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (char ch : tasks) {
            hashmap.put(ch, hashmap.getOrDefault(ch, 0) + 1);
        }

        ArrayList<ArrayList<Integer>> arr2d = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : hashmap.entrySet()) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add((int) entry.getKey());   // task
            temp.add(entry.getValue());       // frequency
            arr2d.add(temp);
        }

        MaxHeap h = new MaxHeap(arr2d);

        int required = 0;

        while (!h.isEmpty()) {

            ArrayList<ArrayList<Integer>> tasksAllocated = new ArrayList<>();

            ArrayList<Integer> value = h.poll();
            int task = value.get(0);
            int countOfTask = value.get(1);

            required++;
            int count = 0;

            countOfTask--;
            if (countOfTask > 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(task);
                temp.add(countOfTask);
                tasksAllocated.add(temp);
            }

            while (count != n) {

                if (!h.isEmpty()) {
                    ArrayList<Integer> value2 = h.poll();

                    int task2 = value2.get(0);
                    int count2 = value2.get(1);

                    required++;
                    count++;
                    count2--;

                    if (count2 > 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(task2);
                        temp.add(count2);
                        tasksAllocated.add(temp);
                    }

                } else {

                    if (tasksAllocated.size() > 0) {
                        required++;
                    }
                    count++;//ye to sirf cycyle todne k liye h agr taska;octed na bche ho
                }
            }

            for (ArrayList<Integer> node : tasksAllocated) {
                h.insert(node);
            }
        }

        return required;
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