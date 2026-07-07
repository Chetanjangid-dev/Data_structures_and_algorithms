class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k>nums.length){
            return -1;
        }
        //so here max heap will be more efficient 
         List<Integer> list = Arrays.stream(nums).map(x -> -x).boxed().toList();
         PriorityQueue<Integer> heap = new PriorityQueue<>(list);
         int n=nums.length;
         int i=1;
         int ans;
         while( (heap.isEmpty())==false && i<k){
            ans= -heap.poll();
            i++;
         } 
         ans=-heap.poll();
        return ans;
    }
}